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
public class RunnableDemo implements Runnable{
    private Thread t;
    private String threadName;
    
    public RunnableDemo( String name) {
      threadName = name;
      System.out.println("Thread " + threadName + "Created" );
   }

    @Override
    public void run() {
        try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // 让线程睡眠一会
            Thread.sleep(50);
         }
      }catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
        System.out.println("Thread " +  threadName + " exiting.");
    }
    
    public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
