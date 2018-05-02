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

    public static int velocity;
    public static int trackMaximumHeight;
    public static HashMap<Integer, ArrayList<Double>> TimeLists;
    public static Station[] stations = {
            new Station(90.0, 70.0, 1), new Station(250.0, 60.0, 2), new Station(370.0, 90.0, 3), new Station(450.0, 40.0, 4), new Station(610.0, 60.0, 5),
            new Station(240.0, 150.0, 6), new Station(380.0, 170.0, 7), new Station(510.0, 160.0, 8), new Station(620.0, 130.0, 9), new Station(170.0, 260.0, 10),
            new Station(300.0, 240.0, 11), new Station(430.0, 230.0, 12), new Station(580.0, 250.0, 13), new Station(460.0, 320.0, 14), new Station(620.0, 420.0, 15),
            new Station(580.0, 570.0, 16), new Station(380.0, 570.0, 17), new Station(230.0, 420.0, 18), new Station(30.0, 420.0, 19), new Station(70.0, 600.0, 20),
            new Station(200.0, 630.0, 21), new Station(320.0, 580.0, 22), new Station(370.0, 490.0, 23), new Station(20.0, 410.0, 24), new Station(300.0, 350.0, 25),
            new Station(60.0, 280.0, 26), new Station(640.0, 600.0, 27), new Station(100.0, 630.0, 28), new Station(440.0, 230.0, 29), new Station(310.0, 440.0, 30)
    };
    
    public HashMap getPosibilities(ArrayList<Trip> pTripLists, Graph pGraph){
        double clock = 0;
        int tripIndex = 0;

        while(clock < InititialData.getSetUpTime()){
            if(pTripLists.get(tripIndex) == null){ 
                break; 
            }
            double clockReference = clock;
            if(TimeLists.values().stream().anyMatch((ArrayList<Double> t) -> {
                return t.contains(clockReference);
            })){
                clock += 0.10;
            }else {
                HashMap<Integer, ArrayList<Double>> newHours = TripFits(pTripLists.get(tripIndex), clock, pGraph);
                if(!newHours.isEmpty()){
                    //queda concatenar ambos datos de las hashmaps y actualizar TimeLists
                    TimeLists.putAll(newHours);
                }
            }
        }
        return  TimeLists;
    }

    private HashMap<Integer, ArrayList<Double>> TripFits(Trip pTrip, double pClock, Graph pGraph){
        HashMap<Integer, ArrayList<Double>> TimesOfTrips = new HashMap<>();
        ArrayList<Double> hours = new ArrayList<>();
        hours.add(pClock);
        TimesOfTrips.put(((Station) pTrip.getRoute().get(0).getObjectInside()).getName(), hours);
        boolean fitsFine = true;
        ArrayList<Double> timeForDestiny = new ArrayList<>();
        for(int routeIndex=0; routeIndex<(pTrip.getRoute().size()-1);routeIndex++){
            ArrayList<DijkstraRoad> allRoads = Dijkstra.calculateAllRoads(pGraph);
            for (DijkstraRoad path : allRoads) {
                if (path.getInitial() == pTrip.getRoute().get(routeIndex)) {
                     timeForDestiny.add((path.getMinimumDistances().get(pTrip.getRoute().get(routeIndex + 1)) / 120) * 3600);
                    try {
                        if (TimeLists.containsValue(timeForDestiny)) {
                            TimesOfTrips.clear();
                            fitsFine = false;
                            break;
                        } else {
                            hours = TimesOfTrips.get(((Station) pTrip.getRoute().get(routeIndex + 1).getObjectInside()).getName());
                            hours.addAll(timeForDestiny);
                            TimesOfTrips.put(((Station) pTrip.getRoute().get(routeIndex + 1).getObjectInside()).getName(), hours);
                        }
                    } catch (Exception e) {
                        TimesOfTrips.clear();
                        fitsFine = false;
                        break;
                    }
                }
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