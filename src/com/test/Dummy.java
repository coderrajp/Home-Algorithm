package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* The class to fetch dummy visit data.
 */
public class Dummy {

  /**
   * Fetch dummy visits list.
   *
   * @return the list
   */
  public static List<Visit> fetchDummyVisits() {
    List<Visit> list = new ArrayList<>();
    Visit visit1 = new Visit();
    visit1.setArrival_time_local(new Date(1531337944000l));
    visit1.setDeparture_time_local(new Date(1531338024000l));
    visit1.setLocation(new Location(38.986609, -77.115316));
    list.add(visit1);

    Visit visit1_1 = new Visit();
    visit1_1.setArrival_time_local(new Date(1531390944000l));
    visit1_1.setDeparture_time_local(new Date(1531398161000l));
    visit1_1.setLocation(new Location(38.9829199, -77.124116));
    list.add(visit1_1);

    Visit visit3 = new Visit();
    visit3.setArrival_time_local(new Date(1531357253000l));
    visit3.setDeparture_time_local(new Date(1531359173000l));
    visit3.setLocation(new Location(38.900111, -77.1157777));
    list.add(visit3);

    Visit visit2 = new Visit();
    visit2.setArrival_time_local(new Date(1531352933000l));
    visit2.setDeparture_time_local(new Date(1531356503000l));
    visit2.setLocation(new Location(38.782821, -77.126616));
    list.add(visit2);

    Visit visit2_2 = new Visit();
    visit2_2.setArrival_time_local(new Date(1531361434000l));
    visit2_2.setDeparture_time_local(new Date(1531363954000l));
    visit2_2.setLocation(new Location(38.9991919, -77.198473));
    list.add(visit2_2);

    Visit visit3_1 = new Visit();
    visit3_1.setArrival_time_local(new Date(1530455418000l));
    visit3_1.setDeparture_time_local(new Date(1530498018000l));
    visit3_1.setLocation(new Location(38.90012, -77.11592));
    list.add(visit3_1);

    Visit visit3_2 = new Visit();
    visit3_2.setArrival_time_local(new Date(1530542898000l));
    visit3_2.setDeparture_time_local(new Date(1530578898000l));
    visit3_2.setLocation(new Location(38.900111, -77.1157777));
    list.add(visit3_2);

    Visit visit4 = new Visit();
    visit4.setArrival_time_local(new Date(1531334065000l));
    visit4.setDeparture_time_local(new Date(1531418605000l));
    visit4.setLocation(new Location(38.222121, -77.1000026));
    list.add(visit4);

    Visit visit5 = new Visit();
    visit5.setArrival_time_local(new Date(1531335865000l));
    visit5.setDeparture_time_local(new Date(1531337665000l));
    visit5.setLocation(new Location(38.5552718, -77.9911991));
    list.add(visit5);

    Visit visit3_3 = new Visit();
    visit3_3.setArrival_time_local(new Date(1530881298000l));
    visit3_3.setDeparture_time_local(new Date(1530928518000l));
    visit3_3.setLocation(new Location(38.9001243, -77.1158927));
    list.add(visit3_3);

    Visit visit5_1 = new Visit();
    visit5_1.setArrival_time_local(new Date(1531401222000l));
    visit5_1.setDeparture_time_local(new Date(1531467702000l));
    visit5_1.setLocation(new Location(38.5551118, -77.991391));
    list.add(visit5_1);

    return list;
  }

}