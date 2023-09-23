package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class WebTableTest {
    /**
     * TODO:
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/tables
     * Focus on table 1
     * The person who has largest due is "Doe Jason"
     */

    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    void getPersonHasDueMax() {
        List<Float> dues = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(element ->
                        Float.parseFloat(element.getText().replace("$",""))
                )
                .collect(Collectors.toList());

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        List<Person> persons = rows.stream().map(this::toPerson).collect(Collectors.toList());

        Person personMaxDue =  persons
                .stream()
                        .max(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new);


        Assert.assertEquals(String.format("%s %s",
                personMaxDue.getLastName(),personMaxDue.getFirstName()),"Doe Jason");
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }

    private Person toPerson(WebElement element){
        String lastName = element.findElements(By.tagName("td")).get(0).getText();
        String firstName = element.findElements(By.tagName("td")).get(1).getText();
        String email = element.findElements(By.tagName("td")).get(2).getText();
        Float due = Float.valueOf(element.findElements(By.tagName("td")).get(3).getText().trim().replace("$", ""));
        String website = element.findElements(By.tagName("td")).get(4).getText();
        return new Person(lastName,firstName,email,due,website);
    }



}
