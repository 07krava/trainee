package com.example.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "weather")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String windspeed;

    private String temperature;

    private String temperaturemin;

    private String temperaturemax;
    private String pressure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTemperaturemin() {
        return temperaturemin;
    }

    public void setTemperaturemin(String temperaturemin) {
        this.temperaturemin = temperaturemin;
    }

    public String getTemperaturemax() {
        return temperaturemax;
    }

    public void setTemperaturemax(String temperaturemax) {
        this.temperaturemax = temperaturemax;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", windspeed='" + windspeed + '\'' +
                ", temperature='" + temperature + '\'' +
                ", temperaturemin='" + temperaturemin + '\'' +
                ", temperaturema='" + temperaturemax + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }
}
