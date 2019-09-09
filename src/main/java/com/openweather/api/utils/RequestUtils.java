package com.openweather.api.utils;

import com.openweather.api.execption.DataNotFoundException;
import com.openweather.api.execption.InvalidAuthTokenException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class RequestUtils {

    private RequestUtils() {
    }

    public static InputStream executeGetRequest(URL requestUrl) {
        InputStream resultStream = null;

        try {
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");

            switch (connection.getResponseCode()) {
                case HttpURLConnection.HTTP_OK:
                    resultStream = connection.getInputStream();
                    break;
                case HttpURLConnection.HTTP_UNAUTHORIZED:
                    throw new InvalidAuthTokenException();
                case HttpURLConnection.HTTP_NOT_FOUND:
                case HttpURLConnection.HTTP_BAD_REQUEST:
                    throw new DataNotFoundException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return resultStream;
    }

}
