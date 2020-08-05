
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
     
     public static void verifierNombreservices(JSONObject terrain ,  String filePath) throws IOException{
     
         JSONArray lotissements = Utilitaire.recupererLotissement(terrain);
         JSONObject lot;
         double nbreService;
         String description, message = null;
         boolean estNonConforme = false;
         int i =0;
         while (estNonConforme == false && i<lotissements.size()) {             
             lot = Utilitaire.obtenirLot(lotissements, i);
             nbreService = lot.getDouble("nombre_services");
             description = lot.getString("description");
              if( nbreService > 5){
                message = "message : Le nombre de services du "+description+" est supérieur à 5 !"; 
                estNonConforme = true;
                
             }
             else if (nbreService < 0){
                message = "message : Le nombre de services du "+description+" est négatif !";
                estNonConforme = true;
                 
             }
              else if(nbreService != (int) nbreService){
                message = "message : Le nombre de service du "+description+" doit etre un nombre entier !";
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
     
     
     public static void verifierNbreLot(JSONObject terrain , String filePath) throws IOException{
     
         boolean estNonConforme = false;
         JSONArray lotissements = Utilitaire.recupererLotissement(terrain);
         String message = null;
         if(lotissements.isEmpty()){
             message = "Le terrain ne contient aucun lot, un terrain doit avoir au moins un lot !";
             estNonConforme = true;        
         }
         else if(lotissements.size() > 10){
              message = "Le terrain contient "+lotissements.size()+" lots, un terrain doit avoir au maximum 10 lots !";
              estNonConforme = true; 
         }
         
         JSONObject erreur = new JSONObject();
         if(estNonConforme == true){
         erreur.accumulate("message", message);
         Utilitaire.saveJsonIntoFile(erreur.toString(), filePath);
         System.exit(0);
      }   
     }
     
     
    public static void verifierPrixNegatif(JSONObject terrain , String filePath) throws IOException{
        String signPrixMin = terrain.getString("prix_m2_min").substring(0, 1);
        String signPrixMax = terrain.getString("prix_m2_max").substring(0, 1);
        String message = null;
        boolean estNonConforme = false;
         
        if(signPrixMax.equals("-")){
                message = "Le prix max ne peut pas être négatif !";
                estNonConforme = true;
        }
        if(signPrixMin.equals("-")){
                message = "Le prix min ne peut pas être négatif !";
                estNonConforme = true;
        }
        JSONObject erreur = new JSONObject();
        if(estNonConforme){
        erreur.accumulate("message", message);
        Utilitaire.saveJsonIntoFile(erreur.toString(), filePath);
        System.exit(0);
    }
    }
     
     
    public static void verifierSuperficie(JSONObject terrain , String filePath) throws IOException{
     
        JSONArray lotissements = Utilitaire.recupererLotissement(terrain);
        JSONObject lot;
        double superficie;
        String description, message = null;
        boolean estNonConforme = false;
        int i = 0;
        while(!estNonConforme && i<lotissements.size()){
           lot = Utilitaire.obtenirLot(lotissements, i);
           superficie = lot.getDouble("superficie");
           description = lot.getString("description"); 
           if( superficie < 0){
               message = "La superficie du "+description+" est négative !";
               estNonConforme = true; 
            }
            else if (superficie > 50000){
               message = "La superficie du "+description+" est supérieure à 50000 m2 !";
               estNonConforme = true;                 
            }
        i++;
        }
        
        JSONObject erreur = new JSONObject();
        if(estNonConforme){
        erreur.accumulate("message", message);
        Utilitaire.saveJsonIntoFile(erreur.toString(), filePath);
        System.exit(0);
    }
}
     
     public static void verifierTypeTerrain(JSONObject terrain , String filePath) throws IOException{
          
        int typeTerrain = terrain.getInt("type_terrain");
        String message; 
        if(!(typeTerrain == 0 || typeTerrain == 1 || typeTerrain == 2)){
            message = "message : le type de terrain doit prendre la valeur 0, 1 ou 2 !";
            JSONObject erreur = new JSONObject();
            erreur.accumulate("message", message);
            Utilitaire.saveJsonIntoFile(erreur.toString(), filePath);
            System.exit(0);
           }  
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
     
     public static void verifierSiDescriptionEstNull(JSONObject terrain , String filePath) throws IOException{
     
        JSONArray lotissement = Utilitaire.recupererLotissement(terrain);
        JSONObject lot;
        boolean isNull = false;
        String description, message = "";
        int i = 0;
        while(isNull == false && i < lotissement.size()){
            lot = Utilitaire.obtenirLot(lotissement, i);
            description = lot.getString("description");
            if(description.equals("")){
                isNull = true;
                message = "la description du lot "+(i+1)+" est vide !";
            }
            i++;
        } 
         System.out.println(" la description du lot est vide ! "); 
        
        JSONObject erreur = new JSONObject();
        if (isNull){
            erreur.accumulate("message", message);
            Utilitaire.saveJsonIntoFile(erreur.toString(), filePath);
            System.exit(0);
        }
     }
     
     public static void verifierSiDescriptionEstUnique(JSONObject terrain , String filePath) throws IOException{
     
        JSONArray lotissement = Utilitaire.recupererLotissement(terrain);
        JSONObject lot;
        boolean isUnique = false;
        String description1, description2, message = "";
        int i = 0, j; 
        while(isUnique == false && i < lotissement.size()){
            lot = Utilitaire.obtenirLot(lotissement, i);
            description1 = lot.getString("description");
            
            j = i+1;
            while(isUnique == false && j < lotissement.size()){
                lot = Utilitaire.obtenirLot(lotissement, j);
                description2 = lot.getString("description");
                
                if(description2.equals(description1)){
                    isUnique = true;
                    message = "La description '"+description2+"' du lot "+(j+1)+" doit etre unique !";
                    break;
                                   }
                j++;
            }
            i++;
        } 
        System.out.println(" La description doit etre unique ! ");
        
        JSONObject erreur = new JSONObject();
        if (isUnique){
            erreur.accumulate("message", message);
            Utilitaire.saveJsonIntoFile(erreur.toString(), filePath);
            System.exit(0);
        }
     }
}
