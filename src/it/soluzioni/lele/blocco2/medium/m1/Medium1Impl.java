/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.soluzioni.lele.blocco2.medium.m1;

import it.ann.Solution;
import it.esercizi.blocco2.medium.m1.Gabbia;
import it.esercizi.blocco2.medium.m1.Medium1;
import it.esercizi.blocco2.medium.m1.logic.Animal;
import it.esercizi.blocco2.medium.m1.logic.Dog;
import it.esercizi.blocco2.medium.m1.logic.Sheep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
@Solution
public class Medium1Impl implements Medium1 {
    
    /**
     * Restituisce la gabbia più popolosa trovata. Se più gabbie hanno lo stesso numero di animali è indifferente quale tra queste restituisce. 
     * @param gabbie
     * @return 
     */
    @Override
    public Gabbia mostPopulated(Gabbia... gabbie){
         throw new UnsupportedOperationException();
    }
    
    /**
     * pareggia la popolazione tra cani e pecora scegliendo il minimo tra le due ed eliminando gli eccessi. Ad esempio se in una gabbia ci sono 3 pecore e 5 cani
     * il metodo cancellerà 2 cani, non importa quali. Se invece ci sono 7 pecore e 2 cani, verranno cancellate 5 pecore. 
     * @param gabbia 
     */
    public void minimize(Gabbia gabbia){    
        int dog = 0;
        int sheep = 0;  
        int equalizes;
        
        List < Animal > tempAnimals = new ArrayList<>();
        
        Iterator it = gabbia.getAnimaliInGabbia().iterator();
        
        for (Animal animal : gabbia.getAnimaliInGabbia()) {
            if ( animal instanceof Dog){
                dog++;                
            }else{
                sheep++;                
            }
        }
        
        if (dog == sheep)
            return;
        
        if (dog <= sheep){
            equalizes = dog;
        }else{
            equalizes = sheep;
        }        

        for (int i = 0; i < equalizes; i++) {
            for (Iterator iterator = it; it.hasNext();) {
                if ( dog <= sheep ){
                    Object next = iterator.next();
                    
                    if ( next instanceof Sheep)
                        it.remove();
                    
                    break;
                }
                
                if ( sheep <= dog ){
                    Object next = iterator.next();
                            
                    if ( next instanceof Dog)
                        it.remove();
                    break;
                }            
            }
        }
    }       
    /**
     * sposta tutte le pecore dalla gabbia g1 alla gabbia g2
     * @param g1
     * @param g2 
     */
    public void moveSheep(Gabbia g1, Gabbia g2){
        for (Animal animal : g1.getAnimaliInGabbia()) {
            
        }
        
        
    }
    
}
