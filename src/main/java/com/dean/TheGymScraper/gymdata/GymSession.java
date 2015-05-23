package com.dean.TheGymScraper.gymdata;

import java.time.LocalDate;
import java.time.Period;

/**
 * Responsible for conveniently structuring the data we extract as JSON from the TheGym so it is easier to deal with.
 * 
 * @author Dean
 *
 */
public class GymSession implements Comparable<GymSession> {

	private long timeSpentAtGym;
	private LocalDate dateAtGym;
	
	public GymSession(long timeSpentAtGym, LocalDate dateAtGym) {
		this.timeSpentAtGym = timeSpentAtGym;
		this.dateAtGym = dateAtGym;
	}


	public double getTimeSpentAtGym() {
		return timeSpentAtGym;
	}

	public LocalDate getDateAtGym() {
		return dateAtGym;
	}
	
	public String toString() {
		String str = "Time Spent : " + timeSpentAtGym + "\n" +
						"Date at gym : " + dateAtGym;
		return str;
	}


	@Override
	public int compareTo(GymSession o) {
		return Period.between(o.getDateAtGym(), dateAtGym).getDays();
	}
}
