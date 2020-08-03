/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsessionteam2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author admin
 */
public class Exigences {

    // methode pour formater les cles, elle est eclatee en 3 methodes
    public static JSONObject formaterVariables(JSONObject jsonObject1) {

        JSONObject jsonObject2 = new JSONObject();
        Iterator iterator = jsonObject1.keys();

        while (iterator.hasNext()) {
            String jsonKey = (String) iterator.next();

            if (jsonObject1.get(jsonKey) instanceof JSONArray) {

                // fait appel a la methode pour formater un JSONArray
              jsonObject2 = formaterVariableArray(jsonObject1, jsonObject2, jsonKey);

            } else {
                Object valueObject = jsonObject1.get(jsonKey);

                jsonKey = jsonKey.toLowerCase().replaceAll(" ", "");

                jsonObject2.accumulate(jsonKey, valueObject);

            }

        }
        return jsonObject2;

    }

    // formater un JSONArray
    public static JSONObject formaterVariableArray(JSONObject jsonObject1,
            JSONObject jsonObject2, String jsonKey) {

        JSONArray arr = new JSONArray();
        JSONArray arr2 = new JSONArray();
        arr = jsonObject1.getJSONArray(jsonKey);

        //faire appel a une methode qui fait le traitement d'un jsonArray
        arr2 = bouclerSurJsonArray(arr, arr2);

        jsonKey = jsonKey.toLowerCase().replaceAll(" ", "");

        return jsonObject2.accumulate(jsonKey, arr2);

    }

    // methode pour faire le traitement d'un jsonArray a travers deux boucles
    public static JSONArray bouclerSurJsonArray(JSONArray arr1, JSONArray arr2) {
        for (int i = 0; i < arr1.size(); i++) {
            JSONObject jsonObject3 = new JSONObject();
            JSONObject jsonObject4 = new JSONObject();
            jsonObject3 = arr1.getJSONObject(i);
            Iterator it2 = jsonObject3.keys();
            while (it2.hasNext()) {
                String jsonKey2 = (String) it2.next();
                Object val1 = new Object();
                val1 = jsonObject3.get(jsonKey2);
                jsonKey2 = jsonKey2.toLowerCase().replaceAll(" ", "");

                jsonObject4.accumulate(jsonKey2, val1);

            }
            arr2.add(jsonObject4);
        }

        return arr2;
    }

    // methode pour formater les montants en faisant appel a la locale
    public static double formaterMontant(String valeur) {

        NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
        double resultat = 0;
        try {
            resultat = nf.parse(valeur).doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(Exigences.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultat;

    }
}
