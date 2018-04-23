package dronecounty;

import java.util.Date;

public class Trip {
    private Nodo Origin;
    private Nodo Destination;
    private int track;
    private int height;
    private int xPosition;
    private Date initialTime;
    private Date endingTime;

    public Nodo getOrigin() {
        return Origin;
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

    public void setOrigin(Nodo origin) {
        Origin = origin;
    }

    public void setDestination(Nodo destination) {
        Destination = destination;
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
