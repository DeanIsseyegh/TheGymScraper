package com.dean.TheGymScraper.gymdata;

import java.time.LocalDate;
import java.time.Period;
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
	double getAverageSessionLengthMins();
	double getTotalSessionLengthMins();
	long getDaysSinceFirstAndLastSession();
	long getDaysSinceFirstSessionAndNow();
	Period getPeriodBetweenFirstAndLastSession();
	Period getPeriodBetweenFirstSessionAndNow();
	LocalDate getFirstSessionDate();
	LocalDate getLastSessionDate();
	
	List<GymSession> getGymSessions();
	void reload(IScrape scrape);
	
}
