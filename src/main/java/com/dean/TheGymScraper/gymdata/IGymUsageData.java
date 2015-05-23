package com.dean.TheGymScraper.gymdata;

import java.util.List;

import com.dean.TheGymScraper.scrapers.IScrape;

/**
 * Contains gym usage data. 
 * 
 * @author Dean
 *
 */
public interface IGymUsageData {

	long getTotalNumOfSessions();
	double getAverageNumOfSessionsPerWeek();
	double getAverageNumOfSessionsPerMonth();
	double getAverageSessionLength();
	long getDaysSinceFirstAndLastSession();
	long getDaysSinceFirstSessionAndNow();
	
	List<GymSession> getGymSessions();
	void reload(IScrape scrape);
	
}
