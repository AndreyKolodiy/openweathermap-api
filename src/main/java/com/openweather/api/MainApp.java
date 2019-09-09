package com.openweather.api;

import com.openweather.api.constants.Accuracy;
import com.openweather.api.constants.Language;
import com.openweather.api.constants.Unit;
import com.openweather.api.model.response.HourlyForecast;
import com.openweather.api.page.LoginPage;
import com.openweather.api.page.NewMessage;
import com.openweather.api.page.ViewMessages;
import com.openweather.api.requesters.HourlyForecastRequester;
import com.openweather.api.requesters.OpenWeatherMapManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainApp {
    private static final String API_TOKEN = "5fa7571c03889c663963c41593c4124d";
    private static final String URL = "https://mail.google.com/mail/u/0/#inbox";
    private static HourlyForecast hourlyForecastcastResponse;

    public static void main(String[] args) throws InterruptedException {
        OpenWeatherMapManager openWeatherManager = new OpenWeatherMapManager(API_TOKEN);
        HourlyForecastRequester forecastRequester = openWeatherManager.getHourlyForecastRequester();
        hourlyForecastcastResponse = forecastRequester
                .setLanguage(Language.ENGLISH)
                .setUnitSystem(Unit.METRIC_SYSTEM)
                .setAccuracy(Accuracy.ACCURATE)
                .getByCityName("Odessa,ua");

        String forecast = hourlyForecastcastResponse.getForecasts().toString();

        final String searchTheme = "Weekly weather for: " + hourlyForecastcastResponse.getCityName()
                + ", " + hourlyForecastcastResponse.getCountry()
                + " " + getCurrentTimeStamp();


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(URL);
        LoginPage.logInWithUsernameAndPassword("weathertestapi@gmail.com", "z9379992", driver);
        NewMessage.sendMessage("weathertestapi@gmail.com", searchTheme, forecast, driver);
        String element = ViewMessages.viewNewdMessage(searchTheme,driver);

        if (hourlyForecastcastResponse.getForecasts().toString().equals(element))
            System.out.println("OK!, The data in the mail is correct");
        else
            System.out.println("ERROR!, The data in the mail is not correct");
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}
