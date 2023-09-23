package pages;

import base.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static base.Browser.visit;
import static base.Browser.wait;

public class ContentMenuPage {
    private By square = By.id("hot-spot");
    public void open(){
        visit("https://the-internet.herokuapp.com/context_menu");
    }
    public void openContextMenu(){
        Browser.rightClick(square);
    }
    public String getAlert(){
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }
    public void acceptAlert(){
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
}
