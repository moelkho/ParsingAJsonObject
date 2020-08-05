/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsessionteam2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.json.simple.parser.ParseException;
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
        String fileSortie = "jsonTest/sortieTest.json";
        String expResult = "{\"name\":\"admin\"}";
        String result = Utilitaire.loadJsonIntoString(filePath,fileSortie);
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

    /**
     * Test of obtenirTypeTerrain method, of class Utilitaire.
     */
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

    /**
     * Test of obtenirPrixMax method, of class Utilitaire.
     */
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
    @Test
    public void testRecupererLotissement() throws IOException {
        System.out.println("recupererLotissement");
        String str = Utilitaire.loadJsonIntoString("jsonTest/obtenirLotissementTest.json","jsonTest/sortieTest.json");
        JSONObject terrain = Utilitaire.creerJsonObject(str);
        JSONArray expResult = JSONArray.fromObject("[{\"description\":\"lot 1\""
                + ",\"nombre_droits_passage\":4,\"nombre_services\":1,\"superficie\":465,\"date_mesure\":\"2015-10-14\"}]");
        JSONArray result = Utilitaire.recupererLotissement(terrain);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of obtenirLot method, of class Utilitaire.
     */
    @Test
    public void testObtenirLot() {
        System.out.println("obtenirLot");
        JSONArray lotissement = JSONArray.fromObject("[{\"description\":\"lot 1\""
                + ",\"nombre_droits_passage\":4,\"nombre_services\":1,\"superficie\""
                + ":465,\"date_mesure\":\"2015-10-14\"},"
                + "{\"description\":\"lot 2\",\"nombre_droits_passage\":0,"
                + "\"nombre_services\":1,\"superficie\":1082,\"date_mesure\":"
                + "\"2015-12-15\"}]");
        int i = 1;
        JSONObject expResult = JSONObject.fromObject("{\"description\":\"lot 2\","
                + "\"nombre_droits_passage\":0,\"nombre_services\":1,\"superficie\""
                + ":1082,\"date_mesure\":\"2015-12-15\"}");
        JSONObject result = Utilitaire.obtenirLot(lotissement, i);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of calculerValeurFonciereParLot method, of class Utilitaire.
     */
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

    /**
     * Test of cumulerValFinanciereParLot method, of class Utilitaire.
     */
    @Test
    public void testCumulerValFinanciereParLot() {
        System.out.println("cumulerValFinanciereParLot");
        double valFonciereParLot = 3.0;
        double valFociereTerrainInitial = 1.5;
        double expResult = 4.5;
        double result = Utilitaire.cumulerValFinanciereParLot(valFonciereParLot, valFociereTerrainInitial);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of creerLotSortie method, of class Utilitaire.
     */
    @Test
    public void testCreerLotSortie() throws Exception {
        System.out.println("creerLotSortie");
        String str = Utilitaire.loadJsonIntoString("jsonTest/testCreerLotSortie.json", "sortieTest.json");
        JSONObject lot = Utilitaire.creerJsonObject(str);
        double valFonciereParLot = 1957.775;
        JSONObject expResult = JSONObject.fromObject("{\"description\":\"lot 1\",\"valeur_par_lot\":\"1957.80 $\"}");
        JSONObject result = Utilitaire.creerLotSortie(lot, valFonciereParLot);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of ajouterLotSortieAuLotissementSortie method, of class Utilitaire.
     */
    @Test
    public void testAjouterLotSortieAuLotissementSortie() {
        System.out.println("ajouterLotSortieAuLotissementSortie");
        JSONObject lotSortie = JSONObject.fromObject("{\"nom\":\"admin\"}");
        JSONArray lotissementSortie = new JSONArray();
        Utilitaire.ajouterLotSortieAuLotissementSortie(lotSortie, lotissementSortie);
        
    }

    /**
     * Test of calculerValFonciereFinal method, of class Utilitaire.
     */
    @Test
    public void testCalculerValFonciereFinal() {
        System.out.println("calculerValFonciereFinal");
        double valFociereTerrainInitial = 200.60;
        double expResult = 934.37;
        double result = Utilitaire.calculerValFonciereFinal(valFociereTerrainInitial);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of calculerTaxeScolaire method, of class Utilitaire.
     */
    @Test
    public void testCalculerTaxeScolaire() {
        System.out.println("calculerTaxeScolaire");
        double valFociereFinalTerrain = 2000.00;
        double expResult = 24;
        double result = Utilitaire.calculerTaxeScolaire(valFociereFinalTerrain);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of calculerTaxeMunicipale method, of class Utilitaire.
     */
    @Test
    public void testCalculerTaxeMunicipale() {
        System.out.println("calculerTaxeMunicipale");
        double valFociereFinalTerrain = 10400;
        double expResult = 260;
        double result = Utilitaire.calculerTaxeMunicipale(valFociereFinalTerrain);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of creerJsonObjectDeSortie method, of class Utilitaire.
     */
    @Test
    public void testCreerJsonObjectDeSortie() throws Exception {
        System.out.println("creerJsonObjectDeSortie");
        JSONArray lotissementSortie = JSONArray.fromObject("[{\"description\":\""
                + "lot 1\",\"valeur_par_lot\":\"1783.40 $\"},{\"description\":\""
                + "lot 2\",\"valeur_par_lot\":\"4232.90 $\"},{\"description\":\""
                + "lot 3\",\"valeur_par_lot\":\"7399.35 $\"},{\"description\":\""
                + "lot 4\",\"valeur_par_lot\":\"4232.90 $\"},{\"description\":\""
                + "lot 5\",\"valeur_par_lot\":\"4232.90 $\"},{\"description\":\""
                + "lot 6\",\"valeur_par_lot\":\"4232.90 $\"}]");
        double valFociereFinalTerrain = 26848.10;
        double taxeScolaire = 322.20;
        double taxeMunicipale = 671.25;
        String str = Utilitaire.loadJsonIntoString("jsonTest/objetDeSortie.json","jsonTest/sortieTest.json");
        JSONObject expResult = null;
        expResult = Utilitaire.creerJsonObject(str);
        JSONObject result = Utilitaire.creerJsonObjectDeSortie(lotissementSortie, valFociereFinalTerrain, taxeScolaire, taxeMunicipale);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of calculerMontantValeurParLot method, of class Utilitaire.
     */
    @Test
    public void testCalculerMontantValeurParLot0() throws IOException {
        System.out.println("calculerMontantValeurParLot0");
        int type_terrain = 0;
        
        JSONObject lot = new JSONObject();
        String str = Utilitaire.loadJsonIntoString("jsonTest/testLot.json","jsonTest/sortieTest.json");
        lot = Utilitaire.creerJsonObject(str);
        double prixMin = 3.45;
        double prixMax = 7.0;
        double expResult = 1604.25;
        double result = Utilitaire.calculerMontantValeurParLot(type_terrain, lot, prixMin, prixMax);
        assertEquals(expResult, result, 0.0);
      
    }
    @Test
    public void testCalculerMontantValeurParLot1() throws IOException {
        System.out.println("calculerMontantValeurParLot1");
        int type_terrain = 1;
        
        JSONObject lot = new JSONObject();
        String str = Utilitaire.loadJsonIntoString("jsonTest/testLot.json","jsonTest/sortieTest.json");
        lot = Utilitaire.creerJsonObject(str);
        double prixMin = 3.45;
        double prixMax = 7.0;
        double expResult = 2429.625;
        double result = Utilitaire.calculerMontantValeurParLot(type_terrain, lot, prixMin, prixMax);
        assertEquals(expResult, result, 0.0);
      
    }
    
    @Test
    public void testCalculerMontantValeurParLot2() throws IOException {
        System.out.println("calculerMontantValeurParLot2");
        int type_terrain = 2;
        
        JSONObject lot = new JSONObject();
        String str = Utilitaire.loadJsonIntoString("jsonTest/testLot.json","jsonTest/sortieTest.json");
        lot = Utilitaire.creerJsonObject(str);
        double prixMin = 3.45;
        double prixMax = 7.0;
        double expResult = 3255;
        double result = Utilitaire.calculerMontantValeurParLot(type_terrain, lot, prixMin, prixMax);
        assertEquals(expResult, result, 0.0);
      
    }

    /**
     * Test of calculerMontantDroitsPassage method, of class Utilitaire.
     */
    @Test
    public void testCalculerMontantDroitsPassage1() {
        System.out.println("calculerMontantDroitsPassage1");
        int type_terrain = 1;
        double valeurParLot = 1750.07;
        JSONObject lot = JSONObject.fromObject("{\"nombre_droits_passage\": 4}");
        double expResult = -200.02800000000002;
        double result = Utilitaire.calculerMontantDroitsPassage(type_terrain, valeurParLot, lot);
        assertEquals(expResult, result, 0.0);
       
    }
    
     @Test
    public void testCalculerMontantDroitsPassage2() {
        System.out.println("calculerMontantDroitsPassage2");
        int type_terrain = 2;
        double valeurParLot = 1750.07;
        JSONObject lot = JSONObject.fromObject("{\"nombre_droits_passage\": 3}");
        
        double expResult = -287.53149999999994;
        double result = Utilitaire.calculerMontantDroitsPassage
        (type_terrain, valeurParLot, lot);
        assertEquals(expResult, result, 0.0);
       
    }
      @Test
    public void testCalculerMontantDroitsPassage0() {
        System.out.println("calculerMontantDroitsPassage0");
        int type_terrain = 0;
        double valeurParLot = 1750.07;
       JSONObject lot = JSONObject.fromObject("{\"nombre_droits_passage\": 2}");
        
        double expResult = 324.993;
        double result = Utilitaire.calculerMontantDroitsPassage
        (type_terrain, valeurParLot, lot);
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of calculerMontantServices method, of class Utilitaire.
     */
     @Test
    public void testCalculerMontantServices2AvecSuperficie500Etmoins() {
        System.out.println("calculerMontantServicesSuperficie500Etmoins");
        int type_terrain = 2;
        JSONObject lot = new JSONObject();
        lot.put("superficie",500);
        lot.put("nombre_services", 3);
        
        double expResult = 2500;
        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
        assertEquals(expResult, result, 0.0);
     
    }
    
    /* test de la la methode CalculerMontantService lorsque le type du terrain 
    est  2 et la superficie est entre 500 et 5000 */
    
     @Test
    public void testCalculerMontantServices2AvecSuperficie500EtPlusEtmoinsDe5000() 
    {
        System.out.println("calculerMontantServicesSuperficie500EtPlusEtmoinsDe5000");
        int type_terrain = 2;
        JSONObject lot = new JSONObject();
        lot.put("superficie",600);
        lot.put("nombre_services",3);
        
        double expResult = 5000;
        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
        assertEquals(expResult, result, 0.0);
     
    }
    
    /* test de la methode CalculerMontantService lorsque le type du terrain est 
    2 et la superficie est superieure a 5000 */
      @Test
    public void testCalculerMontantServices2AvecSuperficiePlusDe5000() {
        System.out.println("calculerMontantServices2AvecSuperficiePlusDe5000");
        int type_terrain = 2;
        JSONObject lot = new JSONObject();
        lot.put("superficie",6000);
        lot.put("nombre_services", 2);
        
        double expResult = 5000;
        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
        assertEquals(expResult, result, 0.0);
     
    }
    
    /* test de la methode CalculerMontantService lorsque le type du terrain est 
    1 et la superficie est superieure a 10000 */
    @Test
    public void testCalculerMontantServices1SuperieurA10000() {
        System.out.println("calculerMontantServices1SuperieurA10000");
        int type_terrain = 1;
        JSONObject lot = new JSONObject();
        lot.put("superficie",12000);
        lot.put("nombre_services", 3);
        
        double expResult = 5000;
        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
        assertEquals(expResult, result, 0.0);
     
    }
    
    /* test de la methode CalculerMontantService lorsque le type du terrain est 
    1 et la superficie est entre 500 et 10000 */
      @Test
    public void testCalculerMontantServices1Entre500Et10000() {
        System.out.println("calculerMontantServices1Entre500Et10000");
        int type_terrain = 1;
        JSONObject lot = new JSONObject();
        lot.put("superficie",700);
        lot.put("nombre_services", 2);
        
        double expResult = 2000;
        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
        assertEquals(expResult, result, 0.0);
     
    }
    
    /* test de la methode CalculerMontantService lorsque le type du terrain est 
    1 et la superficie est inferieure a 500 */
    
     @Test
    public void testCalculerMontantServices1Moinsde500() {
        System.out.println("calculerMontantServices1Moinsde500");
        int type_terrain = 1;
        JSONObject lot = new JSONObject();
        lot.put("superficie",250);
        lot.put("nombre_services", 2);
        
        double expResult = 0;
        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
        assertEquals(expResult, result, 0.0);
     
    }
    /* test de la methode CalculerMontantService lorsque le type du terrain est 
    2 et la superficie est inferieure a 500 */
       @Test
    public void testCalculerMontantServices0() {
        System.out.println("calculerMontantServices0");
        int type_terrain = 0;
        JSONObject lot = new JSONObject();
        lot.put("superficie",6000);
        lot.put("nombre_services", 2);
        
        double expResult = 0;
        double result = Utilitaire.calculerMontantServices(type_terrain, lot);
        assertEquals(expResult, result, 0.0);
     
    }

    /**
     * Test of saveJsonIntoFile method, of class Utilitaire.
     */
    @Test
    public void testSaveJsonIntoFile() throws Exception {
        System.out.println("saveJsonIntoFile");
        String content = "{\"test\":\"sauvegarde json into file \"}";
        String filePath = "/jsonTest/testSauvegardeJsonIntoFile.json" ;
        File expResult = new File("/jsonTest/testSauvegardeJsonIntoFile.json");
        FileWriter fw = new FileWriter(expResult);
        fw.write("{\"test\":\"sauvegarde json into file \"}");
        
        
       
        File result = Utilitaire.saveJsonIntoFile(content, filePath);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of roundTo5 method, of class Utilitaire.
     */
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
     public void testRoundTo5Negatif() throws Exception {
        System.out.println("roundTo5Negatif");
        double i = -2.02;
        double v = 0.05;
        String expResult = "-2.00";
        String result = Utilitaire.roundTo5(i, v);
        assertEquals(expResult, result);
       
    }
     
 @Test(expected = java.text.ParseException.class)
      public void testRoundTo5ParseException() throws Exception {
        System.out.println("roundTo5ParseException");
         NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
         
        String str = "a,2";
        double i = nf.parse(str).doubleValue();
        double v = 0.05;
        
        String expResult = "5.05";
        String result = Utilitaire.roundTo5(i, v);
        assertEquals(expResult, result);
       
    }
     
     @Test
      public void testRoundTo5ChiffreDejaArrondi() throws Exception {
        System.out.println("roundTo5ChiffreDejaArrondi");
        double i = 5.05;
        double v = 0.05;
        String expResult = "5.05";
        String result = Utilitaire.roundTo5(i, v);
        assertEquals(expResult, result);
       
    }
}
