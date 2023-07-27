package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    /**
     * 1.Open browser
     * 2.Navigate to https://the-internet.herokuapp.com/login
     * 3.Fill in username with tomsmith
     * 4.Fill in the password with SuperSecretPassword!
     * 5.Click on Login button
     * 6.And the home page is appear
     */

//    @Test
//    void successfullyWithValidCredentials(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/login");
//
//        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("button[type=submit]")).click();
//
//        //String message = driver.findElement(By.id("flash-messages")).getText();
//        //Assert.assertTrue(message.contains(" You logged into a secure area!"));
//
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
//
//        driver.quit();
//    }

}
