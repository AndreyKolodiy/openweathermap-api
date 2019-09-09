package com.openweather.api.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class Snow {

    @JSONField(name = "all")
    @Getter
    @Setter
    private byte snowVolumeLast3Hrs;

    public String getUnit() {
        return "mm";
    }

    @Override
    public String toString() {
        return "Snow(last 3 hrs): " + snowVolumeLast3Hrs + ' ' + getUnit();
    }
}
