/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dronecounty;

import java.util.*;

/**
 *
 * @author Esteban
 * @param <T>
 */
public class Vertex<T>{
    
    private T objectInside;

    public Vertex(T objectInside) {
        this.objectInside = objectInside;
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
        if (!Objects.equals(this.objectInside, other.objectInside)) {
            return false;
        }
        return true;
    }

    
}
