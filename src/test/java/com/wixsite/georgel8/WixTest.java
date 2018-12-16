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
        startPage.openShop();
        //assert

        //2. Select product GLASSES from gallery shown
        //assert
        //3. Add item to Cart
        //assert
        //4. Remove item from Cart
        //assert
        //5. Minimize the Cart
        //assert
        //6. Add product to Cart again
        //assert
        //7. Minimize the Cart
        //assert
        //8. Go back to main STORES gallery
        //assert
        //9. Go to Bag of Items and expect glasses items
        //assert
        //10. Minimize the Cart
        //assert
        //11. Select product SCARF from the gallery shown
        //assert
        //12. Add item to Cart
        //assert
        //13. Go to Cart View
        //assert
        //14. Change the quantity of glasses to 3
        //assert
        //15. Remove Scarf from the Cart View

    }
}
