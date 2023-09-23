package theInternet;

import org.testng.annotations.*;

public class DemoTest {

    @BeforeSuite
    void beforeSuite(){
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("BeforeTest");
    }

    @BeforeClass
    void beforeClass(){
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("BeforeMethod");
    }

    @Test
    void tc01(){
        System.out.println("TC01");
    }

    @Test
    void tc02(){
        System.out.println("TC02");
    }

    @Test
    void tc03(){
        System.out.println("TC03");
    }

    @Test
    void tc04(){
        System.out.println("TC04");
    }

    @Test
    void tc05(){
        System.out.println("TC05");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("AfterSuite");
    }

    @AfterTest
    void afterTest(){
        System.out.println("AfterTest");
    }

    @AfterClass
    void afterClass(){
        System.out.println("AfterClass");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("AfterMethod");
    }
}
