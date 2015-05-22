package com.dean.TheGymScraper;

/**
 * Class only used when launching from the command line
 *
 */
public class App 
{
	public static void main(String... args) {
		TheGymJsonScrape scrape = new TheGymJsonScrape();
		if (args.length != 2) {
			System.out.println("Need to pass in username and password");
		}
		String userName = args[0];
		String password = args[1];
		scrape.getJson(userName, password);
	}
}
