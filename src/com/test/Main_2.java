package com.test;

import java.util.*;

public class Main_2 {

    private static final int END_TIME = 8;      // 8AM
    private static final int START_TIME = 20;       // 8PM
    private static final int MIN_DURATION = 30 * 60 * 60 * 1000;     // 30 hours!!!!

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<Visit> visits = Dummy.fetchDummyVisits();

        System.out.println("=====================================");
        Location homeLocation = getHomeLocation(visits);
        if (homeLocation != null) {
            System.out.println(
                    "***** Home Location : "
                            + homeLocation.getLatitude()
                            + ", "
                            + homeLocation.getLongitude()
                            + " ******");
            System.out.println("=====================================");
        } else {
            System.out.println("Home Location not found!!!");
        }
    }

    /**
     * The entry point of fetching home location.
     *
     * @param visitList the list of visits by the uer.
     */
    private static Location getHomeLocation(List<Visit> visitList) {
        List<HomeLocation> locations = new ArrayList<>();
        for (int i = 0; i < visitList.size(); i++) {
            Visit visit = visitList.get(i);
            System.out.println("Location : "
                    + visit.getLocation().getLatitude()
                    + ", "
                    + visit.getLocation().getLongitude());
            long duration = validateDuration(visit);            // in milliseconds.
            System.out.println("Duration : " + duration / 1000 + " seconds");
            HomeLocation newLocation = new HomeLocation(visit.getLocation(), duration);
            HomeLocation homeLocation = checkIfLocationExists(locations, newLocation);
            if (homeLocation == null) {
                homeLocation = newLocation;
                locations.add(homeLocation);
            } else {
                homeLocation.setDuration(homeLocation.getDuration() + duration);
            }
            System.out.println("=====================================");
        }

        if (!locations.isEmpty()) {
            Collections.sort(locations, (homeLocation1, homeLocation2) -> homeLocation1.compareTo(homeLocation2));
            HomeLocation homeLocation = locations.get(0);
            System.out.println("Max duration : " + (homeLocation.getDuration() / (60 * 60 * 1000)) + "hours");
            if (homeLocation.getDuration() > MIN_DURATION) {
                return homeLocation.getLocation();
            }
        }
        return null;
    }

    private static HomeLocation checkIfLocationExists(List<HomeLocation> locations, HomeLocation location) {
        for (Iterator<HomeLocation> it = locations.iterator(); it.hasNext(); ) {
            HomeLocation home = it.next();
            if (home.equals(location)) {
                return home;
            }
        }
        return null;
    }

    private static long validateDuration(Visit visit) {
        Date visitArrivalTime = visit.getArrival_time_local();
        Date visitDepartureTime = visit.getDeparture_time_local();

        // this should be set to 8pm of respective date.
        Date startTime = fetchTime(visitArrivalTime, START_TIME);

        // this should be set to 8am of respective date.
        Date endTime = fetchTime(visitDepartureTime, END_TIME);

        if ((visitArrivalTime.before(startTime) && visitDepartureTime.before(startTime))
                || (visitArrivalTime.after(endTime) && visitDepartureTime.after(endTime))) {
            return 0;
        }

        if (visitArrivalTime.before(startTime)) {
            visitArrivalTime = startTime;
        }
        if (visitDepartureTime.after(endTime)) {
            visitDepartureTime = endTime;
        }
        return visitDepartureTime.getTime()
                - visitArrivalTime.getTime();
    }

    private static Date fetchTime(Date date, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.HOUR_OF_DAY) <= END_TIME
                && hour == START_TIME) {          // doing this to check if the time is after midnight.
            cal.add(Calendar.DATE, -1); // if time is after midnight then start_time needs previous date
        }
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }
}
