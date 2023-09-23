package pages;

import base.Browser;
import org.openqa.selenium.By;

public class CheckboxPage {

    private By Checkbox1 = By.xpath("//form[@id ='checkboxes']/input[1]");
    private By Checkbox2 = By.xpath("//form[@id ='checkboxes']/input[2]");

    public void open() {

        Browser.visit("https://the-internet.herokuapp.com/checkboxes");
    }

    public void selectCheckbox1() {
        Browser.check(Checkbox1);
    }

    public void selectCheckbox2() {
        Browser.check(Checkbox2);
    }
    public void unSelectCheckbox1() {
        Browser.uncheck(Checkbox1);
    }

    public void unSelectCheckbox2() {
        Browser.uncheck(Checkbox2);
    }

    public boolean isCheckbox1Selected(){
        return Browser.isSelected(Checkbox1);
    }
    public boolean isCheckbox2Selected(){
        return Browser.isSelected(Checkbox2);
    }

}
