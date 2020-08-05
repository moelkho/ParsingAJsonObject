package com.mycompany.projetsessionteam2;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AppCtr {

    public static void main(String[] args) throws ParseException {

       
        String json = null;

        json = Utilitaire.loadJsonIntoString("json/" + args[0] , "json/" + args[1]);

        JSONObject jsonObjectNonFormated = Utilitaire.creerJsonObject(json);

        JSONObject terrain = Exigences.formaterVariables(jsonObjectNonFormated);

        try {
            GestionErreur.verifierTypeTerrain(terrain , "json/" + args[1]);
            GestionErreur.verifierPrixNegatif(terrain , "json/" + args[1]);
            GestionErreur.verifierNbreLot(terrain ,"json/" + args[1]);
            GestionErreur.verifierExistanceCleJson(terrain, "json/" + args[1]);
            GestionErreur.verifierSiDescriptionEstNull(terrain, "json/" + args[1]);
            GestionErreur.verifierSiDescriptionEstUnique(terrain, "json/" + args[1]);
            GestionErreur.verifierNombreDroitsPassage(terrain, "json/" + args[1]);
            GestionErreur.verifierNombreservices(terrain , "json/" + args[1]);
            GestionErreur.verifierSuperficie(terrain , "json/" + args[1]);
            GestionErreur.verifierFormatDates(terrain, "json/" + args[1]);
        } catch (IOException ex) {
            Logger.getLogger(AppCtr.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        int typeTerrain = Utilitaire.obtenirTypeTerrain(terrain);
        System.out.println(typeTerrain);
        double prixMin = Utilitaire.obtenirPrixMin(terrain);
        double prixMax = Utilitaire.obtenirPrixMax(terrain);

        JSONArray lotissement = Utilitaire.recupererLotissement(terrain);
        
        
        
        double valFonciereParLot, valFociereTerrainInitial = 0, valeurParLot, montantDroitsPassage, montantServices;
        JSONArray lotissementSortie = new JSONArray();

        for (int i = 0; i < lotissement.size(); i++) {

            JSONObject lot = Utilitaire.obtenirLot(lotissement, i);
            valeurParLot = Utilitaire.calculerMontantValeurParLot(typeTerrain, lot, prixMin, prixMax);
            montantDroitsPassage = Utilitaire.calculerMontantDroitsPassage(typeTerrain, valeurParLot, lot);
            montantServices = Utilitaire.calculerMontantServices(typeTerrain, lot);
            valFonciereParLot = Utilitaire.calculerValeurFonciereParLot(valeurParLot, montantDroitsPassage, montantServices);
            valFociereTerrainInitial = Utilitaire.cumulerValFinanciereParLot(valFonciereParLot, valFociereTerrainInitial);
            JSONObject lotSortie = Utilitaire.creerLotSortie(lot, valFonciereParLot);
            Utilitaire.ajouterLotSortieAuLotissementSortie(lotSortie, lotissementSortie);
        }

        double valFociereFinalTerrain = Utilitaire.calculerValFonciereFinal(valFociereTerrainInitial);
        System.out.println(valFociereFinalTerrain);
        double taxeScolaire = Utilitaire.calculerTaxeScolaire(valFociereFinalTerrain);
        System.out.println(taxeScolaire);
        double taxeMunicipale = Utilitaire.calculerTaxeMunicipale(valFociereFinalTerrain);
        System.out.println(taxeMunicipale);

        JSONObject sortie;
        sortie = Utilitaire.creerJsonObjectDeSortie(lotissementSortie, valFociereFinalTerrain, taxeScolaire, taxeMunicipale);
        
        System.out.println(sortie);
        try {
            File file = Utilitaire.saveJsonIntoFile(sortie.toString(), "json/" + args[1]);
            System.out.println(file);

//            //Tester la creation du fichier de sortie
//            file.delete();
//            GestionErreur.verifierCreationFichierSortie(file);
        } catch (IOException e2) {
            System.out.println("Le fichier de sortie '" + args[1] + "' n'a pas été crée");
            System.exit(0);
        }
               
        double i = -2.02;
        String j =Utilitaire.roundTo5(i, 0.05);
        System.out.println(j);
       
        
    }
}
