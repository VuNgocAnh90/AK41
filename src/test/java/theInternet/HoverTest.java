package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class HoverTest {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        actions = new Actions(driver);
    }

    @DataProvider
    public Object[][] avatar(){
        return new Object[][]{
                new Object[]{0,"name: user1"},
                new Object[]{1,"name: user2"},
                new Object[]{2,"name: user3"},
        };
    }

    @Test(dataProvider = "avatar")
    void avatarCaption(int personIndex, String caption){
        WebElement person1 = driver.findElements(By.className("figure")).get(personIndex);
        actions.moveToElement(person1).perform();

        WebElement person1Caption = person1.findElement(By.className("figcaption"))
                        .findElement(By.tagName("h5"));

        Assert.assertEquals(person1Caption.getText(), caption);
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }

    @Test
    void hoverAvatar1() {
        actions
                .moveToElement(driver.findElements(By.className("figure")).get(0))
                .perform();
    }

    @Test
    void hoverAvatar2() {
        actions
                .moveToElement(driver.findElements(By.className("figure")).get(1))
                .perform();
    }

    @Test
    void hoverAvatar3(){
        actions.moveToElement(driver.findElements(By.className("figure")).get(2))
                .perform();
    }
}
