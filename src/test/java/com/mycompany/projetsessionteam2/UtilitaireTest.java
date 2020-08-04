/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsessionteam2;

import java.io.File;
import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class UtilitaireTest {
    
    public UtilitaireTest() {
    }

    /**
     * Test of loadJsonIntoString method, of class Utilitaire.
     */
  @Test
    public void testLoadJsonIntoString() throws Exception {
        System.out.println("loadJsonIntoString");
        String filePath = "jsonTest/test1.json";
        String expResult = "{\"name\":\"admin\"}";
        String result = Utilitaire.loadJsonIntoString(filePath);
        assertEquals(expResult, result);
       
    }
    /**
     * Test of creerJsonObject method, of class Utilitaire.
     */
    @Test
    public void testCreerJsonObject() {
        System.out.println("creerJsonObject");
        String json = "{\"name\":\"admin\"}";
        JSONObject expResult = new JSONObject();
        expResult.put("name", "admin");
        JSONObject result = Utilitaire.creerJsonObject(json);
        assertEquals(expResult, result);
    
    }
//
//    /**
//     * Test of obtenirTypeTerrain method, of class Utilitaire.
//     */
    @Test
    public void testObtenirTypeTerrain()  {
        System.out.println("obtenirTypeTerrain");
       
        JSONObject terrain = new JSONObject();
        terrain.put("type_terrain", 2);
        int expResult = 2;
        int result = Utilitaire.obtenirTypeTerrain(terrain);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of obtenirPrixMin method, of class Utilitaire.
     */
    @Test
    public void testObtenirPrixMin() {
        System.out.println("obtenirPrixMin");
        JSONObject terrain = new JSONObject();
        terrain.put("prix_m2_min","2,6 $");
        double expResult = 2.6;
        double result = Utilitaire.obtenirPrixMin(terrain);
        assertEquals(expResult, result, 0.0);
        
    }
//
//    /**
//     * Test of obtenirPrixMax method, of class Utilitaire.
//     */
    @Test
    public void testObtenirPrixMax() {
        System.out.println("obtenirPrixMax");
        JSONObject terrain = new JSONObject();
        terrain.put("prix_m2_max","4,9 $");
        double expResult = 4.9;
        double result = Utilitaire.obtenirPrixMax(terrain);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of recupererLotissement method, of class Utilitaire.
     */
//    @Test
//    public void testRecupererLotissement() {
//        System.out.println("recupererLotissement");
//        JSONObject terrain = null;
//        JSONArray expResult = null;
//        JSONArray result = Utilitaire.recupererLotissement(terrain);
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of obtenirLot method, of class Utilitaire.
//     */
//    @Test
//    public void testObtenirLot() {
//        System.out.println("obtenirLot");
//        JSONArray lotissement = null;
//        int i = 0;
//        JSONObject expResult = null;
//        JSONObject result = Utilitaire.obtenirLot(lotissement, i);
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of calculerValeurFonciereParLot method, of class Utilitaire.
//     */
    @Test
    public void testCalculerValeurFonciereParLot() {
        System.out.println("calculerValeurFonciereParLot");
        double valeurParLot = 2.5;
        double montantDroitsPassage = 2.5;
        double montantServices = 1.3;
        double expResult = 6.3;
        double result = Utilitaire.calculerValeurFonciereParLot(valeurParLot, montantDroitsPassage, montantServices);
        assertEquals(expResult, result, 0.0);
        
    }
//
//    /**
//     * Test of cumulerValFinanciereParLot method, of class Utilitaire.
//     */
    @Test
    public void testCumulerValFinanciereParLot() {
        System.out.println("cumulerValFinanciereParLot");
        double valFonciereParLot = 3.0;
        double valFociereTerrainInitial = 1.5;
        double expResult = 4.5;
        double result = Utilitaire.cumulerValFinanciereParLot(valFonciereParLot, valFociereTerrainInitial);
        assertEquals(expResult, result, 0.0);
        
    }
//
//    /**
//     * Test of creerLotSortie method, of class Utilitaire.
//     */
//    @Test
//    public void testCreerLotSortie() throws Exception {
//        System.out.println("creerLotSortie");
//        JSONObject lot = null;
//        double valFonciereParLot = 0.0;
//        JSONObject expResult = null;
//        JSONObject result = Utilitaire.creerLotSortie(lot, valFonciereParLot);
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of ajouterLotSortieAuLotissementSortie method, of class Utilitaire.
//     */
//    @Test
//    public void testAjouterLotSortieAuLotissementSortie() {
//        System.out.println("ajouterLotSortieAuLotissementSortie");
//        JSONObject lotSortie = null;
//        JSONArray lotissementSortie = null;
//        Utilitaire.ajouterLotSortieAuLotissementSortie(lotSortie, lotissementSortie);
//        
//    }
//
//    /**
//     * Test of calculerValFonciereFinal method, of class Utilitaire.
//     */
//    @Test
//    public void testCalculerValFonciereFinal() {
//        System.out.println("calculerValFonciereFinal");
//        double valFociereTerrainInitial = 0.0;
//        double expResult = 0.0;
//        double result = Utilitaire.calculerValFonciereFinal(valFociereTerrainInitial);
//        assertEquals(expResult, result, 0.0);
//        
//    }
//
//    /**
//     * Test of calculerTaxeScolaire method, of class Utilitaire.
//     */
//    @Test
//    public void testCalculerTaxeScolaire() {
//        System.out.println("calculerTaxeScolaire");
//        double valFociereFinalTerrain = 0.0;
//        double expResult = 0.0;
//        double result = Utilitaire.calculerTaxeScolaire(valFociereFinalTerrain);
//        assertEquals(expResult, result, 0.0);
//        
//    }
//
//    /**
//     * Test of calculerTaxeMunicipale method, of class Utilitaire.
//     */
//    @Test
//    public void testCalculerTaxeMunicipale() {
//        System.out.println("calculerTaxeMunicipale");
//        double valFociereFinalTerrain = 0.0;
//        double expResult = 0.0;
//        double result = Utilitaire.calculerTaxeMunicipale(valFociereFinalTerrain);
//        assertEquals(expResult, result, 0.0);
//        
//    }
//
//    /**
//     * Test of creerJsonObjectDeSortie method, of class Utilitaire.
//     */
//    @Test
//    public void testCreerJsonObjectDeSortie() throws Exception {
//        System.out.println("creerJsonObjectDeSortie");
//        JSONArray lotissementSortie = null;
//        double valFociereFinalTerrain = 0.0;
//        double taxeScolaire = 0.0;
//        double taxeMunicipale = 0.0;
//        JSONObject expResult = null;
//        JSONObject result = Utilitaire.creerJsonObjectDeSortie(lotissementSortie, valFociereFinalTerrain, taxeScolaire, taxeMunicipale);
//        assertEquals(expResult, result);
//        
//    }
//
//    /**
//     * Test of calculerMontantValeurParLot method, of class Utilitaire.
//     */
    @Test
    public void testCalculerMontantValeurParLot() throws IOException {
        System.out.println("calculerMontantValeurParLot");
        int type_terrain = 0;
        
        JSONObject lot = new JSONObject();
        String str = Utilitaire.loadJsonIntoString("jsonTest/testLot.json");
        lot = Utilitaire.creerJsonObject(str);
        double prixMin = 3.45;
        double prixMax = 7.0;
        double expResult = 1604.25;
        double result = Utilitaire.calculerMontantValeurParLot(type_terrain, lot, prixMin, prixMax);
        assertEquals(expResult, result, 0.0);
      
    }
//
//    /**
//     * Test of calculerMontantDroitsPassage method, of class Utilitaire.
//     */
//    @Test
//    public void testCalculerMontantDroitsPassage() {
//        System.out.println("calculerMontantDroitsPassage");
//        int type_terrain = 0;
//        double valeurParLot = 0.0;
//        JSONObject lot = null;
//        double expResult = 0.0;
//        double result = Utilitaire.calculerMontantDroitsPassage(type_terrain, valeurParLot, lot);
//        assertEquals(expResult, result, 0.0);
//       
//    }
//
//    /**
//     * Test of calculerMontantServices method, of class Utilitaire.
//     */
    @Test
    public void testCalculerMontantServices() throws IOException {
        System.out.println("calculerMontantServices");
        int type_terrain = 0;
        JSONObject lot = null;
        String str = Utilitaire.loadJsonIntoString("jsonTest/testLot.json");
        lot = Utilitaire.creerJsonObject(str);
        double expResult = 0.0;
        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
        assertEquals(expResult, result, 0.0);
        
    }
//
//    /**
//     * Test of saveJsonIntoFile method, of class Utilitaire.
//     */
//    @Test
//    public void testSaveJsonIntoFile() throws Exception {
//        System.out.println("saveJsonIntoFile");
//        String content = "";
//        String filePath = "";
//        File expResult = null;
//        File result = Utilitaire.saveJsonIntoFile(content, filePath);
//        assertEquals(expResult, result);
//       
//    }
//
//    /**
//     * Test of roundTo5 method, of class Utilitaire.
//     */
    @Test
    public void testRoundTo5() throws Exception {
        System.out.println("roundTo5");
        double i = 1.02;
        double v = 0.05;
        String expResult = "1.05";
        String result = Utilitaire.roundTo5(i, v);
        assertEquals(expResult, result);
       
    }
    
    @Test
     public void testRoundTo5Vegatif() throws Exception {
        System.out.println("roundTo5");
        double i = -2.02;
        double v = 0.05;
        String expResult = "-2.00";
        String result = Utilitaire.roundTo5(i, v);
        assertEquals(expResult, result);
       
    }
     
     @Test
      public void testRoundTo5ChiffreDejaArrondi() throws Exception {
        System.out.println("roundTo5");
        double i = 5.05;
        double v = 0.05;
        String expResult = "5.05";
        String result = Utilitaire.roundTo5(i, v);
        assertEquals(expResult, result);
       
    }
}
