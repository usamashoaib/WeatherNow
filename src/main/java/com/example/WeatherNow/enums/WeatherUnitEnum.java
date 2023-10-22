package com.example.WeatherNow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum WeatherUnitEnum {
    FAHRENHEIT("Fahrenheit", "imperial"),
    CELSIUS("Celsius", "metric");

    private final String inputUnit;
    private final String apiUnit;

    public static WeatherUnitEnum fromInputUnit(String inputUnit) {
        return Stream.of(WeatherUnitEnum.values())
                .filter(unit -> unit.inputUnit.equalsIgnoreCase(inputUnit))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported weather unit: " + inputUnit));
    }

    public static String getApiUnit(String inputUnit) {
        return Stream.of(WeatherUnitEnum.values())
                .filter(unit -> unit.inputUnit.equalsIgnoreCase(inputUnit))
                .findFirst()
                .map(WeatherUnitEnum::getApiUnit) // Maps to the apiUnit of the found unit
                .orElseThrow(() -> new IllegalArgumentException("Unsupported weather unit: " + inputUnit));
    }

}
