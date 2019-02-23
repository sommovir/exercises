/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizi.blocco1.easy;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
public class Easy1 {
    
    /**
     * return the sum of a and b
     * @param a
     * @param b
     * @return 
     */
    public int somma(int a, int b){
        return a+b;
    }
    
    /**
     * returns how many text block are separated by <separator> 
     * Example 1: "ciao,a,tutti" with separator "," contains 3 blocks
     * Example 2: "mario/gino and separator "/" contains 2 blocks
     * Example 3: "alfonso-" with separator  "-" contains 1 block.
     * Example 4: "mario,,,gino,pina,," and "," contains 5 blocks. (IMPORTANT: final empty blocks doesnt counts)
     * Example 4B: "mario,gino,,,,,,,,,,,,,,,,,," and "," contains 2 blocks
     * Example 4C: "mario,,gino,,,,,,,,,,,,," and "," contains 3 blocks. 
     * Example 4D: ",,,,,,,,,," and "," contains 0 blocks because all blocks are empty
     * Example 5: "mario,gino,strada" and "-" separator contains 1 block even if "-" separator is never encountered. But it counts as a unique block. 
     * Note: empty string will result always as a one block. But if the input is nulle, blocks are zero.  
     * 
     * IMPORTANT !!!!!!!!!!!! DO NOT USE "split" method of String class. 
     * 
     * @param text
     * @param separator
     * @return 
     */
    public int countBlock(String text, String separator){

        return -1;
    }
    
    /**
     * FIND THE BUG
     * This method should return the int result after converting and summing the inputs. 
     * @param s1
     * @param s2
     * @return 
     */
    public int sumStrings(String s1, String s2){
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s1);
        
        return n1+n2;
    }
    
    public static void main(String[] args) {
        System.out.println("test");
        String t = "mario,gino,,,,,,,,,,,,,";
        String[] split = t.split(",");
        for (String string : split) {
            System.out.println("BLOCCO: "+string);
        }
        System.out.println("blocchi = "+split.length);
        
    }
    
}
