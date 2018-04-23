package dronecounty;

import java.util.ArrayList;
import java.util.Date;

public class Trip {
    private Nodo origin;
    private Nodo destination;
    private ArrayList<Nodo> route;
    private int track;
    private int height;
    private int xPosition;
    private Date initialTime;
    private Date endingTime;

    public Nodo getOrigin() {
        return origin;
    }

    public Nodo getDestination() {
        return destination;
    }

    public int getTrack() {
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

    public void setOrigin(Nodo pOrigin) {
        origin = pOrigin;
    }

    public void setDestination(Nodo Pddestination) {
        destination = destination;
    }

    public void setTrack(int track) {
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
}
