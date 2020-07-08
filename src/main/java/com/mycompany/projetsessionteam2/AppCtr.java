package com.mycompany.projetsessionteam2;

import java.io.IOException;
import java.text.ParseException;
import net.sf.json.JSONObject;

public class AppCtr {

    public static void main(String[] args) throws IOException, ParseException {
      
       //Construire le JSONObject terrain
        JSONObject monTerrain = Terrain.creerTerrain();
       
        //Creer le fichier d'entree
        Utilitaire.saveJsonIntoFile(monTerrain.toString(), "c:\\temp\\"+args[0]);
        
       //Traitement : creer le JSONObject de sortie
        String json = Utilitaire.loadJsonIntoString("c:\\temp\\"+args[0]);
        JSONObject terrain  = JSONObject.fromObject(json);
        JSONObject sortie = Utilitaire.retournerSortie(terrain);
        
       
        //Creer le fichier de sortie
        Utilitaire.saveJsonIntoFile(sortie.toString(), "c:\\temp\\"+args[1]);
   
    }  
}
