/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.soluzioni.lele.blocco2.medium.m1.provz01;

import it.esercizi.blocco2.medium.m1.Gabbia;
import it.esercizi.blocco2.medium.m1.logic.Animal;
import it.esercizi.blocco2.medium.m1.logic.Dog;
import it.esercizi.blocco2.medium.m1.logic.Sheep;
import java.util.List;

/**
 *
 * @author lele
 */
public class Prova01 {

    public Prova01() {

        GabbiaX gabbiaX = new GabbiaX();
        
        Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
        Dog sirio = new Dog("maremmano", "Sirio", "Gino");
        
        Sheep sh1 = new Sheep("Grigio");
        Sheep sh2 = new Sheep("Bianco");        
        Sheep sh3 = new Sheep("nero");        
        
        gabbiaX.addPecora(sh1);
        gabbiaX.addPecora(sh2);
        gabbiaX.addPecora(sh3);
        gabbiaX.addDog(alfonzo);
        gabbiaX.addDog(sirio);
        
        gabbiaX.display();
        gabbiaX.removeDog();
        
        gabbiaX.display();
        
    }
    
    public static void main(String[] args) {
        Prova01 prova01 = new Prova01();
    }
}

