/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsessionteam2;

import java.util.Date;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author RB
 */
public class Terrain {

    public static JSONObject creerTerrain() {
        
        JSONObject monTerrain = new JSONObject();
        monTerrain.accumulate("type_terrain", 2);
        monTerrain.accumulate("prix_m2_min", "3.45 $");
        monTerrain.accumulate("prix_m2_max", "7.00 $");
        JSONArray lotissements = new JSONArray();
        JSONObject lot = new JSONObject(); 
        
        lot.accumulate("description","lot 1");
        lot.accumulate("nombre_droits_passage",4);
        lot.accumulate("nombre_services",0);
        lot.accumulate("superficie",465);
        //Formatter la date en ISO 8601
        lot.accumulate("date_mesure",new Date());
        lotissements.add(lot);
        lot.clear();
                
        lot.accumulate("description","lot 2");
        lot.accumulate("nombre_droits_passage",0);
        lot.accumulate("nombre_services",1);
        lot.accumulate("superficie",1082);
        //Formatter la date en ISO 8601
        lot.accumulate("date_mesure",new Date());
        lotissements.add(lot);
        lot.clear();   
        
        lot.accumulate("description","lot 3");
        lot.accumulate("nombre_droits_passage",8);
        lot.accumulate("nombre_services",3);
        lot.accumulate("superficie",3333);
        //Formatter la date en ISO 8601
        lot.accumulate("date_mesure",new Date());
        lotissements.add(lot);
        lot.clear();  
        
        monTerrain.accumulate("lotissements", lotissements);
        
        return monTerrain;
        
    }
    
    
    
}
