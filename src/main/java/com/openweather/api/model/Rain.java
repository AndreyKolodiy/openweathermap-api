package com.openweather.api.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public class Rain {

    @JSONField(name = "3h")
    @Getter
    @Setter
    private byte rainVolumeLast3Hrs;

    public String getUnit() {
        return "mm";
    }

    @Override
    public String toString() {
        return "Rain(last 3 hrs): " + rainVolumeLast3Hrs + ' ' + getUnit();
    }
}
