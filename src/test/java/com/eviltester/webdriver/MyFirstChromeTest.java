package com.eviltester.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Alan_Wardrope on 25/11/2016.
 */

public class MyFirstChromeTest {

    @Test
    public void startWebDriver() {

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://seleniumsimplified.com");

        Assert.assertTrue("title should start differently",
                driver.getTitle().startsWith("Selenium Simplified"));

        driver.quit();
    }

    }
