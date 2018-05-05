/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author esteban
 */
public class ConstantData {
    
    public static int VELOCITY = 120;
    public static int TRACK_MAXIMUM_HEIGHT = 1000;
    public static HashMap<Integer, ArrayList<Double>> TimeLists = new HashMap<>();
    public static Station[] stations = {
            new Station(90.0, 70.0, 1), new Station(250.0, 60.0, 2), new Station(370.0, 90.0, 3), new Station(450.0, 40.0, 4), new Station(610.0, 60.0, 5),
            new Station(240.0, 150.0, 6), new Station(380.0, 170.0, 7), new Station(510.0, 160.0, 8), new Station(620.0, 130.0, 9), new Station(170.0, 260.0, 10),
            new Station(300.0, 240.0, 11), new Station(430.0, 230.0, 12), new Station(580.0, 250.0, 13), new Station(460.0, 320.0, 14), new Station(620.0, 420.0, 15),
            new Station(580.0, 570.0, 16), new Station(380.0, 570.0, 17), new Station(230.0, 420.0, 18), new Station(30.0, 420.0, 19), new Station(70.0, 600.0, 20),
            new Station(200.0, 630.0, 21), new Station(320.0, 580.0, 22), new Station(370.0, 490.0, 23), new Station(20.0, 410.0, 24), new Station(300.0, 350.0, 25),
            new Station(60.0, 280.0, 26), new Station(640.0, 600.0, 27), new Station(100.0, 630.0, 28), new Station(440.0, 230.0, 29), new Station(310.0, 440.0, 30)
    };
    
    public static HashMap getPosibilities(ArrayList<Trip> pTripLists, Graph pGraph){
        double clock = 0;
        int tripIndex = 0;
        int MAX = pTripLists.size();
        ArrayList<Trip> uninsertable = new ArrayList<>();

        while(clock < InitialData.getSetUpTime()){
            if(tripIndex == MAX){
                tripIndex = 0;
            }
            double clockReference = clock;
            
            if(TimeLists.values().stream().anyMatch((ArrayList<Double> t) -> t.contains(clockReference))){
                clock += 0.10;
            }else {
                HashMap<Integer, ArrayList<Double>> newHours = TripFits(pTripLists.get(tripIndex), clock, pGraph);
                if(!newHours.isEmpty()){
                    TimeLists.putAll(newHours);
                }
                else{
                    uninsertable.add(pTripLists.get(tripIndex));
                }
                tripIndex++;
                clock += 0.10;
            }
        }
        clock = 0;
        tripIndex = 0;
        MAX = uninsertable.size();
        while(!uninsertable.isEmpty()){
            if(tripIndex == MAX){
                tripIndex = 0;
            }
            if(clock > InitialData.getSetUpTime()){
                clock = 0;
            }
            double clockReference = clock;
            if(TimeLists.values().stream().anyMatch((ArrayList<Double> t) -> t.contains(clockReference))){
                clock += 0.10;
            }else {
                HashMap<Integer, ArrayList<Double>> newHoursForUninserted = TripFits(uninsertable.get(tripIndex), clock, pGraph);
                if(!newHoursForUninserted.isEmpty()){
                    TimeLists.putAll(newHoursForUninserted);
                    uninsertable.remove(tripIndex);
                }
                tripIndex++;
                clock += 0.10;
            }
        }
        return TimeLists;
    }

    private static HashMap<Integer, ArrayList<Double>> TripFits(Trip pTrip, double pClock, Graph pGraph){
        HashMap<Vertex, Double> minimumDistancesOfTrips;
        minimumDistancesOfTrips = new HashMap<>();
        HashMap<Integer, ArrayList<Double>> TimesOfTrips = new HashMap<>();
        ArrayList<Double> hours = new ArrayList<>();
        hours.add(pClock);
        TimesOfTrips.put(((Station) pTrip.getRoute().get(0).getObjectInside()).getName(), hours);
        boolean fitsFine = true;
        ArrayList<Double> timeForDestiny = new ArrayList<>();
        ArrayList<DijkstraRoad> allRoads = Dijkstra.calculateAllRoads(pGraph);
        pTrip.setDistances(allRoads);
        for(int routeIndex = 0; routeIndex < (pTrip.getRoute().size()) ; routeIndex++){

            for (DijkstraRoad path : allRoads) {
                minimumDistancesOfTrips = path.getMinimumDistances();
                if(routeIndex+1 < pTrip.getRoute().size() && minimumDistancesOfTrips.keySet().contains(pTrip.getRoute().get(routeIndex + 1))){
                    if( TimesOfTrips.get(((Station) pTrip.getRoute().get(routeIndex + 1).getObjectInside()).getName()) != null){
                        timeForDestiny.add((path.getMinimumDistances().get(pTrip.getRoute().get(routeIndex + 1)) / 120) * 3600);
                        hours = TimesOfTrips.get(((Station) pTrip.getRoute().get(routeIndex + 1).getObjectInside()).getName());
                        for(Double time : timeForDestiny){
                            hours.add(time);
                        }
                        TimesOfTrips.put(((Station) pTrip.getRoute().get(routeIndex + 1).getObjectInside()).getName(), hours);
                    }else{
                        TimesOfTrips.put(((Station) pTrip.getRoute().get(routeIndex + 1).getObjectInside()).getName(), timeForDestiny);
                    }
                }
                /*
                if (path.getInitial() == pTrip.getRoute().get(routeIndex) && routeIndex+1 < pTrip.getRoute().size()) {
                    timeForDestiny.add((path.getMinimumDistances().get(pTrip.getRoute().get(routeIndex + 1)) / 120) * 3600);
                    try {
                        if (TimeLists.containsValue(timeForDestiny)) {
                            TimesOfTrips.clear();
                            fitsFine = false;
                            break;
                        } else {
                            if( TimesOfTrips.get(((Station) pTrip.getRoute().get(routeIndex + 1).getObjectInside()).getName()) != null){
                                hours = TimesOfTrips.get(((Station) pTrip.getRoute().get(routeIndex + 1).getObjectInside()).getName());
                                for(double time : timeForDestiny){
                                    hours.add(time);
                                }
                                TimesOfTrips.put(((Station) pTrip.getRoute().get(routeIndex + 1).getObjectInside()).getName(), hours);
                            }else{
                                TimesOfTrips.put(((Station) pTrip.getRoute().get(routeIndex + 1).getObjectInside()).getName(), timeForDestiny);
                                //timeForDestiny.clear();
                            }
                        }
                    } catch (Exception e) {
                        TimesOfTrips.clear();
                        fitsFine = false;
                        break;
                    }
                }*/
            }
        }
        if(fitsFine)
            return TimesOfTrips;
        else {
            TimesOfTrips.clear();
            return TimesOfTrips;
        }
    }
}