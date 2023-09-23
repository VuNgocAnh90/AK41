package theInternet;

import base.Browser;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckboxPage;

public class CheckboxTest extends TestBase {
    /**
     * 1.Check to a checkbox
     * 2.Open browser
     * 3.Navigate to:https://the-internet.herokuapp.com/checkboxes
     * 4.Check on checkbox1
     * 5.Verify checkbox1 is checked
     * 6.Check on checkbox2
     * 7.Verify checkbox2 is checked
     */
    CheckboxPage checkboxPage;

    @BeforeClass
    void setup(){
        Browser.openBrowser("chrome");
        checkboxPage = new CheckboxPage();
        checkboxPage.open();
    }

    @Test
    void selectedCheckboxSuccessfully(){
        checkboxPage.selectCheckbox1();
        Assert.assertTrue(checkboxPage.isCheckbox1Selected());

        checkboxPage.selectCheckbox2();
        Assert.assertTrue(checkboxPage.isCheckbox2Selected());

    }
    @Test
    void unselectedCheckboxSuccessfully(){
        checkboxPage.unSelectCheckbox1();
        Assert.assertFalse(checkboxPage.isCheckbox1Selected());

        checkboxPage.unSelectCheckbox2();
        Assert.assertFalse(checkboxPage.isCheckbox2Selected());

    }

}
