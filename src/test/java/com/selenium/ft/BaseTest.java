package com.selenium.ft;

import com.selenium.ft.setup.DriverFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.selenium.ft.constants.Constants.BASE_URL;
import static com.selenium.ft.setup.DriverFactory.quitDriver;

public class BaseTest {

    protected WebDriver driver;


    @Parameters({"width", "height"})
    @BeforeMethod
    public void setUp(@Optional("1920") int width, @Optional("1080") int height) {
        DriverFactory.setDriver();
        driver = DriverFactory.getDriver();
        driver.manage().window().setSize(new Dimension(width, height));
        driver.get(BASE_URL); // Change this to your test URL
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
