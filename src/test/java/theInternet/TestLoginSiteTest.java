package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestLoginSiteTest {

    @Test
    void testLoginSuccessfullyWithSiteTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://d5uenqsch6qdo.cloudfront.net/#/login");

        driver.findElement(By.id("input-11")).sendKeys("ngocanh@vn-cubesystem.com");
        driver.findElement(By.id("input-14")).sendKeys("Csv123456");
        driver.findElement(By.id("btnLogin")).click();

        Thread.sleep(3000);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(),"https://d5uenqsch6qdo.cloudfront.net/#/home");

        driver.quit();
    }


}
