package com.seleniumdemoproject.pageobjectmodel;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage {

    private WebDriver driver;

    private String searchString;

    @FindBy(css = "#gs_lc0 input")
    private WebElement searchBox;

    public GoogleMainPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // navigate driver to inserted url and build instance of GoogleMainPage
    public static GoogleMainPage usingDriverNavigateTo(WebDriver driver, String url) throws Exception {

        driver.get(url);
        return new GoogleMainPage(driver);
    }

    // google search by inserted string
    public void searchByInsertedValue(String searchString) throws Exception {

        this.searchString = searchString;
        
        //Adding Explicit wait to avoid failures
        WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(searchString);
        searchBox.submit();
    }

    // verify if search is successful
    public boolean isSearchSuccessful(){

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(isTrue -> driver.getTitle().toLowerCase().contains(searchString.toLowerCase()));
            return true;
        }
        catch (TimeoutException e) {
            System.out.println("Search failed.");
            return false;
        }
    }
}
