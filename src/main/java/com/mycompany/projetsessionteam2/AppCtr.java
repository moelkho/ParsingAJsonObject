package com.mycompany.projetsessionteam2;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AppCtr {

    public static void main(String[] args) throws ParseException {
      
            System.out.println("test pour jenkins +++");
        String json = null;
        try{
            json = Utilitaire.loadJsonIntoString("json/"+args[0]);
        }catch(IOException e1){
            System.out.println("Le fichier d'entrée spécifié '"+args[0]+"' est introuvable");
             System.exit(0);
        }
           
            JSONObject jsonObjectNonFormated = Utilitaire.creerJsonObject(json);
           System.out.println(jsonObjectNonFormated.toString());
            
            JSONObject terrain = Exigences.formaterVariables(jsonObjectNonFormated);
            System.out.println(terrain.toString());
            
            GestionErreur.verifierNombreDroitsPassage(terrain);
            GestionErreur.verifierNombreservices(terrain);
            GestionErreur.verifierNbreLot(terrain);
            GestionErreur.PrixNegatif(terrain);
            GestionErreur.verifierSuperficieNegative(terrain);
            
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
            //System.out.println(sortie);
            
            try{
                File file = Utilitaire.saveJsonIntoFile(sortie.toString(), "json/"+args[1]);
                
//            //Tester la creation du fichier de sortie
//            file.delete();
//            GestionErreur.verifierCreationFichierSortie(file);
                
            }catch(IOException e2){
                System.out.println("Le fichier de sortie '"+args[1]+"' n'a pas été crée");
            System.exit(0);
            }
            System.out.println("test jenkins");
    }  
}
