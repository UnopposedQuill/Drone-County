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
 * @param <T>
 */
public class Graph<T>{
    private final HashSet<Vertex<T>> vertexes;
    private final HashSet<Edge> edges;

    public Graph() {
        this.vertexes = new HashSet<>();
        this.edges = new HashSet<>();
    }
    
    public Graph(ArrayList<Station>stations, int stationNumber, int edgeNumber){
        this.vertexes = new HashSet<>();
        this.edges = new HashSet<>();
        Random random = new Random();
        //I have to get the new stations inside
        /*
        for (int i = 0; i < stationNumber; i++) {
            
        }
        for (int i = 0; i < stations.size(); i++) {
            this.addVertex(new Vertex<>(stations.get(i)));
        }
        //now i'm missing the edges only
        for (int i = 0; i < this.vertexes.size(); i++) {
            this.vertexes.stream().forEachOrdered((Vertex<T> vertex) -> {
                for (int j = 0; j < edgeNumber; j++) {
                    
                }
            });
            
        }
        */
    }
   
    public boolean addVertex(Vertex<T> vertex){
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
    
    public ArrayList<Edge> findNeighbours(Vertex<T> vertex){
        ArrayList<Edge> answer = new  ArrayList<>();
        this.edges.stream().forEach((Edge e) -> {
            if(e.getVertex1().equals(vertex)){
                answer.add(e);
            }
        });
        return answer;
    }
}
