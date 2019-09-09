package com.openweather.api.test;

import com.openweather.api.requesters.OpenWeatherMapManager;
import org.junit.BeforeClass;

public class ApiTest {

    private static OpenWeatherMapManager manager;

    @BeforeClass
    public static void retrieveApiKey() {
        String apiKey = System.getenv("OPENWEATHER_API_KEY");
        manager = new OpenWeatherMapManager(apiKey);
    }

    protected static OpenWeatherMapManager getManager() {
        return manager;
    }
}
