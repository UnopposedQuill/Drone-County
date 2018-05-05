/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author Esteban
 */
public class ProbabilisticScheduler extends Scheduler{
    
    /*
    Probabilistc algorithm meassurments: our analysis of the algorithm shows that this algorthim runs on a f(n)=7C(n)
    which means it posesses O(N). 
    */
    
    @Override
    public ArrayList<Trip> scheduleTrips(ArrayList<Trip> listTrip, HashMap<Integer, ArrayList<Double>> timeLists){
        for(Trip trip : listTrip){
            Random random = new Random();
            int generatedRandomNumber;
            while(trip.getTripTotalAmount()> 0){
                generatedRandomNumber = (int)(timeLists.get(((Station)trip.getOrigin().getObjectInside()).getName()).size() * random.nextDouble());
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
