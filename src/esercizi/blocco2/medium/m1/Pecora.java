/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizi.blocco2.medium.m1;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
public class Pecora extends Animal{
    
    private String color;

    public Pecora() {
    }

    public Pecora(String color) {
        super("Percora");
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
