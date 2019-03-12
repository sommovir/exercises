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
public abstract class Forza4 {
    
    private Sign[][] grid = new Sign[6][7];

    public Forza4() {
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
     * Aggiunge un gettonce con segno 'sign' alla griglia indicando in quale colonna (col) verrà inserito. Il gettone quindi
     * verrà impilato secondo le regole del gioco Forza4. Se un gettone viene inserito in una colonna già piena verrà lanciata IndexOutOfBoundsException
     * @param sign
     * @param row
     * @param col 
     */
    public abstract void insert(Sign sign, int col) throws IndexOutOfBoundsException;
    
    
     /**
     * ritorna null se la griglia è ancora incompleta, se invece è completa e nessuno a vinto ritorna Sign.EMPTY. Viceversa ritorna il segno del vincitore
     * @return 
     */
    public abstract Sign whowin();
    
    
    /**
     * stampa la griglia come da esempio: 
     * | | | | | | | |
     * | | | | | | | |
     * | | |X| | | | |
     * |X| |O| | | | |
     * |X|X|O| | |X| |
     * |O|O|X|O| |X| |
     * Sign.X diventa 'X'    Sign.Y diventa 'Y'  e Sign.EMPTY diventa uno spazio vuoto. Inoltre vengono inserite delle barrette verticali per decorazione.
     */
    public abstract void printGrid();
    
    /**
     * inverte i segni della riga passata come argomento. Non fa nulla se la riga eccede i bounds. 
     * @param row 
     */
    public abstract void invertiRiga(int row);
    
    
    /**
     * ritorna il numero delle colonne riempite fino in cima
     */
    public abstract int countOfFilledColumns();
    
    /**
     * riporta lo stato della griglia alla configurazione iniziale
     */
    public abstract void clear();
}
