package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EdgeTest {
    @Test
    void openBrowser(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev");
        Assert.assertEquals(driver.getTitle(),"selenium");
        driver.quit();
    }
}
