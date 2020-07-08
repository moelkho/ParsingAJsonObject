package com.mycompany.projetsessionteam2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

public class TerrainTest {

    public TerrainTest() {
    }

    // teste de la methode creer un terrain 
    @Test
    public void testCreerTerrain() {
        System.out.println("creerTerrain");

        JSONObject expResult = new JSONObject();
        expResult.accumulate("type_terrain", 2);
        expResult.accumulate("prix_m2_min", "3.45 $");
        expResult.accumulate("prix_m2_max", "7.00 $");
        JSONArray lotissements = new JSONArray();
        JSONObject lot = new JSONObject();

        TimeZone tz = TimeZone.getTimeZone("GMT-4:00");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);

        lot.accumulate("description", "lot 1");
        lot.accumulate("nombre_droits_passage", 4);
        lot.accumulate("nombre_services", 0);
        lot.accumulate("superficie", 465);

        String dateInString1 = "12-05-2000";
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date1 = dateFormat1.parse(dateInString1);
        } catch (ParseException ex) {
            Logger.getLogger(Terrain.class.getName()).log(Level.SEVERE, null, ex);
        }

        String dateLot1 = df.format(new Date());
        lot.accumulate("date_mesure", dateLot1);
        lotissements.add(lot);
        lot.clear();

        String dateInString2 = "19-10-2013";
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date2 = dateFormat2.parse(dateInString2);
        } catch (ParseException ex) {
            Logger.getLogger(Terrain.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dateLot2 = df.format(new Date());
        lot.accumulate("description", "lot 2");
        lot.accumulate("nombre_droits_passage", 0);
        lot.accumulate("nombre_services", 1);
        lot.accumulate("superficie", 1082);
        
        //Formatter la date en ISO 8601
        
        lot.accumulate("date_mesure", dateLot2);
        lotissements.add(lot);
        lot.clear();

        String dateInString3 = "01-04-2009";
        SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date3 = dateFormat3.parse(dateInString2);
        } catch (ParseException ex) {
            Logger.getLogger(Terrain.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dateLot3 = df.format(new Date());
        lot.accumulate("description", "lot 3");
        lot.accumulate("nombre_droits_passage", 8);
        lot.accumulate("nombre_services", 3);
        lot.accumulate("superficie", 3333);
        
        //Formatter la date en ISO 8601
        
        lot.accumulate("date_mesure", dateLot3);
        lotissements.add(lot);
        lot.clear();

        expResult.accumulate("lotissements", lotissements);

        JSONObject result = Terrain.creerTerrain();
        assertEquals(expResult, result);

    }

}
