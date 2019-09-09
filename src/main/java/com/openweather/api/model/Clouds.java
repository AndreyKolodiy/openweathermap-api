package com.openweather.api.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class Clouds {

    @JSONField(name = "all")
    @Getter
    @Setter
    private byte cloudiness;

    @Override
    public String toString() {
        return "Cloudiness: " + cloudiness + "%";
    }
}
