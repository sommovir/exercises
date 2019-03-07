package it;

import it.esercizi.blocco2.medium.m1.logic.Sheep;
import it.soluzioni.lele.blocco2.medium.m1.GabbiaImpl;
import it.soluzioni.lele.blocco2.medium.m1.GabbiaLele;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
public class Main {
    public static void main(String[] args) {
        GabbiaImpl gabbiaImpl = new GabbiaImpl();
        Sheep sh1 = new Sheep();
        
        gabbiaImpl.addPecora(sh1);

    }
    
}
