/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsessionteam2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class GestionErreurTest {
    
    public GestionErreurTest() {
    }

    /**
     * Test of verifierCreationFichierSortie method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierCreationFichierSortie() throws IOException {
//        System.out.println("verifierCreationFichierSortie");
//        File file = new File("jsonTest/testCreation.json");
//        FileWriter fw = new FileWriter(file);
//        fw.write("TestCreationFichierSortie");
//        
//        GestionErreur.verifierCreationFichierSortie(file);
//    }
//
//    /**
//     * Test of verifierNombreDroitsPassage method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierNombreDroitsPassage() throws Exception {
//        System.out.println("verifierNombreDroitsPassage");
//        JSONObject terrain = null;
//        String filePath = "";
//        GestionErreur.verifierNombreDroitsPassage(terrain, filePath);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of verifierNombreservices method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierNombreservices() throws Exception{
//        System.out.println("verifierNombreservices");
//        JSONObject terrain = new JSONObject();
//        
//        
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entree_1.json", "jsonTest/ErreurFichierEntree.json");
//
//        terrain = Utilitaire.creerJsonObject(str);
//
//        String filePath = "jsonTest/NbrService.json";
//        
//        GestionErreur.verifierNombreservices(terrain, filePath);
//
//    }
//
//    /**
//     * Test of verifierNbreLot method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierNbreLot() {
//        System.out.println("verifierNbreLot");
//        JSONObject terrain = null;
//        GestionErreur.verifierNbreLot(terrain);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of verifierPrixNegatif method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierPrixNegatif() {
//        System.out.println("verifierPrixNegatif");
//        JSONObject terrain = null;
//        GestionErreur.verifierPrixNegatif(terrain);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of verifierSuperficieNegative method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierSuperficieNegative() {
//        System.out.println("verifierSuperficieNegative");
//        JSONObject terrain = null;
//        GestionErreur.verifierSuperficieNegative(terrain);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of verifierTypeTerrain method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierTypeTerrain() {
//        System.out.println("verifierTypeTerrain");
//        JSONObject terrain = null;
//        GestionErreur.verifierTypeTerrain(terrain);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of verifierExistanceCleJson method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierExistanceCleJson() throws Exception {
//        System.out.println("verifierExistanceCleJson");
//        JSONObject terrain = null;
//        String filePath = "";
//        GestionErreur.verifierExistanceCleJson(terrain, filePath);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of verifierSiDescriptionEstNull method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierSiDescriptionEstNull() throws Exception {
//        System.out.println("verifierSiDescriptionEstNull");
//        JSONObject terrain = null;
//        String filePath = "";
//        GestionErreur.verifierSiDescriptionEstNull(terrain, filePath);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of verifierSiDescriptionEstUnique method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierSiDescriptionEstUnique() throws Exception {
//        System.out.println("verifierSiDescriptionEstUnique");
//        JSONObject terrain = null;
//        String filePath = "";
//        GestionErreur.verifierSiDescriptionEstUnique(terrain, filePath);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
     
//    @Test
//    public void testVerifierCreationFichierSortie() throws IOException {
//        System.out.println("verifierCreationFichierSortie");
//        File file = new File("jsonTest/testCreation.json");
//        FileWriter fw = new FileWriter(file);
//        fw.write("TestCreationFichierSortie");
//        
//        GestionErreur.verifierCreationFichierSortie(file);
//    }
//
//    /**
//     * Test of verifierNombreDroitsPassage method, of class GestionErreur.
//     */
//@Test
//    public void testVerifierNombreDroitsPassage0() throws Exception {
//        System.out.println("verifierNombreDroitsPassage");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeNormal.json", "jsonTest/sortieTestNb0.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testNbrePassages.json";
//        GestionErreur.verifierNombreDroitsPassage(terrain,filePath );      
//    }
//@Test
//    public void testVerifierNombreDroitsPassagePlusQue10() throws Exception {
//        System.out.println("verifierNombreDroitsPassage");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeTestNbDroitsPassagePlusQue10.json", "jsonTest/sortieTesPlus10.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testNbrePassagesPlusQue10.json";
//        GestionErreur.verifierNombreDroitsPassage(terrain,filePath );      
//    }
//@Test
//    public void testVerifierNombreDroitsPassagePasEntie() throws Exception {
//        System.out.println("verifierNombreDroitsPassage");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeTestNbDroitsPassagePasEntie.json", "jsonTest/sortieTestDansInterval.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testNbrePassagesPasEntie.json";
//        GestionErreur.verifierNombreDroitsPassage(terrain,filePath );      
//    }
//@Test
//    public void testVerifierNombreDroitsPassageNegatif() throws Exception {
//        System.out.println("verifierNombreDroitsPassage");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeTestNbDroitsPassageNegatif.json", "jsonTest/sortieTestNegatif.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testNbrePassagesNegatif.json";
//        GestionErreur.verifierNombreDroitsPassage(terrain,filePath );      
//    }
//@Test
//    public void testVerifierNombreDroitsPassageEnter0Et10() throws Exception {
//        System.out.println("verifierNombreDroitsPassage");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeNormal.json", "jsonTest/sortieTestNbEnter0Et10.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testNbrePassages.json";
//        GestionErreur.verifierNombreDroitsPassage(terrain,filePath );      
//    }
//@Test
//    public void testVerifierNombreDroitsPassage10() throws Exception {
//        System.out.println("verifierNombreDroitsPassage");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeNormal.json", "jsonTest/sortieTestNb10.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testNbrePassages.json";
//        GestionErreur.verifierNombreDroitsPassage(terrain,filePath );      
//    }
    /**
     * Test of verifierNombreservices method, of class GestionErreur.
     */
//    @Test
//    public void testVerifierNombreservices() {
//        System.out.println("verifierNombreservices");
//        JSONObject terrain = null;
//        GestionErreur.verifierNombreservices(terrain);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of verifierNbreLot method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierNbreLot() {
//        System.out.println("verifierNbreLot");
//        JSONObject terrain = null;
//        GestionErreur.verifierNbreLot(terrain);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of verifierPrixNegatif method, of class GestionErreur.
//     */
//
//    @Test
//    public void testVerifierPrixMaxNegatif() throws IOException {
//        System.out.println("verifierPrixNegatif");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreePrixMaxNegatif.json", "jsonTest/sortieTestPrixMaxNegatif.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testPrixMaxNegatif.json";   
//        GestionErreur.verifierPrixNegatif(terrain, filePath);
//    }
//    @Test
//    public void testVerifierPrixMinNegatif() throws IOException {
//        System.out.println("verifierPrixNegatif");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreePrixMinNegatif.json", "jsonTest/sortieTestPrixMinNegatif.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testPrixMinNegatif.json";   
//        GestionErreur.verifierPrixNegatif(terrain, filePath);
//    }
//
//    /**
//     * Test of verifierSuperficieNegative method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierSuperficieNegative() throws IOException {
//        System.out.println("verifierSuperficieNegative");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeSuperficieNegatif.json", "jsonTest/sortieTestSuperficierNegatif.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testSuperficierNegatif.json"; 
//        GestionErreur.verifierSuperficie(terrain, filePath);       
//    }
//    @Test
//      public void testVerifierSuperficiePlusQue50000() throws IOException {
//        System.out.println("verifierSuperficieNegative");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeSuperficierPlusQue50000.json", "jsonTest/sortieTestSuperficierPlusQue50000.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testSuperficierPlusQue50000.json"; 
//        GestionErreur.verifierSuperficie(terrain, filePath);
//    }
//    @Test
//      public void testVerifierSuperficieDansInterval() throws IOException {
//        System.out.println("verifierSuperficieNegative");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeNormal.json", "jsonTest/sortieTestSuperficieDansInterval.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testSuperficieDansInterval.json"; 
//        GestionErreur.verifierSuperficie(terrain, filePath);
//    }
//
//    /**
//     * Test of verifierTypeTerrain method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierTypeTerrain_Ni0_Ni1_Ni2() throws IOException {
//        System.out.println("verifierTypeTerrain");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeTypeTerain_Ni0_Ni1_Ni2.json", "jsonTest/sortieTestTyptTerrain_Ni0_Ni1_Ni2.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testTypeTerain_Ni0_Ni1_Ni2.json"; 
//        GestionErreur.verifierTypeTerrain(terrain, filePath);
//    }
//    @Test
//    public void testVerifierTypeTerrainSoit_0_1_2() throws IOException {
//        System.out.println("verifierTypeTerrain");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeNormal.json", "jsonTest/sortieTestTyptTerrainDans_0_1_2.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testTypeTerainDans0_1_2.json"; 
//        GestionErreur.verifierTypeTerrain(terrain, filePath);
//    }

    /**
     * Test of verifierExistanceCleJson method, of class GestionErreur.
     */
//    @Test
//    public void testVerifierExistanceCleJsonSansTypeTerrain() throws Exception {
//        System.out.println("verifierExistanceCleJson");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeSansTypeTerrain.json", "jsonTest/sortieTestSansTyptTerrain.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testSansTypeTerrain.json"; 
//        GestionErreur.verifierExistanceCleJson(terrain, filePath);
//    }
//    @Test
//    public void testVerifierExistanceCleJsonSansPrixMax() throws Exception {
//        System.out.println("verifierExistanceCleJson");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeSansPrixMax.json", "jsonTest/sortieTestSansPrixMax.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testSansPrixMax.json"; 
//        GestionErreur.verifierExistanceCleJson(terrain, filePath);
//    }   
//    @Test
//    public void testVerifierExistanceCleJsonSansPrixMin() throws Exception {
//        System.out.println("verifierExistanceCleJson");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeSansPrixMin.json", "jsonTest/sortieTestSansPrixMin.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testSansPrixMin.json"; 
//        GestionErreur.verifierExistanceCleJson(terrain, filePath);
//    } 
//////    @Test
//////    public void testVerifierExistanceCleJsonSansLotissements() throws Exception {
//////        System.out.println("verifierExistanceCleJson");       
//////        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeSansLotissements.json", "jsonTest/sortieTestSansLotissements.json");
//////        JSONObject terrain =Utilitaire.creerJsonObject(str);      
//////        String filePath = "jsonTest/testSansLotissements.json"; 
//////        GestionErreur.verifierExistanceCleJson(terrain, filePath);
//////    } 
//    @Test
//    public void testVerifierExistanceCleJsonSansDescription() throws Exception {
//        System.out.println("verifierExistanceCleJson");       
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeSansDescription.json", "jsonTest/sortieTestSansDescription.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);      
//        String filePath = "jsonTest/testSansDescription.json"; 
//        GestionErreur.verifierExistanceCleJson(terrain, filePath);
//    } 
//    @Test
//    public void testVerifierExistanceCleJsonSansNombre_droits_passage() throws Exception {
//        System.out.println("verifierExistanceCleJson");       
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeSansNombre_droits_passage.json", "jsonTest/sortieTestSansNombre_droits_passage.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);      
//        String filePath = "jsonTest/testSansNombre_droits_passage.json"; 
//        GestionErreur.verifierExistanceCleJson(terrain, filePath);
//    } 
//    @Test
//    public void testVerifierExistanceCleJsonSansNombre_services() throws Exception {
//        System.out.println("verifierExistanceCleJson");       
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeSansNombre_services.json", "jsonTest/sortieTestSansNombre_services.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);      
//        String filePath = "jsonTest/testSansNombre_services.json"; 
//        GestionErreur.verifierExistanceCleJson(terrain, filePath);
//    } 
//    @Test
//    public void testVerifierExistanceCleJsonSansSuperficie() throws Exception {
//        System.out.println("verifierExistanceCleJson");       
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeSansSuperficie.json", "jsonTest/sortieTestSansSuperficie.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);      
//        String filePath = "jsonTest/testSansSuperficie.json"; 
//        GestionErreur.verifierExistanceCleJson(terrain, filePath);
//    }
//    @Test
//    public void testVerifierExistanceCleJsonSansDate_mesure() throws Exception {
//        System.out.println("verifierExistanceCleJson");       
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeSansDate_mesure.json", "jsonTest/sortieTestSansDate_mesure.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);      
//        String filePath = "jsonTest/testSansDate_mesure.json"; 
//        GestionErreur.verifierExistanceCleJson(terrain, filePath);
//    }
//
//    /**
//     * Test of verifierSiDescriptionEstNull method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierSiDescriptionEstNull() throws Exception {
//        System.out.println("verifierSiDescriptionEstNull");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeDescriptionEstNull.json", "jsonTest/sortieTestDescriptionEstNull.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testDescriptionEstNull.json"; 
//        GestionErreur.verifierSiDescriptionEstNull(terrain, filePath);
//    }
//    @Test
//    public void testVerifierSiDescriptionNonNull() throws Exception {
//        System.out.println("verifierSiDescriptionEstNull");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeNormal.json", "jsonTest/sortieTestDescriptionNonNull.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testDescriptionNonNull.json"; 
//        GestionErreur.verifierSiDescriptionEstNull(terrain, filePath);
//    }
//
//    /**
//     * Test of verifierSiDescriptionEstUnique method, of class GestionErreur.
//     */
//    @Test
//    public void testVerifierSiDescriptionEstUnique() throws Exception {
//        System.out.println("verifierSiDescriptionEstUnique");
//        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeNormal.json", "jsonTest/sortieTestDescriptionEstUnique.json");
//        JSONObject terrain =Utilitaire.creerJsonObject(str);
//        String filePath = "jsonTest/testDescriptionEstUnique.json"; 
//        GestionErreur.verifierSiDescriptionEstUnique(terrain, filePath);
//    }
     @Test
    public void testVerifierSiDescriptionNonUnique() throws Exception {
        System.out.println("verifierSiDescriptionEstUnique");
        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeDescriptionNonUnique.json", "jsonTest/sortieTestDescriptionNonUnique.json");
        JSONObject terrain =Utilitaire.creerJsonObject(str);
        String filePath = "jsonTest/testDescriptionNonUnique.json"; 
        GestionErreur.verifierSiDescriptionEstUnique(terrain, filePath);
    }
//    
}
