package com.openweather.api.requesters;

abstract class AuthenticationTokenBasedRequester {

    protected static final String OPEN_WEATHER_API_VERSION = "2.5";
    protected static final String OPEN_WEATHER_BASE_URL = "http://api.openweathermap.org/";
    protected static final String OPEN_WEATHER_API_URL = OPEN_WEATHER_BASE_URL + "data/" + OPEN_WEATHER_API_VERSION + "/";

    protected String authToken;

    protected AuthenticationTokenBasedRequester(String authToken) {
        this.authToken = authToken;
    }

}
