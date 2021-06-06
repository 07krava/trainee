package com.example.test.service;

import com.example.test.model.Weather;
import net.minidev.json.JSONObject;

// Вот такой парсер я написал
public class JParseImpl implements JParse{

    @Override
    public Weather jParse(Object json) {
        Weather weather = new Weather();

        try{
            JSONObject pageJsonObject = new JSONObject((JSONObject)json);

            JSONObject test2 = (JSONObject) pageJsonObject.get("wind");
            weather.setWindSpeed(test2.get("speed").toString());

            JSONObject test3 = (JSONObject) pageJsonObject.get("main");
            weather.setTemperature(test3.get("temp").toString());
            weather.setTemperatureMax(test3.get("temp_max").toString());
            weather.setTemperatureMin(test3.get("temp_min").toString());
            weather.setPressure(test3.get("pressure").toString());

            return weather;

        }catch(Exception e){
            System.out.println("Parsing error" + e.toString());
        }
        //этот ретурн нужно переместить с катч, но пока так
        return null;
    }
}
