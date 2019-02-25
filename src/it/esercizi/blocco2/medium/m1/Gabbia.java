/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.esercizi.blocco2.medium.m1;

import it.esercizi.blocco2.medium.m1.logic.Dog;
import it.esercizi.blocco2.medium.m1.logic.Animal;
import it.esercizi.blocco2.medium.m1.logic.Sheep;
import java.util.List;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
public interface Gabbia {
    
    /**
     * svuota complemente la gabbia riportandola allo stato iniziale. 
     */
    public void clear();
    
    /**
     * aggiunge un cane alla gabbia
     * La gabbia però deve essere fatta in modo che non ci possano essere più cani di un solo padrone. 
     * Nel caso si tenta di inserire un cane con un padrone già esistente, la funzione ignora semplicemente e non lancia eccezioni
     * Nel caso invece si tenta di inserire un oggetto vuoto, il metodo lancerà una NullPointerException contenente il testuale messaggio: 'Input Nullo'
     * @param cane 
     */
    public void addDog(Dog cane) throws NullPointerException;
    
    /**
     * aggiunge una pecora alla gabbia
     * il metodo ignora input nulli o oggetti Sheep con il colore non settato o stringa vuota. 
     * @param pecora 
     */
    public void addPecora(Sheep pecora);
    
    /**
     * restituisce tutti gli animali contenuti nella gabbia
     * @return 
     */
    public List<Animal> getAnimaliInGabbia();
    
    /**
     * restituisce il totale dei cani contenuti nella gabbia
     * @return 
     */
    public int countDogs();
    
    /**
     * rimuove dalla gabbia tutti i cani
     */
    public void removeAllDog();
    
    /**
     * ritorna le pecore con il colore desiderato passato in input, Se l'input è una stringa vuota o null o non trova nulla ritorna una lista vuota.  
     * @param color
     * @return 
     */
    public List<Sheep> findSheepsByColor(String color);

    /**
     * E' l'override classico del metodo equals. Restituisce true se il contenuto dell'oggetto this e obj è lo stesso. False viceversa. 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj);
    
    
    
}
