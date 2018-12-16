package com.wixsite.georgel8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage {

    WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "comp-jhalo8eilabel")
    public WebElement shopBtn;

    public void openShop() {
        shopBtn.click();
    }
}
