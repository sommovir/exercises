/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.soluzioni.lele.blocco2.medium.m1.provz01;

import it.esercizi.blocco2.medium.m1.logic.Animal;
import it.esercizi.blocco2.medium.m1.logic.Dog;
import it.esercizi.blocco2.medium.m1.logic.Sheep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author lele
 */
public class GabbiaX  {
    private List < Animal > animals = new ArrayList<>();

    public List<Animal> getAnimaliInGabbia() {
        return animals;
    }    
    
    public void addPecora(Sheep sheep){
        animals.add(sheep);
    }

    public void addDog(Dog dog){
        animals.add(dog);
    }
    
    public void removeDog(){      
        Iterator iterator = animals.iterator();
        
        while (iterator.hasNext()) {
            Object nextElement = iterator.next();
            if (nextElement instanceof Dog)
                iterator.remove();
        }        
    }
    
    public void display(){
        for (Animal animal : animals) {
            System.out.println(""+ animal.getName());
        }
        
        System.out.println("---------------");
    }
    
   public void minimizeV01(GabbiaX gabbia){
        int dog = 0;
        int sheep = 0;
        int equalizes;
        List < Animal > tempAnimals = new ArrayList<>();
        
        for (Animal animal : gabbia.getAnimaliInGabbia()) {
            if ( animal instanceof Dog){
                dog++;
            }else{
                sheep++;
            }
        }
        
        if (dog <= sheep){
            equalizes = dog;
        }else{
            equalizes = sheep;
        }
        
        dog = 0;
        sheep = 0;
        
        for (Animal animal : gabbia.getAnimaliInGabbia()) {
            if ( animal instanceof Dog){
                if ( dog < equalizes){
                    tempAnimals.add(animal);
                    dog++;
                }
            }else{
                if ( sheep < equalizes){
                    tempAnimals.add(animal);
                    sheep++;
                }
            }
            
            if ( sheep == dog )
                break;
        }
        
        animals = tempAnimals;
    }    
}
