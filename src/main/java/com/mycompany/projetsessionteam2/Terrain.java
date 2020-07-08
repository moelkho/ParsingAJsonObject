/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author RB
 */
public class Terrain {

    public static JSONObject creerTerrain() throws ParseException  {
        
        JSONObject monTerrain = new JSONObject();
        monTerrain.accumulate("type_terrain", 2);
        monTerrain.accumulate("prix_m2_min", "3.45 $");
        monTerrain.accumulate("prix_m2_max", "7.00 $");
        JSONArray lotissements = new JSONArray();
        JSONObject lot = new JSONObject(); 
        
        TimeZone tz = TimeZone.getTimeZone("GMT-4:00");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); 
        df.setTimeZone(tz);
       
        
        lot.accumulate("description","lot 1");
        lot.accumulate("nombre_droits_passage",4);
        lot.accumulate("nombre_services",0);
        lot.accumulate("superficie",465);
        
        String dateInString1 = "12-05-2000";
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
        
            Date date1 = dateFormat1.parse(dateInString1);
      
        
        String dateLot1 = df.format(new Date());
        lot.accumulate("date_mesure",dateLot1);
        lotissements.add(lot);
        lot.clear();
          
        
        String dateInString2 = "19-10-2013";
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
        
            Date date2 = dateFormat2.parse(dateInString2);
       
        String dateLot2 = df.format(new Date());
        lot.accumulate("description","lot 2");
        lot.accumulate("nombre_droits_passage",0);
        lot.accumulate("nombre_services",1);
        lot.accumulate("superficie",1082);
        //Formatter la date en ISO 8601
        lot.accumulate("date_mesure",dateLot2);
        lotissements.add(lot);
        lot.clear();   
        
        
        String dateInString3 = "01-04-2009";
        SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd-MM-yyyy");
        
            Date date3 = dateFormat3.parse(dateInString2);
      
        String dateLot3 = df.format(new Date());
        lot.accumulate("description","lot 3");
        lot.accumulate("nombre_droits_passage",8);
        lot.accumulate("nombre_services",3);
        lot.accumulate("superficie",3333);
        //Formatter la date en ISO 8601
        lot.accumulate("date_mesure",dateLot3);
        lotissements.add(lot);
        lot.clear();  
        
        monTerrain.accumulate("lotissements", lotissements);
        
        return monTerrain;
        
    }
    
    
    
}
