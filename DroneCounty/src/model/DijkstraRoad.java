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
public class DijkstraRoad {
 
    private final Vertex initial;//I need this in order to remember which initial node produced this path
    private final HashMap<Vertex, ArrayList<Vertex>> path;
    private final HashMap<Vertex, Double> minimumDistances;

    public DijkstraRoad(Vertex initial, HashMap<Vertex, ArrayList<Vertex>> path, HashMap<Vertex, Double> minimumDistances) {
        this.initial = initial;
        this.path = path;
        this.minimumDistances = minimumDistances;
    }

    public Vertex getInitial() {
        return initial;
    }
    
    public HashMap<Vertex, ArrayList<Vertex>> getPath() {
        return path;
    }

    public HashMap<Vertex, Double> getMinimumDistances() {
        return minimumDistances;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.path);
        hash = 29 * hash + Objects.hashCode(this.minimumDistances);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DijkstraRoad other = (DijkstraRoad) obj;
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.minimumDistances, other.minimumDistances)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DijkstraRoad: Initial=" + initial + ", closest path=" + path + ", minimum distance=" + minimumDistances;
    }
}