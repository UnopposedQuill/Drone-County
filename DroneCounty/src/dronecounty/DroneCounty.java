/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dronecounty;

import java.util.ArrayList;
import java.util.Random;

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
        //initGraphNodes(5);
    }
   
    public static void initGraphNodes(int quantity, ArrayList nodeList){
        Random rand = new Random();
        for(int i = 0; i<quantity; i++){
            int  n = rand.nextInt(30) + 0;
            //node temporaryNode = nodeList.get(n);
            //if nodeListFinal.contains(temporaryNode){
            //
            //}
            //else{
            //nodeListFinal.add(
            //}
        } 
    }
}
