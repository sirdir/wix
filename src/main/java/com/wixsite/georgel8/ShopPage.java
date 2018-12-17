package com.wixsite.georgel8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ShopPage extends BasePage {

    public HeaderComponent header;
    public SideCartComponent sideCart;

    public ShopPage(WebDriver driver) {
        super(driver);
        header = PageFactory.initElements(driver, HeaderComponent.class);
        sideCart = PageFactory.initElements(driver, SideCartComponent.class);
    }

    @FindBy(xpath = "(.//div/h3[@class='title'])[2]") //todo
    private WebElement glasses;

    @FindBy(xpath = "(.//div/h3[@class='title'])[6]") //todo
    private WebElement scarf;

    public ItemPage openItem() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("TPASection_jh9acbfxiframe");
        wait.until(visibilityOf(glasses)).click();//todo dynamically select item or smth else

        return PageFactory.initElements(driver, ItemPage.class);
    }

    public ItemPage openScarfItem() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("TPASection_jh9acbfxiframe");
        wait.until(visibilityOf(scarf)).click();//todo dynamically select item or smth else

        return PageFactory.initElements(driver, ItemPage.class);
    }
}
