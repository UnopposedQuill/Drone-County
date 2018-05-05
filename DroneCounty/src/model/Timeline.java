/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author esteban
 */
public class Timeline {
    /*
    private Vertex origin;
    private Vertex destination;
    */
    private int droneQuantity;
    private Double startTime;
    //private Double endingTime;

    public Timeline(int droneQuantity, Double startTime) {
        this.droneQuantity = droneQuantity;
        this.startTime = startTime;
        //this.endingTime = endingTime;
    }

    public int getDroneQuantity() {
        return droneQuantity;
    }

    public void setDroneQuantity(int droneQuantity) {
        this.droneQuantity = droneQuantity;
    }

    public Double getStartTime() {
        return startTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    /*
    public Double getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Double endingTime) {
        this.endingTime = endingTime;
    }
    */
    
}
