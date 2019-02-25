/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.atteo.classindex.IndexAnnotated;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
@IndexAnnotated
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Solution {

}
