package com.example.test.repositories;

import com.example.test.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CityRepository extends JpaRepository<Weather, Long> {

}
