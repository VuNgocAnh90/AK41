package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;

public class FrameTest {
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }

    @Test
    void listAllFrames(){
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");
        String leftFrame = driver.findElement(By.xpath("html/body")).getText();
        System.out.println(leftFrame);
        //Assert.assertEquals(leftFrame,"LEFT");
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        String middleFrame = driver.findElement(By.id("content")).getText();
        System.out.println(middleFrame);
        //Assert.assertEquals(middleFrame,"MIDDLE");
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        String rightFrame = driver.findElement(By.xpath("html/body")).getText();
        System.out.println(rightFrame);
        //Assert.assertEquals(rightFrame,"RIGHT");
        driver.switchTo().parentFrame();

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        String bottomFrame = driver.findElement(By.xpath("html/body")).getText();
        System.out.println(bottomFrame);
        //Assert.assertEquals(bottomFrame,"BOTTOM");

    }

    @AfterClass
    void leavePage(){
        driver.quit();
    }
}
