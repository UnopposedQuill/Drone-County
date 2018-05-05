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
public class DroneCounty {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        InitialData iData = new InitialData(4, 2000000, 100, 2, 100,500,1,1);

        Graph<Station> g = new Graph<>(ConstantData.stations, InitialData.getNodeQty(), InitialData.getEdgeQty());
        System.out.println(g.toString());
        ArrayList <DijkstraRoad> allRoads = Dijkstra.calculateAllRoads(g);
        System.out.println(DijkstraRoad.fullDijkstraRoadsToString(allRoads));
        ArrayList<Trip> trips = Scheduler.calculateAllTrips(allRoads,1000, 1000, InitialData.getTripQty());
        System.out.println(ConstantData.getPosibilities(trips, g));
        System.out.println(Scheduler.calculateAllTrips(allRoads,1000, 1000, 20000));
        ArrayList<Trip> allTheTrips = Scheduler.calculateAllTrips(allRoads, 1000, 1000, 20000);
        System.out.println(Trip.fullTripToString(allTheTrips));
        ProbabilisticScheduler ps = new ProbabilisticScheduler();
        BackTrackingScheduler bts = new BackTrackingScheduler();
        Long beforePS = System.nanoTime();
        trips = ps.scheduleTrips(trips, ConstantData.TimeLists);
        Long afterPS = System.nanoTime();
        System.out.println(Trip.fullTripToString(trips));
        Long beforeBTS = System.nanoTime();
        trips = bts.scheduleTrips(trips, ConstantData.TimeLists);
        Long afterBTS = System.nanoTime();
        System.out.println(Trip.fullTripToString(trips));
        System.out.println("Probabilistic "+String.valueOf(afterPS-beforePS));
        System.out.println("BackTracking "+String.valueOf(afterBTS-beforeBTS));
        
    }

    /*
    //Obsolete method
    public static ArrayList<Trip> setJourney(int pNumberOfTrips, ArrayList<Vertex> pGraph){
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
        //initGraphNodes(5);
    }
*/
   
    public static ArrayList<Vertex> initGraphNodes(int quantity, ArrayList<Vertex> nodeList){
        Random rand = new Random();
        ArrayList<Vertex> nodeListFinal = new ArrayList<>();
        for(int i = 0; i<quantity; i++){
            int  n = rand.nextInt(30) + 0;
            Vertex temporaryNode = nodeList.get(n);
            if (!nodeListFinal.contains(temporaryNode)){
                nodeListFinal.add(temporaryNode);
            }
        }
        return nodeListFinal;
    }
}
