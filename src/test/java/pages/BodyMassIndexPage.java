package pages;

import base.Browser;
import org.openqa.selenium.By;

public class BodyMassIndexPage {
    private By metricTab = By.xpath("//*[.='Metric Units']");
    private By clearButton = By.className("clearbtn");
    private By ageTextBox = By.id("cage");
    private By maleRadioButton = By.cssSelector("label[for=csex1]");
    private By femaleRadioButton = By.cssSelector("label[for=csex2]");
    private By heightTextBox = By.id("cheightmeter");
    private By weightTextBox = By.id("ckg");
    private By calculatorButton = By.cssSelector("input[alt=Calculate]");
    private By resultLabel = By.cssSelector(".rightresult .bigtext > b");

    public void open(){

        Browser.visit("https://www.calculator.net/bmi-calculator.html");
    }
    public void selectMetricTab(){

        Browser.click(metricTab);
    }

    public void clearForm(){

        Browser.click(clearButton);
    }

    public void fillForm(String age, String gender, String height, String weight){
        Browser.fill(ageTextBox,age);

        if (gender.equalsIgnoreCase("male")){
            Browser.click(maleRadioButton);
        }else Browser.click(femaleRadioButton);

        Browser.fill(heightTextBox,height);
        Browser.fill(weightTextBox,weight);
        Browser.click(calculatorButton);
    }

    public String getResult(){

        return Browser.getText(resultLabel);
    }
}
