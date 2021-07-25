package com.example.test.service;

import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

public class WeatherAPI {

    private static String apiKey = "9cc8200c0952f91f777998004aecbcf6";

    public static String getCity(String name) {
        try {
            RestTemplate template = new RestTemplate();
            String weather = template.getForObject("https://api.openweathermap.org/data/2.5/weather?q="+ name +"&units=metric&lang=en&appid=" + apiKey, String.class);
            return weather;
        } catch (HttpStatusCodeException e) {
            return e.getResponseBodyAsString();
        }
    }
}
