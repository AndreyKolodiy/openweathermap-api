package com.openweather.api.model;

public interface OpenWeatherResponse {

    String getCityName();
    long getCityId();
    String getCountry();
    Coordinates getCoordinates();
    short getResponseCode();
}
