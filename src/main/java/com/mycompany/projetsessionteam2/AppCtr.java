package com.mycompany.projetsessionteam2;

import java.io.IOException;
import net.sf.json.JSONObject;

public class AppCtr {

    public static void main(String[] args) throws IOException {
      
        String json = Utilitaire.loadJsonIntoString("jsonFiles/entree.json");
        
        JSONObject terrain  = JSONObject.fromObject(json);
        
        JSONObject sortie = Utilitaire.retournerSortie(terrain);
       
        System.out.println(sortie);
        Utilitaire.saveJsonIntoFile(sortie.toString(), "jsonFiles/sortie5.json");
   
    }  
}
