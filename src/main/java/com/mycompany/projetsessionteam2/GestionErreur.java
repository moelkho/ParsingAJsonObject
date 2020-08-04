
package com.mycompany.projetsessionteam2;

import java.io.File;
import java.io.IOException;
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
     
//     public static void verifierNombreDroitsPassage(JSONObject terrain , String filePath) throws IOException{
//     
//         JSONArray lotissements = Utilitaire.recupererLotissement(terrain);
//         JSONObject lot;
//         double nbreDroitsPassage;
//         String description;
//         for(int i = 0 ; i < lotissements.size() ; i++){
//             lot = Utilitaire.obtenirLot(lotissements, i);
//             nbreDroitsPassage = lot.getDouble("nombre_droits_passage");
//             description = lot.getString("description");
//             JSONObject erreur = new JSONObject();
//             if( nbreDroitsPassage > 10){
//                 erreur.accumulate("message", "Le nombre de droits de passage du "+description+" est supérieur à 10 !");
//                 Utilitaire.saveJsonIntoFile(erreur.toString(), filePath);
//                 System.out.println("message : Le nombre de droits de passage du "+description+" est supérieur à 10 !");
//                 System.exit(0);
//             }
//             else if (nbreDroitsPassage < 0){
//                 System.out.println("message : Le nombre de droits de passage du "+description+" est négatif !");
//                 System.exit(0);
//             }
//             else if(nbreDroitsPassage != (int) nbreDroitsPassage){
//                 System.out.println("message : Le nombre de droits de passage du "+description+" doit etre un nombre entier !");
//                 System.exit(0);
//             }
//            
//         }
//    
//     }
     
     public static void verifierNombreDroitsPassage(JSONObject terrain , String filePath) throws IOException{
     
         boolean estNonConforme = false;
         String message = null;
         JSONArray lotissements = Utilitaire.recupererLotissement(terrain);
         JSONObject lot;
         double nbreDroitsPassage;
         String description;
         int i = 0;
         
         while(estNonConforme == false && i < lotissements.size()){
            lot = Utilitaire.obtenirLot(lotissements, i);
            nbreDroitsPassage = lot.getDouble("nombre_droits_passage");
            description = lot.getString("description");
             if( nbreDroitsPassage > 10){
                message = "Le nombre de droits de passage du "+description+" est supérieur à 10 !";
                estNonConforme = true;
             }
             else if(nbreDroitsPassage < 0){
                message = "Le nombre de droits de passage du "+description+" est négatif !";
                estNonConforme = true;
             }
             else if(nbreDroitsPassage != (int) nbreDroitsPassage){
                message = "Le nombre de droits de passage du "+description+" doit etre un nombre entier !";
                estNonConforme = true;
             }
             i++; 
         }
         JSONObject erreur = new JSONObject();
         if(estNonConforme == true){
         erreur.accumulate("message", message);
         Utilitaire.saveJsonIntoFile(erreur.toString(), filePath);
         System.exit(0);
         }
         
     }
     
     public static void verifierNombreservices(JSONObject terrain){
     
         JSONArray lotissements = Utilitaire.recupererLotissement(terrain);
         JSONObject lot;
         double nbreService;
         String description;
         for(int i = 0 ; i < lotissements.size() ; i++){
             lot = Utilitaire.obtenirLot(lotissements, i);
             nbreService = lot.getDouble("nombre_services");
             description = lot.getString("description");
             if( nbreService > 5){
                 System.out.println("message : Le nombre de services du "+description+" est supérieur à 5 !");
                 System.exit(0);
             }
             else if (nbreService < 0){
                 System.out.println("message : Le nombre de services du "+description+" est négatif !");
                 System.exit(0);
             }
              else if(nbreService != (int) nbreService){
                 System.out.println("message : Le nombre de service du "+description+" doit etre un nombre entier !");
                 System.exit(0);
             }
         }
     }
     
     
     public static void verifierNbreLot(JSONObject terrain){
     
         JSONArray lotissements = Utilitaire.recupererLotissement(terrain);
 
         if(lotissements.size() == 0)
         {
             System.out.println("message : Le terrain ne contient aucun lot, un terrain doit avoir au moins un lot !");
             System.exit(0);         
         }
         else if(lotissements.size() > 10){
             System.out.println("message : Le terrain contient "+lotissements.size()+" lots, un terrain doit avoir au maximum 10 lots !");
             System.exit(0);     
         }
     }
     
     
     public static void  verifierPrixNegatif(JSONObject terrain){
         String signPrixMin = terrain.getString("prix_m2_min").substring(0, 1);
         String signPrixMax = terrain.getString("prix_m2_max").substring(0, 1);
        
        if(signPrixMax.equals("-"))
            {
                System.out.println("Le prix max ne peut pas être négatif !");
                System.exit(0);         
            }
        if(signPrixMin.equals("-"))
            {
                System.out.println("Le prix min ne peut pas être négatif !");
                System.exit(0);         
            }

         
    }
     
     
     public static void verifierSuperficieNegative(JSONObject terrain){
     
         JSONArray lotissements = Utilitaire.recupererLotissement(terrain);
         JSONObject lot;
         double superficie;
         String description;
         for(int i = 0 ; i < lotissements.size() ; i++){
             lot = Utilitaire.obtenirLot(lotissements, i);
             superficie = lot.getDouble("superficie");
             description = lot.getString("description");
             
             if( superficie < 0){
                 System.out.println("message : La superficie du "+description+" est négative !");
                 System.exit(0);
             }
             else if (superficie > 50000){
                 System.out.println("message: La superficie du "+description+" est supérieure à 50000 m2 !");
                 System.exit(0);
                 
             }
         }
     }
     
     public static void verifierTypeTerrain(JSONObject terrain ){
          
        int typeTerrain = terrain.getInt("type_terrain");
         
         if(!(typeTerrain == 0 || typeTerrain == 1 || typeTerrain == 2)){
                 System.out.println("message : le type de terrain doit prendre la valeur 0, 1 ou 2 !");
                 System.exit(0);}
           
     }
     
     public static void verifierExistanceCleJson(JSONObject terrain , String filePath) throws IOException {
     
        boolean isMissingKey = false;
        String message = null;
        if(!(terrain.has("type_terrain"))){
            isMissingKey = true;
            message = "La propriété 'type_terrain' est manquante dans le fichier d'entrée !";
        }
        if(!(terrain.has("prix_m2_min"))){
            isMissingKey = true;
            message = "La propriété 'prix_m2_min' est manquante dans le fichier d'entrée !";
        }
        if(!(terrain.has("prix_m2_max"))){
            isMissingKey = true;
            message = "La propriété 'prix_m2_max' est manquante dans le fichier d'entrée !";
        }
        if(!(terrain.has("lotissements"))){
            isMissingKey = true;
            message = "La propriété 'lotissements' est manquante dans le fichier d'entrée !";
        }
        
        JSONArray lotissements = Utilitaire.recupererLotissement(terrain);
        JSONObject lot;
        int i = 0;
        if(isMissingKey == false){
            while(isMissingKey == false && i < lotissements.size()){
        
                lot = Utilitaire.obtenirLot(lotissements, i);

                if(!(lot.has("description"))){
                    isMissingKey = true;
                    message = "La propriété 'description' du lot "+(i+1)+" est manquante dans le fichier d'entrée !";
                    break;
                }
                if(!(lot.has("nombre_droits_passage"))){
                    isMissingKey = true;
                    message = "La propriété 'nombre_droits_passage' du lot "+(i+1)+" est manquante dans le fichier d'entrée !";
                    break;
                }
                if(!(lot.has("nombre_services"))){
                    isMissingKey = true;
                    message = "La propriété 'nombre_services' du lot "+(i+1)+" est manquante dans le fichier d'entrée !";
                    break;
                }
                if(!(lot.has("superficie"))){
                    isMissingKey = true;
                    message = "La propriété 'superficie' du lot "+(i+1)+" est manquante dans le fichier d'entrée !";
                    break;
                }
                if(!(lot.has("date_mesure"))){
                    isMissingKey = true;
                    message = "La propriété 'date_mesure' du lot "+(i+1)+" est manquante dans le fichier d'entrée !";
                    break;
                }
                i++;
        }
        }
       
        JSONObject erreur = new JSONObject();
        if(isMissingKey == true){
            erreur.accumulate("message", message);
            Utilitaire.saveJsonIntoFile(erreur.toString(), filePath);
            System.exit(0);
        }
       
     }
     
    
}
