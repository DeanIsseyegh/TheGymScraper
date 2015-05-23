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
public class GymUsageData {

	List<GymSession> gymSessions = new ArrayList<>();

	public GymUsageData(List<GymSession> gymSessions) {
		this.gymSessions = gymSessions;
	}

	public long calcNumOfSessions() {
		return gymSessions.size();
	}

	public List<GymSession> getGymSessions() {
		return gymSessions;
	}
}
