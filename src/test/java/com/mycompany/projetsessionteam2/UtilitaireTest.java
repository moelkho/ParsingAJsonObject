/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsessionteam2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import net.sf.json.JSONObject;
import net.sf.json.test.JSONAssert;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class UtilitaireTest {
    
    public UtilitaireTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loadJsonIntoString method, of class Utilitaire.
     */
    @Test
    public void testLoadJsonIntoString() throws Exception {
        System.out.println("loadJsonIntoString");
        String filePath = "jsonFiles/test1.json";
        String expResult = "{\"name\":\"admin\"}";
        String result = Utilitaire.loadJsonIntoString(filePath);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of saveJsonIntoFile method, of class Utilitaire.
     */
    @Test
    public void testSaveJsonIntoFile() throws Exception {
        System.out.println("saveJsonIntoFile");
        String content = "{\"cle\" : \"valeur\"}";
        String filePath = "jsonFiles/test3.json";
        
        Utilitaire.saveJsonIntoFile(content, filePath);
       
      
    }
//
//    /**
//     * Test of retournerSortie method, of class Utilitaire.
//     */
//    @Test
//    public void testRetournerSortie() throws FileNotFoundException, IOException, ParseException {
//        System.out.println("retournerSortie");
//       JSONObject terrain ;
//        
//       JSONParser parser = new JSONParser();
//       terrain =  (net.sf.json.JSONObject) parser.parse(new FileReader("jsonFiles/entree.json"));
//        JSONObject expResult =( net.sf.json.JSONObject ) parser.parse(new FileReader("jsonFiles/sortie.json"));
//        net.sf.json.JSONObject result = Utilitaire.retournerSortie(terrain);
//        assertEquals(expResult, result);
//       
//    }
//
//    /**
//     * Test of calculerMontantValeurParLot method, of class Utilitaire.
//     */
    
          @Test
    public void testCalculerMontantValeurParLot2() {
        System.out.println("calculerMontantValeurParLot");
        int type_terrain = 2;
        double prixMin = 2.5;
        double prixMax = 4.5;
        JSONObject lot = new JSONObject();
        lot.put("superficie", 1000);
        double expResult = 4500;
        double result = Utilitaire.calculerMontantValeurParLot(type_terrain, prixMin, prixMax, lot);
        assertEquals(expResult, result, 0.0);
       
    }
    @Test
    public void testCalculerMontantValeurParLot1() {
        System.out.println("calculerMontantValeurParLot");
        int type_terrain = 1;
        double prixMin = 2.5;
        double prixMax = 4.5;
        JSONObject lot = new JSONObject();
        lot.put("superficie", 500.02);
        double expResult = 1750.07;
        double result = Utilitaire.calculerMontantValeurParLot(type_terrain, prixMin, prixMax, lot);
        assertEquals(expResult, result, 0.0);
       
    }
    
       @Test
    public void testCalculerMontantValeurParLot0() {
        System.out.println("calculerMontantValeurParLot");
        int type_terrain = 0;
        double prixMin = 2.5;
        double prixMax = 4.5;
        JSONObject lot = new JSONObject();
        lot.put("superficie", 1000);
        double expResult = 2500;
        double result = Utilitaire.calculerMontantValeurParLot(type_terrain, prixMin, prixMax, lot);
        assertEquals(expResult, result, 0.0);
       
    }
//
//    /**
//     * Test of calculerMontantDroitsPassage method, of class Utilitaire.
//     */
      @Test
    public void testCalculerMontantDroitsPassage2() {
        System.out.println("calculerMontantDroitsPassage");
        int type_terrain = 2;
        double valeurParLot = 4500;
        JSONObject lot = new JSONObject();
        lot.put("nombre_droits_passage",1);
        
        double expResult = -175;
        double result = Utilitaire.calculerMontantDroitsPassage(type_terrain, valeurParLot, lot);
        assertEquals(expResult, result, 0.0);
       
    }
     @Test
    public void testCalculerMontantDroitsPassage1() {
        System.out.println("calculerMontantDroitsPassage");
        int type_terrain = 1;
        double valeurParLot = 1750.07;
        JSONObject lot = new JSONObject();
        lot.put("nombre_droits_passage",3);
        
        double expResult = -25.021000000000072;
        double result = Utilitaire.calculerMontantDroitsPassage(type_terrain, valeurParLot, lot);
        assertEquals(expResult, result, 0.0);
       
    }
    @Test
    public void testCalculerMontantDroitsPassage0() {
        System.out.println("calculerMontantDroitsPassage");
        int type_terrain = 0;
        double valeurParLot = 2500;
        JSONObject lot = new JSONObject();
        lot.put("nombre_droits_passage",2);
        
        double expResult = 250;
        double result = Utilitaire.calculerMontantDroitsPassage(type_terrain, valeurParLot, lot);
        assertEquals(expResult, result, 0.0);
       
    }
//
//    /**
//     * Test of calculerMontantServices method, of class Utilitaire.
//     */
//    @Test
//    public void testCalculerMontantServices() {
//        System.out.println("calculerMontantServices");
//        int type_terrain = 0;
//        JSONObject lot = null;
//        double expResult = 0.0;
//        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
//        assertEquals(expResult, result, 0.0);
//     
//    }
//    
}
