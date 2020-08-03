
package com.mycompany.projetsessionteam2;

import java.io.File;
import javax.sound.midi.Soundbank;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author RB
 */
public class GestionErreur {
    
     public static void verifierCreationFichierSortie(File file){
    
    if(!file.exists()){
        System.out.println("Le fichier de sortie n'a pas été crée! ");
        System.exit(0);
    }
   }
     
     public static void verifierNombreDroitsPassage(JSONObject terrain){
     
         JSONArray lotissements = Utilitaire.recupererLotissement(terrain);
         JSONObject lot;
         int nbreDroitsPassage;
         String description;
         for(int i = 0 ; i < lotissements.size() ; i++){
             lot = Utilitaire.obtenirLot(lotissements, i);
             nbreDroitsPassage = lot.getInt("nombre_droits_passage");
             description = lot.getString("description");
             if( nbreDroitsPassage > 10){
                 System.out.println("message : Le nombre de droits de passage du "+description+" est supérieur à 10.");
                 System.exit(0);
             }
             else if (nbreDroitsPassage < 0){
                 System.out.println("message : Le nombre de droits de passage du "+description+" est inférieur à 0.");
                 System.exit(0);
             }
         }
    
     }
     
     
}
