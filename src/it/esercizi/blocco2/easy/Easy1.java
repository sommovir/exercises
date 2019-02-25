/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.esercizi.blocco2.easy;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class Easy1 {

    /**
     * Restituire la media dei n numeri dati in input.
     *
     * @param n
     * @return
     */
    public double media(int... n) {
        if(n == null || n.length == 0){
            return 0;
        }
        int sum = 0;
        for (int i : n) {
            sum+=i;
        }
        return sum/n.length;
    }

    /**
     * ritorna il numero di zeri contenuti nell'array in input
     *
     * @param array
     * @return
     */
    public int countZero(int[] array) {
        int zeros = 0;
        for (int i : array) {
            if (i == 0) zeros++;
        }
        return zeros;
    }

    /**
     * dati due array di interi in input di uguale dimensione (viceversa ritorna
     * un eccezione) ritorna un array che è la somma dei precedenti (c[i] = a[i]+b[i] )
     *
     * @param a
     * @param b
     * @return
     */
    public int[] sumArrays(int[] a, int[] b) throws Exception{
        if(a.length != b.length){
            throw new Exception();
        }
        int [] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            
            c[i] = a[i] + b[i];
        }
        return c;
    }

    /**
     * Data una stringa contenente i dati di una persona nel formato
     * NOME:COGNOME:AGE, il metodo parsa la stringa e ritorna l'oggetto Persona
     * corrispondente.
     *
     * @param string_person
     * @return
     */
    public Persona generatePersonaFromString(String string_person) {
        return null;
    }

}
