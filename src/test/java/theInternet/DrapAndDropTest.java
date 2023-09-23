package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DrapAndDropTest {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        actions = new Actions(driver);
    }

    @Test
    void drapAndDrop(){
        WebElement boxA = driver.findElement(By.id("column-a"));
        WebElement boxB = driver.findElement(By.id("column-b"));
        actions.dragAndDrop(boxA,boxB).perform();
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
