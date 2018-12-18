package com.wixsite.georgel8;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input._1RFas._2oHMR")
    private WebElement quantityInput;

    @FindBy(css = "button._3FsQD")
    private WebElement removeLink;

    public CartPage changeItemQuantity(Integer quantity) {
        switchToFrame("TPAMultiSection_jh9acbtyiframe");
        wait.until(visibilityOf(quantityInput)).sendKeys(Keys.DELETE);
        quantityInput.sendKeys(Keys.DELETE);
        quantityInput.sendKeys(quantity.toString());
        quantityInput.sendKeys(Keys.TAB);

        return this;
    }

    public CartPage removeScarfItem() {
        switchToFrame("TPAMultiSection_jh9acbtyiframe");
        removeLink.click();

        return this;
    }
}
