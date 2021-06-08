package com.example.test.service;

import com.example.test.model.Weather;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

public class JParseImpl implements JParse{

    @Override
    public Weather jParse(String json) {

        Weather weather = new Weather();
        JSONParser parser = new JSONParser();

        try{
            JSONObject pageJsonObject = (JSONObject) parser.parse(json);

            JSONObject test2 = (JSONObject) pageJsonObject.get("wind");
            weather.setWindSpeed(test2.get("speed").toString());

            JSONObject test3 = (JSONObject) pageJsonObject.get("main");
            JSONObject test4 = (JSONObject) pageJsonObject.get("sys");

            weather.setTemperature(test3.get("temp").toString());
            weather.setTemperatureMax(test3.get("temp_max").toString());
            weather.setTemperatureMin(test3.get("temp_min").toString());
            weather.setPressure(test3.get("pressure").toString());
            weather.setCountry(test4.get("country").toString());
            weather.setNameCity(pageJsonObject.get("name").toString());

            return weather;

        }catch(Exception e){
            System.out.println("Parsing error" + e.toString());

        }
        return null;
    }
}
