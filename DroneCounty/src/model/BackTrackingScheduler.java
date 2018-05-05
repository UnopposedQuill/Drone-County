/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Esteban
 */
public class BackTrackingScheduler extends Scheduler{
    
    /**
     * This is a BackTracking version of the Scheduler.
     * It runs on a O(N^2) where N = AmountOfTrips * (DroneCountPerTrip/MaximumDronesPerTrack)
     * @param listTrip
     * @param timeLists
     * @return 
     */
    @Override
    public ArrayList<Trip> scheduleTrips(ArrayList<Trip> listTrip, HashMap<Integer, ArrayList<Double>> timeLists){
        for(Trip trip : listTrip){
            Random random = new Random();
            int generatedRandomNumber = (int)(timeLists.get(((Station)trip.getOrigin().getObjectInside()).getName()).size() * random.nextDouble());
            while(trip.getTripTotalAmount() > 0){
                while(!isAvailable(listTrip, timeLists.get(((Station)trip.getOrigin().getObjectInside()).getName()).get(generatedRandomNumber))){
                    generatedRandomNumber = (int)(timeLists.get(((Station)trip.getOrigin().getObjectInside()).getName()).size() * random.nextDouble());
                }
                Timeline timeline = new Timeline(InitialData.getMaxDronePerTrack(), timeLists.get(((Station)trip.getOrigin().getObjectInside()).getName()).get(generatedRandomNumber));
                trip.setTripTotalAmount(trip.getTripTotalAmount()-InitialData.getMaxDronePerTrack());
                ArrayList<Timeline> tripTimeLines = trip.getTimelines();
                tripTimeLines.add(timeline);
                trip.setTimelines(tripTimeLines);
            }
        }
        return listTrip;
    }
    
    /**
     * This is an auxiliary method for the main schedule() method.
     * This method checks an arrayList of trips to see whether or not a given time is available for use
     * It runs on a O(N) where N = Amount of Trips
     * @param listTrip The trips to verify
     * @param d A given Double to check if it's available for re-use
     * @return A boolean that represents whether or not @d is available
     */
    private boolean isAvailable(ArrayList<Trip> listTrip, Double d){
        for (int i = 0; i < listTrip.size(); i++) {
            Trip get = listTrip.get(i);
            for (int j = 0; j < get.getTimelines().size(); j++) {
                Timeline get1 = get.getTimelines().get(j);
                if(get1.getStartTime().equals(d)){
                    return false;
                }
            }
        }
        return true;
    }
}
