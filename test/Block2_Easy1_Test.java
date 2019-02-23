/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import esercizi.blocco2.easy.Easy1;
import esercizi.blocco2.easy.Persona;
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
 * @author Luca Coraci <luca.coraci@istc.cnr.it> ISTC-CNR
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Block2_Easy1_Test {

    private static int totalTest = 0;
    private static int successTest = 0;
    private static int failedTest = 0;

    public Block2_Easy1_Test() {
    }

    @BeforeClass
    public static void setUpClass() {
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
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testMedia1() {

        System.out.print("[EASY][MEDIA][1]..");
        Easy1 instance = new Easy1();

        try {
            double result = instance.media(new int[]{1});
            double expectedResult = 1d;
            assertEquals("[EASY][MEDIA][1][ERRORE] array = {1} media should be: " + expectedResult, expectedResult, result, 0.00001d);
        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
        }
        System.out.println("\t[OK]");
        successTest++;

    }

    @Test
    public void testMedia2() {

        System.out.print("[EASY][MEDIA][2]..");
        Easy1 instance = new Easy1();
        try {
            double result = instance.media(new int[]{1, 2, 3, 4, 5});
            double expectedResult = 3d;
            assertEquals("[EASY][MEDIA][2][ERRORE] array = {1,2,3,4,5} media should be: " + expectedResult, expectedResult, result, 0.00001d);
        } catch (AssertionError e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
        }
        System.out.println("\t[OK]");
        successTest++;

    }

    @Test
    public void testMedia3() {

        System.out.print("[EASY][MEDIA][3]..");
        Easy1 instance = new Easy1();
        try {
            double result = instance.media(null);
            double expectedResult = 0;

            assertEquals("[EASY][MEDIA][3][ERRORE] array = null media should be: " + expectedResult, expectedResult, result, 0.00001d);
        } catch (AssertionError e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            return;
        }
        System.out.println("\t[OK]");
        successTest++;

    }

    @Test
    public void testCountZero1() {

        System.out.print("[EASY][COUNTZERO][1]..");
        Easy1 instance = new Easy1();
        try {
            int[] numbers = new int[]{0, 1, 1, 0, 0};
            int result = instance.countZero(numbers);
            int expectedResult = 3;

            assertEquals("[EASY][COUNTZERO][1][ERRORE] array = {0,1,1,0,0} numbers of zero should be: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            return;
        }
        System.out.println("\t[OK]");
        successTest++;

    }

    @Test
    public void testCountZero2() {

        System.out.print("[EASY][COUNTZERO][2]..");
        Easy1 instance = new Easy1();
        try {
            int result = instance.countZero(new int[]{1});
            int expectedResult = 0;

            assertEquals("[EASY][COUNTZERO][2][ERRORE] array = {1} numbers of zero should be: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            return;
        }
        System.out.println("\t[OK]");
        successTest++;
    }

    @Test
    public void testCountZero3() {

        System.out.print("[EASY][COUNTZERO][3]..");
        Easy1 instance = new Easy1();
        try {
            int result = instance.countZero(new int[]{});
            int expectedResult = 0;
            assertEquals("[EASY][COUNTZERO][3][ERRORE] array = {} numbers of zero should be: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            return;
        }
        System.out.println("\t[OK]");
        successTest++;
    }

    @Test()
    public void testSumArrays() {

        System.out.print("[EASY][SUM ARRAYS][1]..");
        Easy1 instance = new Easy1();
        try {
            int a[] = new int[]{1, 2};
            int b[] = new int[]{4, 4, 4};
            instance.sumArrays(a, b);

//            assertEquals("[EASY][SUM ARRAYS][1][ERRORE] array = {} numbers of zero should be: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t[OK]");
            successTest++;

            return;
        }
        System.out.println("\t[FAIL]");
        failedTest++;
        assertFalse(true);

    }
    
    private boolean checkArrays(int a[], int b[]){
        if(a.length!=b.length){
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    
    @Test
    public void testSumArrays2() {

        System.out.print("[EASY][SUM ARRAYS][2]..");
        Easy1 instance = new Easy1();
        try {
            int a[] = new int[]{1, 2, -7, 5};
            int b[] = new int[]{4, 3, 12, 0};
            int[] result = instance.sumArrays(a, b);
            int[] expectedResult = new int[]{5,5,5,5};
            
            
            assertTrue("[EASY][SUM ARRAYS][2][ERRORE]", checkArrays(result, expectedResult));
        } catch (AssertionError e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            assertFalse(true);
            return;
        }
        System.out.println("\t[OK]");
        successTest++;
    }
    
    
    @Test
    public void testGeneratePersonaFromString() {

        System.out.print("[EASY][GENERATE PERSON FROM STRING][1]..");
        Easy1 instance = new Easy1();
        try {
            String persona = "Paolo:Rossi:22";
            Persona expectedResult = new Persona("Paolo", "Rossi", 22);
            Persona result = instance.generatePersonaFromString(persona);
            
            
            assertEquals("[EASY][GENERATE PERSON FROM STRING][1][ERRORE]", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            return;
        }
        System.out.println("\t[OK]");
        successTest++;
    }
    
    @Test
    public void testGeneratePersonaFromString2() {

        System.out.print("[EASY][GENERATE PERSON FROM STRING][2]..");
        Easy1 instance = new Easy1();
        try {
            String persona = "Sara::27";
            Persona expectedResult = new Persona("Sara", "", 27);
            Persona result = instance.generatePersonaFromString(persona);
            
            
            assertEquals("[EASY][GENERATE PERSON FROM STRING][2][ERRORE]", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            return;
        }
        System.out.println("\t[OK]");
        successTest++;
    }

}
