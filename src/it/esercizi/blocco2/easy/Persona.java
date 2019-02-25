/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.esercizi.blocco2.easy;

/**
 * NON MODIFICARE
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class Persona {
    
    private String nome;
    private String cognome;
    private int age;

    public Persona() {
    }

    public Persona(String nome, String cognome, int age) {
        this.nome = nome;
        this.cognome = cognome;
        this.age = age;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj instanceof Persona){
            Persona p = (Persona)obj;
            if(this.nome.equals(p.nome) && this.cognome.equals(p.cognome) && this.age == p.age){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    
    
    
    
}
