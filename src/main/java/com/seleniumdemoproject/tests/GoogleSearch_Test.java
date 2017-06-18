package com.seleniumdemoproject.tests;

import com.seleniumdemoproject.core.TestBase;
import com.seleniumdemoproject.pageobjectmodel.GoogleMainPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class GoogleSearch_Test extends TestBase {

    @Test
    public void GoogleSearch(){

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
}
