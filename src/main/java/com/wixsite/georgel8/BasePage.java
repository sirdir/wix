package com.wixsite.georgel8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.frameToBeAvailableAndSwitchToIt;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    void switchToFrame(By locator) {
        driver.switchTo().defaultContent();
        wait.until(frameToBeAvailableAndSwitchToIt(locator));
    }

    void switchToFrame(WebElement element) {
        driver.switchTo().defaultContent();
        wait.until(frameToBeAvailableAndSwitchToIt(element));
    }

    void switchToFrame(String id) {
        driver.switchTo().defaultContent();
        wait.until(frameToBeAvailableAndSwitchToIt(id));
    }

}
