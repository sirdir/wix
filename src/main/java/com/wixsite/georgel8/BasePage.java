package com.wixsite.georgel8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    void switchToFrame(By locator) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(locator));
    }

    void switchToFrame(String id) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(id);
    }

}
