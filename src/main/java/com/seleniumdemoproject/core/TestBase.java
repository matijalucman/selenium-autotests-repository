package com.seleniumdemoproject.core;

import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected RemoteWebDriver driver;

    @BeforeMethod
    public void startDriver() {

        driver = Driver.getDriverForBrowser(BrowserType.CHROME);
    }

    @AfterMethod
    public void stopDriver() {

        driver.quit();
    }
}
