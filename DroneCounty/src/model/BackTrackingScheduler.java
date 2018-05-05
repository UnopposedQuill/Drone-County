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
