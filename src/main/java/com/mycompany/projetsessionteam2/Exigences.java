/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsessionteam2;

import java.util.Iterator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author admin
 */
public class Exigences {

    public static JSONObject formaterVariables(JSONObject jsonObject1) {

        JSONObject jsonObject2 = new JSONObject();
        Iterator iterator = jsonObject1.keys();

        while (iterator.hasNext()) {
            String jsonKey = (String) iterator.next();

            if (jsonObject1.get(jsonKey) instanceof JSONArray) {

             jsonObject2 = formaterVariableArray(jsonObject1,jsonObject2, jsonKey);

            } else {
                Object valueObject = jsonObject1.get(jsonKey);

                jsonKey = jsonKey.toLowerCase().replaceAll(" ", "");

                jsonObject2.accumulate(jsonKey, valueObject);

            }

        }
        return jsonObject2;

    }

    
    public static JSONObject formaterVariableArray(JSONObject jsonObject1,
            JSONObject jsonObject2, String jsonKey)
    {
            
                JSONArray arr = new JSONArray();
                JSONArray arr2 = new JSONArray();
                arr = jsonObject1.getJSONArray(jsonKey);

                for (int i = 0; i < arr.size(); i++) {
                    JSONObject jsonObject3 = new JSONObject();
                    JSONObject jsonObject4 = new JSONObject();
                    jsonObject3 = arr.getJSONObject(i);
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
                jsonKey = jsonKey.toLowerCase().replaceAll(" ", "");

               return jsonObject2.accumulate(jsonKey, arr2);
    
    }
}
