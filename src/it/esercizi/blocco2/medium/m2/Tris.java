/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.esercizi.blocco2.medium.m2;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
public abstract class Tris {
    
    private Sign[][] grid = new Sign[3][3];

    public Tris() {
        init();
    }
    
    /**
     * setta la griglia tutta a valore Sign.EMPTY
     */
    protected abstract void init();
    
    
    public Sign[][] getGrid(){
        return this.grid;
    }
    
    /**
     * Aggiunge un segno alla griglia indicando in quale riga (row) e in quale colonn (col). Il segno non può sovrascrivere un segno già esistente. 
     * Inoltre se i parametri in input eccedono le dimensioni della matrice va ritornata una IndexOutOfBoundsException
     * @param sign
     * @param row
     * @param col 
     */
    public abstract void addSign(Sign sign, int row, int col) throws IndexOutOfBoundsException;
    
    /**
     * ritorna null se la griglia è ancora incompleta, se invece è completa e nessuno a vinto ritorna Sign.EMPTY. Viceversa ritorna il segno del vincitore
     * @return 
     */
    public abstract Sign whowin();
    
    
    /**
     * stampa la griglia come da esempio: 
     * |X|O|O|
     * | |X| |
     * |O| |X|
     * Sign.X diventa 'X'    Sign.Y diventa 'Y'  e Sign.EMPTY diventa uno spazio vuoto. Inoltre vengono inserite delle barrette verticali per decorazione.
     */
    public abstract void printGrid();
    
    /**
     * riporta allo stato iniziale la griglia
     */
    public abstract void clear();
    
    
    
    
    
}
