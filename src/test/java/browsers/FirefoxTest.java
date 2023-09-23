package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirefoxTest {
    @Test
    void openBrowser(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }

    @Test
    void validatePageUrlWithHeadlessMode() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://selenium.dev");
        Assert.assertTrue(driver.getCurrentUrl().contains("selenium.dev"));
        driver.quit();
    }
}
