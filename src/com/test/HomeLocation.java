package com.test;

public class HomeLocation implements Comparable {

    private Location location;
    private long duration;

    public HomeLocation(Location location, long duration) {
        this.location = location;
        this.duration = duration;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HomeLocation that = (HomeLocation) o;

        return (roundOff(location.getLatitude()) == roundOff((that.location.getLatitude())))
                && (roundOff(location.getLongitude()) == roundOff(that.location.getLongitude()));
    }

    private double roundOff(double value) {
        return Math.round(value * 1000.0) / 1000.0;
    }

    @Override
    public int hashCode() {
        return location.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(((HomeLocation) o).getDuration(), duration);
    }
}
