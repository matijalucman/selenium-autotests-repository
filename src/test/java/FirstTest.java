import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FirstTest {

    /***
     * Testing is Maven and Selenium set up correctly
     * ***/

    // open Google main page and search by given string
    public void googleSearch(final String searchString) throws Exception {

        final RemoteWebDriver driver = new RemoteWebDriver(DesiredCapabilities.chrome());

        driver.get("https://www.google.hr");

        WebElement searchBox = driver.findElement(By.cssSelector("#gs_lc0 input"));

        searchBox.clear();

        searchBox.sendKeys(searchString);

        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        // waits 10 seconds that page title become correct
        // if it's not become correct, exception is thrown and test fails
        wait.until(isTrue -> driver.getTitle().toLowerCase().contains(searchString.toLowerCase()));

        driver.quit();
    }

    @Test
    public void searchSelenium() {

        try {
            googleSearch("Selenium");
        }
        catch (Exception e) {

            System.out.print("Test failed because of: " + e);
            Assert.fail();
        }
    }
}
