package com.openweather.api.constants;

public final class Unit {

    private Unit() {}

    public static final String METRIC_SYSTEM = "metric";
    public static final String IMPERIAL_SYSTEM = "imperial";
    public static final String STANDARD_SYSTEM = "standard";

    public static String getWindUnit(String type) {
        switch (type) {
            case IMPERIAL_SYSTEM:
                return "miles/hour";
            case STANDARD_SYSTEM:
            case METRIC_SYSTEM:
            default:
                return "meter/sec";
        }
    }

    public static char getTemperatureUnit(String type) {
        switch (type) {
            case METRIC_SYSTEM:
                return '℃';
            case IMPERIAL_SYSTEM:
                return '℉';
            case STANDARD_SYSTEM:
            default:
                return 'K';
        }
    }

}
