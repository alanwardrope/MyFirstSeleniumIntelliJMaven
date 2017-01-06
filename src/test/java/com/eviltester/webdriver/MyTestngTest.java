package com.eviltester.webdriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

/**
 * Created by Alan_Wardrope on 04/01/2017.
 */
public class MyTestngTest {

    public WebDriver driver;

    @Parameters({"browser"})
    @Test

    public void main(String param) throws InterruptedException {

        switch (param) {
            case "chrome":
                // Create a new instance of the Chrome driver
                driver = new ChromeDriver();
                break;
            case "firefox":
                // Create a new instance of the Firefox driver
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("marionette", true);
                String driverType = capabilities.getCapability("marionette").toString();
                System.out.println("1. Marionette is set to : " + driverType);
                driver = new FirefoxDriver(capabilities);
                System.out.println("2. Marionette is set to : " + driverType);
                break;
            case "ie":
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + param);
        }

        //Put a Implicit wait, this means that any search for elements on the page could take the time
        // the implicit wait is set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("3.");

        //Launch the Online Store Website
        //driver.get("http://www.onlinestore.toolsqa.wpengine.com");
        driver.get("http://www.linkedin.com");


        // Find the element that's ID attribute is 'account'(My Account)
        //driver.findElement(By.id("account")).click();

        // Find the element that's ID attribute is 'log' (Username)
        // Enter Username on the element found by above desc.
        driver.findElement(By.id("login-email")).sendKeys("awardrope@hotmail.com");

        // Find the element that's ID attribute is 'pwd' (Password)
        // Enter Password on the element found by the above desc.
        driver.findElement(By.id("login-password")).sendKeys("09Nov1963");

        // Now submit the form. WebDriver will find the form for us from the element
        driver.findElement(By.id("login-submit")).click();

        // Print a Log In message to the screen
        System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

        driver.findElement(By.id("main-search-box")).sendKeys("I am here");

        // Create a web element for the  settings dropdown
        System.out.println("4.1");
        WebElement settingsDropDown = driver.findElement(By.xpath("//*/li/a/img[@class='img-defer nav-profile-photo']"));
        // Move to the image to display the drop dowb
        Actions myMouse = new Actions(driver);
        System.out.println("4.2");
        myMouse.moveToElement(settingsDropDown).build().perform();
        //myMouse.clickAndHold(settingsDropDown);
        Thread.sleep(5000L);

        System.out.println("4.3");

        //Now select sgn out
        // Find the element that's ID attribute is 'account_logout' (Log Out)
        driver.findElement(By.xpath("//*/div[@id='account-sub-nav']/div/div[2]/ul/li[1]/div/span/span[3]/a")).click();


        System.out.println("5");

    }

    @BeforeMethod

    public void beforeMethod() {


        System.out.println("Do NAda for now");
    }

    @AfterMethod

    public void afterMethod() throws InterruptedException {

        // Close the driver
        //Thread.sleep(10000);
        //driver.quit();

    }


}
