/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dronecounty;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 * @param <T>
 */
public class Grafo<T>{
    private ArrayList<Nodo<T>> Nodos;

    public Grafo() {
        this.Nodos = new ArrayList<>();
    }
}
