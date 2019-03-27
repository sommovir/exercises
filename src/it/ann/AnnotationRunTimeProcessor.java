/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ann;

import it.Main;
import it.esercizi.blocco1.easy.Easy1;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import org.atteo.classindex.ClassIndex;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
public class AnnotationRunTimeProcessor {

    private static AnnotationRunTimeProcessor _instance = null;

    public static AnnotationRunTimeProcessor getInstance() {
        if (_instance == null) {
            _instance = new AnnotationRunTimeProcessor();
            return _instance;
        } else {
            return _instance;
        }
    }

    private AnnotationRunTimeProcessor() {
        super();
    }

    public Iterable<Class<?>> getSolutionClasses() {

        Iterable<Class<?>> klasses = ClassIndex.getAnnotated(Solution.class);
        return klasses;

    }

    private boolean isImplementing(Class<?> clazz, String interfaceName) {
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            String inter = i.toString().replace("interface ", "");
            if (inter.equals(interfaceName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExtending(Class<?> clazz, String interfaceName) {
        Class<?> superClazz = clazz.getSuperclass();
//        System.out.println("superclazz = "+superClazz.toString());
        String inter = superClazz.toString().replace("class ", "");
        if (inter.equals(interfaceName)) {
            return true;
        }

        return false;
    }

    public Class<?> getSolutionFor(Class<?> mustImplement) throws IOException, URISyntaxException {
        Iterable<Class<?>> clazzes = getSolutionClasses();
        for (Class<?> clazze : clazzes) {

            if (clazze.isAnnotationPresent(Solution.class)) {
                if (isImplementing(clazze, mustImplement.getName()) || isExtending(clazze, mustImplement.getName())) {
                    System.out.println("[ANN] checking class: " + clazze.getCanonicalName() + "\t [SOLUTION FOUND]");
                    return clazze;
                } else {
//                    System.out.println("\t [NOT SOLUTION]");
                }
            }
        }
        return null;
    }

}
