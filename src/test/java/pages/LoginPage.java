package pages;

import org.openqa.selenium.By;

import static base.Browser.*;

public class LoginPage {
    private By usernameTextBox = By.id("username");
    private By passwordTextBox = By.id("password");
    private By loginButton = By.cssSelector("button[type=submit]");
    private By resultLabel = By.id("flash-messages");

    public void open(){

        visit("https://the-internet.herokuapp.com/login");
    }

    public void fillForm(String username, String password){
        fill(usernameTextBox,username);
        fill(passwordTextBox,password);
        click(loginButton);
    }

    public String getResult(){

        return getText(resultLabel);
    }
}
