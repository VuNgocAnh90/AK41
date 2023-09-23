package theInternet;

import base.Browser;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContentMenuPage;


public class ContentMenuTest extends TestBase {
    ContentMenuPage contentMenuPage;

    @Parameters({"browser"})
    @BeforeClass
    void setup(String browser){
        Browser.openBrowser(browser);
        contentMenuPage = new ContentMenuPage();
        contentMenuPage.open();
    }

    @Test
    void tc01(){
        contentMenuPage.openContextMenu();
        Assert.assertEquals(contentMenuPage.getAlert(),"You selected a context menu");
        contentMenuPage.acceptAlert();
    }

}
