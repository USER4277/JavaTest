/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jessetest.classes;

import com.jessetest.Interfaces.GenericInterface1;
import java.util.Random;

/**
 *
 * @author I540371
 */
public class GenericFriut implements GenericInterface1<String> {
    
    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
    
    @Override
    public String toString(){
        return "GenericFriut";
    }
    
}
