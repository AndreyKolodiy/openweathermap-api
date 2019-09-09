package com.openweather.api.execption;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException() {
        super("Data for provided parameters wasn't found. Please, check your request.");
    }

}
