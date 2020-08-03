package com.mycompany.projetsessionteam2;

import java.io.IOException;
import java.text.ParseException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AppCtr {

    public static void main(String[] args) throws IOException, ParseException {
      
        
        String json = Utilitaire.loadJsonIntoString("json/"+args[0]);
        
           
           
            JSONObject jsonObjectNonFormated = Utilitaire.creerJsonObject(json);
            
            System.out.println(jsonObjectNonFormated);
            
            JSONObject terrain = Exigences.formaterVariables(jsonObjectNonFormated);
            
            System.out.println(terrain);
            
            int typeTerrain = Utilitaire.obtenirTypeTerrain(terrain);
            double prixMin = Utilitaire.obtenirPrixMin(terrain);
            double prixMax = Utilitaire.obtenirPrixMax(terrain);
            
            JSONArray lotissement = Utilitaire.recupererLotissement(terrain);
            
            double valFonciereParLot, valFociereTerrainInitial=0, valeurParLot, montantDroitsPassage, montantServices;
            JSONArray lotissementSortie = new JSONArray();
            
            for (int i = 0; i < lotissement.size(); i++) {
                
                JSONObject lot = Utilitaire.obtenirLot(lotissement , i);
                valeurParLot = Utilitaire.calculerMontantValeurParLot(typeTerrain, lot , prixMin, prixMax );
                
                montantDroitsPassage = Utilitaire.calculerMontantDroitsPassage(typeTerrain, valeurParLot, lot);
               
                montantServices = Utilitaire.calculerMontantServices(typeTerrain, lot);
                
                valFonciereParLot = Utilitaire.calculerValeurFonciereParLot(valeurParLot, montantDroitsPassage, montantServices);
                
                valFociereTerrainInitial = Utilitaire.cumulerValFinanciereParLot(valFonciereParLot , valFociereTerrainInitial);
                
                JSONObject lotSortie = Utilitaire.creerLotSortie(lot , valFonciereParLot);
                Utilitaire.ajouterLotSortieAuLotissementSortie(lotSortie , lotissementSortie);
            }
                                
            double valFociereFinalTerrain = Utilitaire.calculerValFonciereFinal(valFociereTerrainInitial);
            double taxeScolaire = Utilitaire.calculerTaxeScolaire(valFociereFinalTerrain);
            double taxeMunicipale = Utilitaire.calculerTaxeMunicipale(valFociereFinalTerrain);
              
            JSONObject sortie;
            sortie = Utilitaire.creerJsonObjectDeSortie(lotissementSortie, valFociereFinalTerrain, taxeScolaire, taxeMunicipale);
            System.out.println(sortie);
            Utilitaire.saveJsonIntoFile(sortie.toString(), "json/"+args[1]);
        
    }  
}
