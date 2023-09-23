package pages;

import base.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static base.Browser.visit;

public class DropDownPage {
    public void open(){
        visit("https://the-internet.herokuapp.com/dropdown");
    }
    public void selectOption(String visibleText){
        Select dropdown = new Select(Browser.getElement(By.id("dropdown")));
        dropdown.selectByVisibleText(visibleText);
    }
    public boolean isOptionSelected(String visibleText){
        return Browser.isSelected(By.xpath(String.format("//select[@id='dropdown']/option[text()='%s']",visibleText)));
    }
}
