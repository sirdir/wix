package com.wixsite.georgel8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideCartComponent extends BasePage {

    public SideCartComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "li[data-hook='sideCart-widget-item']") //todo
    private WebElement itemInCart;

    @FindBy(css = "button.remove-item") //todo
    private WebElement crossToDel;

    @FindBy(id = "sideCart-widget-close")
    private WebElement closeCartBtn;

    @FindBy(css = "a[fm-id='7']")
    private WebElement viewCartBtn;

    public SideCartComponent removeItem() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0); //todo maybe some locator
        new Actions(driver)
                .moveToElement(itemInCart)
                .click(crossToDel)
                .perform();

        return this;
    }

    public <T> T minimizeCart(Class<T> page) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0); //todo maybe some locator???
        closeCartBtn.click();

        return PageFactory.initElements(driver, page);
    }

    public CartPage goToCart() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0); //todo maybe some locator???
        viewCartBtn.click();

        return PageFactory.initElements(driver, CartPage.class);
    }
}
