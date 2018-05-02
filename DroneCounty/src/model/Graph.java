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
    
    public Graph(Station[] stations, int stationNumber, int edgeNumber){
        this.vertexes = new HashSet<>();
        this.edges = new HashSet<>();
        Random random = new Random();
        Vertex possibleNewVertex;
        int generatedRandomNumber;
        //I have to get the new stations inside an N number of random stations taken from the Stations list
        while(this.vertexes.size() < stationNumber){
            generatedRandomNumber = (int)(stationNumber * random.nextDouble());
            possibleNewVertex = (Vertex<T>) new Vertex<>(stations[generatedRandomNumber]);
            if(generatedRandomNumber == 1 && !this.vertexes.contains(possibleNewVertex)){
                this.vertexes.add(possibleNewVertex);
            }
        }
        random.setSeed(0);//reset the random's seed, just in case
        //now i'm missing the edges only
        ArrayList<Vertex> vertexesWithoutEdgesToThem = new ArrayList<>(this.vertexes);
        for (Vertex<T> vertex : this.vertexes) {
            int edgeCount = 0;//this represents the number of edges already generated to that point
            while(edgeCount < edgeNumber){//I'd normally use a For, but I need further manipulation of edgeCount
                
                if(!vertexesWithoutEdgesToThem.isEmpty()){//I have to prioritize the vertexes who have no edges to them
                    //I'll pick a random one
                    generatedRandomNumber = (int)(vertexesWithoutEdgesToThem.size()*random.nextDouble());//I give myself one random position I can get
                    this.edges.add(new Edge(vertex, vertexesWithoutEdgesToThem.get(generatedRandomNumber), Math.hypot(((Station)vertex.getObjectInside()).getxPosition()-((Station)vertexesWithoutEdgesToThem.get(generatedRandomNumber).getObjectInside()).getxPosition(),
                            ((Station)vertex.getObjectInside()).getyPosition()-((Station)vertexesWithoutEdgesToThem.get(generatedRandomNumber).getObjectInside()).getyPosition())));//I add the edge to the arbitrary picked vertex
                    vertexesWithoutEdgesToThem.remove(generatedRandomNumber);//it now has at least one edge, so I'll remove it from the options
                    edgeCount++;//I just added an edge, so i'll add it to the count
                    continue;//next edge
                }
                //all the vertexes have edges to them, so, i'll pick the closest one that doesn't have an edge to it from this vertex
                PriorityQueue<Vertex> queueCloserVertexes = new PriorityQueue((vertex1, vertex2) -> (
                        Double.compare( Math.hypot(((Station)vertex.getObjectInside()).getxPosition()-((Station)((Vertex)vertex1).getObjectInside()).getxPosition(),
                                ((Station)vertex.getObjectInside()).getyPosition()-((Station)((Vertex)vertex1).getObjectInside()).getyPosition()),
                                Math.hypot(((Station)vertex.getObjectInside()).getxPosition()-((Station)((Vertex)vertex2).getObjectInside()).getxPosition(),
                                        ((Station)vertex.getObjectInside()).getyPosition()-((Station)((Vertex)vertex2).getObjectInside()).getyPosition()))
                        ));
                //all the vertexes can now ordered along their closeness to "vertex", which is the current iterating vertex whose number of output edges
                //I just have to pick the one that's in the peek to get the closer one to the current vertex of the iteration
                while(edgeCount < edgeNumber){//I'll fill the remaining edges using while, If I decided to use an "if", the algorithm would fill the remaining ones using just the closer vertex, which is absolutely a no-go
                    if(queueCloserVertexes.isEmpty()){//if it's empty, I cycled all the nodes available for use, so I'll refill it
                        queueCloserVertexes.addAll(this.vertexes);//I have to get the vertexes inside the queue
                    }
                    Vertex target = queueCloserVertexes.poll();//i take the closer one to the current vertex which hasnt' been cycled
                    this.edges.add(new Edge(vertex, target, 
                        Math.hypot(((Station)vertex.getObjectInside()).getxPosition()-((Station)target.getObjectInside()).getxPosition(),
                                   ((Station)vertex.getObjectInside()).getyPosition()-((Station)target.getObjectInside()).getyPosition())));//add an edge to it
                    edgeCount++;//I just added an edge, so i'll add it to the count
                }
            }
        }
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
