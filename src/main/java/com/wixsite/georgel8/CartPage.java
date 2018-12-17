package com.wixsite.georgel8;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input._1RFas._2oHMR")
    private WebElement quantityInput;

    @FindBy(css = "button._3FsQD")
    private WebElement removeLink;

    public CartPage changeItemQuantity(int quantity) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("TPAMultiSection_jh9acbtyiframe");
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
        quantityInput.sendKeys(Keys.TAB);

        return this;
    }

    public CartPage removeScarfItem() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("TPAMultiSection_jh9acbtyiframe");
        removeLink.click();

        return this;
    }
}
