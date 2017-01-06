package com.eviltester.webdriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Alan_Wardrope on 29/12/2016.
 */
public class MyFacebookFFTest {

    private String firstName = "Test Selenium";


    public WebDriver driver3;

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
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("marionette", true);

        String driverType = capabilities.getCapability("marionette").toString();

        System.out.println("1. Marionette is set to : " + driverType);

        driver3 = new FirefoxDriver(capabilities);
        driver3.manage().window().maximize();
        System.out.println("2. Marionette is set to : " + driverType);

    }

    @Test
    public void startFF(){

        driver3.navigate().to("http://www.facebook.com");

        // Enter FirstName
        //driver3.findElement(By.xpath(".//*[@id='u_0_1']")).sendKeys(firstName);

        System.out.println("-----1111");

        // Select Day drop-dnw and get list of all values
        Select selDay = new Select(driver3.findElement(By.xpath(".//*[@id='month'")));
        // Now select a value
        selDay.selectByVisibleText("24");

        System.out.println("-----2222");

        // Select Month drop-dnw and get list of all values
        Select selMonth = new Select(driver3.findElement(By.xpath(".//*[@id='day'")));
        // Now select a value
        selMonth.selectByValue("8");

        System.out.println("-----3333");

        // Select Year drop-dnw and get list of all values
        Select selYear = new Select(driver3.findElement(By.xpath(".//*[@id='year'")));
        // Now select a value
        selYear.selectByIndex(56);

        // Select the Male button
        driver3.findElement(By.xpath(".//*[@id='u_0_i']")).click();

        // Select Sign In button
        driver3.findElement(By.xpath(".//*[@id='u_0_e']")).click();

        // TO DO, validate Mandatory fields not entered have error icons

        // Now to select a link to a new page - Create a page link
        driver3.findElement(By.xpath(".//*[@id='reg_pages_msg']/a")).click();

        // New page displayed
        // Vaidate title
        Assert.assertTrue("title should start differently",
                driver3.getTitle().contains("Create a Page | Facebook"));

        // Now Navigate back to original page
        driver3.navigate().back();

    }

    @AfterTest
    public void tearDown() throws Exception {
       // driver3.quit();
    }

}
