package com.example.WeatherNow.adapter;

import com.example.WeatherNow.domain.WeatherData;
import com.example.WeatherNow.exception.WeatherDataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherMapAdapter {

    @Autowired
    private RestTemplate restTemplate;

    private static final String WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather";

    public WeatherData getWeatherData(String city, String units) {
        try {
            String apiKey = "60d1a3d8def99847f95ab35b1e7c23b9";
            String url = WEATHER_API_URL + "?q=" + city + "&appid=" + apiKey + "&units=" + units;
            ResponseEntity<WeatherData> response = restTemplate.getForEntity(url, WeatherData.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                throw new WeatherDataNotFoundException("Weather data not found");
            }
        } catch (HttpClientErrorException.BadRequest ex) {
            throw new WeatherDataNotFoundException(ex.getMessage());
        }
    }

}
