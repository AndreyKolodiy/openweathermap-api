package com.openweather.api.test;

import com.openweather.api.requesters.HourlyForecastRequester;
import org.junit.BeforeClass;
import org.junit.Test;

public class HourlyForecastRequesterIntegrationTest extends ApiTest {

    private static HourlyForecastRequester hourlyForecastRequester;

    @BeforeClass
    public static void setup() {
        hourlyForecastRequester = getManager().getHourlyForecastRequester();
    }

    @Test
    public void whenRequestForecastForMinskByCity() {
        assert hourlyForecastRequester.getByCityName("Kiev") != null;
    }
}
