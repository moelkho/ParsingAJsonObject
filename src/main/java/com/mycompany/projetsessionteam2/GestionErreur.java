
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
         double nbreDroitsPassage;
         String description;
         for(int i = 0 ; i < lotissements.size() ; i++){
             lot = Utilitaire.obtenirLot(lotissements, i);
             nbreDroitsPassage = lot.getDouble("nombre_droits_passage");
             description = lot.getString("description");
             if( nbreDroitsPassage > 10){
                 System.out.println("message : Le nombre de droits de passage du "+description+" est supérieur à 10!");
                 System.exit(0);
             }
             else if (nbreDroitsPassage < 0){
                 System.out.println("message : Le nombre de droits de passage du "+description+" est inférieur à 0!");
                 System.exit(0);
             }
             else if(nbreDroitsPassage != (int) nbreDroitsPassage){
                 System.out.println("message : Le nombre de droits de passage du "+description+" doit etre un nombre entier!");
                 System.exit(0);
             }
            
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
                 System.out.println("message : Le nombre de services du "+description+" est supérieur à 5!");
                 System.exit(0);
             }
             else if (nbreService < 0){
                 System.out.println("message : Le nombre de services du "+description+" est inférieur à 0!");
                 System.exit(0);
             }
              else if(nbreService != (int) nbreService){
                 System.out.println("message : Le nombre de service du "+description+" doit etre un nombre entier!");
                 System.exit(0);
             }
         }
     }
     
     public static void verifierNbreLot(JSONObject terrain){
     
         JSONArray lotissements = Utilitaire.recupererLotissement(terrain);
 
         if(lotissements.size() == 0)
         {
             System.out.println("message : Le terrain ne contient aucun lot, un terrain doit avoir au moins un lot.");
             System.exit(0);         
         }
         else if(lotissements.size() > 10){
             System.out.println("message : Le terrain contient "+lotissements.size()+" lots, un terrain doit avoir au maximum 10 lots.");
             System.exit(0);     
         }
     }
     
     
     public static void  PrixNegatif(JSONObject terrain){
         String prixMin = terrain.getString("prix_m2_min").substring(0, 4);
         double valeurPrixMin = Exigences.formaterMontant(prixMin);
         
         String prixMax = terrain.getString("prix_m2_max").substring(0, 4);
         double valeurPrixMax = Exigences.formaterMontant(prixMax);
         
         
         if(valeurPrixMin < 0 || valeurPrixMax < 0)
         {
             System.out.println("Le montant d'argent ne peut pas être négatif.");
             System.exit(0);         
         }
         
    }
     
     
     public static void verifierSuperficieNegative(JSONObject terrain){
     
         JSONArray lotissements = Utilitaire.recupererLotissement(terrain);
         JSONObject lot;
         int superficie;
         String description;
         for(int i = 0 ; i < lotissements.size() ; i++){
             lot = Utilitaire.obtenirLot(lotissements, i);
             superficie = lot.getInt("superficie");
             description = lot.getString("description");
             
             if( superficie < 0){
                 System.out.println("Erreur: La superficie du "+description+" est négative");
                 System.exit(0);
             }
             else if (superficie > 50000){
                 System.out.println("Erreur: La superficie du "+description+" est supérieure à 50000 m2.");
                 System.exit(0);
                 
             }
         }
     }
}
