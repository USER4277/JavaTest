/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jessetest.classes;

/**
 *
 * @author I540371
 */
public class GenericMethodTest {
    public static <E> void printArray( E[] inputArrary ){
        for(E element: inputArrary){
            System.out.println(element.toString());
        }
    }
}
