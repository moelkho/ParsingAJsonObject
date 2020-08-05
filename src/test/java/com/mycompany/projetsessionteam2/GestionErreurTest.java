/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsessionteam2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
//    public void testVerifierCreationFichierSortie() {
//        System.out.println("verifierCreationFichierSortie");
//        File file = null;
//        GestionErreur.verifierCreationFichierSortie(file);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
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
@Test
    public void testVerifierNombreDroitsPassagePasEntie() throws Exception {
        System.out.println("verifierNombreDroitsPassage");
        String str = Utilitaire.loadJsonIntoString("jsonTest/entreeTestNbDroitsPassagePasEntie.json", "jsonTest/sortieTestDansInterval.json");
        JSONObject terrain =Utilitaire.creerJsonObject(str);
        String filePath = "jsonTest/testNbrePassagesPasEntie.json";
        GestionErreur.verifierNombreDroitsPassage(terrain,filePath );      
    }
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

    /**
     * Test of verifierExistanceCleJson method, of class GestionErreur.
     */
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
//    
}
