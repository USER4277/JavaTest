/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jessetest.Interfaces;

import java.io.IOException;

/**
 *
 * @author I540371
 */
public interface ServerInterface {
    
    public void serviceStart() throws IOException;
    
    public void serviceEnd() throws IOException;
}
