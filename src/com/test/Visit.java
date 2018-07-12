package com.test;

import java.util.Date;

public class Visit {

    private Location location;
    private Date arrival_time_local;
    private Date departure_time_local;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getArrival_time_local() {
        return arrival_time_local;
    }

    public void setArrival_time_local(Date arrival_time_local) {
        this.arrival_time_local = arrival_time_local;
    }

    public Date getDeparture_time_local() {
        return departure_time_local;
    }

    public void setDeparture_time_local(Date departure_time_local) {
        this.departure_time_local = departure_time_local;
    }
}
