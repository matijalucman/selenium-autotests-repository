package com.seleniumdemoproject.tests;

import com.seleniumdemoproject.core.TestBase;
import com.seleniumdemoproject.pageobjectmodel.GoogleMainPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends TestBase {

    @Test
    public void googleSearchSelenium_Test(){

        try {
            GoogleMainPage googleMainPage = GoogleMainPage.usingDriverNavigateTo(driver, "https://www.google.hr");

            googleMainPage.searchByInsertedValue("selenium");

            Assert.assertTrue(googleMainPage.isSearchSuccessful());
        }
        catch (Exception e) {
            System.out.println("There was an error during test execution: " + e);
            Assert.fail();
        }
    }

    @Test
    public void googleSearchApple_Test(){

        try {
            GoogleMainPage googleMainPage = GoogleMainPage.usingDriverNavigateTo(driver, "https://www.google.hr");

            googleMainPage.searchByInsertedValue("apple");

            Assert.assertTrue(googleMainPage.isSearchSuccessful());
        }
        catch (Exception e) {
            System.out.println("There was an error during test execution: " + e);
            Assert.fail();
        }
    }
}
