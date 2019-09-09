package com.openweather.api.requesters;

import com.openweather.api.constants.Unit;
import com.openweather.api.model.response.HourlyForecast;
import com.openweather.api.utils.JSONUtils;
import com.openweather.api.utils.RequestUtils;

import java.io.IOException;
import java.io.InputStream;

public class HourlyForecastRequester extends BasicRequester<HourlyForecast> {

    HourlyForecastRequester(String authToken) {
        super(authToken);
    }

    public HourlyForecastRequester setLanguage(String language) {
        this.language = language;
        return this;
    }

    public HourlyForecastRequester setUnitSystem(String unitSystem) {
        this.unitSystem = unitSystem;
        return this;
    }

    public HourlyForecastRequester setAccuracy(String accuracy) {
        this.accuracy = accuracy;
        return this;
    }

    protected String getRequestType() {
        return "forecast";
    }

    protected HourlyForecast executeRequest(String requestSpecificParameters) {

        HourlyForecast forecastResponse = null;

        try {
            InputStream requestResult = RequestUtils.executeGetRequest(buildURL(requestSpecificParameters));
            forecastResponse = (HourlyForecast) JSONUtils.parseJSON(requestResult, HourlyForecast.class);

            char temperatureUnit = Unit.getTemperatureUnit(unitSystem);
            String windUnit = Unit.getWindUnit(unitSystem);

            forecastResponse.getForecasts().forEach(forecastInfo -> {
                forecastInfo.getWind().setUnit(windUnit);
                forecastInfo.getWeatherInfo().setTemperatureUnit(temperatureUnit);
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return forecastResponse;
    }

}
