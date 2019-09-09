package com.openweather.api.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewMessage {

    public static By buttonNewMessageLocator = By.cssSelector(".T-I.J-J5-Ji.T-I-KE.L3");
    public static By userNameLocator = By.xpath("//textarea[@rows='1']");
    public static By themeLocator = By.xpath("//input[@name='subjectbox']");
    public static By messageLocator = By.xpath("//div[@role='textbox']");

    public static void sendMessage
            (String userName, String theme, String message, WebDriver driver) throws InterruptedException {

        driver.findElement(buttonNewMessageLocator).click();
        driver.findElement(userNameLocator).sendKeys(userName);
        driver.findElement(themeLocator).sendKeys(theme);
        driver.findElement(messageLocator).sendKeys(message);
        Thread.sleep(1000);
    }
}
