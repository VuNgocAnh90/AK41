package theInternet;

import base.Browser;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest extends TestBase {

    /**
     * 1.Open browser
     * 2.Navigate to https://the-internet.herokuapp.com/login
     * 3.Fill in username with tomsmith
     * 4.Fill in the password with SuperSecretPassword!
     * 5.Click on Login button
     * 6.And the home page is appear
     */
      LoginPage loginPage;
      @Parameters({"browser"})
      @BeforeClass
      void setup(String browser){
          Browser.openBrowser(browser);
          loginPage = new LoginPage();
      }

      @DataProvider
      Object[][] testData(){
          return new Object[][]{
                  {"tomsmith1","SuperSecretPassword!","Your username is invalid!"},
                  {"tomsmith","SuperSecretPassword","Your password is invalid!"},
                  {"tomsmith1","SuperSecretPassword","Your username is invalid!"},
                  {"tomsmith","SuperSecretPassword!","You logged into a secure area!"},
          };
      }
    @Test(dataProvider = "testData")
    void tc01(String username, String password,String message){
        loginPage.open();
        loginPage.fillForm(username,password);
        Assert.assertTrue(loginPage.getResult().contains(message));

    }

}
