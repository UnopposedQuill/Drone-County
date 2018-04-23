package dronecounty;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Trip {
    private Vertex origin;
    private Vertex destination;
    private ArrayList<Vertex> route;
    private Track track;
    private int height;
    private int xPosition;
    private Date initialTime;
    private Date endingTime;

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

    public int getHeight() {
        return height;
    }

    public int getxPosition() {
        return xPosition;
    }

    public Date getInitialTime() {
        return initialTime;
    }

    public Date getEndingTime() {
        return endingTime;
    }

    public void setOrigin(Vertex pOrigin) {
        origin = pOrigin;
    }

    public void setDestination(Vertex Pddestination) {
        destination = destination;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setInitialTime(Date initialTime) {
        this.initialTime = initialTime;
    }

    public void setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
    }

    public void setDijkstra(Graph pGraph){
        Dijkstra vDijkstra = new Dijkstra(pGraph);
        ArrayList<Vertex> listOfNodes = new ArrayList<>();
        vDijkstra.execute(this.origin);
        listOfNodes = vDijkstra.getPath(this.destination);
        this.setRoute(listOfNodes);
    }
}
