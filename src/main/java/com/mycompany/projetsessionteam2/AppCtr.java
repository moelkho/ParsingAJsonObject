package com.mycompany.projetsessionteam2;

import java.io.IOException;
import java.text.DecimalFormat;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;

public class AppCtr {

    public static void main(String[] args) throws IOException {
      
        String json = Utilitaire.loadJsonIntoString("jsonFiles/entree.json");
        
        JSONObject terrain  = JSONObject.fromObject(json);
        
        JSONObject sortie = Utilitaire.retournerSortie(terrain);
        
        Utilitaire.saveJsonIntoFile(sortie.toString(0), "jsonFiles/sortie3.json");
        
        
        
    }
    
}
