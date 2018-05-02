package model;

import java.util.*;

public class Trip {
    private Vertex origin;
    private Vertex destination;
    private ArrayList<Vertex> route;
    private Track track;
    /*
    private Date initialTime;
    private Date endingTime;
    */
    private ArrayList<Timeline> timelines;

    public Trip(Vertex origin, Vertex destination, ArrayList<Vertex> route, Track track) {
        this.origin = origin;
        this.destination = destination;
        this.route = route;
        this.track = track;
        this.timelines = new ArrayList<>();
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
        return "Trip{" + "Origin=" + origin + ", Target=" + destination + ", Route=" + route + ", Track=" + track + ", Timelines=" + timelines + '}';
    }
    
    
}
