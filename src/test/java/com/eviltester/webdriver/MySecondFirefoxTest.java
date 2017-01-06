package com.eviltester.webdriver;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.lang.Runtime;
/**
 * Created by Alan_Wardrope on 29/12/2016.
 */
public class MySecondFirefoxTest {

    public WebDriver driver2;

    @BeforeTest
    public void setUp() throws Exception {
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


        FirefoxProfile fp = new FirefoxProfile();
        fp.setPreference("dom.ipc.plugins.enabled", false);

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        capabilities.setCapability(FirefoxDriver.PROFILE, fp);

        String driverType = capabilities.getCapability("marionette").toString();

        System.out.println("1. Marionette is set to : " + driverType);
        System.out.println(capabilities.asMap());

        driver2 = new FirefoxDriver(capabilities);
        System.out.println("2. Marionette is set to : " + driverType);

    }

    @Test
    public void startFF() {

        driver2.navigate().to("http://seleniumsimplified.com");

        Assert.assertTrue("title should start differently",
                driver2.getTitle().startsWith("Selenium Simplified"));

    }

    @AfterTest
    public void tearDown() throws Exception {
        driver2.quit();

        /**
        driver2.close();

        try {
            Thread.sleep(5000);
            Runtime.getRuntime().exec("taskkill /f /im plugin-container.exe");
            driver2.quit();
        } catch(Exception e) {
            System.out.println(e);
        }
         **/


    }
}
