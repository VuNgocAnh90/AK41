package theInternet;

import base.Browser;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DropDownPage;

public class DropDownTest extends TestBase {
    /**
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/dropdown
     * Select "option 1"
     * Validate "option 1" is selected
     */
    DropDownPage dropDownPage;

    @Parameters({"browser"})
    @BeforeClass
    void setup(String browser){
        Browser.openBrowser(browser);
        dropDownPage = new DropDownPage();
        dropDownPage.open();
    }
    @BeforeMethod
    void refreshOption(){
        Browser.refresh();
    }
    @DataProvider
    Object[][] testData(){
       return new Object[][]{
               {"Option 1"},
               {"Option 2"},
       };
    }
    @Test(dataProvider = "testData")
  void optionSelectedSuccessfully(String visibleText) {
        dropDownPage.selectOption(visibleText);
        Assert.assertTrue(dropDownPage.isOptionSelected(visibleText));
    }
}
