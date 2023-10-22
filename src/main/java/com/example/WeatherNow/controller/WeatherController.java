package com.example.WeatherNow.controller;

import com.example.WeatherNow.domain.weatherData.Main;
import com.example.WeatherNow.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current")
    public ResponseEntity<Main> getCurrentWeather(@RequestParam(value = "city") String city, @RequestParam(value = "unit") String unit) {
        return ResponseEntity.ok(weatherService.getWeatherData(city, unit));
    }
}