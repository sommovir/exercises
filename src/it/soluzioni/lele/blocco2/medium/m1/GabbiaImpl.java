/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.soluzioni.lele.blocco2.medium.m1;

import it.ann.Solution;
import it.esercizi.blocco2.medium.m1.Gabbia;
import it.esercizi.blocco2.medium.m1.logic.Dog;
import it.esercizi.blocco2.medium.m1.logic.Animal;
import it.esercizi.blocco2.medium.m1.logic.Sheep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
@Solution
public class GabbiaImpl implements Gabbia{
    protected List <Animal> animals = new ArrayList<>();

    /**
     * svuota complemente la gabbia riportandola allo stato iniziale. 
     */
    @Override
    public void clear() {
        animals.clear();
    }
    
    /**
     * aggiunge un cane alla gabbia
     * La gabbia però deve essere fatta in modo che non ci possano essere più cani di un solo padrone. 
     * Nel caso si tenta di inserire un cane con un padrone già esistente, la funzione ignora semplicemente e non lancia eccezioni
     * Nel caso invece si tenta di inserire un oggetto vuoto, il metodo lancerà una NullPointerException contenente il testuale messaggio: 'Input Nullo'
     * @param cane 
     */
    @Override
    public void addDog(Dog cane) throws NullPointerException {
        if ( cane == null )
            throw new NullPointerException("Input Nullo");

        if ( animals.isEmpty() ){
            animals.add(cane);
            return;
        }
                
        for (Animal animal : animals) {
            if ( animal instanceof Dog){
                if ( ((Dog)animal).getPadrone() == cane.getPadrone() )
                    return;
            }
        }

        animals.add(cane);
    }
    
    /**
     * aggiunge una pecora alla gabbia
     * il metodo ignora input nulli o oggetti Sheep con il colore non settato o stringa vuota. 
     * @param pecora 
     */
    @Override
    public void addPecora(Sheep pecora) {
        
        if ( pecora == null)
            return;
        
        if ( pecora.getColor() == null )
            return;
        
        if ( pecora.getColor().equals(""))
            return;        

        animals.add(pecora);
    }
           
    /**
     * restituisce tutti gli animali contenuti nella gabbia
     * @return 
     */
    @Override
    public List<Animal> getAnimaliInGabbia() {
        return animals;
    }
    
    /**
     * restituisce il totale dei cani contenuti nella gabbia
     * @return 
     */
    @Override
    public int countDogs() {
        int dog = 0;
        
        for (Animal animal : animals) {
            if ( animal instanceof Dog ){
                dog++;
            }
        }
        return dog;
    }
    
    /**
     * rimuove dalla gabbia tutti i cani
     */
    @Override
    public void removeAllDog() {
        Iterator iterator = animals.iterator();
        
        while (iterator.hasNext()) {
            Object nextElement = iterator.next();
            
            if (nextElement instanceof Dog)
                iterator.remove();
        }  
    }
    
    /**
     * ritorna le pecore con il colore desiderato passato in input, Se l'input è una stringa vuota o null o non trova nulla ritorna una lista vuota.  
     * @param color
     * @return 
     */
    @Override
    public List<Sheep> findSheepsByColor(String color) {
        if ( color == null)
            return null;
        
        if ( color == "")
            return null;
        
        
        List < Sheep > sheeps = new ArrayList<>();
        
        for (Animal animal : animals) {
            if ( animal instanceof Sheep){
                if ( ((Sheep) animal).getColor() == color ){
                    sheeps.add( (Sheep)  animal );
                }
            }
        }
        return sheeps;
    }

    /**
     * E' l'override classico del metodo equals. Restituisce true se il contenuto dell'oggetto this e obj è lo stesso. False viceversa. 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        int dog01 = 0;
        int dog02 = 0;
        
        if ( obj == null ){
            return false;
        }
   
        if ( this == obj   ){
            return true;
        }
        
        if ( this.animals.isEmpty() && 
                ((GabbiaImpl)obj).animals.isEmpty()){
            return true;
        }
                
        return false;
    }

    
    /**
     * Nessuno riesce a vederlo!!!<
     */
    public void qualcosa(){
        
    }
}
