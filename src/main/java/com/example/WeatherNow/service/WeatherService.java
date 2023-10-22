package com.example.WeatherNow.service;

import com.example.WeatherNow.adapter.OpenWeatherMapAdapter;
import com.example.WeatherNow.domain.weatherData.Main;
import com.example.WeatherNow.enums.WeatherUnitEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private OpenWeatherMapAdapter openWeatherMapAdapter;
    public Main getWeatherData(String city, String unit) {
        unit = WeatherUnitEnum.getApiUnit(unit);
        return openWeatherMapAdapter.getWeatherData(city, unit).getMain();
    }
}

