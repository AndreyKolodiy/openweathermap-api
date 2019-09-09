package com.openweather.api.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class JSONUtils {

    private JSONUtils() {}

    public static Object parseJSON(InputStream inputStream, Class clazz) throws IOException {
        return JSON.parseObject(getStringFromStream(inputStream), clazz);
    }

    public static Object parseJSON(InputStream inputStream, TypeReference typeReference) throws IOException {
        return JSON.parseObject(getStringFromStream(inputStream), typeReference);
    }

    private static String getStringFromStream(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        reader.close();

        return result.toString();
    }
}
