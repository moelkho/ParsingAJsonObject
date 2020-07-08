/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsessionteam2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class AppCtrTest {
    
    public AppCtrTest() {
    }

    /**
     * Test of main method, of class AppCtr.
     */
    @Test(expected=NullPointerException.class)
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        AppCtr.main(args);
       
    }
    
}
