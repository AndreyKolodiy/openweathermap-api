package com.openweather.api.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@AllArgsConstructor
public class Coordinates {

    @JSONField(name = "lat")
    @Getter
    @Setter
    private float latitude;

    @JSONField(name = "lon")
    @Getter
    @Setter
    private float longitude;

    @Override
    public String toString() {
        return "latitude=" + latitude + ", longitude=" + longitude;
    }
}
