/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import it.ann.AnnotationRunTimeProcessor;
import it.esercizi.blocco2.easy.Easy1;
import it.esercizi.blocco2.medium.m1.Gabbia;
import it.esercizi.blocco2.medium.m1.Medium1;
import it.esercizi.blocco2.medium.m1.logic.Dog;
import it.esercizi.blocco2.medium.m1.logic.Sheep;
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
public class Block2_Medium1_Test {

    private static int totalTest = 0;
    private static int successTest = 0;
    private static int failedTest = 0;
    private static Gabbia gabbia = null;
    private static Gabbia gabbia2 = null;
    private static Medium1 medium = null;

    public Block2_Medium1_Test() {
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
            Class<?> solutionFor = AnnotationRunTimeProcessor.getInstance().getSolutionFor(Gabbia.class);
            Class<?> solution2For = AnnotationRunTimeProcessor.getInstance().getSolutionFor(Medium1.class);
            if (solutionFor != null && solution2For != null) {

                System.out.print("[JUNIT] instantiating solution..");

                try {
                    gabbia = (Gabbia) solutionFor.getConstructor().newInstance();
                    gabbia2 = (Gabbia) solutionFor.getConstructor().newInstance();
                    medium = (Medium1) solution2For.getConstructor().newInstance();
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
                if (gabbia != null && gabbia2 != null && medium != null) {
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
        if (gabbia != null) {
            gabbia.clear();
        }
        if (gabbia2 != null) {
            gabbia2.clear();
        }
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
    public void testAddDog() {
        System.out.print("[GABBIA][ADD-DOG][1][inserimento due cani con padroni distinti]..");

        try {
            Dog merlicchia = new Dog("barboncino", "Merlicchia", "Luca");
            Dog carlino = new Dog("carlino", "Carlone", "Carlo");
            gabbia.addDog(merlicchia);
            gabbia.addDog(carlino);
            int result = gabbia.getAnimaliInGabbia().size();
            int expectedResult = 2;
            assertEquals("[GABBIA][ADD-DOG][1][ERRORE] valore aspettato: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            return;
        }
        System.out.println("\t\t[OK]");
        successTest++;
    }

    @Test
    public void testAddDog2() {
        System.out.print("[GABBIA][ADD-DOG][2][inserimento 6 cani, di cui 3 aventi lo stesso padrone]..");

        try {
            Dog merlicchia = new Dog("barboncino", "Merlicchia", "Luca");
            Dog carlino = new Dog("carlino", "Carlone", "Luca");
            Dog alfonzo = new Dog("carlino", "Alfonzo", "Carlo");
            Dog sirio = new Dog("carlino", "Sirio", "Carlo");
            Dog teo = new Dog("carlino", "Teo", "Matteo");
            Dog simmy = new Dog("pastore tedesco", "Simmy", "Carlo");
            gabbia.addDog(merlicchia);
            gabbia.addDog(carlino);
            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);
            gabbia.addDog(teo);
            gabbia.addDog(simmy);

            int result = gabbia.getAnimaliInGabbia().size();
            int expectedResult = 3;
            assertEquals("[GABBIA][ADD-DOG][2][ERRORE] valore aspettato: " + expectedResult, expectedResult, result);
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
    public void testAddDog3() {
        System.out.print("[GABBIA][ADD-DOG][3][inserimento null input]..");

        try {
            Dog merlicchia = new Dog("barboncino", "Merlicchia", "Luca");
            Dog carlino = new Dog("carlino", "Carlone", "Luca");
            gabbia.addDog(merlicchia);
            gabbia.addDog(carlino);
            try {
                gabbia.addDog(null);
            } catch (NullPointerException ex) {

                int result = gabbia.getAnimaliInGabbia().size();
                int expectedResult = 1;
                assertEquals("[GABBIA][ADD-DOG][3][ERRORE] valore aspettato: " + expectedResult, expectedResult, result);
                System.out.println("\t\t\t\t\t[OK]");
                successTest++;
                return;
            }

        } catch (AssertionError e) {
            System.out.println("\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t\t[FAIL]");
            failedTest++;
        }
        System.out.println("\t\t\t\t\t[FAIL]");
        failedTest++;

    }

    @Test
    public void testAddDog4() {
        System.out.print("[GABBIA][ADD-DOG][4][controllo messaggio di errore - null input]..");

        try {
            Dog merlicchia = new Dog("barboncino", "Merlicchia", "Luca");
            Dog carlino = new Dog("carlino", "Carlone", "Bea");
            gabbia.addDog(merlicchia);
            gabbia.addDog(carlino);
            try {
                gabbia.addDog(null);
            } catch (NullPointerException ex) {

                int expectedResult = 2;
                String expectedMessage = "Input Nullo";
                assertEquals("[GABBIA][ADD-DOG][4B][ERRORE] valore aspettato: " + expectedResult, expectedMessage, ex.getMessage());
                System.out.println("\t\t[OK]");
                successTest++;
                return;
            }

        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
        }
        System.out.println("\t\t[FAIL]");
        failedTest++;

    }

    @Test
    public void testAddPecora1() {
        System.out.print("[GABBIA][ADD-PECORA][1][inserimento tre pecore]..");

        try {
            Sheep sh1 = new Sheep("Bianca");
            Sheep sh2 = new Sheep("Bianca");
            Sheep sh3 = new Sheep("Nera");
            gabbia.addPecora(sh1);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh3);
            int result = gabbia.getAnimaliInGabbia().size();
            int expectedResult = 3;
            assertEquals("[GABBIA][ADD-PECORA][1][ERRORE] valore aspettato: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testAddPecora2() {
        System.out.print("[GABBIA][ADD-PECORA][2][inserimento n pecore con input errati]..");

        try {
            Sheep sh1 = new Sheep();
            Sheep sh2 = new Sheep("Bianca");
            Sheep sh3 = new Sheep(null);
            Sheep sh4 = new Sheep("Nera");
            Sheep sh5 = new Sheep("");
            Sheep sh6 = new Sheep("Nera");
            Sheep sh7 = new Sheep("Nera");

            gabbia.addPecora(sh1);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh3);
            gabbia.addPecora(sh4);
            gabbia.addPecora(sh5);
            gabbia.addPecora(sh6);
            gabbia.addPecora(sh7);

            int result = gabbia.getAnimaliInGabbia().size();
            int expectedResult = 4;
            assertEquals("[GABBIA][ADD-PECORA][2][ERRORE] valore aspettato: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t[OK]");
        successTest++;
    }

    @Test
    public void testAddDogPecore() {
        System.out.print("[GABBIA][ADD-DOG-PECORE][1][inserimento cani e pecore]..");

        try {
            Sheep sh1 = new Sheep();
            Sheep sh2 = new Sheep("Bianca");
            Sheep sh3 = new Sheep(null);
            Sheep sh4 = new Sheep("Nera");
            Sheep sh5 = new Sheep("");
            Sheep sh6 = new Sheep(null);
            Sheep sh7 = new Sheep("Nera");

            Dog merlicchia = new Dog("barboncino", "Merlicchia", "Carlo");
            Dog carlino = new Dog("carlino", "Carlone", "Carlo");
            Dog alfonzo = new Dog("carlino", "Alfonzo", "Carlo");
            Dog sirio = new Dog("carlino", "Sirio", "Carlo");
            Dog teo = new Dog("carlino", "Teo", "Matteo");
            Dog simmy = new Dog("pastore tedesco", "Simmy", "Carlo");

            gabbia.addPecora(sh1);
            gabbia.addDog(merlicchia);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh3);
            gabbia.addPecora(sh4);
            gabbia.addDog(carlino);
            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh5);
            gabbia.addDog(teo);
            gabbia.addPecora(sh6);
            gabbia.addPecora(sh7);
            gabbia.addDog(simmy);

            int result = gabbia.getAnimaliInGabbia().size();
            int expectedResult = 5;
            assertEquals("[GABBIA][ADD-DOG-PECORE][1][ERRORE] valore aspettato: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testClear() {
        System.out.print("[GABBIA][CLEAR][1][inserimenti vari e poi clear()]..");

        try {
            Sheep sh1 = new Sheep();
            Sheep sh2 = new Sheep("Bianca");
            Sheep sh3 = new Sheep(null);
            Sheep sh4 = new Sheep("Nera");
            Sheep sh5 = new Sheep("");
            Sheep sh6 = new Sheep(null);
            Sheep sh7 = new Sheep("Nera");

            Dog merlicchia = new Dog("barboncino", "Merlicchia", "Carlo");
            Dog carlino = new Dog("carlino", "Carlone", "Carlo");
            Dog alfonzo = new Dog("carlino", "Alfonzo", "Carlo");
            Dog sirio = new Dog("carlino", "Sirio", "Carlo");
            Dog teo = new Dog("carlino", "Teo", "Matteo");
            Dog simmy = new Dog("pastore tedesco", "Simmy", "Carlo");

            gabbia.addPecora(sh1);
            gabbia.addDog(merlicchia);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh3);
            gabbia.addPecora(sh4);
            gabbia.addDog(carlino);
            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh5);
            gabbia.addDog(teo);
            gabbia.addPecora(sh6);
            gabbia.addPecora(sh7);
            gabbia.addDog(simmy);

            gabbia.clear();

            int result = gabbia.getAnimaliInGabbia().size();
            int expectedResult = 0;
            assertEquals("[GABBIA][CLEAR][1][ERRORE] valore aspettato: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testClear2() {
        System.out.print("[GABBIA][DEEP CLEAR][2][test pulizia profonda di strutture di supporto]..");

        try {
            Sheep sh1 = new Sheep();
            Sheep sh2 = new Sheep("Bianca");
            Sheep sh3 = new Sheep(null);
            Sheep sh4 = new Sheep("Nera");
            Sheep sh5 = new Sheep("");
            Sheep sh6 = new Sheep(null);
            Sheep sh7 = new Sheep("Nera");

            Dog merlicchia = new Dog("barboncino", "Merlicchia", "Carlo");
            Dog carlino = new Dog("carlino", "Carlone", "Carlo");
            Dog alfonzo = new Dog("carlino", "Alfonzo", "Carlo");
            Dog sirio = new Dog("carlino", "Sirio", "Carlo");
            Dog teo = new Dog("carlino", "Teo", "Matteo");
            Dog simmy = new Dog("pastore tedesco", "Simmy", "Carlo");

            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh5);
            gabbia.addDog(teo);
            gabbia.addPecora(sh6);
            gabbia.addPecora(sh1);
            gabbia.addDog(merlicchia);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh4);
            gabbia.addDog(carlino);
            gabbia.addPecora(sh3);

            gabbia.addPecora(sh7);
            gabbia.addDog(simmy);

            gabbia.clear();

            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);

            int result = gabbia.getAnimaliInGabbia().size();
            int expectedResult = 1;
            assertEquals("[GABBIA][DEEP CLEAR][1][ERRORE] valore aspettato: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t[OK]");
        successTest++;
    }

    @Test
    public void testClearDog() {
        System.out.print("[GABBIA][REMOVE-ALL-DOG][1][insrimento misto e cancellazione cani]..");

        try {
            Sheep sh1 = new Sheep("Grigia");
            Sheep sh2 = new Sheep("Bianca");
            Sheep sh3 = new Sheep(null);
            Sheep sh4 = new Sheep("Nera");
            Sheep sh5 = new Sheep("Nera");
            Sheep sh6 = new Sheep("Verde");
            Sheep sh7 = new Sheep("Nera");

            Dog merlicchia = new Dog("barboncino", "Merlicchia", "Michela");
            Dog carlino = new Dog("carlino", "Carlone", "Carlo");
            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("carlino", "Sirio", "Carlo");
            Dog teo = new Dog("carlino", "Teo", "Matteo");
            Dog simmy = new Dog("pastore tedesco", "Simmy", "Carlo");

            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh5);
            gabbia.addDog(teo);
            gabbia.addPecora(sh6);
            gabbia.addPecora(sh1);
            gabbia.addDog(merlicchia);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh4);
            gabbia.addDog(carlino);
            gabbia.addPecora(sh3);

            gabbia.addPecora(sh7);
            gabbia.addDog(simmy);

            gabbia.removeAllDog();

            int result = gabbia.getAnimaliInGabbia().size();
            int expectedResult = 6;
            assertEquals("[GABBIA][REMOVE-ALL-DOG][1][ERRORE] valore aspettato: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t[OK]");
        successTest++;
    }

    @Test
    public void testCountDogs() {
        System.out.print("[GABBIA][COUNT-DOG][1][inserimento misto e check]..");

        try {
            Sheep sh1 = new Sheep("Grigia");
            Sheep sh2 = new Sheep("Bianca");
            Sheep sh3 = new Sheep(null);
            Sheep sh4 = new Sheep("Nera");
            Sheep sh5 = new Sheep("");
            Sheep sh6 = new Sheep("");
            Sheep sh7 = new Sheep("Nera");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("carlino", "Sirio", "Carlo");
            Dog teo = new Dog("carlino", "Teo", "Matteo");
            Dog simmy = new Dog("pastore tedesco", "Simmy", "Carlo");

            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh5);
            gabbia.addDog(teo);
            gabbia.addPecora(sh6);
            gabbia.addPecora(sh1);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh4);
            gabbia.addPecora(sh3);

            gabbia.addPecora(sh7);
            gabbia.addDog(simmy);

            int result = gabbia.countDogs();
            int expectedResult = 3;
            assertEquals("[GABBIA][COUNT-DOG][1][ERRORE] valore aspettato: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testCountDogs2() {
        System.out.print("[GABBIA][COUNT-DOG][2][inserimento misto,rimozione,inserimento e check]..");

        try {
            Sheep sh1 = new Sheep("Grigia");
            Sheep sh2 = new Sheep("Bianca");
            Sheep sh3 = new Sheep(null);
            Sheep sh4 = new Sheep("Nera");
            Sheep sh5 = new Sheep("");
            Sheep sh6 = new Sheep("");
            Sheep sh7 = new Sheep("Nera");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("carlino", "Sirio", "Carlo");
            Dog teo = new Dog("carlino", "Teo", "Matteo");
            Dog simmy = new Dog("pastore tedesco", "Simmy", "Carlo");

            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh5);
            gabbia.addDog(teo);
            gabbia.addPecora(sh6);
            gabbia.addPecora(sh1);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh4);
            gabbia.addPecora(sh3);

            gabbia.addPecora(sh7);
            gabbia.addDog(simmy);

            gabbia.removeAllDog();
            gabbia.addDog(new Dog("babbeo", "bassotto", "Matteo"));
            gabbia.addDog(new Dog("babbeo2", "bassotto", "Alfonso"));

            int result = gabbia.countDogs();
            int expectedResult = 2;
            assertEquals("[GABBIA][COUNT-DOG][2][ERRORE] valore aspettato: " + expectedResult, expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t[OK]");
        successTest++;
    }

    @Test
    public void testFindShipByColor() {
        System.out.print("[GABBIA][FIND-SHEEPS][1][multi test: colori presenti/assenti]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");
            Sheep sh3 = new Sheep(null);
            Sheep sh4 = new Sheep("Nero");
            Sheep sh5 = new Sheep("");
            Sheep sh6 = new Sheep("Nero");
            Sheep sh7 = new Sheep("Nero");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("carlino", "Sirio", "Matteo");
            Dog teo = new Dog("carlino", "Teo", "Matteo");
            Dog simmy = new Dog("pastore tedesco", "Simmy", "Carlo");

            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh5);
            gabbia.addDog(teo);
            gabbia.addPecora(sh6);
            gabbia.addPecora(sh1);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh4);
            gabbia.addPecora(sh3);

            gabbia.addPecora(sh7);
            gabbia.addDog(simmy);

            int grigie = gabbia.findSheepsByColor("Grigio").size();
            int bianche = gabbia.findSheepsByColor("Bianco").size();
            int nere = gabbia.findSheepsByColor("Nero").size();
            int blu = gabbia.findSheepsByColor("Blu").size();

            int[] results = new int[]{grigie, bianche, nere, blu};
            int[] expectedResults = new int[]{1, 1, 3, 0};

            assertTrue("[GABBIA][FIND-SHEEPS][1][ERRORE] valore aspettato: 1 grigio, 1 bianco, 3 neri, 0 blu", checkArrays(results, expectedResults));
        } catch (AssertionError e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testFindShipByColor2() {
        System.out.print("[GABBIA][FIND-SHEEPS][2][input test: color null]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");
            Sheep sh3 = new Sheep(null);
            Sheep sh4 = new Sheep("Nero");
            Sheep sh5 = new Sheep("");
            Sheep sh6 = new Sheep("Nero");
            Sheep sh7 = new Sheep("Nero");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("carlino", "Sirio", "Matteo");
            Dog teo = new Dog("carlino", "Teo", "Matteo");
            Dog simmy = new Dog("pastore tedesco", "Simmy", "Carlo");

            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh5);
            gabbia.addDog(teo);
            gabbia.addPecora(sh6);
            gabbia.addPecora(sh1);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh4);
            gabbia.addPecora(sh3);

            gabbia.addPecora(sh7);
            gabbia.addDog(simmy);

            List<Sheep> l1 = gabbia.findSheepsByColor(null);

            assertNull("[GABBIA][FIND-SHEEPS][1][ERRORE] valore aspettato - null - per input nullo", l1);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testFindShipByColor3() {
        System.out.print("[GABBIA][FIND-SHEEPS][3][input test: color empty]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");
            Sheep sh3 = new Sheep(null);
            Sheep sh4 = new Sheep("Nero");
            Sheep sh5 = new Sheep("");
            Sheep sh6 = new Sheep("Nero");
            Sheep sh7 = new Sheep("Nero");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("carlino", "Sirio", "Matteo");
            Dog teo = new Dog("carlino", "Teo", "Matteo");
            Dog simmy = new Dog("pastore tedesco", "Simmy", "Carlo");

            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh5);
            gabbia.addDog(teo);
            gabbia.addPecora(sh6);
            gabbia.addPecora(sh1);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh4);
            gabbia.addPecora(sh3);

            gabbia.addPecora(sh7);
            gabbia.addDog(simmy);

            List<Sheep> l1 = gabbia.findSheepsByColor("");

            assertNull("[GABBIA][FIND-SHEEPS][1][ERRORE] valore aspettato - null - per input stringa vuota", l1);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testEquals1() {
        System.out.print("[GABBIA][EQUALS][1][input test: null input]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");
            Sheep sh3 = new Sheep(null);
            Sheep sh4 = new Sheep("Nero");
            Sheep sh5 = new Sheep("");
            Sheep sh6 = new Sheep("Nero");
            Sheep sh7 = new Sheep("Nero");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("carlino", "Sirio", "Matteo");
            Dog teo = new Dog("carlino", "Teo", "Matteo");
            Dog simmy = new Dog("pastore tedesco", "Simmy", "Carlo");

            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh5);
            gabbia.addDog(teo);
            gabbia.addPecora(sh6);
            gabbia.addPecora(sh1);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh4);
            gabbia.addPecora(sh3);

