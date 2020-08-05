package com.mycompany.projetsessionteam2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.BreakNode;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class Utilitaire {

    public static final double TAUXTAXESCOLAIRE = 0.012;
    public static final double TAUXTAXEMUNICIPALE = 0.025;
    public static final double VALEURDEBASE = 733.77;
    public static final int NBRESERVICEDEBASE = 2;
    public static final double MONTANTDEBASE = 500;
    public static final double TAUXPASSAGEAGRICOLE = .05;
    public static final double TAUXPASSAGECOMMERCIAL = .15;
    public static final double TAUXPASSAGERESIDENTIEL = .1;
    public static final double SUPERFICIEMIN = 500;
    public static final double SUPERFICIEMAX = 10000;
    public static final double MONTANTSERVICE1 = 500;
    public static final double MONTANTSERVICE2 = 1000;
    public static final double MONTANTSERVICE3 = 1500;
    public static final double MONTANTPLAFON = 5000;
    public static final int TERRAINAGRICOLE = 0;
    public static final int TERRAINRESIDENTIEL = 1;
    public static final int TERRAINCOMMERCIAL = 2;
    
    

    public static String loadJsonIntoString(String filePath) throws FileNotFoundException, IOException 
        {
      
        FileInputStream myInputStream = new FileInputStream(filePath);
        return IOUtils.toString(myInputStream, "UTF-8");
    }
    
    
    public static JSONObject creerJsonObject(String json){
        
        JSONObject terrain  = JSONObject.fromObject(json);
        return terrain;
    }

    
    public static int obtenirTypeTerrain(JSONObject terrain){
         int type_terrain = terrain.getInt("type_terrain");
         return type_terrain;
    }
    
    public static double obtenirPrixMin(JSONObject terrain){
         String prixMinStr = terrain.getString("prix_m2_min").substring(0, 4);
         double valeurPrixMin = Exigences.formaterMontant(prixMinStr);
         return valeurPrixMin;
    }
    
    public static double obtenirPrixMax(JSONObject terrain){
        String prixMaxStr = terrain.getString("prix_m2_max").substring(0, 4);
        double ValeurPrixMax = Exigences.formaterMontant(prixMaxStr);
        
         return ValeurPrixMax;
    }
              
    //recuperer le lotissement
    public static JSONArray recupererLotissement(JSONObject terrain){
       return terrain.getJSONArray("lotissements");
    }
    
    //recuperer le lot
    public static JSONObject obtenirLot(JSONArray lotissement , int i){
        return lotissement.getJSONObject(i);
    }
    
    //Calculer la sortie pour un lot
    public static double calculerValeurFonciereParLot(double valeurParLot , 
                double montantDroitsPassage, double montantServices){
        
        double valFonciereParLot =  valeurParLot + montantDroitsPassage + montantServices;
        return valFonciereParLot;
    }
    
    //Cumuler la valeur financiere par lot
    public static double cumulerValFinanciereParLot(double valFonciereParLot , double valFociereTerrainInitial){
        
        valFociereTerrainInitial = valFociereTerrainInitial + valFonciereParLot;
        return valFociereTerrainInitial;
    }
    
    //Creer lot de sortie
    public static JSONObject creerLotSortie(JSONObject lot , double valFonciereParLot) throws ParseException{
        JSONObject lotSortie = new JSONObject();
        String description = lot.getString("description");
        lotSortie.accumulate("description", description);
        lotSortie.accumulate("valeur_par_lot", roundTo5(valFonciereParLot , 0.05) + " $");
        return lotSortie;
    }
    
    
    //Ajouter le lotSortie au lotissement de sortie
    public static void ajouterLotSortieAuLotissementSortie(JSONObject lotSortie , JSONArray lotissementSortie){
        lotissementSortie.add(lotSortie);
        lotSortie.clear();
        
    }
   
    
    public static double calculerValFonciereFinal(double valFociereTerrainInitial){
        
        return valFociereTerrainInitial + VALEURDEBASE ;
    }
    
    public static double calculerTaxeScolaire(double valFociereFinalTerrain){
        return valFociereFinalTerrain * TAUXTAXESCOLAIRE;
    }
    
    public static double calculerTaxeMunicipale(double valFociereFinalTerrain){
        return valFociereFinalTerrain * TAUXTAXEMUNICIPALE;
    }
    
    
    
    //Creer le jsonObject de sortie
    public static JSONObject creerJsonObjectDeSortie(JSONArray lotissementSortie, 
            double valFociereFinalTerrain, double taxeScolaire, double taxeMunicipale) throws ParseException{
        JSONObject sortie = new JSONObject();
        sortie.accumulate("valeur_fonciere_totale", roundTo5(valFociereFinalTerrain , 0.05) + " $");
        
        sortie.accumulate("taxe_scolaire", roundTo5(taxeScolaire , 0.05) + " $");
        sortie.accumulate("taxe_municipale", roundTo5(taxeMunicipale , 0.05) + " $");
        sortie.accumulate("lotissements", lotissementSortie);
        
        return sortie;
    }
    
    //Methode qui calcule le montant pour la valeur du lot 
    public static double calculerMontantValeurParLot(int type_terrain , JSONObject lot, double prixMin, double prixMax) {
        double prix = 0;
             
        switch (type_terrain) {
            case 0:
                prix = prixMin;
                break;
            case 1:
                prix = (prixMin + prixMax) / 2;
                break;
            case 2:
                prix = prixMax;
                break;
            default:
                break;
        }
        return  lot.getDouble("superficie") * prix;
    }

    
    //Methode qui calcule le montant pour les droits de passage
    public static double calculerMontantDroitsPassage(int type_terrain, 
            double valeurParLot, JSONObject lot) {
        double tauxPassage = 0;
       
        int nbreDroitPassage = lot.getInt("nombre_droits_passage");
        
        switch (type_terrain) {
            case 0:
                tauxPassage = TAUXPASSAGEAGRICOLE;
                break;
            case 1:
                tauxPassage = TAUXPASSAGERESIDENTIEL;
                break;
            case 2:
                tauxPassage = TAUXPASSAGECOMMERCIAL;
                break;
            default:
                break;
        }

        return MONTANTDEBASE - (nbreDroitPassage * tauxPassage * valeurParLot);
    }
    
    
//Methode qui calcule le montant pour les services
    public static double calculerMontantServices(int type_terrain, JSONObject lot) {

        double superficie, montantServices = 0;
        int nbreDeService = (lot.getInt("nombre_services")) + NBRESERVICEDEBASE;
        superficie = lot.getDouble("superficie");

        //traitement terrain residentiel
        if (type_terrain == TERRAINRESIDENTIEL) {
            
            if (superficie > SUPERFICIEMAX) 
                montantServices = MONTANTSERVICE2 * nbreDeService;
            else if (superficie > SUPERFICIEMIN) 
                montantServices = MONTANTSERVICE1 * nbreDeService;
        } 
        
        //traitement terrain commercial
        else if (type_terrain == TERRAINCOMMERCIAL) {
            if (superficie <= SUPERFICIEMIN) 
                montantServices = MONTANTSERVICE1 * nbreDeService;
            else 
                montantServices = MONTANTSERVICE3 * nbreDeService;
            
            //Plafonner le montant pour les services a 5000$
            if (montantServices > MONTANTPLAFON) 
                montantServices = MONTANTPLAFON;
            
        }

        return montantServices;
    }

   public static File saveJsonIntoFile(String content, String filePath) 
            throws IOException {

        File file = new File(filePath);
        FileUtils.writeStringToFile(file, content, "UTF-8");
        return file;
    }
   
   
   public static String roundTo5(double i, double v) throws ParseException{
   
   DecimalFormat d = new DecimalFormat("#.00") ;
   String r = d.format(Math.ceil(i/v) * v);
   NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
   double d1 = 0;
       try {
            d1 = nf.parse(r).doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(Utilitaire.class.getName()).log(Level.SEVERE, null, ex);
        }
   String str=d.format(d1);
       
   return str.replaceAll(",", ".") ;
   
}
   

}
