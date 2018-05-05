/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class BackTrackingScheduler extends Scheduler{
    
    @Override
    public ArrayList<Trip> scheduleTrips(ArrayList<Trip> listTrip){
        for(Trip trip : listTrip ){
            
        }
        return null;
    }
    
    
    private boolean isAvailable(){
        return false;
    }
}
