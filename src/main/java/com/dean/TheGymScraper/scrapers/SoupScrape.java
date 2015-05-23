package com.dean.TheGymScraper.scrapers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dean.TheGymScraper.gymdata.GymSession;

public class SoupScrape extends AbstractScrape {

	Map<String, String> cookies = new HashMap<>();
	private static final String START_URL = "http://www.thegymgroup.com/login/";
	private static final String USAGE_URL = "http://www.thegymgroup.com/my-account/my-usage/";
	
	private List<GymSession> gymSessions;
	
	public SoupScrape(String username, String password) {
		super(username, password);
		connect(username, password);
	}

	/**
	 * Connects and login in using username and password, and store the cookies
	 * so we can access all the member specific pages.
	 * 
	 * @param username
	 * @param password
	 */
	private void connect(String username, String password) {
		try {
			String formActive = "tx_gym_auth_pi[active]"; // Should usually be 1 if active
			String formUsername = "tx_gym_auth_pi[email]"; 
			String formPassword = "tx_gym_auth_pi[password]"; // A pin with TheGym e.g 10284738
			Connection.Response res = Jsoup.connect(START_URL).data(formActive, "1").data(formUsername, username)
					.data(formPassword, password).execute();

			cookies = res.cookies();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Will return information on the users gym usage.
	 */
	@Override
	public List<GymSession> scrapeGymUsage() {
		try {
			Document doc = Jsoup.connect(USAGE_URL).cookies(cookies).get();
			Element usage = doc.getElementById("myusagedata");
			// Returns a table of values - select it
			Elements myUsage = usage.select("tbody tr");
			this.gymSessions = new ArrayList<>();
			
			// Iterate over table values - we only care about 1st and 3rd column
			for(Element visit : myUsage){
				String dateStr = visit.child(0).text().split(" ")[0].replace("/", "-");
				String sessionLengthStr = visit.child(2).text().replace(" mins", "");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate date = LocalDate.parse(dateStr, formatter);
				long sessionLengthMinths = Long.parseLong(sessionLengthStr);
				GymSession gymSession = new GymSession(sessionLengthMinths, date);
				gymSessions.add(gymSession);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return gymSessions;
	}

}
