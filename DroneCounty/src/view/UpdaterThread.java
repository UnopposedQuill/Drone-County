/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Trip;

/**
 *
 * @author Esteban
 */
public class UpdaterThread extends Thread{

    private Trip tripToDraw;
    private long simulationTimer;
    
    @Override
    public void run() {
        while(!this.tripToDraw.getTimelines().isEmpty()){//this thread still has to send someone else
            
        }
    }
    
    
    
}
