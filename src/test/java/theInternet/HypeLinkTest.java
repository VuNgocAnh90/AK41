package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HypeLinkTest {
    /**
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/status_codes
     * Click on "200"
     * Then "200 status code" page appear
     * Click on "go here"
     * Click on "301"
     * Then "301 status code" page appear
     * Click on "go here"
     * Click on "404"
     * Then "404 status code" page appear
     * Click on "go here"
     * Click on "500"
     * Then "500 status code" page appear
     * Click on "go here"
     */
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }
    @Test
    void clickHypeLinkSuccessfully(){

        driver.findElement(By.linkText("200")).click();
        String content200 = driver.findElement(By.cssSelector("#content p")).getText();
        Assert.assertTrue(content200.contains("This page returned a 200 status code."));
        driver.navigate().back();

        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/301");
        driver.findElement(By.linkText("here")).click();

        driver.findElement(By.linkText("404")).click();
        String content404 = driver.findElement(By.cssSelector("#content p")).getText();
        Assert.assertTrue(content404.contains("This page returned a 404 status code."));
        driver.navigate().back();

        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/500");
        driver.navigate().back();

    }
    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
