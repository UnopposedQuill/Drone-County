/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;
import java.util.function.Consumer;

/**
 *
 * @author Esteban
 * @param <T>
 */
public class Graph<T>{
    private final HashSet<Vertex<T>> vertexes;
    private final HashSet<Edge> edges;

    public Graph() {
        this.vertexes = new HashSet<>();
        this.edges = new HashSet<>();
    }
    
    public Graph(Station [] stations, int stationNumber, int edgeNumber){
        this.vertexes = new HashSet<>();
        this.edges = new HashSet<>();
        Random random = new Random();
        //I have to get the new stations inside
        for (int i = 0; i < stationNumber; i++) {
            
        }
        for (int i = 0; i < stations.length; i++) {
            this.addVertex(new Vertex<>(stations[i]));
        }
        //now i'm missing the edges only
        for (int i = 0; i < this.vertexes.size(); i++) {
            this.vertexes.stream().forEachOrdered((Vertex<T> vertex) -> {
                for (int j = 0; j < edgeNumber; j++) {
                    
                }
            });
            
        }
    }
   
    public boolean addVertex(Vertex<T>vertex){
        return this.vertexes.add(vertex);
    }
    
    public boolean addEdge(Vertex<T> vertex1, Vertex<T> vertex2, double weight){
        if(!(this.vertexes.contains(vertex1) && this.vertexes.contains(vertex2))){
            return false;
        }
        return this.edges.add(new Edge(vertex1, vertex2, weight));
    }
    
    public HashSet<Vertex<T>> getVertexes() {
        return this.vertexes;
    }

    public HashSet<Edge> getEdges() {
        return edges;
    }
}
