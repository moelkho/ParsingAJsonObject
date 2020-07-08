/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetsessionteam2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author RB
 */
public class Terrain {

    public static JSONObject creerTerrain() throws DateTimeException {

        JSONObject monTerrain = new JSONObject();
        monTerrain.accumulate("type_terrain", 2);
        monTerrain.accumulate("prix_m2_min", "3.45 $");
        monTerrain.accumulate("prix_m2_max", "7.00 $");
        JSONArray lotissements = new JSONArray();
        JSONObject lot = new JSONObject();

        lot.accumulate("description", "lot 1");
        lot.accumulate("nombre_droits_passage", 4);
        lot.accumulate("nombre_services", 0);
        lot.accumulate("superficie", 465);

        LocalDate date1 = LocalDate.of(2000, Month.MARCH, 12);

        lot.accumulate("date_mesure", date1.getYear() + "-" + date1.getMonthValue()
                + "-" + date1.getDayOfMonth());
        lotissements.add(lot);
        lot.clear();

        LocalDate date2 = LocalDate.of(2010, Month.MAY, 21);

        lot.accumulate("description", "lot 2");
        lot.accumulate("nombre_droits_passage", 0);
        lot.accumulate("nombre_services", 1);
        lot.accumulate("superficie", 1082);
        lot.accumulate("date_mesure", date2.getYear() + "-" + date2.getMonthValue()
                + "-" + date2.getDayOfMonth());
        lotissements.add(lot);
        lot.clear();

        LocalDate date3 = LocalDate.of(2013, Month.JANUARY, 05);

        lot.accumulate("description", "lot 3");
        lot.accumulate("nombre_droits_passage", 8);
        lot.accumulate("nombre_services", 3);
        lot.accumulate("superficie", 3333);
        lot.accumulate("date_mesure", date3.getYear() + "-" + date3.getMonthValue()
                + "-" + date3.getDayOfMonth());
        lotissements.add(lot);
        lot.clear();

        monTerrain.accumulate("lotissements", lotissements);

        return monTerrain;

    }

}
