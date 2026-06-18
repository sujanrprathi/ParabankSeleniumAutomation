package test.parabank.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class DriverManager {
    //private static WebDriver driver;
    public static ThreadLocal<WebDriver> driver= new ThreadLocal<>();
    private static WebDriverWait wait;
    public static void setDriver(String browser){
        if (driver.get()==null){
            if (Objects.equals(browser, "chrome")){
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--window-size=1920,5000");
                options.addArguments("--force-device-scale-factor=1");
                options.addArguments("--high-dpi-support=1");
                ChromeDriverService service = new ChromeDriverService.Builder()
                        .withSilent(true)
                        .build();
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(service,options));
            }
            else if(Objects.equals(browser,"edge")){
                EdgeOptions options=new EdgeOptions();
                options.addArguments("--window-size=1920,5000");
                options.addArguments("--force-device-scale-factor=1");
                options.addArguments("--high-dpi-support=1");
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver(options));
            }
        }
    }
    private static void waitForClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    private static void waitForVisible(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForFixedTime(){
       try {
           Thread.sleep(1000);
       }
       catch (Exception e){
           System.out.println(e.toString());
       }
    }
    public static void clickObject(By by){
        waitForClickable(by);
        driver.get().findElement(by).click();
    }
    public static void enterValue(By locator, String value){
        waitToBePresent(locator);
        driver.get().findElement(locator).sendKeys(value.trim());
    }

    private static void waitToBePresent(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean isDisplayed(By locator){
        waitForVisible(locator);
        return driver.get().findElement(locator).isDisplayed();
    }
    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if(driver!=null){
        driver.get().quit();
        driver.remove();}
    }

    public static void setWaitTime(int waitTime) {
        wait=new WebDriverWait(driver.get(),Duration.ofSeconds(waitTime));
    }

}
