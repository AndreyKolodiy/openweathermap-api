package com.openweather.api.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewMessages {

    public static By buttonSearchMessageLocator = By.xpath("//div[@class='dC']");
    public static By searchMessageLocator = By.xpath("//input[@class='gb_jf']");
    public static By startSearchingLocator = By.xpath("//input[@class='gb_jf']");
    public static By openMessageLocator = By.xpath("//div[@class='BltHke nH oy8Mbf']");
    public static By readMessageLocator = By.xpath("//div[@class='a3s aXjCH ']");

    public static String viewNewdMessage
            (String searchMessage, WebDriver driver) throws InterruptedException {
        driver.findElement(buttonSearchMessageLocator).click();
        driver.findElement(searchMessageLocator).sendKeys(searchMessage);
        driver.findElement(startSearchingLocator).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(openMessageLocator).click();
        WebElement element = driver.findElement(readMessageLocator);
        return element.getText();
    }


}
