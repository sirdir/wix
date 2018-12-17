package com.wixsite.georgel8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "comp-jhalo8eilink")
    private WebElement shopBtn;

    public ShopPage openShop() {
        shopBtn.click();

        return PageFactory.initElements(driver, ShopPage.class);
    }
}
