package com.dean.TheGymScraper.gymdata;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dean.TheGymScraper.scrapers.IScrape;

/**
 * Immutable gym use data that can return information such as average gym
 * length, num of sessions etc.
 * 
 * @author Dean
 *
 */
public class GymUsageData implements IGymUsageData {

	List<GymSession> gymSessions = new ArrayList<>();

	public GymUsageData(IScrape scrape) {
		reload(scrape);
	}

	@Override
	public List<GymSession> getGymSessions() {
		return gymSessions;
	}
	
	@Override
	public long getTotalNumOfSessions() {
		return gymSessions.size();
	}

	@Override
	public long getDaysSinceFirstAndLastSession() {
		LocalDate firstGymSession = gymSessions.get(0).getDateAtGym();
		LocalDate lastGymSession = gymSessions.get(gymSessions.size() - 1).getDateAtGym();
		return ChronoUnit.DAYS.between(firstGymSession, lastGymSession);
	}

	public long getDaysSinceFirstSessionAndNow() {
		LocalDate firstGymSession = gymSessions.get(0).getDateAtGym();
		return ChronoUnit.DAYS.between(firstGymSession, LocalDate.now());
	}
	
	@Override
	public double getAverageNumOfSessionsPerWeek() {
		// Number of sessions divided by days since first session
		double avgSessionsPerWeek = getTotalNumOfSessions()/
				numOfWeeksInDays(getDaysSinceFirstSessionAndNow());
		return avgSessionsPerWeek;
	}
	
	/**
	 * Convenience method to avoid multiple divisions occurring in calculations (makes it easier to read).
	 * 
	 * @param days
	 * @return days/7
	 */
	private double numOfWeeksInDays(long days) {
		return days/7;
	}

	@Override
	public double getAverageNumOfSessionsPerMonth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAverageSessionLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reload(IScrape scrape) {
		this.gymSessions = scrape.scrapeGymUsage();
		Collections.sort(gymSessions);
	}

}
