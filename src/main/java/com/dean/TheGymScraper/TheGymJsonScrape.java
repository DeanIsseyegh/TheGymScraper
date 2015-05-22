package com.dean.TheGymScraper;

import javax.json.JsonObject;

import com.dean.TheGymScraper.scrapers.IScrape;
import com.dean.TheGymScraper.scrapers.SoupScrape;

public class TheGymJsonScrape {

	public JsonObject getJson(String username, String password) {
		IScrape scrape = new SoupScrape(username, password);
		
		return null;
	}
	
	public String getJsonAsString(String username, String password) {
		
		
		return "";
	}
	
}
