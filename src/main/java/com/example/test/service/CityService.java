package com.example.test.service;

import com.example.test.model.Weather;

import java.util.List;

public interface CityService {

    void save(Weather weather);

    List<Weather> findAll();

    Weather getById(Long id);

    void delete(Long id);
}
