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
public class Dog extends Animal{
    
    private String race;
    private String nome;
    private String padrone;

    public Dog() {
    }

    public Dog(String race, String nome, String padrone) {
        super("Cane");
        this.race = race;
        this.nome = nome;
        this.padrone = padrone;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPadrone() {
        return padrone;
    }

    public void setPadrone(String padrone) {
        this.padrone = padrone;
    }
    
    
    
}
