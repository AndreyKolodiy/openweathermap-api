package com.openweather.api.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public static By usernameLocator = By.id("identifierId");
    public static By loginButtonLocatorNext = By.id("identifierNext");
    public static By passwordLocator = By.xpath("//input[@type='password']");
    public static By loginButtonLocatorLogin = By.id("passwordNext");

    public static void logInWithUsernameAndPassword
            (String username, String password, WebDriver driver) throws InterruptedException {

        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(loginButtonLocatorNext).click();
        Thread.sleep(1000);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocatorLogin).click();
        Thread.sleep(1000);
    }
}
