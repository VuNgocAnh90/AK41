package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultiDropDownTest {
    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.get("http://jsbin.com/osebed/2");
    }
    @Test
    void multiSelectedSuccessfully(){
        Select multiSelect = new Select(driver.findElement(By.id("fruits")));
        multiSelect.selectByVisibleText("Banana");
        multiSelect.selectByIndex(1);
        multiSelect.selectByValue("orange");

        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='fruits']/option[text() ='Banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruits']/option[.='Apple']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruits']/option[.='Orange']")).isSelected());

    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }

}
