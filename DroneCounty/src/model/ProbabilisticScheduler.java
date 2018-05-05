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
public class ProbabilisticScheduler extends Scheduler{
    
    /*
    I was thinking: Why do we have to bring a random choice of EVERY possible combination in order
    to make this a Probabilistic guy. Actually, he only needs to choose randomly on two different choices, right?
    */
    
    @Override
    public ArrayList<Trip> scheduleTrips(ArrayList<Trip> listTrip){
        return null;
    }
}
