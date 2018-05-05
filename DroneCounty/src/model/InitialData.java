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
public class InitialData {
    private static int nodeQty;
    private static int tripQty;
    private static int setUpTime;
    private static int timeRatio;
    private static int edgeQty;
    private static int trackHeight;
    private static int trackWidth;
    private static int maxDronePerTrack = (trackHeight*trackWidth)/(Drone.HEIGHT*Drone.WIDTH);
    public static int getNodeQty() {
        return nodeQty;
    }

    public static int getTripQty() {
        return tripQty;
    }

    public static int getSetUpTime() {
        return setUpTime;
    }

    public static int getTimeRatio() {
        return timeRatio;
    }

    public static int getEdgeQty() {
        return edgeQty;
    }

    public InitialData(int pNodeQty, int pTripQty, int pSetUpTime, int pEdgeQty) {
        nodeQty = pNodeQty;
        tripQty = pTripQty;
        setUpTime = pSetUpTime;
        //this.timeRatio = timeRatio;  //Debemos hacer la conversion de cuanto equivale 1 segundo en la simulacion
        edgeQty = pEdgeQty;
    }
}
