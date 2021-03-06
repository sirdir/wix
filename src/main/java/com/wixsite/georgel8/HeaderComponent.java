package com.wixsite.georgel8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HeaderComponent extends BasePage {

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "comp-jh99ppou2label")
    private WebElement storesLink;

    @FindBy(css = "._1gJ4T._3tSTQ")
    private WebElement bagIcon;
//
//    @FindBy(css = "iframe.s_yOSHETPAPopupSkiniframe")
//    private WebElement wrapper;

    public ShopPage openStores() {
        driver.switchTo().defaultContent();
//        wait.until(invisibilityOf(wrapper));
        wait.until(elementToBeClickable(storesLink)).click();

        return PageFactory.initElements(driver, ShopPage.class);
    }

    public void openCart() {
        driver.switchTo().defaultContent();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(elementToBeClickable(bagIcon)).click();

//        return PageFactory.initElements(driver, SideCartComponent.class);
    }
}