            gabbia.addPecora(sh7);
            gabbia.addDog(simmy);

            boolean result = gabbia.equals(null);

            assertFalse("[GABBIA][EQUALS][1][ERRORE] valore aspettato - null - per input stringa vuota", result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testEquals2() {
        System.out.print("[GABBIA][EQUALS][2][confronto su tipi diversi]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");
            Sheep sh3 = new Sheep(null);
            Sheep sh4 = new Sheep("Nero");
            Sheep sh5 = new Sheep("");
            Sheep sh6 = new Sheep("Nero");
            Sheep sh7 = new Sheep("Nero");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("carlino", "Sirio", "Matteo");
            Dog teo = new Dog("carlino", "Teo", "Matteo");
            Dog simmy = new Dog("pastore tedesco", "Simmy", "Carlo");

            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh5);
            gabbia.addDog(teo);
            gabbia.addPecora(sh6);
            gabbia.addPecora(sh1);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh4);
            gabbia.addPecora(sh3);

            gabbia.addPecora(sh7);
            gabbia.addDog(simmy);

            boolean result = gabbia.equals(new Double(2.3d));

            assertFalse("[GABBIA][EQUALS][2][ERRORE] valore aspettato - null - per input stringa vuota", result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testEquals3() {
        System.out.print("[GABBIA][EQUALS][3][due gabbie vuote sono uguali]..");

        try {

            boolean result = gabbia.equals(gabbia2);

            assertTrue("[GABBIA][EQUALS][3][ERRORE] dovrebbero essere uguali perché sono due gabbie vuote", result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testEquals4() {
        System.out.print("[GABBIA][EQUALS][4][due gabbie diverse per dimensione]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");
            Sheep sh3 = new Sheep("Nero");
            Sheep sh4 = new Sheep("Nero");
            Sheep sh5 = new Sheep("Verde");
            Sheep sh6 = new Sheep("Nero");
            Sheep sh7 = new Sheep("Nero");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("carlino", "Sirio", "Sara");
            Dog teo = new Dog("carlino", "Teo", "Matteo");
            Dog simmy = new Dog("pastore tedesco", "Simmy", "Carlo");

            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh5);
            gabbia.addDog(teo);
            gabbia.addPecora(sh6);
            gabbia2.addPecora(sh1);
            gabbia2.addPecora(sh2);
            gabbia2.addPecora(sh4);
            gabbia2.addPecora(sh3);

            gabbia2.addPecora(sh7);
            gabbia2.addDog(simmy);

            boolean result = gabbia.equals(gabbia2);

            assertFalse("[GABBIA][EQUALS][4][ERRORE] gabbie diverse anche solo per dimensione", result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testEquals5() {
        System.out.print("[GABBIA][EQUALS][5][due gabbie diverse per contenuti]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");
            Sheep sh3 = new Sheep("Nero");

            Sheep sh1b = new Sheep("Grigio");
            Sheep sh2b = new Sheep("Bianco");
            Sheep sh3b = new Sheep("Nero");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("carlino", "Sirio", "Sara");
            Dog alfonzo2 = new Dog("carlino", "Alfonzo", "Katia");
            Dog simmy = new Dog("carlino", "Simmy", "Sara");

            gabbia.addPecora(sh1);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh3);
            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);

            gabbia2.addPecora(sh1b);
            gabbia2.addPecora(sh2b);
            gabbia2.addPecora(sh3b);
            gabbia2.addDog(alfonzo2);
            gabbia2.addDog(simmy);

            boolean result = gabbia.equals(gabbia2);

            assertFalse("[GABBIA][EQUALS][5][ERRORE] gabbie diverse per un parametro di un cane", result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testEquals5B() {
        System.out.print("[GABBIA][EQUALS][5B][due gabbie diverse per contenuti]..");

        try {
            Sheep sh1 = new Sheep("Bianco");
            Sheep sh2 = new Sheep("Bianco");
            Sheep sh3 = new Sheep("Nero");

            Sheep sh1b = new Sheep("Grigio");
            Sheep sh2b = new Sheep("Bianco");
            Sheep sh3b = new Sheep("Nero");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("carlino", "Simmy", "Sara");
            Dog alfonzo2 = new Dog("carlino", "Alfonzo", "Katia");
            Dog simmy = new Dog("carlino", "Simmy", "Sara");

            gabbia.addPecora(sh1);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh3);
            gabbia.addDog(alfonzo);
            gabbia.addDog(sirio);

            gabbia2.addPecora(sh1b);
            gabbia2.addPecora(sh2b);
            gabbia2.addPecora(sh3b);
            gabbia2.addDog(alfonzo2);
            gabbia2.addDog(simmy);

            boolean result = gabbia.equals(gabbia2);

            assertFalse("[GABBIA][EQUALS][5B][ERRORE] gabbie diverse per la razza di una pecora", result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testEquals6() {
        System.out.print("[GABBIA][EQUALS][6][due gabbie uguali per contenuti]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");
            Sheep sh3 = new Sheep("Nero");

            Sheep sh1b = new Sheep("Grigio");
            Sheep sh2b = new Sheep("Bianco");
            Sheep sh3b = new Sheep("Nero");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("carlino", "Sirio", "Sara");
            Dog alfonzo2 = new Dog("carlino", "Alfonzo", "Katia");
            Dog simmy = new Dog("carlino", "Sirio", "Sara");

            gabbia.addDog(sirio);
            gabbia.addPecora(sh3);
            gabbia.addPecora(sh1);
            gabbia.addPecora(sh2);
            gabbia.addDog(alfonzo);

            gabbia2.addPecora(sh2b);
            gabbia2.addDog(simmy);
            gabbia2.addPecora(sh1b);
            gabbia2.addDog(alfonzo2);
            gabbia2.addPecora(sh3b);

            boolean result = gabbia.equals(gabbia2);

            assertTrue("[GABBIA][EQUALS][6][ERRORE] gabbie diverse per un parametro di un cane", result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testMedium() {
        System.out.print("[MEDIUM][MOST POPULATED][1][due gabbie, una vuota]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("maremmano", "Sirio", "Gino");

            gabbia2.addPecora(sh1);
            gabbia2.addDog(alfonzo);
            gabbia2.addPecora(sh2);
            gabbia2.addDog(sirio);

            Gabbia result = medium.mostPopulated(gabbia, gabbia2);

            assertTrue("[GABBIA][MEDIUM][1][ERRORE] la prima gabbia è vuota", result == gabbia2);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testMedium2() {
        System.out.print("[MEDIUM][MOST POPULATED][2][due gabbie diversamente riempite]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("maremmano", "Sirio", "Gino");
            Dog sirio2 = new Dog("maremmano", "Sirio2", "Gino2");
            Dog sirio3 = new Dog("maremmano", "Sirio3", "Gino3");
            Dog sirio4 = new Dog("maremmano", "Sirio4", "Gino4");
            Dog sirio5 = new Dog("maremmano", "Sirio5", "Gino5");

            gabbia.addPecora(sh1);
            gabbia.addDog(alfonzo);
            gabbia.addPecora(sh2);
            gabbia.addDog(sirio);
            gabbia.addDog(sirio2);
            gabbia.addDog(sirio3);
            gabbia.addDog(sirio4);
            gabbia.addDog(sirio5);

            Sheep sh11 = new Sheep("Grigio");
            Sheep sh22 = new Sheep("Bianco");
            Sheep sh33 = new Sheep("Bianco");

            Dog alfonzo2 = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio23 = new Dog("maremmano", "Sirio", "Gino");

            gabbia2.addPecora(sh11);
            gabbia2.addPecora(sh22);
            gabbia2.addPecora(sh33);
            gabbia2.addDog(alfonzo2);
            gabbia2.addDog(sirio23);

            Gabbia result = medium.mostPopulated(gabbia, gabbia2);

            assertTrue("[GABBIA][MEDIUM][2][ERRORE] gabbie popolate, la prima è più numerosa", result == gabbia);
        } catch (AssertionError e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t[OK]");
        successTest++;
    }

    @Test
    public void testMinimize1() {
        System.out.print("[MEDIUM][MINIMIZE][1][gabbia vuota]..");

        try {

            medium.minimize(gabbia);
            int result = gabbia.getAnimaliInGabbia().size();
            int expectedResult = 0;

            assertEquals("[GABBIA][MINIMIZE][1][ERRORE] gabbia vuota, non dovrebbe fare nulla", expectedResult, result);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t\t\t[OK]");
        successTest++;
    }
    
    @Test
    public void testMinimize2() {
        System.out.print("[MEDIUM][MINIMIZE][2][una gabbie in equilibrio]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("maremmano", "Sirio", "Gino");

            gabbia.addPecora(sh1);
            gabbia.addDog(alfonzo);
            gabbia.addPecora(sh2);
            gabbia.addDog(sirio);

            medium.minimize(gabbia);
            int resultSize = gabbia.getAnimaliInGabbia().size();
            int resultCountDog = gabbia.countDogs();
            int expectedSize = 4;
            int expectedCountDog = 2;

            assertEquals("[GABBIA][MINIMIZE][2][ERRORE] il numero animali è cambiato, ma la gabbia non necessitava di minimizzazione", expectedSize, resultSize);
            assertEquals("[GABBIA][MINIMIZE][2][ERRORE] sono stati aggiunti o rimossi dei cani ma la gabbia non necessitava di minimizzazione", expectedCountDog, resultCountDog);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }
    
    
    @Test
    public void testMinimize3() {
        System.out.print("[MEDIUM][MINIMIZE][3][una gabbia con più pecore]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");
            Sheep sh3 = new Sheep("Bianco");
            Sheep sh4 = new Sheep("Bianco");
            Sheep sh5 = new Sheep("Bianco");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("maremmano", "Sirio", "Gino");
            Dog bubbu = new Dog("maremmano", "Bubby", "Mario");

            gabbia.addPecora(sh1);
            gabbia.addDog(alfonzo);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh3);
            gabbia.addDog(bubbu);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh4);
            gabbia.addPecora(sh5);

            medium.minimize(gabbia);
            int resultSize = gabbia.getAnimaliInGabbia().size();
            int resultCountDog = gabbia.countDogs();
            int expectedSize = 6;
            int expectedCountDog = 3;

            assertEquals("[GABBIA][MINIMIZE][3][ERRORE] il numero animali non è corretto, sono stati rimossi troppi o pochi animali", expectedSize, resultSize);
            assertEquals("[GABBIA][MINIMIZE][3][ERRORE] il numero dei cani non doveva variare perché sono meno delle pecore", expectedCountDog, resultCountDog);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }
    
    @Test
    public void testMinimize4() {
        System.out.print("[MEDIUM][MINIMIZE][4][una gabbia con più cani]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");
            Sheep sh3 = new Sheep("Bianco");
            Sheep sh4 = new Sheep("Bianco");
            Sheep sh5 = new Sheep("Bianco");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("maremmano", "Sirio", "Gino");
            Dog bubbu = new Dog("maremmano", "Bubby", "Mario");
            Dog bubbu2 = new Dog("maremmano", "Fido", "Mario");
            Dog bubbu3 = new Dog("maremmano", "Alfonso", "Carlo");
            Dog bubbu4 = new Dog("maremmano", "Kevin", "Luca");
            Dog bubbu5 = new Dog("maremmano", "Hotel", "Simona");
            Dog bubbu6 = new Dog("maremmano", "Mastino", "Gina");

            gabbia.addDog(bubbu2);
            gabbia.addPecora(sh1);
            gabbia.addDog(alfonzo);
            gabbia.addPecora(sh2);
            gabbia.addPecora(sh3);
            gabbia.addDog(bubbu);
            gabbia.addDog(bubbu3);
            gabbia.addDog(bubbu4);
            gabbia.addDog(sirio);
            gabbia.addPecora(sh4);
            gabbia.addPecora(sh5);
            gabbia.addDog(bubbu5);
            gabbia.addDog(bubbu6);

            medium.minimize(gabbia);
            int resultSize = gabbia.getAnimaliInGabbia().size();
            int resultCountDog = gabbia.countDogs();
            int expectedSize = 10;
            int expectedCountDog = 5;

            assertEquals("[GABBIA][MINIMIZE][4][ERRORE] il numero animali non è corretto, sono stati rimossi troppi o pochi animali", expectedSize, resultSize);
            assertEquals("[GABBIA][MINIMIZE][4][ERRORE] il numero dei cani non doveva variare perché sono meno delle pecore", expectedCountDog, resultCountDog);
        } catch (AssertionError e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t\t[OK]");
        successTest++;
    }
    
    
    
    @Test
    public void testMoveSheep1() {
        System.out.print("[MEDIUM][MOVE SHEEP][1][la prima gabbia non ha pecore]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("maremmano", "Sirio", "Gino");
            Dog sirio2 = new Dog("maremmano", "Sirio2", "Gino2");
            Dog sirio3 = new Dog("maremmano", "Sirio3", "Gino3");
            Dog sirio4 = new Dog("maremmano", "Sirio4", "Gino4");
            Dog sirio5 = new Dog("maremmano", "Sirio5", "Gino5");

//            gabbia.addPecora(sh1);
            gabbia.addDog(alfonzo);
//            gabbia.addPecora(sh2);
            gabbia.addDog(sirio);
            gabbia.addDog(sirio2);
            gabbia.addDog(sirio3);
            gabbia.addDog(sirio4);
            gabbia.addDog(sirio5);

            Sheep sh11 = new Sheep("Grigio");
            Sheep sh22 = new Sheep("Bianco");
            Sheep sh33 = new Sheep("Bianco");

            Dog alfonzo2 = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio23 = new Dog("maremmano", "Sirio", "Gino");

            gabbia2.addPecora(sh11);
            gabbia2.addPecora(sh22);
            gabbia2.addPecora(sh33);
            gabbia2.addDog(alfonzo2);
            gabbia2.addDog(sirio23);

            medium.moveSheep(gabbia, gabbia2);
            
            int resultG1 = gabbia.getAnimaliInGabbia().size();
            int resultG2 = gabbia2.getAnimaliInGabbia().size();
            int dogCountG1 = gabbia.countDogs();
            int dogCountG2 = gabbia2.countDogs();
            
            int expectedResultG1 = 6;
            int expectedResultG2 = 5;
            int expectedDogCountG1 = 6;
            int expectedDogCountG2 = 2;

            assertEquals("[GABBIA][MOVE SHEEP][1][ERRORE] il numero degli animali della prima gabbia non deve variare", expectedResultG1, resultG1);
            assertEquals("[GABBIA][MOVE SHEEP][1][ERRORE] il numero degli animali della seconda gabbia non deve variare", expectedResultG2, resultG2);
            assertEquals("[GABBIA][MOVE SHEEP][1][ERRORE] il numero di cani della prima gabbia non deve variare", expectedDogCountG1, dogCountG1);
            assertEquals("[GABBIA][MOVE SHEEP][1][ERRORE] il numero di cani della seconda gabbia non deve variare", expectedDogCountG2, dogCountG2);
        } catch (AssertionError e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t[OK]");
        successTest++;
    }
    
    @Test
    public void testMoveSheep2() {
        System.out.print("[MEDIUM][MOVE SHEEP][2][la prima gabbia ha due pecore]..");

        try {
            Sheep sh1 = new Sheep("Grigio");
            Sheep sh2 = new Sheep("Bianco");

            Dog alfonzo = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio = new Dog("maremmano", "Sirio", "Gino");
            Dog sirio2 = new Dog("maremmano", "Sirio2", "Gino2");
            Dog sirio3 = new Dog("maremmano", "Sirio3", "Gino3");
            Dog sirio4 = new Dog("maremmano", "Sirio4", "Gino4");
            Dog sirio5 = new Dog("maremmano", "Sirio5", "Gino5");

            gabbia.addPecora(sh1);
            gabbia.addDog(alfonzo);
            gabbia.addPecora(sh2);
            gabbia.addDog(sirio);
            gabbia.addDog(sirio2);
            gabbia.addDog(sirio3);
            gabbia.addDog(sirio4);
            gabbia.addDog(sirio5);

            Sheep sh11 = new Sheep("Grigio");
            Sheep sh22 = new Sheep("Bianco");
            Sheep sh33 = new Sheep("Bianco");

            Dog alfonzo2 = new Dog("carlino", "Alfonzo", "Katia");
            Dog sirio23 = new Dog("maremmano", "Sirio", "Gino");

            gabbia2.addPecora(sh11);
            gabbia2.addPecora(sh22);
            gabbia2.addPecora(sh33);
            gabbia2.addDog(alfonzo2);
            gabbia2.addDog(sirio23);

            medium.moveSheep(gabbia, gabbia2);
            
            int resultG1 = gabbia.getAnimaliInGabbia().size();
            int resultG2 = gabbia2.getAnimaliInGabbia().size();
            int dogCountG1 = gabbia.countDogs();
            int dogCountG2 = gabbia2.countDogs();
            
            int expectedResultG1 = 6;
            int expectedResultG2 = 7;
            int expectedDogCountG1 = 6;
            int expectedDogCountG2 = 2;

            assertEquals("[GABBIA][MOVE SHEEP][2a][ERRORE] il numero degli animali della prima gabbia non deve variare", expectedResultG1, resultG1);
            assertEquals("[GABBIA][MOVE SHEEP][2b][ERRORE] il numero degli animali della seconda gabbia non deve variare", expectedResultG2, resultG2);
            assertEquals("[GABBIA][MOVE SHEEP][2c][ERRORE] il numero di cani della prima gabbia non deve variare", expectedDogCountG1, dogCountG1);
            assertEquals("[GABBIA][MOVE SHEEP][2d][ERRORE] il numero di cani della seconda gabbia non deve variare", expectedDogCountG2, dogCountG2);
        } catch (AssertionError e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            throw e;
        } catch (Exception e) {
            System.out.println("\t\t\t[FAIL]");
            failedTest++;
            assertTrue(false);
            return;
        }
        System.out.println("\t\t\t[OK]");
        successTest++;
    }

}
