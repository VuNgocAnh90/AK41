package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Browser {
    private static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    private static final int TIME_OUT =30;
    public static void openBrowser(String name){
        switch (name){
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "edge": {
                driver = new EdgeDriver();
                break;
            }
            case "safari": {
                driver = new SafariDriver();
                break;
            }
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
        action = new Actions(driver);
    }

    public static void visit(String url){
        driver.get(url);
    }

    public static void check(By locator){
        if(!isSelected(locator)){
            click(locator);
        }
    }
    public static void uncheck(By locator){
        if(isSelected(locator)){
            click(locator);
        }
    }

    public static void rightClick(By locator){
        action.contextClick(driver.findElement(locator)).perform();
    }

    public static void doubleClick(By locator){
        action.doubleClick(driver.findElement(locator)).perform();
    }
    public static void executeScript(String script, Object... arguments) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, arguments);
    }
    public static void clearLocalStorage(){
        LocalStorage session = ((WebStorage) driver).getLocalStorage();
        session.clear();
    }

    public static boolean isDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    public static boolean isEnabled(By locator){
        return driver.findElement(locator).isEnabled();
    }

    public static boolean isSelected(By locator){
        return driver.findElement(locator).isSelected();
    }

    public static void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public static void fill(By locator, CharSequence... withText){
        driver.findElement(locator).sendKeys(withText);
    }
    public static List<WebElement> all(By locator){
        return driver.findElements(locator);
    }

    public static String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }
    public static void refresh(){
        driver.navigate().refresh();
    }
    public static void hover(By locator){
        action.moveToElement(getElement(locator)).perform();
    }


    public static void quit(){
        if(driver!=null){
            driver.quit();
        }
    }

    public static void captureScreen(String name){
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-ns");
        File DestFile=new File(String.format("target/%s-%s.png",
                name,
                myDateObj.format(myFormatObj)));
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
