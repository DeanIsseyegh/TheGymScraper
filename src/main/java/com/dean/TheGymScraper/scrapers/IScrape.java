package com.dean.TheGymScraper.scrapers;

import java.util.List;

import com.dean.TheGymScraper.gymdata.GymSession;

/**
 * Interface responsible for scraping information about a users gym usage from TheGym. Decoupled
 * from implementation of actual scraping, as multiple frameworks exist for scraping.
 * 
 * @author dean.isseyegh.ext
 *
 */
public interface IScrape {

	List<GymSession> scrapeGymUsage();
	
}
