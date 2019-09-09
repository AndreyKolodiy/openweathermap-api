package com.openweather.api.requesters;

import com.openweather.api.requesters.HourlyForecastRequester;

public class OpenWeatherMapManager {

    private String authToken;

    public OpenWeatherMapManager(String token) {
        this.authToken = token;
    }

    public HourlyForecastRequester getHourlyForecastRequester() {
        return new HourlyForecastRequester(authToken);
    }

}
