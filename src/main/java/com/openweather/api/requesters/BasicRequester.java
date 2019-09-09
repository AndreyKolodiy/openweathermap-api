package com.openweather.api.requesters;


import com.openweather.api.constants.Unit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

abstract class BasicRequester<T> extends AuthenticationTokenBasedRequester {

    protected String language;
    protected String unitSystem = Unit.STANDARD_SYSTEM;
    protected String accuracy;

    protected BasicRequester(String authToken) {
        super(authToken);
    }

    public T getByCityName(String name) {
        return executeRequest("?q=" + name);
    }

    protected URL buildURL(String requestSpecificParameters) {

        StringBuilder urlBuilder = new StringBuilder(OPEN_WEATHER_API_URL);
        urlBuilder.append(getRequestType());
        urlBuilder.append(requestSpecificParameters);

        urlBuilder.append("&appid=");
        urlBuilder.append(authToken);


        if (language != null) {
            urlBuilder.append("&lang=");
            urlBuilder.append(language);
        }

        if (!Unit.STANDARD_SYSTEM.equals(unitSystem)) {
            urlBuilder.append("&units=");
            urlBuilder.append(unitSystem);
        }

        if (accuracy != null) {
            urlBuilder.append("&type=");
            urlBuilder.append(accuracy);
        }

        Map<String, String> additionalParameters = getAdditionalParameters();
        if (additionalParameters != null) {
            additionalParameters.forEach((key, value) -> {
                urlBuilder.append("&");
                urlBuilder.append(key);
                urlBuilder.append("=");
                urlBuilder.append(value);
            });
        }

        URL url = null;
        try {
            url = new URL(urlBuilder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    protected Map<String, String> getAdditionalParameters() {
        return null;
    }

    protected abstract String getRequestType();

    protected abstract T executeRequest(String requestSpecificParameters);

}
