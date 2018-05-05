package model;

import java.util.*;

public class Trip {
    private Vertex origin;
    private Vertex destination;
    private ArrayList<Vertex> route;
    private ArrayList<Double> distancesOfRoute = new ArrayList<>();
    private Track track;
    private int tripTotalAmount;
    private int tripCounter = 0;
    private ArrayList<Timeline> timelines;
    private PriorityQueue<Double> timePool;

    public Trip(Vertex origin, Vertex destination, ArrayList<Vertex> route, Track track, int tripTotalAmount) {
        this.origin = origin;
        this.destination = destination;
        this.route = route;
        this.track = track;
        this.timelines = new ArrayList<>();
        this.tripTotalAmount = tripTotalAmount;
    }
    
    public void setDistances(ArrayList<DijkstraRoad> allroads){
        int max = route.size();
        Vertex nodeOfRoute;
        for(int i = 0; i < max-1; i++){
            nodeOfRoute = route.get(i);
            for(DijkstraRoad road : allroads){
                if(road.getInitial().equals(nodeOfRoute)){
                    double x = road.getMinimumDistances().get(route.get(i+1));
                    distancesOfRoute.add(x);
                    break;
                }
            }


        }

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

    public PriorityQueue<Double> getTimePool() {
        return timePool;
    }

    public void setTimePool(PriorityQueue<Double> timePool) {
        this.timePool = timePool;
    }

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
        return "Trip{" + "Origin=" + origin + "\n"
                + "\tTarget=" + destination + "\n"
                + "\tRoute=" + route + "\n"
                + "\tTrack=" + track + "\n"
                + "\tTimelines=" + timelines +"\n"
                + "\tTripTotalAmount="+tripTotalAmount+"\n"
                + "\tCurrentTripAmount="+tripCounter+ '}';
    }
    
    public static String fullTripToString(ArrayList<Trip> tripsToString){
        String result = "Trips{\n";
        for (Trip trip : tripsToString) {
            result = result.concat("\t"+trip.toString()+"\n\n");
        }
        return result;
    }
}
