package com.wixsite.georgel8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SideCartComponent extends BasePage {

    public SideCartComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "li[data-hook='cart-widget-item']") //todo
    private WebElement itemInCart;

    @FindBy(css = "button.remove-item") //todo
    private WebElement crossToDel;

    @FindBy(id = "cart-widget-close")
    private WebElement closeCartBtn;

    @FindBy(css = "footer > a[data-hook='widget-view-cart-button']")
    private WebElement viewCartBtn;

    @FindBy(css = "iframe.s_yOSHETPAPopupSkiniframe")
    private WebElement iFrame;

    @FindBy(css = "div.minicart")
    private WebElement miniCart;

    public SideCartComponent removeItem() {
        switchToFrame(iFrame);
        wait.until(attributeContains(miniCart, "class", "active"));
        new Actions(driver)
                .moveToElement(itemInCart)
                .pause(1000)
                .moveToElement(crossToDel)
                .click()
                .perform();

        return this;
    }

    public <T> T minimizeCart(Class<T> page) {
        switchToFrame(iFrame);
        wait.until(attributeContains(miniCart, "class", "active"));
        closeCartBtn.click();
        wait.until(not(attributeContains(miniCart, "class", "active")));

        return PageFactory.initElements(driver, page);
    }

    public CartPage goToCart() {
        switchToFrame(iFrame);
        wait.until(attributeContains(miniCart, "class", "active"));
        wait.until(elementToBeClickable(viewCartBtn)).click();
//        viewCartBtn.click();

        return PageFactory.initElements(driver, CartPage.class);
    }
}
