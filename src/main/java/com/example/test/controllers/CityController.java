package com.example.test.controllers;

import com.example.test.model.Weather;
import com.example.test.service.CityService;
import com.example.test.service.JParseImpl;
import com.example.test.service.WeatherAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/{name}")
    public @ResponseBody String getWeather(@PathVariable String name){
        String response = WeatherAPI.getCity(name);
        JParseImpl jParse = new JParseImpl();
        Weather weather = jParse.jParse(response);
        cityService.save(weather);
        return "Погода успешно сохранена в Базу данных";
    }
}
