package com.wixsite.georgel8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class WixTest {

    static WebDriver driver;
    final String BASE_URL = "https://georgel8.wixsite.com/ait-ht";

    @BeforeAll
    static void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }

    @Test
    void userCartWorkflow() {
        driver.get(BASE_URL);
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        //1. Go to the Shop
        ShopPage shopPage = startPage.openShop();
        //assert todo

        //2. Select product GLASSES from gallery shown
        ItemPage itemPage = shopPage.openItem();
        //assert todo
        //3. Add item to Cart
        itemPage.addToCart();
        //assert todo
        //4. Remove item from Cart
        itemPage.sideCart.removeItem();
        //assert todo
        //5. Minimize the Cart
        itemPage = itemPage.sideCart.minimizeCart(ItemPage.class); //todo rethink generic
        //assert todo
        //6. Add product to Cart again
        itemPage.addToCart();
        //assert todo
        //7. Minimize the Cart
        itemPage = itemPage.sideCart.minimizeCart(ItemPage.class); //todo rethink generic
        //assert todo
        //8. Go back to main STORES gallery
        shopPage = itemPage.header.openStores();
        //assert todo
        //9. Go to Bag of Items and expect glasses items
        shopPage.header.openCart();
        //assert todo
        //10. Minimize the Cart
        shopPage = shopPage.sideCart.minimizeCart(ShopPage.class);
        //assert todo
        //11. Select product SCARF from the gallery shown
        itemPage = shopPage.openScarfItem();
        //assert todo
        //12. Add item to Cart
        itemPage.addToCart();
        //assert todo
        //13. Go to Cart View
        CartPage cartPage = itemPage.sideCart.goToCart();
        //assert todo
        //14. Change the quantity of glasses to 3
        cartPage.changeItemQuantity(3);
        //assert todo
        //15. Remove Scarf from the Cart View
        cartPage.removeScarfItem();
        //assert todo
    }
}
