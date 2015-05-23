package com.dean.TheGymScraper.gymdata;

import java.util.List;

public interface IGymUsageData {

	long getTotalNumOfSessions();
	double getAverageNumOfSessionsPerWeek();
	double getAverageNumOfSessionsPerMonth();
	double getAverageSessionLength();
	
	List<GymSession> getGymSessions();
	
}
