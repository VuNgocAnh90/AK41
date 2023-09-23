package calculator;

import base.Browser;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BodyMassIndexPage;


public class BodyMassIndexTest extends TestBase {
    BodyMassIndexPage bodyMassIndexPage;
    @Parameters({"browser"})
    @BeforeClass
    void setup(String browser){
        Browser.openBrowser(browser);
        bodyMassIndexPage = new BodyMassIndexPage();
        bodyMassIndexPage.open();
        bodyMassIndexPage.selectMetricTab();
    }
    @BeforeMethod
    void clearForm(){
        bodyMassIndexPage.clearForm();
    }

    @DataProvider
    Object[][] testData(){
        return new Object[][]{
                {"33","female","155","55","BMI = 22.9 kg/m2"},
                {"36","male","170","71","BMI = 24.6 kg/m2"},
                {"36","male","170","81","BMI = 24.6 kg/m2"},
        };
    }
    @Test(dataProvider = "testData")
    void tc01(String age, String gender, String height, String weight, String expectedResult){
        bodyMassIndexPage.fillForm(age,gender,height,weight);
        Assert.assertEquals(bodyMassIndexPage.getResult(),expectedResult);
    }


}
