package theInternet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeCreenShootTest {
    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/V4/");
    }

    @Test
    void takeCreenShoot() throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        File DestFile=new File("target/test.png");

        FileUtils.copyFile(SrcFile, DestFile);

    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }



}
