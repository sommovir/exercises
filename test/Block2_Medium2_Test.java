/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import it.ann.AnnotationRunTimeProcessor;
import it.esercizi.blocco2.easy.Easy1;
import it.esercizi.blocco2.medium.m1.Gabbia;
import it.esercizi.blocco2.medium.m1.Medium1;
import it.esercizi.blocco2.medium.m1.logic.Animal;
import it.esercizi.blocco2.medium.m1.logic.Dog;
import it.esercizi.blocco2.medium.m1.logic.Sheep;
import it.esercizi.blocco2.medium.m2.Forza4;
import it.esercizi.blocco2.medium.m2.Tris;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Block2_Medium2_Test {

    private static int totalTest = 0;
    private static int successTest = 0;
    private static int failedTest = 0;
    private static Tris tris = null;
    private static Forza4 forza4 = null;


    public Block2_Medium2_Test() {
    }

    private boolean checkArrays(int a[], int b[]) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {

            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    @BeforeClass
    public static void setUpClass() {
        try {
            System.out.println("[JUNIT] looking for solution..");
            Class<?> solutionFor = AnnotationRunTimeProcessor.getInstance().getSolutionFor(Tris.class);
            Class<?> solution2For = AnnotationRunTimeProcessor.getInstance().getSolutionFor(Forza4.class);
            if (solutionFor != null && solution2For != null) {

                System.out.print("[JUNIT] instantiating solution..");

                try {
                    tris = (Tris) solutionFor.getConstructor().newInstance();
                    forza4 = (Forza4) solutionFor.getConstructor().newInstance();
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(Block2_Medium1_Test.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(Block2_Medium1_Test.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Block2_Medium1_Test.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Block2_Medium1_Test.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Block2_Medium1_Test.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Block2_Medium1_Test.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (tris != null && forza4 != null) {
                    System.out.println("[OK] loaded.");
                } else {
                    System.out.println("[FAILED] test aborted.");
                    System.exit(1);
                }

                System.out.println("[JUNIT] Starting tests... \n\n");
            }

        } catch (IOException ex) {
            Logger.getLogger(Block2_Medium1_Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Block2_Medium1_Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @AfterClass
    public static void tearDownClass() {

        System.out.println("\n------------------------------------------------");
        System.out.println("Total test: " + totalTest);
        System.out.println("SUCCESS: " + successTest + "/" + totalTest);
        System.out.println("FAILED: " + failedTest);
    }

    @Before
    public void setUp() {
        totalTest++;
        if (tris != null) {
            tris.clear();
        }
        if (forza4 != null) {
            forza4.clear();
        }
    }

    @After
    public void tearDown() {
    }

}