package com.wixsite.georgel8;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ItemPage extends BasePage {

    public SideCartComponent sideCart;
    public HeaderComponent header;

    public ItemPage(WebDriver driver) {
        super(driver);
        sideCart = PageFactory.initElements(driver, SideCartComponent.class);
        header = PageFactory.initElements(driver, HeaderComponent.class);
        switchToFrame(iFrame);
    }
//
//    @FindBy(css = "button[data-hook='add-to-cart']")
//    private WebElement addToCartBtn;

    private By addToCartBtn = By.cssSelector("button[data-hook='add-to-cart']");

    private By iFrame = By.id("TPAMultiSection_jh9acbtniframe");

    public ItemPage addToCart() {
        switchToFrame(iFrame);
        wait
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver drv) -> {
                    drv.findElement(addToCartBtn).click();
                    return true;
                });

        return this;
    }
}
