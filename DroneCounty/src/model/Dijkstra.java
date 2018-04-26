/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//Conseguido de
//http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html

//it has to be completely rebuilt
//Esteban's going to do that

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
                Double newDistance = minimumDistances.get(v)+edge.getWeight();
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
}