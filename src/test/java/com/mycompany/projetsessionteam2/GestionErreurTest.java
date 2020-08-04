/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsessionteam2;

import java.io.File;
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
     */
    @Test
    public void testVerifierCreationFichierSortie() {
        System.out.println("verifierCreationFichierSortie");
        File file = null;
        GestionErreur.verifierCreationFichierSortie(file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifierNombreDroitsPassage method, of class GestionErreur.
     */
    @Test
    public void testVerifierNombreDroitsPassage() throws Exception {
        System.out.println("verifierNombreDroitsPassage");
        JSONObject terrain = null;
        String filePath = "";
        GestionErreur.verifierNombreDroitsPassage(terrain, filePath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifierNombreservices method, of class GestionErreur.
     */
    @Test
    public void testVerifierNombreservices() {
        System.out.println("verifierNombreservices");
        JSONObject terrain = null;
        GestionErreur.verifierNombreservices(terrain);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifierNbreLot method, of class GestionErreur.
     */
    @Test
    public void testVerifierNbreLot() {
        System.out.println("verifierNbreLot");
        JSONObject terrain = null;
        GestionErreur.verifierNbreLot(terrain);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifierPrixNegatif method, of class GestionErreur.
     */
    @Test
    public void testVerifierPrixNegatif() {
        System.out.println("verifierPrixNegatif");
        JSONObject terrain = null;
        GestionErreur.verifierPrixNegatif(terrain);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifierSuperficieNegative method, of class GestionErreur.
     */
    @Test
    public void testVerifierSuperficieNegative() {
        System.out.println("verifierSuperficieNegative");
        JSONObject terrain = null;
        GestionErreur.verifierSuperficieNegative(terrain);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifierTypeTerrain method, of class GestionErreur.
     */
    @Test
    public void testVerifierTypeTerrain() {
        System.out.println("verifierTypeTerrain");
        JSONObject terrain = null;
        GestionErreur.verifierTypeTerrain(terrain);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifierExistanceCleJson method, of class GestionErreur.
     */
    @Test
    public void testVerifierExistanceCleJson() throws Exception {
        System.out.println("verifierExistanceCleJson");
        JSONObject terrain = null;
        String filePath = "";
        GestionErreur.verifierExistanceCleJson(terrain, filePath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifierSiDescriptionEstNull method, of class GestionErreur.
     */
    @Test
    public void testVerifierSiDescriptionEstNull() throws Exception {
        System.out.println("verifierSiDescriptionEstNull");
        JSONObject terrain = null;
        String filePath = "";
        GestionErreur.verifierSiDescriptionEstNull(terrain, filePath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifierSiDescriptionEstUnique method, of class GestionErreur.
     */
    @Test
    public void testVerifierSiDescriptionEstUnique() throws Exception {
        System.out.println("verifierSiDescriptionEstUnique");
        JSONObject terrain = null;
        String filePath = "";
        GestionErreur.verifierSiDescriptionEstUnique(terrain, filePath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
