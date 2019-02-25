/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.esercizi.blocco2.medium.m1;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
public interface Medium1 {
    
    /**
     * Restituisce la gabbia più popolosa trovata. Se più gabbie hanno lo stesso numero di animali è indifferente quale tra queste restituisce. 
     * @param gabbie
     * @return 
     */
    public Gabbia mostPopulated(Gabbia... gabbie);
    
    /**
     * pareggia la popolazione tra cani e pecora scegliendo il minimo tra le due ed eliminando gli eccessi. Ad esempio se in una gabbia ci sono 3 pecore e 5 cani
     * il metodo cancellerà 2 cani, non importa quali. Se invece ci sono 7 pecore e 2 cani, verranno cancellate 5 pecore. 
     * @param gabbia 
     */
    public void minimize(Gabbia gabbia);
    
    
    /**
     * sposta tutte le pecore dalla gabbia g1 alla gabbia g2
     * @param g1
     * @param g2 
     */
    public void moveSheep(Gabbia g1, Gabbia g2);
    
}
