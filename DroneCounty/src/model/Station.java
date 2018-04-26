/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Esteban
 */
public class Station {
    private final double xPosition, yPosition;

    public Station(double xPosition, double yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.xPosition) ^ (Double.doubleToLongBits(this.xPosition) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.yPosition) ^ (Double.doubleToLongBits(this.yPosition) >>> 32));
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
        final Station other = (Station) obj;
        if (Double.doubleToLongBits(this.xPosition) != Double.doubleToLongBits(other.xPosition)) {
            return false;
        }
        if (Double.doubleToLongBits(this.yPosition) != Double.doubleToLongBits(other.yPosition)) {
            return false;
        }
        return true;
    }
    
    
}
