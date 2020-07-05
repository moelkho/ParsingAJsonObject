package com.mycompany.projetsessionteam2;

import java.io.IOException;
import java.text.DecimalFormat;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

public class AppCtr {

    public static void main(String[] args) throws IOException {
      
        String json = Utilitaire.loadJsonIntoString("jsonFiles/test1.json");
       
      
//        
        JSONObject terrain  = JSONObject.fromObject(json);
  
        
        JSONObject sortie = Utilitaire.retournerSortie(terrain);
        System.out.println(sortie);
        
        Utilitaire.saveJsonIntoFile(sortie.toString(0), "jsonFiles/sortie4.json");
        
        
        
    }
    
}
