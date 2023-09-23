package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptAlertTest {
    WebDriver driver;

    @BeforeClass
    void  setup(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    void verifyClickForJSAlert(){
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You successfully clicked an alert");
    }

    @Test
    void dismissForJsConfirm(){
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss(); // ~ click on Cancel button on alert popup

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You clicked: Cancel");
    }

    @Test
    void acceptClickForJSConfirm(){
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You clicked: Ok");
    }

    @Test
    void dismissClickForJSPrompt(){
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Wellcome to VietNam");
        driver.switchTo().alert().dismiss();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You entered: null");
    }

    @Test
    void acceptClickForJSPromptWithNotInput(){
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        //driver.switchTo().alert().sendKeys("Wellcome to VietNam");
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You entered:");
    }

    @Test
    void acceptClickForJSPromptWithInput(){
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Wellcome to VietNam");
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You entered: Wellcome to VietNam");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }

}
