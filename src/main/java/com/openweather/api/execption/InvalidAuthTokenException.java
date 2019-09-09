package com.openweather.api.execption;

public class InvalidAuthTokenException extends RuntimeException {

    public InvalidAuthTokenException() {
        super("Check your authentication token! You can get it here: https://home.openweathermap.org/api_keys/.");
    }

}
