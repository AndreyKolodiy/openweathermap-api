package com.openweather.api.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.net.MalformedURLException;
import java.net.URL;

@EqualsAndHashCode
public class WeatherState {

    @JSONField(name = "id")

    @Getter
    @Setter
    long conditionId;

    @JSONField(name = "main")

    @Getter
    @Setter
    String weatherGroup;

    @JSONField(name = "description")

    @Getter
    @Setter
    String description;

    @JSONField(name = "icon")

    @Getter
    @Setter
    String iconId;

    public URL getWeatherIconUrl() {
        URL iconUrl = null;
        try {
            iconUrl = new URL("http://openweathermap.org/img/w/" + iconId + ".png");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return iconUrl;
    }

    @Override
    public String toString() {
        return "Weather: " + description;
    }
}
