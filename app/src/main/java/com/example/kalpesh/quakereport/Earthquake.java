package com.example.kalpesh.quakereport;

import java.util.Date;

public class Earthquake {
    private String place;
    private double magnitude;
    private long date;

    public Earthquake(String place, double mag, long date) {
        this.magnitude = mag;
        this.place = place;
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public long getDate() {
        return date;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
