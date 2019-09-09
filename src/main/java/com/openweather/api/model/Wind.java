package com.openweather.api.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class Wind {

    @JSONField(name = "speed")

    @Getter
    @Setter
    private float speed;

    @Getter
    @Setter
    private String unit;

    @JSONField(name = "deg")

    @Getter
    @Setter
    private short degrees;

    @Override
    public String toString() {
        return "Wind: " + speed + ' ' + unit + ", " + degrees + " degrees";
    }
}
