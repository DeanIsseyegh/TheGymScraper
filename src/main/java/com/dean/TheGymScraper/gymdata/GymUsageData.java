package com.dean.TheGymScraper.gymdata;

import java.util.ArrayList;
import java.util.List;

/**
 * Immutable gym use data that can return information such as average gym
 * length, num of sessions etc.
 * 
 * @author Dean
 *
 */
public class GymUsageData implements IGymUsageData {

	List<GymSession> gymSessions = new ArrayList<>();

	public GymUsageData(List<GymSession> gymSessions) {
		this.gymSessions = gymSessions;
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
	public double getAverageNumOfSessionsPerWeek() {
		// TODO Auto-generated method stub
		return 0;
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
}
