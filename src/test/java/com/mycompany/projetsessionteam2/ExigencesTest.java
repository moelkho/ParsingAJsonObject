/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsessionteam2;

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class ExigencesTest {
    
    public ExigencesTest() {
    }

    /**
     * Test of formaterVariables method, of class Exigences.
     */
    @Test
    public void testFormaterVariables() throws IOException {
        System.out.println("formaterVariables");
        String json = Utilitaire.loadJsonIntoString("jsonTest/entree.json");
        JSONObject jsonObject1 =  Utilitaire.creerJsonObject(json);
        
        String json2 = Utilitaire.loadJsonIntoString("jsonTest/resultaEntreAttendu.json");
        
        JSONObject expResult = Utilitaire.creerJsonObject(json2);
        JSONObject result = Exigences.formaterVariables(jsonObject1);
        assertEquals(expResult, result);
        
    }


   
    /**
     * Test of formaterMontant method, of class Exigences.
     */
    @Test
    public void testFormaterMontant() {
        System.out.println("formaterMontant");
        String valeur = "3,2";
        double expResult = 3.2;
        double result = Exigences.formaterMontant(valeur);
        assertEquals(expResult, result, 0.0);
       
    }
    
    @Test
    public void testFormaterMontantValeurNegative() {
        System.out.println("formaterMontant");
        String valeur = "-3,2";
        double expResult = -3.2;
        double result = Exigences.formaterMontant(valeur);
        assertEquals(expResult, result, 0.0);
       
    }
}
