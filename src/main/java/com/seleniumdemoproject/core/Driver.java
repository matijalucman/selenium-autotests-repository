package com.seleniumdemoproject.core;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {

    public static RemoteWebDriver getDriverForBrowser(String browser) {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browser);

        RemoteWebDriver driver = new RemoteWebDriver(caps);
        driver.manage().window().maximize();
        return driver;
    }
}
