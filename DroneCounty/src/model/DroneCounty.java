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
        
        Graph g = new Graph();
        
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        //----------------------------------
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        //----------------------------------
        g.addEdge(v1, v2, 1);
        g.addEdge(v1, v3, 2);
        g.addEdge(v1, v4, 1);
        g.addEdge(v1, v6, 4);
        //----------------------------------
        g.addEdge(v2, v1, 6);
        g.addEdge(v2, v4, 1);
        g.addEdge(v2, v5, 2);
        //----------------------------------
        g.addEdge(v3, v2, 3);
        g.addEdge(v3, v4, 1);
        g.addEdge(v3, v5, 4);
        g.addEdge(v3, v6, 1);
        //----------------------------------
        g.addEdge(v4, v1, 6);
        g.addEdge(v4, v5, 1);
        g.addEdge(v4, v6, 2);
        //----------------------------------
        g.addEdge(v5, v1, 1);
        g.addEdge(v5, v6, 2);
        //----------------------------------
        g.addEdge(v6, v1, 1);
        g.addEdge(v6, v2, 1);
        g.addEdge(v6, v3, 3);
        g.addEdge(v6, v5, 4);
        //----------------------------------
        Dijkstra d = new Dijkstra(g);
        d.execute(v1);
        ArrayList<Vertex> path = d.getPath(v6);
        path.forEach((vertex) -> {System.out.println(vertex);});

    }

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