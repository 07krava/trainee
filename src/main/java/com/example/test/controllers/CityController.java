package com.example.test.controllers;

import com.example.test.model.Weather;
import com.example.test.service.CityService;
import com.example.test.service.JParseImpl;
import com.example.test.service.WeatherAPI;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/{name}")
    public @ResponseBody Object getWeather(@PathVariable String name){
        Weather weather = new Weather();
        Object response = WeatherAPI.getCity(name);

        //если урать следующие 3 строчки то код работает
        JParseImpl jParse = new JParseImpl();
        jParse.jParse(response);
        cityService.save(weather);

        //этот саут тут для теста, я смотрел что выводит респонс(и он норм выводит весь json вывод)
        System.out.println(response.toString());
        return response;
    }
}
