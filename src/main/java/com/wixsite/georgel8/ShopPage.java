package com.wixsite.georgel8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ShopPage extends BasePage {

    public HeaderComponent header;
    public SideCartComponent sideCart;

    public ShopPage(WebDriver driver) {
        super(driver);
        header = PageFactory.initElements(driver, HeaderComponent.class);
        sideCart = PageFactory.initElements(driver, SideCartComponent.class);
        switchToFrame("TPASection_jh9acbfxiframe");
        wait.until(visibilityOfAllElementsLocatedBy(allProducts));
    }

    @FindBy(xpath = "(.//div/h3[@class='title'])[2]") //todo
    private WebElement glasses;

    @FindBy(xpath = "(.//div/h3[@class='title'])[8]") //todo
    private WebElement scarf;

//    @FindBy(tagName = "product-item")
//    private WebElement allProducts;

//    private By allProducts = By.tagName("product-item");
    private By allProducts = By.cssSelector("li.gallery-item");

    public ItemPage openGlassItem() {
        switchToFrame("TPASection_jh9acbfxiframe");
        wait.until(visibilityOf(glasses)).click();//todo dynamically select item or smth else

        return PageFactory.initElements(driver, ItemPage.class);
    }

    public ItemPage openScarfItem() {
        switchToFrame("TPASection_jh9acbfxiframe");
        wait.until(visibilityOf(scarf)).click();//todo dynamically select item or smth else

        return PageFactory.initElements(driver, ItemPage.class);
    }
}
