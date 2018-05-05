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
            int generatedRandomNumberCopy = generatedRandomNumber;
            while(trip.getTripTotalAmount() > 0){
                while(listTrip.stream().anyMatch((Trip t) -> {
                    return t.getTimelines().stream().anyMatch((Timeline time) -> {
                        return time.getStartTime().compareTo(timeLists.get(((Station)trip.getOrigin().getObjectInside()).getName()).get(generatedRandomNumberCopy)); //To change body of generated lambdas, choose Tools | Templates.
                    });
                })){
                    generatedRandomNumber = (int)(timeLists.get(((Station)trip.getOrigin().getObjectInside()).getName()).size() * random.nextDouble());
                }
                Timeline timeline = new Timeline(InitialData.getMaxDronePerTrack(), timeLists.get(((Station)trip.getOrigin().getObjectInside()).getName()).get(generatedRandomNumber));
                trip.setTripTotalAmount(trip.getTripTotalAmount()-InitialData.getMaxDronePerTrack());
                ArrayList<Timeline> tripTimeLines = trip.getTimelines();
                tripTimeLines.add(timeline);
                trip.setTimelines(tripTimeLines);
                timeLists.get(((Station)trip.getOrigin().getObjectInside()).getName()).remove(generatedRandomNumber);
            }
        }
        return listTrip;
    }
    
}
