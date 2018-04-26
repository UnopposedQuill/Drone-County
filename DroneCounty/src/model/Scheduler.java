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
public abstract class Scheduler {
    
    public abstract ArrayList<Trip> scheduleTrips(Graph<Station> G);
}
