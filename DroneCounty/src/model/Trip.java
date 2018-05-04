package model;

import java.util.*;

public class Trip {
    private Vertex origin;
    private Vertex destination;
    private ArrayList<Vertex> route;
    Double minimumTimes;
    private Track track;
    private int tripTotalAmount;
    private int tripCounter = 0;
    /*
    private Date initialTime;
    private Date endingTime;
    */
    private ArrayList<Timeline> timelines;

    public Trip(Vertex origin, Vertex destination, ArrayList<Vertex> route, Double minimumTimes, Track track, int tripTotalAmount) {
        this.origin = origin;
        this.destination = destination;
        this.route = route;
        this.minimumTimes = minimumTimes;
        this.track = track;
        this.timelines = new ArrayList<>();
        this.tripTotalAmount = tripTotalAmount;
    }
    
    public Vertex getOrigin() {
        return origin;
    }

    public ArrayList<Vertex> getRoute() {
        return route;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setRoute(ArrayList<Vertex> route) {
        this.route = route;
    }

    public Track getTrack() {
        return track;
    }

    public int getTripTotalAmount() {
        return tripTotalAmount;
    }

    public int getTripCounter() {
        return tripCounter;
    }

    public ArrayList<Timeline> getTimelines() {
        return timelines;
    }

    public void setTripTotalAmount(int tripTotalAmount) {
        this.tripTotalAmount = tripTotalAmount;
    }

    public void setTripCounter(int tripCounter) {
        this.tripCounter = tripCounter;
    }

    public void setTimelines(ArrayList<Timeline> timelines) {
        this.timelines = timelines;
    }

    
    
    /*
    public Date getInitialTime() {
        return initialTime;
    }

    public Date getEndingTime() {
        return endingTime;
    }
    */

    public void setOrigin(Vertex pOrigin) {
        origin = pOrigin;
    }

    public void setDestination(Vertex Pddestination) {
        destination = Pddestination;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    @Override
    public String toString() {
        return "Trip{" + "Origin=" + origin + ", Target=" + destination + ", Route=" + route + ", Track=" + track + ", Timelines=" + timelines +", TripTotalAmount="+tripTotalAmount+", CurrentTripAmount="+tripCounter+ '}';
    }
    
    
}
