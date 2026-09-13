package com.campusbuspass.model;

import java.io.Serializable;

/**
 * Represents a bus route between two stops.
 */
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String routeName;
    private String source;
    private String destination;
    private double distance;      // km
    private double fee;           // monthly fee in Rupees

    public Route(int id, String routeName, String source, String destination,
                 double distance, double fee) {
        this.id = id;
        this.routeName = routeName;
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.fee = fee;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getRouteName() { return routeName; }
    public void setRouteName(String routeName) { this.routeName = routeName; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }
    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }

    @Override
    public String toString() {
        return "[" + id + "] " + routeName + " (" + source + " -> " + destination
                + "), " + distance + " km, Rs. " + fee + "/month";
    }
}