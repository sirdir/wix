package com.wixsite.georgel8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ItemPage extends BasePage {

    public SideCartComponent sideCart;
    public HeaderComponent header;

    public ItemPage(WebDriver driver) {
        super(driver);
        sideCart = PageFactory.initElements(driver, SideCartComponent.class);
        header = PageFactory.initElements(driver, HeaderComponent.class);
    }

    @FindBy(css = "button[data-hook='add-to-cart']")
    private WebElement addToCartBtn;


    public ItemPage addToCart() {
        driver.switchTo().defaultContent();
        wait.until(refreshed(presenceOfElementLocated(By.id("TPAMultiSection_jh9acbtniframe"))));
//        wait.until((By.id("TPAMultiSection_jh9acbtniframe")));
//        wait.until(refreshed(By.id("TPAMultiSection_jh9acbtniframe")));
        wait.until(refreshed(frameToBeAvailableAndSwitchToIt("TPAMultiSection_jh9acbtniframe")));
        wait.until(visibilityOf(addToCartBtn)).click();

        return this;
    }
}
