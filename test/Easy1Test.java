/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import it.esercizi.blocco1.easy.Easy1;
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
public class Easy1Test {

    private static int totalTest = 0;
    private static int successTest = 0;
    private static int failedTest = 0;

    public Easy1Test() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("------------------------------------------------");
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

    @Test
    public void testSomma() {
        System.out.print("[testing somma][1]..");
        int a = 3;
        int b = 5;
        Easy1 instance = new Easy1();
        int result = instance.somma(a, b);
        int expectedResult = 8;
        try {
            assertEquals("[testing somma][ERRORE] 3 + 5 != " + result, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t[OK]");
        successTest++;

    }

    @Test
    public void testSomma2() {
        System.out.print("[testing somma][2]..");
        int a = -3;
        int b = 5;
        Easy1 instance = new Easy1();
        int result = instance.somma(a, b);
        int expectedResult = 2;
        try {
            assertEquals("[testing somma2][ERRORE] -3 + 5 != " + result, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t[OK]");
        successTest++;
        //fail("[testing somma][ERRORE] 3 + 5 != "+result);

    }

    @Test
    public void testCountBlock1() {
        System.out.print("[testing countblock][1]..");
        Easy1 instance = new Easy1();
        String text = "ciao,belli";
        String separator = ",";
        int result = instance.countBlock(text, separator);
        int expectedResult = 2;
        try {
            assertEquals("[testing countblock][ERRORE] examining string= " + text + " and separator = '" + separator + "'", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t[OK]");
        successTest++;

    }

    @Test
    public void testCountBlock2() {
        System.out.print("[testing countblock][2]..");
        Easy1 instance = new Easy1();
        String text = "paolo-mario-pedro-alifrizzi";
        String separator = "-";
        int result = instance.countBlock(text, separator);
        int expectedResult = 4;
        try {
            assertEquals("[testing countblock][ERRORE] examining string= " + text + " and separator = '" + separator + "'", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t[OK]");
        successTest++;

    }

    @Test
    public void testCountBlock3() {
        System.out.print("[testing countblock][3]..");
        Easy1 instance = new Easy1();
        String text = "paolo-mario-pedro-alifrizzi";
        String separator = ",";
        int result = instance.countBlock(text, separator);
        int expectedResult = 1;
        try {
            assertEquals("[testing countblock][ERRORE] examining string= " + text + " and separator = '" + separator + "'", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t[OK]");
        successTest++;

    }

    @Test
    public void testCountBlock4() {
        System.out.print("[testing countblock][4]..");
        Easy1 instance = new Easy1();
        String text = "";
        String separator = ",";
        int result = instance.countBlock(text, separator);
        int expectedResult = 1;
        try {
            assertEquals("[testing countblock][ERRORE] examining string= " + text + " and separator = '" + separator + "'", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t[OK]");
        successTest++;

    }

    @Test
    public void testCountBlock5() {
        System.out.print("[testing countblock][5]..");
        Easy1 instance = new Easy1();
        String text = null;
        String separator = ",";
        try {
            int result = instance.countBlock(text, separator);
            int expectedResult = 0;

            assertEquals("[testing countblock][ERRORE] examining string= " + text + " and separator = '" + separator + "'", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t[OK]");
        successTest++;

    }

    @Test
    public void testCountBlock6() {
        System.out.print("[testing countblock][6]..");
        Easy1 instance = new Easy1();
        String text = "ciao,bella-come stai, tutt'ok ?,,sisi,";
        String separator = ",";
        int result = instance.countBlock(text, separator);
        int expectedResult = 5;
        try {
            assertEquals("[testing countblock][ERRORE] examining string= " + text + " and separator = '" + separator + "'", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t[OK]");
        successTest++;

    }

    @Test
    public void testCountBlock7() {
        System.out.print("[testing countblock][7]..");
        Easy1 instance = new Easy1();
        String text = "uno,,,,due,,tre,,,";
        String separator = ",";
        int result = instance.countBlock(text, separator);
        int expectedResult = 7;
        try {
            assertEquals("[testing countblock][ERRORE] examining string= " + text + " and separator = '" + separator + "'", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t[OK]");
        successTest++;

    }

    @Test
    public void testCountBlock8() {
        System.out.print("[testing countblock][7]..");
        Easy1 instance = new Easy1();
        String text = ",,,,,,,,,,,";
        String separator = ",";
        int result = instance.countBlock(text, separator);
        int expectedResult = 0;
        try {
            assertEquals("[testing countblock][ERRORE] examining string= " + text + " and separator = '" + separator + "'", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t[OK]");
        successTest++;

    }

    @Test
    public void testSumString() {
        System.out.print("[DEBUG][sumStrings]..");
        Easy1 instance = new Easy1();
        String s1 = "10";
        String s2 = "3";
        int result = instance.sumStrings(s1, s2);
        int expectedResult = 13;
        try {
            assertEquals("[testing countblock][ERRORE] 10 + 3 != " + result, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t[OK]");
        successTest++;

    }

}
