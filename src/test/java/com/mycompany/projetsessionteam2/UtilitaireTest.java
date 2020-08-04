/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsessionteam2;

import java.io.FileNotFoundException;

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;


public class UtilitaireTest {
    
    public UtilitaireTest() {
    }
    
  

   
    // test de la methode LoadJsonIntoString
    
    @Test
    public void testLoadJsonIntoString() throws Exception {
        System.out.println("loadJsonIntoString");
        String filePath = "jsonTest/test1.json";
        String expResult = "{\"name\":\"admin\"}";
        String result = Utilitaire.loadJsonIntoString(filePath);
        assertEquals(expResult, result);
       
    }

    // test de la methode SaveJsonIntoFile
    @Test
    public void testSaveJsonIntoFile() throws Exception {
        System.out.println("saveJsonIntoFile");
        String content = "{\"cle\" : \"valeur\"}";
        String filePath = "jsonTest/test3.json";
        
        Utilitaire.saveJsonIntoFile(content, filePath);
       
      
    }
//
//    /* test de la methode  RetournerSortie, on construit en dur un objet
//    JSON a l'interieur, cette methode retourne un objet JSON*/ 
//    
//    @Test
//    public void testRetournerSortie() throws FileNotFoundException, 
//            IOException, ParseException {
//        System.out.println("retournerSortie");
//          JSONObject terrain = new JSONObject();
//       terrain.put("type_terrain", 2);
//       terrain.put("prix_m2_min", "3.45 $");
//        terrain.put("prix_m2_max", "7.00 $");
//        
//        JSONArray lotissement = new JSONArray();
//        
//        JSONObject lot1 = new JSONObject();
//        lot1.put("description","lot 1");
//        lot1.put("nombre_droits_passage", 4);
//        lot1.put("nombre_services", 0);
//        lot1.put("superficie", 465);
//        lot1.put("date_mesure","2015-10-14");
//        
//        JSONObject lot2 = new JSONObject();
//        lot2.put("description","lot 2");
//        lot2.put("nombre_droits_passage", 0);
//        lot2.put("nombre_services", 1);
//        lot2.put("superficie", 1082);
//        lot2.put("date_mesure","2015-12-15");
//        
//        JSONObject lot3 = new JSONObject();
//        lot3.put("description","lot 3");
//        lot3.put("nombre_droits_passage", 8);
//        lot3.put("nombre_services", 3);
//        lot3.put("superficie", 3333);
//        lot3.put("date_mesure","2013-06-20");
//        
//        lotissement.add(lot1);
//        lotissement.add(lot2);
//        lotissement.add(lot3);
//        terrain.put("lotissements", lotissement);
//                
//       
//      
//        JSONObject expResult = new JSONObject();
//        expResult.put("valeur_fonciere_totale","16943,57 $");
//        expResult.put("taxe_scolaire","203,32 $");
////        expResult.put("taxe_scolaire",203.32284);
//        expResult.put("taxe_ municipale","423,59 $");
//        JSONArray lotissementSortie = new JSONArray();
//        
//        JSONObject lotSortie1= new JSONObject();
//        lotSortie1.put("description","lot 1");
//        lotSortie1.put("valeur_par_lot","2802 $");
//        
//        JSONObject lotSortie2= new JSONObject();
//        lotSortie2.put("description","lot 2");
//        lotSortie2.put("valeur_par_lot","12574 $");
//        
//        JSONObject lotSortie3= new JSONObject();
//        lotSortie3.put("description","lot 3");
//        lotSortie3.put("valeur_par_lot","833,8 $");
//         lotissementSortie.add(lotSortie1);
//         lotissementSortie.add(lotSortie2);
//         lotissementSortie.add(lotSortie3);
//         
//         expResult.put("lotissements",lotissementSortie);
//        
//        
//        JSONObject result = Utilitaire.retournerSortie(terrain);
//        assertEquals(expResult, result);
//       
//    }
///* test de la methode CalculerMontantValeurParLot lorsque le type du terrain est 
//    2 */
//    
//          @Test
//    public void testCalculerMontantValeurParLot2() {
//        System.out.println("calculerMontantValeurParLot");
//        int type_terrain = 2;
//        double prixMin = 2.5;
//        double prixMax = 4.5;
//        JSONObject lot = new JSONObject();
//        lot.put("superficie", 1000);
//        double expResult = 4500;
//        double result = Utilitaire.calculerMontantValeurParLot
//        (type_terrain, prixMin, prixMax, lot);
//        assertEquals(expResult, result, 0.0);
//       
//    }
//    
//    /* test de la methode CalculerMontantValeurParLot lorsque le type du terrain
//    est  1 */
//    @Test
//    public void testCalculerMontantValeurParLot1() {
//        System.out.println("calculerMontantValeurParLot");
//        int type_terrain = 1;
//        double prixMin = 2.5;
//        double prixMax = 4.5;
//        JSONObject lot = new JSONObject();
//        lot.put("superficie", 500.02);
//        double expResult = 1750.07;
//        double result = Utilitaire.calculerMontantValeurParLot
//        (type_terrain, prixMin, prixMax, lot);
//        assertEquals(expResult, result, 0.0);
//       
//    }
//    
//    /* test de la methode CalculerMontantValeurParLot lorsque le type du
//    terrain est 0 */
//       @Test
//    public void testCalculerMontantValeurParLot0() {
//        System.out.println("calculerMontantValeurParLot");
//        int type_terrain = 0;
//        double prixMin = 2.5;
//        double prixMax = 4.5;
//        JSONObject lot = new JSONObject();
//        lot.put("superficie", 1000);
//        double expResult = 2500;
//        double result = Utilitaire.calculerMontantValeurParLot
//        (type_terrain, prixMin, prixMax, lot);
//        assertEquals(expResult, result, 0.0);
//       
//    }
///* test de la methodeCalculerMontantDroitsPassage lorsque le type du terrain est 
//    2 */
//      @Test
//    public void testCalculerMontantDroitsPassage2() {
//        System.out.println("calculerMontantDroitsPassage");
//        int type_terrain = 2;
//        double valeurParLot = 4500;
//        JSONObject lot = new JSONObject();
//        lot.put("nombre_droits_passage",1);
//        
//        double expResult = -175;
//        double result = Utilitaire.calculerMontantDroitsPassage
//        (type_terrain, valeurParLot, lot);
//        assertEquals(expResult, result, 0.0);
//       
//    }
//    
//    /* test de la methodeCalculerMontantDroitsPassage lorsque le type du terrain
//    est  1 */
//     @Test
//    public void testCalculerMontantDroitsPassage1() {
//        System.out.println("calculerMontantDroitsPassage");
//        int type_terrain = 1;
//        double valeurParLot = 1750.07;
//        JSONObject lot = new JSONObject();
//        lot.put("nombre_droits_passage",3);
//        
//        double expResult = -25.021000000000072;
//        double result = Utilitaire.calculerMontantDroitsPassage
//        (type_terrain, valeurParLot, lot);
//        assertEquals(expResult, result, 0.0);
//       
//    }
//    
//    /* test de la methodeCalculerMontantDroitsPassage lorsque le type du terrain
//    est  0 */
//    @Test
//    public void testCalculerMontantDroitsPassage0() {
//        System.out.println("calculerMontantDroitsPassage");
//        int type_terrain = 0;
//        double valeurParLot = 2500;
//        JSONObject lot = new JSONObject();
//        lot.put("nombre_droits_passage",2);
//        
//        double expResult = 250;
//        double result = Utilitaire.calculerMontantDroitsPassage
//        (type_terrain, valeurParLot, lot);
//        assertEquals(expResult, result, 0.0);
//       
//    }
///* test de la methode CalculerMontantService lorsque le type du terrain est 
//    2 et la superficie est inferieure a 500 */
//    @Test
//    public void testCalculerMontantServices2AvecSuperficie500Etmoins() {
//        System.out.println("calculerMontantServices");
//        int type_terrain = 2;
//        JSONObject lot = new JSONObject();
//        lot.put("superficie",500);
//        lot.put("nombre_services", 3);
//        
//        double expResult = 2500;
//        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
//        assertEquals(expResult, result, 0.0);
//     
//    }
//    
//    /* test de la la methode CalculerMontantService lorsque le type du terrain 
//    est  2 et la superficie est entre 500 et 5000 */
//    
//     @Test
//    public void testCalculerMontantServices2AvecSuperficie500EtPlusEtmoinsDe5000() 
//    {
//        System.out.println("calculerMontantServices");
//        int type_terrain = 2;
//        JSONObject lot = new JSONObject();
//        lot.put("superficie",600);
//        lot.put("nombre_services",3);
//        
//        double expResult = 5000;
//        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
//        assertEquals(expResult, result, 0.0);
//     
//    }
//    
//    /* test de la methode CalculerMontantService lorsque le type du terrain est 
//    2 et la superficie est superieure a 5000 */
//      @Test
//    public void testCalculerMontantServices2AvecSuperficiePlusDe5000() {
//        System.out.println("calculerMontantServices");
//        int type_terrain = 2;
//        JSONObject lot = new JSONObject();
//        lot.put("superficie",6000);
//        lot.put("nombre_services", 2);
//        
//        double expResult = 5000;
//        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
//        assertEquals(expResult, result, 0.0);
//     
//    }
//    
//    /* test de la methode CalculerMontantService lorsque le type du terrain est 
//    1 et la superficie est superieure a 10000 */
//    @Test
//    public void testCalculerMontantServices1SuperieurA10000() {
//        System.out.println("calculerMontantServices");
//        int type_terrain = 1;
//        JSONObject lot = new JSONObject();
//        lot.put("superficie",12000);
//        lot.put("nombre_services", 3);
//        
//        double expResult = 5000;
//        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
//        assertEquals(expResult, result, 0.0);
//     
//    }
//    
//    /* test de la methode CalculerMontantService lorsque le type du terrain est 
//    1 et la superficie est entre 500 et 10000 */
//      @Test
//    public void testCalculerMontantServices1Entre500Et10000() {
//        System.out.println("calculerMontantServices");
//        int type_terrain = 1;
//        JSONObject lot = new JSONObject();
//        lot.put("superficie",700);
//        lot.put("nombre_services", 2);
//        
//        double expResult = 2000;
//        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
//        assertEquals(expResult, result, 0.0);
//     
//    }
//    
//    /* test de la methode CalculerMontantService lorsque le type du terrain est 
//    1 et la superficie est inferieure a 500 */
//    
//     @Test
//    public void testCalculerMontantServices1Moinsde500() {
//        System.out.println("calculerMontantServices");
//        int type_terrain = 1;
//        JSONObject lot = new JSONObject();
//        lot.put("superficie",250);
//        lot.put("nombre_services", 2);
//        
//        double expResult = 0;
//        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
//        assertEquals(expResult, result, 0.0);
//     
//    }
//    /* test de la methode CalculerMontantService lorsque le type du terrain est 
//    2 et la superficie est inferieure a 500 */
//       @Test
//    public void testCalculerMontantServices0() {
//        System.out.println("calculerMontantServices");
//        int type_terrain = 0;
//        JSONObject lot = new JSONObject();
//        lot.put("superficie",6000);
//        lot.put("nombre_services", 2);
//        
//        double expResult = 0;
//        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
//        assertEquals(expResult, result, 0.0);
//     
//    }
}
