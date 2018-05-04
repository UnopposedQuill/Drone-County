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
public class Dijkstra {
    
    public static DijkstraRoad calculateRoads(Graph g, Vertex initialVertex){
        HashMap<Vertex, ArrayList<Vertex>> predecessors = new HashMap<>();
        HashMap<Vertex, Double> minimumDistances = new HashMap<>();
        predecessors.put(initialVertex,new ArrayList<>());
        Iterator vertexIterator = g.getVertexes().iterator();
        while(vertexIterator.hasNext()){
            Vertex vertex = (Vertex)vertexIterator.next();
            minimumDistances.put(vertex, Double.POSITIVE_INFINITY);
        }
        minimumDistances.replace(initialVertex, 0.0);
        PriorityQueue<Vertex> queue = new PriorityQueue((vertex,vertex2) -> (
                minimumDistances.get((Vertex)vertex).compareTo(minimumDistances.get((Vertex)vertex2))
        ));
        queue.add(initialVertex);
        while(!queue.isEmpty()){
            Vertex v = queue.poll();
            for (int i = 0; i < g.findNeighbours(v).size(); i++) {
                Edge edge = (Edge)g.findNeighbours(v).get(i);
                Double newDistance = minimumDistances.get(v) + edge.getWeight();
                if(minimumDistances.get(edge.getVertex2()) > newDistance){
                    queue.remove(edge.getVertex2());
                    minimumDistances.replace(edge.getVertex2(), newDistance);
                    ArrayList <Vertex> temporalPredecessors = new ArrayList<>(predecessors.get(v));
                    temporalPredecessors.add(v);
                    predecessors.put(edge.getVertex2(), temporalPredecessors);
                    queue.add(edge.getVertex2());
                }
            }
        }
        return new DijkstraRoad(initialVertex, predecessors, minimumDistances);
    }
    
    public static ArrayList<DijkstraRoad> calculateAllRoads(Graph g){
        ArrayList<DijkstraRoad> allRoads = new ArrayList<>();
        Iterator initialVertexIterator = g.getVertexes().iterator();
        while(initialVertexIterator.hasNext()){
            allRoads.add(calculateRoads(g, (Vertex)initialVertexIterator.next()));
        }
        return allRoads;
    }
    
    public static ArrayList<Trip> calculateAllTrips(ArrayList<DijkstraRoad> dijkstraRoads, int height, int width, int tripMaximumQuantity){
        ArrayList<Trip> result = new ArrayList<>();
        int tripAmount = 0;
        for(DijkstraRoad dijkstraRoad: dijkstraRoads){
            Vertex vertex = dijkstraRoad.getInitial();
            for(Vertex v : dijkstraRoad.getPath().keySet()){
                if(!dijkstraRoad.getInitial().equals(vertex) && dijkstraRoad.getPath().get(vertex) != null){
                    tripAmount++;
                }
            }
        }
        int tripQtyPerStation = tripMaximumQuantity/tripAmount;
        int tripAssignmentCounter = 0;
        //for each vertex in the DijkstraRoad i have to add each vertex in the ".getPath()" method
        for (int i = 0; i < dijkstraRoads.size(); i++) {
            DijkstraRoad getDijkstraRoad = dijkstraRoads.get(i);
            //in this project we won't want to go from A to A, just specifications
            //i'll just stream all the vertexes while filtering them in order to skip the A to A jumps
            for(Vertex vertex:getDijkstraRoad.getPath().keySet()){
                if(!getDijkstraRoad.getInitial().equals(vertex) && getDijkstraRoad.getPath().get(vertex) != null){
                    result.add(new Trip(getDijkstraRoad.getInitial(), vertex, getDijkstraRoad.getPath().get(vertex), getDijkstraRoad.getMinimumDistances().get(vertex), new Track(width, height),tripQtyPerStation));
                    tripAssignmentCounter+=tripQtyPerStation;
                }
            }
        }
        if(tripAssignmentCounter>tripMaximumQuantity){
            Random random = new Random();
            int rng = (int)(random.nextDouble()*dijkstraRoads.size()*(dijkstraRoads.size()-1));
            result.get(rng).setTripTotalAmount(result.get(rng).getTripTotalAmount()+(tripAssignmentCounter-tripMaximumQuantity));
        }
        return result;
    }
}