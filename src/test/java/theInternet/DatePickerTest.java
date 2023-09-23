package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class DatePickerTest {
    WebDriver driver;
    WebDriverWait wait;

    ChromeOptions options;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.vietnamairlines.com/vn/en/home");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void dateTicket(){

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("cookie-agree"))).get(0).click();

        options.addArguments("--disable-notifications");

        driver.findElement(By.id("roundtrip-date-depart")).click();
        WebElement dateWidgetFrom = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar"))).get(0);

        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
        DateUtils.clickGivenDay(columns, DateUtils.getCurrentDay());

        driver.findElement(By.className("ui-datepicker-close")).click();

    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }




    public static class DateUtils {
        //Get The Current Day
        public static String getCurrentDay() {
            //Create a Calendar Object
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

            //Get Current Day as a number
            int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
            System.out.println("Today Int: " + todayInt + "\n");

            //Integer to String Conversion
            String todayStr = Integer.toString(todayInt);
            System.out.println("Today Str: " + todayStr + "\n");

            return todayStr;
        }

        //Click to given day
        public static void clickGivenDay(List<WebElement> elementList, String day) {
            //DatePicker is a table. Thus we can navigate to each cell
            //and if a cell matches with the current date then we will click it.
            /**Functional JAVA version of this method.*/
            elementList.stream()
                    .filter(element -> element.getText().contains(day))
                    .findFirst()
                    .ifPresent(WebElement::click);

        }
    }

}
