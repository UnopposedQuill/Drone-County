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
public class Vertex<T>{
    
    private final T objectInside;
    
    public Vertex(T objectInside) {
        this.objectInside = objectInside;
        //this.neighbours = new ArrayList<>();
    }

    public T getObjectInside() {
        return objectInside;
    }
        
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.objectInside);
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
        final Vertex<?> other = (Vertex<?>) obj;
        return Objects.equals(this.objectInside, other.objectInside);
    }

    @Override
    public String toString() {
        return "Vertex {" + objectInside + '}';
    }
}

