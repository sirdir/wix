package com.wixsite.georgel8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public SideCartComponent removeItem() {
        driver.switchTo().defaultContent();
        wait.until(frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.s_yOSHETPAPopupSkiniframe")));
        wait.until(visibilityOf(itemInCart));
        new Actions(driver)
                .moveToElement(itemInCart)
                .moveToElement(crossToDel)
                .click()
                .perform();

        return this;
    }

    public <T> T minimizeCart(Class<T> page) {
        driver.switchTo().defaultContent();
        wait.until(frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.s_yOSHETPAPopupSkiniframe")));
        wait.until(not(stalenessOf(closeCartBtn)));
        wait.until(elementToBeClickable(closeCartBtn)).click();

        return PageFactory.initElements(driver, page);
    }

    public CartPage goToCart() {
        driver.switchTo().defaultContent();
        wait.until(frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.s_yOSHETPAPopupSkiniframe")));
        wait.until(elementToBeClickable(viewCartBtn)).click();
//        viewCartBtn.click();

        return PageFactory.initElements(driver, CartPage.class);
    }
}
