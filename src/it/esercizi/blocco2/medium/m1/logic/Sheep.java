/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.esercizi.blocco2.medium.m1.logic;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
public class Sheep extends Animal{
    
    private String color;

    public Sheep() {
    }

    public Sheep(String color) {
        super("Pecora");
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
