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
public class GenericClassTmp1<T> implements java.io.Serializable {
    private T key;
    public GenericClassTmp1(T key){
        this.key = key;
    }
    public T getKey(){
        return key;
    }
    
    @Override
    public String toString(){
        return "GenericClassTmp1";
    }
}
