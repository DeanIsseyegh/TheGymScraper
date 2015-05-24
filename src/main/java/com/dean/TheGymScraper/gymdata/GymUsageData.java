package com.dean.TheGymScraper.gymdata;

import java.time.LocalDate;
import java.time.Period;
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
	private LocalDate firstSessionDate;
	private LocalDate lastSessionDate;


	public GymUsageData(IScrape scrape) {
		reload(scrape);
	}

	@Override
	public List<GymSession> getGymSessions() {
		return gymSessions;
	}
	
	public LocalDate getFirstSessionDate() {
		return firstSessionDate;
	}
	
	public LocalDate getLastSessionDate() {
		return lastSessionDate;
	}
	
	@Override
	public long getTotalNumOfSessions() {
		return gymSessions.size();
	}

	@Override
	public long getDaysSinceFirstAndLastSession() {
		return ChronoUnit.DAYS.between(firstSessionDate, lastSessionDate);
	}

	@Override
	public long getDaysSinceFirstSessionAndNow() {
		return ChronoUnit.DAYS.between(firstSessionDate, LocalDate.now());
	}
	
	@Override
	public Period getPeriodBetweenFirstAndLastSession() {
		return Period.between(firstSessionDate, lastSessionDate);
	}

	@Override
	public Period getPeriodBetweenFirstSessionAndNow() {
		return Period.between(firstSessionDate, LocalDate.now());
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
		return getAverageNumOfSessionsPerWeek() * 4;
	}
	
	@Override
	public double getTotalSessionLengthMins() {
		double totalSessionsLength = 0;
		for (GymSession session : gymSessions) {
			totalSessionsLength += session.getTimeSpentAtGym();
		}
		return totalSessionsLength;
	}

	@Override
	public double getAverageSessionLengthMins() {
		return getTotalSessionLengthMins()/gymSessions.size();
	}

	@Override
	public void reload(IScrape scrape) {
		this.gymSessions = scrape.scrapeGymUsage();
		Collections.sort(gymSessions);
		firstSessionDate = gymSessions.get(0).getDateAtGym();
		lastSessionDate = gymSessions.get(gymSessions.size() - 1).getDateAtGym();
	}
	
	public String toString() {
		return "Total Number Of Sessions : " + getTotalNumOfSessions() +
				"\nFirst session date : " + getFirstSessionDate() +
				"\nLast session date : " + getLastSessionDate() +
				"\nDays since first and last session : " + getDaysSinceFirstAndLastSession() +
				"\nDays since first session and now : " + getDaysSinceFirstSessionAndNow() +
				"\nAverage num of sessions per week : " + getAverageNumOfSessionsPerWeek() +
				"\nAverage num of sessions per month : " + getAverageNumOfSessionsPerMonth() +
				"\nTotal session length : " + getTotalSessionLengthMins() +
				"\nAverage session length : " + getAverageSessionLengthMins();
	}

}
