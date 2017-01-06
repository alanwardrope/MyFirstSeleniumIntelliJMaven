package com.eviltester.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Alan_Wardrope on 25/11/2016.
 */
public class MyFirstFirefoxTest {

    @Test
    public void startWebDriver(){
//        Configured the Gecko Path in 'Run - Edit Configurations' for the project in the java section
//        -Dwebdriver.gecko.driver="C:\MyProgramFiles\geckodriver-v0.11.1-win64\geckodriver.exe"
//        To run from cmd line with mvn clean test, ensure directory with geckodriver is in the PATH
//        System.setProperty("webdriver.gecko.driver","C:\\MyProgramFiles\\geckodriver-v0.11.1-win64\\geckodriver.exe");

        // < FF 48 (uses FF driver thyat comes with Selenium 2.53.1 or wires)
//        WebDriver driver = new FirefoxDriver();

        // >= FF 48 and above download marionette driver (gecko)
        /**
        // https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/firefox/MarionetteDriver.html
        // Apparently we should now use FirefoxDriver with a capability of Marionette set to rrue or false
        WebDriver driver = new MarionetteDriver();
         **/
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("marionette", true);

        String driverType = capabilities.getCapability("marionette").toString();

        System.out.println("1. Marionette is set to : " + driverType);
        System.out.println(capabilities.asMap());

        WebDriver driver = new FirefoxDriver(capabilities);


        System.out.println("2. Marionette is set to : " + driverType);


        driver.navigate().to("http://seleniumsimplified.com");

        Assert.assertTrue("title should start differently",
                driver.getTitle().startsWith("Selenium Simplified"));

        driver.quit();

    }
}
