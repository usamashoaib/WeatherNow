package com.example.WeatherNow.validator;

import com.example.WeatherNow.exceptions.MyApplicationException;

public class CommonValidator {
    public static void notNullOrEmpty(String s, String name) {
        if (s == null || s.isEmpty()) {
            throw new MyApplicationException(name + "is required");
        }
    }
}
