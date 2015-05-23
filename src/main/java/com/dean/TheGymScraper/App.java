package com.dean.TheGymScraper;

import java.util.List;

import com.dean.TheGymScraper.gymdata.GymSession;
import com.dean.TheGymScraper.gymdata.GymUsageData;
import com.dean.TheGymScraper.scrapers.IScrape;
import com.dean.TheGymScraper.scrapers.SoupScrape;

/**
 * Class that can be used when launching from the command line for testing purposes.
 *
 */
public class App 
{
	public static void main(String... args) {
		if (args.length != 2) {
			System.out.println("Need to pass in username and password");
		}
		String userName = args[0];
		String password = args[1];
		IScrape scrape = new SoupScrape(userName, password);
		System.out.println("Successfully scraped...");
		List<GymSession> gymSessions = scrape.scrapeGymUsage();
		GymUsageData gymUsageData = new GymUsageData(gymSessions);
		System.out.println(gymUsageData.getTotalNumOfSessions());
	}
}
