package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseHelper
{
    protected static WebDriver driver = getDriver();
    public static WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    protected static JavascriptExecutor js = (JavascriptExecutor) driver;
    private static WebDriver getDriver (){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1280,960");

        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    public static WebElement returnElementAttValue (String attributeName, String attributeValue)
    {
        String selector = "[" + attributeName + "=" + attributeValue + "]";
        WebElement element = driver.findElement(By.cssSelector(selector));
        return element;
    }



}
