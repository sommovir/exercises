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
import it.esercizi.blocco2.medium.m2.Sign;
import it.esercizi.blocco2.medium.m2.Tris;
import it.esercizi.blocco2.medium.m2.exceptions.OutOfGridException;
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
    private Sign[][] matrixEmpty = new Sign[][]{{Sign.EMPTY, Sign.EMPTY, Sign.EMPTY}, {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY}, {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY}};

    public Block2_Medium2_Test() {
    }

    private boolean checkArrays(Sign a[], Sign b[]) {
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

    private boolean checkMatrix(Sign a[][], Sign b[][]) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
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
                    forza4 = (Forza4) solution2For.getConstructor().newInstance();
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

    @Test
    public void testInit() {
        System.out.print("[TRIS][INIT][1][test inizializzazione griglia]..");

        try {
            boolean result = checkMatrix(tris.getGrid(), this.matrixEmpty);
            boolean expectedResult = true;
            assertEquals("[TRIS][INIT][1] valore aspettato: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testAddSign1() {
        System.out.print("[TRIS][ADD SIGN][1][test inserimento X at 0,0]..");

        try {
            tris.addSign(Sign.X, 0, 0);
            Sign[][] matrix = new Sign[][]{{Sign.X, Sign.EMPTY, Sign.EMPTY}, {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY}, {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY}};
            boolean result = checkMatrix(tris.getGrid(), matrix);
            boolean expectedResult = true;
            assertEquals("[TRIS][ADD SIGN][1] la griglia non è stata correttamente aggiornata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testAddSign2() {
        System.out.print("[TRIS][ADD SIGN][2][test inserimento X at 1,1]..");

        try {
            tris.addSign(Sign.O, 1, 1);
            Sign[][] matrix = new Sign[][]{{Sign.EMPTY, Sign.EMPTY, Sign.EMPTY}, {Sign.EMPTY, Sign.O, Sign.EMPTY}, {Sign.EMPTY, Sign.EMPTY, Sign.EMPTY}};
            boolean result = checkMatrix(tris.getGrid(), matrix);
            boolean expectedResult = true;
            assertEquals("[TRIS][ADD SIGN][1] la griglia non è stata correttamente aggiornata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testAddSign3() {
        System.out.print("[TRIS][ADD SIGN][3][test inserimenti multipli, non sovrascriventi]..");

        try {
            tris.addSign(Sign.O, 1, 1);
            tris.addSign(Sign.X, 1, 0);
            tris.addSign(Sign.O, 0, 2);
            tris.addSign(Sign.X, 2, 0);
            tris.addSign(Sign.O, 1, 2);

            Sign[][] matrix = new Sign[][]{{Sign.EMPTY, Sign.EMPTY, Sign.O}, {Sign.X, Sign.O, Sign.O}, {Sign.X, Sign.EMPTY, Sign.EMPTY}};
            boolean result = checkMatrix(tris.getGrid(), matrix);
            boolean expectedResult = true;
            assertEquals("[TRIS][ADD SIGN][1] la griglia non è stata correttamente aggiornata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t[OK]");
        successTest++;
    }

    @Test
    public void testAddSign4() {
        System.out.print("[TRIS][ADD SIGN][4][test inserimenti multipli, con sovrascritture]..");

        try {
            tris.addSign(Sign.O, 1, 1);
            tris.addSign(Sign.X, 1, 1);
            tris.addSign(Sign.O, 0, 2);
            tris.addSign(Sign.X, 2, 0);
            tris.addSign(Sign.O, 0, 2);

            Sign[][] matrix = new Sign[][]{{Sign.EMPTY, Sign.EMPTY, Sign.O}, {Sign.EMPTY, Sign.O, Sign.EMPTY}, {Sign.X, Sign.EMPTY, Sign.EMPTY}};
            boolean result = checkMatrix(tris.getGrid(), matrix);
            boolean expectedResult = true;
            assertEquals("[TRIS][ADD SIGN][4] la griglia non è stata correttamente aggiornata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t[OK]");
        successTest++;
    }

    @Test
    public void testAddSign5() {
        System.out.print("[TRIS][ADD SIGN][5][test inserimenti over bounds]..");

        try {
            tris.addSign(Sign.O, 1, 1);
            tris.addSign(Sign.X, 1, 1);
            tris.addSign(Sign.O, 0, 5);
            tris.addSign(Sign.X, 2, 0);
            tris.addSign(Sign.O, 0, 2);

        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[OK]");
            successTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[FAIL]");
        failedTest++;

    }

    @Test
    public void testAddSign6() {
        System.out.print("[TRIS][ADD SIGN][6][test inserimenti over bounds]..");

        try {
            tris.addSign(Sign.O, 1, 1);
            tris.addSign(Sign.X, 1, 1);
            tris.addSign(Sign.O, 0, 5);
            tris.addSign(Sign.X, -2, 0);
            tris.addSign(Sign.O, 0, 2);

        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[OK]");
            successTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[FAIL]");
        failedTest++;

    }

    @Test
    public void testAddSign7() {
        System.out.print("[TRIS][ADD SIGN][7][test inserimenti over bounds]..");

        try {
            tris.addSign(Sign.O, 1, -1);
            tris.addSign(Sign.X, 1, 1);
            tris.addSign(Sign.O, 0, 5);
            tris.addSign(Sign.X, -2, 0);
            tris.addSign(Sign.O, 0, 2);

        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[OK]");
            successTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[FAIL]");
        failedTest++;

    }

    @Test
    public void testAddSign8() {
        System.out.print("[TRIS][ADD SIGN][7][test inserimenti over bounds]..");

        try {
            tris.addSign(Sign.O, 1, 2);
            tris.addSign(Sign.X, 3, 1);
            tris.addSign(Sign.O, 0, 1);
            tris.addSign(Sign.X, 0, 0);
            tris.addSign(Sign.O, 0, 2);

        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[OK]");
            successTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[FAIL]");
        failedTest++;

    }

    @Test
    public void testClear() {
        System.out.print("[TRIS][CLEAR][1][riempe la griglia e poi la ripulisce]..");

        try {
            tris.addSign(Sign.O, 1, 1);
            tris.addSign(Sign.X, 2, 0);
            tris.addSign(Sign.O, 0, 2);
            tris.addSign(Sign.X, 2, 0);
            tris.addSign(Sign.O, 1, 2);
            tris.addSign(Sign.X, 2, 2);

            tris.clear();
            boolean result = checkMatrix(tris.getGrid(), matrixEmpty);
            boolean expectedResult = true;
            assertEquals("[TRIS][ADD SIGN][1] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testWW1() {
        System.out.print("[TRIS][WHOWIN][1][griglia vuota]..");

        try {
            tris.addSign(Sign.O, 0, 0);
            tris.clear();
            Sign result = tris.whowin();
            Sign expectedResult = null;
            assertEquals("[TRIS][WHOWIN][1] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testWW2() {
        System.out.print("[TRIS][WHOWIN][2][griglia incompleta]..");

        try {
            tris.addSign(Sign.O, 1, 1);
            tris.clear();
            Sign result = tris.whowin();
            Sign expectedResult = null;
            assertEquals("[TRIS][WHOWIN][2] la griglia non è stata correttamente ripulita ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testWW3() {
        System.out.print("[TRIS][WHOWIN][3][griglia quasi completa]..");

        try {
            tris.addSign(Sign.O, 0, 0);
            tris.addSign(Sign.X, 0, 1);
            tris.addSign(Sign.O, 0, 2);
            tris.addSign(Sign.X, 1, 0);
            tris.addSign(Sign.O, 1, 1);
            tris.addSign(Sign.X, 1, 2);
            tris.addSign(Sign.O, 2, 0);
            tris.addSign(Sign.X, 2, 1);
            Sign result = tris.whowin();
            Sign expectedResult = null;
            assertEquals("[TRIS][WHOWIN][3] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t\t[OK]");
        successTest++;
    }
    
    @Test
    public void testWW4() {
        System.out.print("[TRIS][WHOWIN][4][griglia non vincente]..");

        try {
            tris.addSign(Sign.O, 0, 0);tris.addSign(Sign.X, 0, 1);tris.addSign(Sign.X, 0, 2);
            tris.addSign(Sign.X, 1, 0);tris.addSign(Sign.O, 1, 1);tris.addSign(Sign.O, 1, 2);
            tris.addSign(Sign.O, 2, 0);tris.addSign(Sign.X, 2, 1);tris.addSign(Sign.X, 2, 2);
            
            Sign result = tris.whowin();
            Sign expectedResult = Sign.EMPTY;
            assertEquals("[TRIS][WHOWIN][4] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t\t[OK]");
        successTest++;
    }
    
    @Test
    public void testWW5() {
        System.out.print("[TRIS][WHOWIN][5][griglia vince O in prima colonna]..");

        try {
            tris.addSign(Sign.O, 0, 0);tris.addSign(Sign.X, 0, 1);tris.addSign(Sign.X, 0, 2);
            tris.addSign(Sign.O, 1, 0);tris.addSign(Sign.O, 1, 1);tris.addSign(Sign.X, 1, 2);
            tris.addSign(Sign.O, 2, 0);tris.addSign(Sign.X, 2, 1);tris.addSign(Sign.O, 2, 2);
            
            Sign result = tris.whowin();
            Sign expectedResult = Sign.O;
            assertEquals("[TRIS][WHOWIN][5] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }
    
    
    @Test
    public void testWW6() {
        System.out.print("[TRIS][WHOWIN][6][griglia vince O in seconda colonna]..");

        try {
            tris.addSign(Sign.O, 0, 0);tris.addSign(Sign.O, 0, 1);tris.addSign(Sign.X, 0, 2);
            tris.addSign(Sign.X, 1, 0);tris.addSign(Sign.O, 1, 1);tris.addSign(Sign.O, 1, 2);
            tris.addSign(Sign.X, 2, 0);tris.addSign(Sign.O, 2, 1);tris.addSign(Sign.X, 2, 2);
            
            Sign result = tris.whowin();
            Sign expectedResult = Sign.O;
            assertEquals("[TRIS][WHOWIN][6] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }
    
    @Test
    public void testWW7() {
        System.out.print("[TRIS][WHOWIN][7][griglia vince X in terza colonna]..");

        try {
            tris.addSign(Sign.O, 0, 0);tris.addSign(Sign.O, 0, 1);tris.addSign(Sign.X, 0, 2);
            tris.addSign(Sign.X, 1, 0);tris.addSign(Sign.O, 1, 1);tris.addSign(Sign.X, 1, 2);
            tris.addSign(Sign.O, 2, 0);tris.addSign(Sign.X, 2, 1);tris.addSign(Sign.X, 2, 2);
            
            Sign result = tris.whowin();
            Sign expectedResult = Sign.X;
            assertEquals("[TRIS][WHOWIN][7] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }
    
    
    @Test
    public void testWW8() {
        System.out.print("[TRIS][WHOWIN][8][griglia vince X in prima riga]..");

        try {
            tris.addSign(Sign.X, 0, 0);tris.addSign(Sign.X, 0, 1);tris.addSign(Sign.X, 0, 2);
            tris.addSign(Sign.X, 1, 0);tris.addSign(Sign.O, 1, 1);tris.addSign(Sign.O, 1, 2);
            tris.addSign(Sign.O, 2, 0);tris.addSign(Sign.X, 2, 1);tris.addSign(Sign.X, 2, 2);
            
            Sign result = tris.whowin();
            Sign expectedResult = Sign.X;
            assertEquals("[TRIS][WHOWIN][8] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }
    
    @Test
    public void testWW9() {
        System.out.print("[TRIS][WHOWIN][9][griglia vince O in seconda riga]..");

        try {
            tris.addSign(Sign.X, 0, 0);tris.addSign(Sign.X, 0, 1);tris.addSign(Sign.O, 0, 2);
            tris.addSign(Sign.O, 1, 0);tris.addSign(Sign.O, 1, 1);tris.addSign(Sign.O, 1, 2);
            tris.addSign(Sign.X, 2, 0);tris.addSign(Sign.O, 2, 1);tris.addSign(Sign.X, 2, 2);
            
            Sign result = tris.whowin();
            Sign expectedResult = Sign.O;
            assertEquals("[TRIS][WHOWIN][9] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }
    
    @Test
    public void testWW91() {
        System.out.print("[TRIS][WHOWIN][10][griglia vince O in terza riga]..");

        try {
            tris.addSign(Sign.O, 0, 0);tris.addSign(Sign.O, 0, 1);tris.addSign(Sign.X, 0, 2);
            tris.addSign(Sign.X, 1, 0);tris.addSign(Sign.X, 1, 1);tris.addSign(Sign.O, 1, 2);
            tris.addSign(Sign.O, 2, 0);tris.addSign(Sign.O, 2, 1);tris.addSign(Sign.O, 2, 2);
            
            Sign result = tris.whowin();
            Sign expectedResult = Sign.O;
            assertEquals("[TRIS][WHOWIN][10] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }
    
    @Test
    public void testWW92() {
        System.out.print("[TRIS][WHOWIN][11][griglia vince X in terza riga]..");

        try {
            tris.addSign(Sign.O, 0, 0);tris.addSign(Sign.O, 0, 1);tris.addSign(Sign.X, 0, 2);
            tris.addSign(Sign.X, 1, 0);tris.addSign(Sign.O, 1, 1);tris.addSign(Sign.O, 1, 2);
            tris.addSign(Sign.X, 2, 0);tris.addSign(Sign.X, 2, 1);tris.addSign(Sign.X, 2, 2);
            
            Sign result = tris.whowin();
            Sign expectedResult = Sign.X;
            assertEquals("[TRIS][WHOWIN][11] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }
    
    @Test
    public void testWW93() {
        System.out.print("[TRIS][WHOWIN][12][griglia vince O in prima diagonale]..");

        try {
            tris.addSign(Sign.O, 0, 0);tris.addSign(Sign.O, 0, 1);tris.addSign(Sign.X, 0, 2);
            tris.addSign(Sign.X, 1, 0);tris.addSign(Sign.O, 1, 1);tris.addSign(Sign.O, 1, 2);
            tris.addSign(Sign.X, 2, 0);tris.addSign(Sign.X, 2, 1);tris.addSign(Sign.O, 2, 2);
            
            Sign result = tris.whowin();
            Sign expectedResult = Sign.O;
            assertEquals("[TRIS][WHOWIN][12] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t[OK]");
        successTest++;
    }
    
    @Test
    public void testWW94() {
        System.out.print("[TRIS][WHOWIN][13][griglia vince X in seconda diagonale]..");

        try {
            tris.addSign(Sign.O, 0, 0);tris.addSign(Sign.O, 0, 1);tris.addSign(Sign.X, 0, 2);
            tris.addSign(Sign.X, 1, 0);tris.addSign(Sign.X, 1, 1);tris.addSign(Sign.O, 1, 2);
            tris.addSign(Sign.X, 2, 0);tris.addSign(Sign.X, 2, 1);tris.addSign(Sign.O, 2, 2);
            
            Sign result = tris.whowin();
            Sign expectedResult = Sign.X;
            assertEquals("[TRIS][WHOWIN][13] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t[OK]");
        successTest++;
    }
    
    @Test
    public void testWW95() {
        System.out.print("[TRIS][WHOWIN][14][griglia patta..");

        try {
            tris.addSign(Sign.O, 0, 0);tris.addSign(Sign.O, 0, 1);tris.addSign(Sign.X, 0, 2);
            tris.addSign(Sign.X, 1, 0);tris.addSign(Sign.X, 1, 1);tris.addSign(Sign.O, 1, 2);
            tris.addSign(Sign.O, 2, 0);tris.addSign(Sign.X, 2, 1);tris.addSign(Sign.O, 2, 2);
            
            Sign result = tris.whowin();
            Sign expectedResult = Sign.EMPTY;
            assertEquals("[TRIS][WHOWIN][14] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t\t\t[OK]");
        successTest++;
    }
    
    @Test
    public void testWW96() {
        System.out.print("[TRIS][WHOWIN][15][griglia patta..");

        try {
            tris.addSign(Sign.X, 0, 0);tris.addSign(Sign.X, 0, 1);tris.addSign(Sign.O, 0, 2);
            tris.addSign(Sign.O, 1, 0);tris.addSign(Sign.O, 1, 1);tris.addSign(Sign.X, 1, 2);
            tris.addSign(Sign.X, 2, 0);tris.addSign(Sign.O, 2, 1);tris.addSign(Sign.X, 2, 2);
            
            Sign result = tris.whowin();
            Sign expectedResult = Sign.EMPTY;
            assertEquals("[TRIS][WHOWIN][15] la griglia non è stata correttamente analizzata ", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (OutOfGridException e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            return;
        } catch (Exception e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        }
        System.out.println("\t\t\t\t\t\t[OK]");
        successTest++;
    }
}
