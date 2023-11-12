package com.example.WeatherNow.exceptions;

public class MyApplicationException extends RuntimeException {
    public MyApplicationException(String message) {
        super(message);
    }
}
