package base;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class TestBase {
    @AfterMethod
    protected void captureScreen(ITestResult testResult){
        if(!testResult.isSuccess()){
            Browser.captureScreen(testResult.getMethod().getMethodName());
        }
        Browser.clearLocalStorage();
    }
    @AfterClass
    protected void tearDown(){
        Browser.quit();
    }
}
