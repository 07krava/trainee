package com.example.test.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

public class WeatherAPI {

    private static String apiKey = "9cc8200c0952f91f777998004aecbcf6";

    public static Object getCity(String name) {
        try {
            /*
            Вот следующие 2 о которых я говорил, у меня возвращается обьект:
            ResponseEntity<Object> weather который я пытаюсь распарсить, но он не является JSONObject!
             */
            RestTemplate template = new RestTemplate();
            ResponseEntity<Object> weather = template.getForEntity("https://api.openweathermap.org/data/2.5/weather?q=" + name
                                                                   + "&units=metric&lang=fi&appid=" + apiKey, Object.class);
            return weather;
        } catch (HttpStatusCodeException e) {
            return e.getResponseBodyAsString();
        }
    }
}
