package com.example.test.service;

import com.example.test.model.Weather;
import com.example.test.repositories.CityRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Log4j
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public void save(Weather weather) {
        log.info("IN CityServiceImpl save() " + weather);
        cityRepository.save(weather);
    }

    @Override
    public List<Weather> findAll() {
        log.info("IN CityServiceImpl findAll() ");
        return cityRepository.findAll();
    }

    @Override
    public Weather getById(Long id) {
        log.info("IN CityServiceImpl getById() " + id);
        return cityRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        log.info("IN CityServiceImpl delete() " + id);
        cityRepository.deleteById(id);
    }
}
