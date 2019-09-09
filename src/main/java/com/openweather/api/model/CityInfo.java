package com.openweather.api.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class CityInfo {

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String name;

    @JSONField(name = "coord")
    @Getter
    @Setter
    private Coordinates coordinates;

    @Getter
    @Setter
    private String country;

    @Override
    public String toString() {
        return "City: " + name + "(" + id + "). Coordinates: " + coordinates + '\n' + "Country: " + country;
    }

}
