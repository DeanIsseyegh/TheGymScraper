package com.dean.TheGymScraper.scrapers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.json.JsonObject;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class SoupScrape extends AbstractScrape {

	Map<String, String> cookies = new HashMap<>();

	public SoupScrape(String username, String password) {
		super(username, password);
		connect(username, password);
	}

	private void connect(String username, String password) {
		try {			
			//Connection.Response loginForm = Jsoup.connect("http://www.google.com/").method(Connection.Method.GET).execute();
			Connection.Response loginForm = Jsoup.connect("https://www.thegymgroup.com/login/").method(Connection.Method.GET).timeout(0).execute();

			Jsoup.connect("https://www.thegymgroup.com/login/").
			data("tx_gym_auth_pi[active]", "1").
			data("tx_gym_auth_pi[email]", username).
			data("tx_gym_auth_pi[password]", password).
			cookies(loginForm.cookies()).
			post();
			
			cookies = loginForm.cookies();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Will return information on the users gym usage.
	 */
	@Override
	public JsonObject scrapeGymUsage() {
		return null;
	}

}
