package com.dean.TheGymScraper.scrapers;

import javax.json.JsonObject;

/**
 * Interface responsible for scraping information about a users gym usage from TheGym. Decoupled
 * from implementation of actual scraping, as multiple frameworks exist for scraping.
 * 
 * @author dean.isseyegh.ext
 *
 */
public interface IScrape {

	JsonObject scrapeGymUsage();
	
}
