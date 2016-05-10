package com.saurabh.superselectorbackend.util;

import com.fasterxml.jackson.core.JsonParser;
import com.saurabh.superselectorbackend.models.MatchPoints;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;

import javax.json.JsonObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by saurabhkmr on 3/4/16.
 */
public class Utils {

    public static int calculatePoints(MatchPoints matchPoints){
        int points=0;

        try {
            ClassPathResource classPathResource = new ClassPathResource("rules.json");
            InputStream inputStream = classPathResource.getInputStream();
            StringBuilder sb=new StringBuilder();
            String read;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while((read=br.readLine()) != null) {
                sb.append(read);
            }
            JSONObject obj = new JSONObject(sb.toString());
            JSONObject wickets = obj.getJSONObject("wickets");
            JSONObject runs = obj.getJSONObject("runs");
            JSONObject catches = obj.getJSONObject("catches");
            JSONObject stumps = obj.getJSONObject("stumps");
            JSONObject econRate = obj.getJSONObject("econ_rate");
            JSONObject strikeRate = obj.getJSONObject("strike_rate");

            Map<String,Object> wicketsRule=toMap(wickets);
            Map<String,Object> runsRule=toMap(runs);
            Map<String,Object> catchesRule=toMap(catches);
            Map<String,Object> stumpsRule=toMap(stumps);
            Map<String,Object> econRateRule=toMap(econRate);
            Map<String,Object> strikeRateRule=toMap(strikeRate);

            //Wicket Points
            int wicketsInput=matchPoints.getWickets();
            int perWicketPoints= (int) wicketsRule.get("per");
            points+=wicketsInput*perWicketPoints;
            long pointsAwareded;
            switch (wicketsInput){
                case 2: pointsAwareded=(int)wicketsRule.get(">2");
                     points+=pointsAwareded;
                    break;
                case 3: pointsAwareded=(int)wicketsRule.get(">3");
                    points+=pointsAwareded;
                    break;
                case 4: pointsAwareded=(int)wicketsRule.get(">4");
                    points+=pointsAwareded;
                    break;
                default:break;
            }
            if(wicketsInput>4){
                pointsAwareded=(int)wicketsRule.get(">4");
                points+=pointsAwareded;
            }

            //Runs points
            int runsInput=matchPoints.getRuns();
            points+=runsInput*(int)runsRule.get("per");
            if(runsInput>=100){
                pointsAwareded=(int)runsRule.get(">100");
                points+=pointsAwareded;
            }
            else if(runsInput>=75){
                pointsAwareded=(int)runsRule.get(">75");
                points+=pointsAwareded;
            }
            else if(runsInput>=50){
                pointsAwareded=(int)runsRule.get(">50");
                points+=pointsAwareded;
            }
            else if(runsInput>=30){
                pointsAwareded=(int)runsRule.get(">30");
                points+=pointsAwareded;
            }

            //Catches Taken
            int catchesTaken=matchPoints.getCatches();
            points+=catchesTaken*(int)catchesRule.get("per");

            //Stumps
            int stumsDone=matchPoints.getStumps();
            points+=stumsDone*(int)stumpsRule.get("per");

            //econRate
            double econRateInput=matchPoints.getEconRate();
            if(matchPoints.getOvers()>=3 & econRateInput<=4){
                pointsAwareded=(int)econRateRule.get("<4.0");
                points+=pointsAwareded;
            }
            else if(matchPoints.getOvers()>=3 & econRateInput<=5){
                pointsAwareded=(int)econRateRule.get("<5.0");
                points+=pointsAwareded;
            }
            else if(matchPoints.getOvers()>=3 & econRateInput<=6){
                pointsAwareded=(int)econRateRule.get("<6.0");
                points+=pointsAwareded;
            }

            //Strike Rate
            double strikeRateInput=matchPoints.getStrikeRate();
            if(runsInput>=20 & strikeRateInput>150){
                pointsAwareded=(int)strikeRateRule.get(">150");
                points+=pointsAwareded;
            }
            else if(runsInput>=20 & strikeRateInput>125){
                pointsAwareded=(int)strikeRateRule.get(">125");
                points+=pointsAwareded;
            }
            else if(runsInput >=20 & strikeRateInput>100){
                pointsAwareded=(int)strikeRateRule.get(">100");
                points+=pointsAwareded;
            }
        }
        catch (Exception ex){

        }

        return points;
    }

    public static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while(keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }

}
