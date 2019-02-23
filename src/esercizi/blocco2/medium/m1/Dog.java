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
public class Dog extends Animal{
    
    private String race;

    public Dog() {
    }

    public Dog(String race) {
        super("Cane");
        this.race = race;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
    
}
