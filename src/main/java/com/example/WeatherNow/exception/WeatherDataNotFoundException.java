package com.example.WeatherNow.exception;

public class WeatherDataNotFoundException extends RuntimeException {
    public WeatherDataNotFoundException(String message) {
        super(message);
    }

    public WeatherDataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
