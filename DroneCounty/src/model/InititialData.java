/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Elias
 */
public class InititialData {
    private int nodeQty;
    private int tripQty;
    private int setUpTime;
    private int timeRatio;
    private int edgeQty;

    public int getNodeQty() {
        return nodeQty;
    }

    public int getTripQty() {
        return tripQty;
    }

    public int getSetUpTime() {
        return setUpTime;
    }

    public int getTimeRatio() {
        return timeRatio;
    }

    public int getEdgeQty() {
        return edgeQty;
    }

    public InititialData(int nodeQty, int tripQty, int setUpTime, int edgeQty) {
        this.nodeQty = nodeQty;
        this.tripQty = tripQty;
        this.setUpTime = setUpTime;
        //this.timeRatio = timeRatio;
        this.edgeQty = edgeQty;
    }
    
    
    
}
