# TheGymScraper

Scrapes information from TheGym website and returns gym usage info. Some of the data it can provide:

* Total number of gym sessions
* Average number of gym sessions per week
* Average number of gym sessions per month
* Average gym session length

# Aim

This should provide a neat interface that can plugin into and be used by other projects easily and take care of extracting the data and information, allowing the projects to do more interesting things like visualize the data, add leaderboards etc.

# How to use/API

Use the GymUsageData class which implements IGymUsageData and provides the following API:

* long getTotalNumOfSessions();
*	double getAverageNumOfSessionsPerWeek();
*	double getAverageNumOfSessionsPerMonth();
*	double getAverageSessionLength();
*	List<GymSession> getGymSessions();
*	void reload(IScrape scrape);

Simply construct a GymUsageData(IScrape scrape) object, and pass in a scraping implemention. So far this project uses [JSoup] (http://jsoup.org/) in the form of the SoupScrape() class, but if you would like to use your own scraping implemention just make it implement IScrape and pass it in instead. 

You can refresh the latest data by calling reload(IScrape scrape).

Example:

```
String username = "bob@Gmail.com";
String password = "12345678";
IGymUsageData gymUsageData = new GymUsageData(new SoupScrape(username, password));
long numOfSessions = gymUsageData.getTotalNumOfSessions();
```

# Build

The build uses maven and java 1.8. Simply clone the repo and import the project as a maven project in eclipse.

# Running from the command line

You can run the project directly from the command line/eclipse by sending it two arguments - 1. email 2. pin.

# Technologies

This project makes use of [JSoup] (http://jsoup.org/) to scrape data from TheGym's site. 
