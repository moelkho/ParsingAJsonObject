
package com.mycompany.projetsessionteam2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;


public class Utilitaire {
    
    public static String loadJsonIntoString(String filePath) throws FileNotFoundException, IOException{
        
        FileInputStream myInputStream = new FileInputStream(filePath);
       return IOUtils.toString(myInputStream,"UTF-8");
       
    }
    
    public static void saveJsonIntoFile(String content , String filePath) throws IOException{
    
        File file = new File(filePath);
        FileUtils.writeStringToFile(file, content, "UTF-8");
    }
    
    public static JSONObject retournerSortie(JSONObject terrain){
        int type_terrain = terrain.getInt("type_terrain");
        double prixMax = Double.parseDouble((terrain.get("prix_m2_max")).toString().substring(0,4));
        double prixMin = Double.parseDouble((terrain.get("prix_m2_min")).toString().substring(0,4));
        JSONArray lotissements = terrain.getJSONArray("lotissements");
    
        double valeurParLot=0, valFonciereParLot, montantDroitsPassage=0, montantServices = 0;
        double valFociereTerrainTemp=0, valFociereTerrainFinal=0, taxeScolaire, taxeMunicipale ;
        
        String description;
        
        JSONObject lot;
        JSONObject sortie = new JSONObject();
        JSONArray lotissementSortie = new JSONArray();
        JSONObject lotSortie = new JSONObject();
        
         for(int i = 0 ; i < lotissements.size() ; i++){
        
            lot = lotissements.getJSONObject(i);
            
            description = lot.getString("description");
            //superficie = lot.getDouble("superficie");
           // nbreDroitPassage = lot.getInt("nombre_droits_passage");
            //nbreDeService = (lot.getInt("nombre_services"))+2;
            valeurParLot = calculerMontantValeurParLot(type_terrain, prixMin, prixMax, lot);
            montantDroitsPassage = calculerMontantDroitsPassage(type_terrain, valeurParLot, lot);
            montantServices = calculerMontantServices(type_terrain, lot);
            
            valFonciereParLot = valeurParLot + montantDroitsPassage + montantServices;
            valFociereTerrainTemp +=valFonciereParLot; 
            
             lotSortie.accumulate("description", description);
             lotSortie.accumulate("valeur_par_lot", valFonciereParLot);
             lotissementSortie.add(lotSortie);
             lotSortie.clear(); 
         }
        valFociereTerrainFinal = valFociereTerrainTemp + 733.77;
        taxeScolaire = valFociereTerrainFinal * 0.012;
        taxeMunicipale = valFociereTerrainFinal * 0.025;

        sortie.accumulate("valeur_fonciere_totale", valFociereTerrainFinal);
        sortie.accumulate("taxe_scolaire",taxeScolaire );
        sortie.accumulate("taxe_ municipale", taxeMunicipale);
        sortie.accumulate("lotissements",lotissementSortie);
              
    return sortie;
    }
    
    public static double calculerMontantValeurParLot(int type_terrain , double prixMin, double prixMax , JSONObject lot){
                
        double valeurParLot=0, superficie;
        superficie = lot.getDouble("superficie");
           //DecimalFormat df = new DecimalFormat("#.###");
            
//traitement terrain agricole
            if(type_terrain == 0)
                valeurParLot = superficie * prixMin;
                
//traitement terrain residentiel
            else if (type_terrain == 1) 
                valeurParLot = superficie * (prixMin + prixMax) / 2;
                           
//traitement terrain commercial
            else if (type_terrain == 2) 
                valeurParLot = superficie * prixMax;
                 
        return valeurParLot;
   }
    
    public static double calculerMontantDroitsPassage(int type_terrain , double valeurParLot , JSONObject lot){
         
        double montantDroitsPassage = 0;
        int nbreDroitPassage = lot.getInt("nombre_droits_passage");
                
        if(type_terrain == 0){
                montantDroitsPassage = 500 - (nbreDroitPassage * .05 * valeurParLot) ;
        }
            
//traitement terrain residentiel
        else if (type_terrain == 1) {
                 montantDroitsPassage = 500 - (nbreDroitPassage * .1 * valeurParLot) ;
        }
            
//traitement terrain commercial
        else if (type_terrain == 2) {
                montantDroitsPassage = 500 - (nbreDroitPassage * .15 * valeurParLot) ;
        }
        
      return montantDroitsPassage;
    }
    
    public static double calculerMontantServices(int type_terrain , JSONObject lot){
        
        double superficie, montantServices=0;
        int nbreDeService = (lot.getInt("nombre_services"))+2;
        superficie = lot.getDouble("superficie");
                   
//traitement terrain residentiel
            if (type_terrain == 1) {
                if(superficie > 10000)
                    montantServices = 1000 * nbreDeService;
                else if(superficie > 500)
                    montantServices = 500 * nbreDeService;
            }
            
//traitement terrain commercial
            else if (type_terrain == 2) {
                if(superficie <= 500)
                    montantServices = 500 * nbreDeService;
                else if(superficie > 500)
                    montantServices = 1500 * nbreDeService;
                
                if(montantServices > 5000)
                    montantServices = 5000;
            }
    
        return montantServices;
    }
    
}
