/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dronecounty;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Esteban
 */
public class DroneCounty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

    public static ArrayList<Trip> setJourney(int pNumberOfTrips, ArrayList<Nodo> pGraph){
        int numberOfNodes = pGraph.size();
        int randNumber;
        Random rand = new Random();
        ArrayList<Trip> tripList = new ArrayList<>();

        for(int nTrip=0; nTrip < pNumberOfTrips; nTrip++){
            Trip objTrip = new Trip();

            randNumber = rand.nextInt(numberOfNodes);
            objTrip.setOrigin(pGraph.get(randNumber));

            randNumber = rand.nextInt(numberOfNodes);
            objTrip.setDestination(pGraph.get(randNumber));

            //objTrip.setDijkstra();

            tripList.add(objTrip);
        }

        return tripList;
    }
    
}
