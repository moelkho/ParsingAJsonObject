package com.mycompany.projetsessionteam2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class Utilitaire {

    public static final double TAUXTAXESCOLAIRE = 0.012;
    public static final double TAUXTAXEMUNICIPALE = 0.025;
    public static final double VALEURDEBASE = 733.77;
    public static final int NBRESERVICEDEBASE = 2;

    public static String loadJsonIntoString(String filePath) 
            throws FileNotFoundException, IOException {

        FileInputStream myInputStream = new FileInputStream(filePath);
        return IOUtils.toString(myInputStream, "UTF-8");

    }

    public static void saveJsonIntoFile(String content, String filePath) 
            throws IOException {

        File file = new File(filePath);
        FileUtils.writeStringToFile(file, content, "UTF-8");
    }

    
    public static JSONObject retournerSortie(JSONObject terrain) {
      
        //Recuperer le type de terrain ainsi que le prixMin et prixMax
        int type_terrain = terrain.getInt("type_terrain");
        String prixMaxStr = terrain.getString("prix_m2_max").substring(0, 4);
        String prixMinStr = terrain.getString("prix_m2_min").substring(0, 4);
        double prixMax = Double.parseDouble(prixMaxStr);
        double prixMin = Double.parseDouble(prixMinStr);
        
        //Declarer les diffrente valeur a calculer pour chaque lot et pour le terrain
        double valeurParLot, montantServices, montantDroitsPassage;
        double valFonciereParLot, valFociereTerrainInitial = 0;
        double valFociereFinalTerrain, taxeScolaire, taxeMunicipale;

        String description;
        
        JSONArray lotissements = terrain.getJSONArray("lotissements");
        JSONObject lot;
        JSONObject sortie = new JSONObject();
        
        JSONArray lotissementSortie = new JSONArray();
        JSONObject lotSortie = new JSONObject();
        
        DecimalFormat df = new DecimalFormat("#.##");

        for (int i = 0; i < lotissements.size(); i++) {

            lot = lotissements.getJSONObject(i);

            description = lot.getString("description");

            valeurParLot = calculerMontantValeurParLot(type_terrain, prixMin, prixMax, lot);
            montantDroitsPassage = calculerMontantDroitsPassage(type_terrain, valeurParLot, lot);
            montantServices = calculerMontantServices(type_terrain, lot);
            
            valFonciereParLot = valeurParLot + montantDroitsPassage + montantServices;
            valFociereTerrainInitial += valFonciereParLot;

            lotSortie.accumulate("description", description);
            lotSortie.accumulate("valeur_par_lot", df.format(valFonciereParLot) + " $");
            lotissementSortie.add(lotSortie);
            lotSortie.clear();
        }
        valFociereFinalTerrain = valFociereTerrainInitial + VALEURDEBASE;
        taxeScolaire = valFociereFinalTerrain * TAUXTAXESCOLAIRE;
        taxeMunicipale = valFociereFinalTerrain * TAUXTAXEMUNICIPALE;

        sortie.accumulate("valeur_fonciere_totale", df.format(valFociereFinalTerrain) + " $");
        sortie.accumulate("taxe_scolaire", df.format(taxeScolaire) + " $");
        sortie.accumulate("taxe_ municipale", df.format(taxeMunicipale) + " $");
        sortie.accumulate("lotissements", lotissementSortie);

        return sortie;
    }

    //Methode qui calcule le montant pour la valeur du lot 
    public static double calculerMontantValeurParLot(int type_terrain,
            double prixMin, double prixMax, JSONObject lot) {

        double valeurParLot = 0, superficie;
        
        superficie = lot.getDouble("superficie");
                
        switch (type_terrain) {
        //traitement terrain agricole
            case 0:
                valeurParLot = superficie * prixMin;
                break;
        //traitement terrain residentiel
            case 1:
                valeurParLot = superficie * (prixMin + prixMax) / 2;
                break;
        //traitement terrain commercial
            case 2:
                valeurParLot = superficie * prixMax;
                break;
            default:
                break;
        }

        return valeurParLot;
    }

    
    //Methode qui calcule le montant pour les droits de passage
    public static double calculerMontantDroitsPassage(int type_terrain, 
            double valeurParLot, JSONObject lot) {

        double montantDroitsPassage = 0;
        int nbreDroitPassage = lot.getInt("nombre_droits_passage");
        
        switch (type_terrain) {
        //traitement terrain agricole
            case 0:
                montantDroitsPassage = 500 - (nbreDroitPassage * .05 * valeurParLot);
                break;
        //traitement terrain residentiel
            case 1:
                montantDroitsPassage = 500 - (nbreDroitPassage * .1 * valeurParLot);
                break;
              //traitement terrain commercial  
            case 2:
                montantDroitsPassage = 500 - (nbreDroitPassage * .15 * valeurParLot);
                break;
            default:
                break;
        }

        return montantDroitsPassage;
    }
    
    
//Methode qui calcule le montant pour les services
    public static double calculerMontantServices(int type_terrain, JSONObject lot) {

        double superficie, montantServices = 0;
        int nbreDeService = (lot.getInt("nombre_services")) + NBRESERVICEDEBASE;
        superficie = lot.getDouble("superficie");

        //traitement terrain residentiel
        if (type_terrain == 1) {
            
            if (superficie > 10000) 
                montantServices = 1000 * nbreDeService;
            else if (superficie > 500) 
                montantServices = 500 * nbreDeService;
        } 
        
        //traitement terrain commercial
        else if (type_terrain == 2) {
            if (superficie <= 500) 
                montantServices = 500 * nbreDeService;
            else 
                montantServices = 1500 * nbreDeService;
            
            //Plafonner le montant pour les services a 5000$
            if (montantServices > 5000) 
                montantServices = 5000;
            
        }

        return montantServices;
    }

}
