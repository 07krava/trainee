package com.example.test.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceJob {

    // тут я пытался создать сервис который мы обговаривали по телефону

    public String getCityAPI(String nameCity){
        String response = WeatherAPI.getCity(nameCity);
        return response;
    }
}
