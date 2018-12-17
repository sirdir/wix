package com.wixsite.georgel8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponent extends BasePage {

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "comp-jh99ppou2label")
    private WebElement storesLink;

    @FindBy(id = "comp-jh9acbuw")
    private WebElement bagIcon;

    public ShopPage openStores() {
        storesLink.click();

        return PageFactory.initElements(driver, ShopPage.class);
    }

    public void openCart() {
        bagIcon.click();

//        return PageFactory.initElements(driver, SideCartComponent.class);
    }
}
