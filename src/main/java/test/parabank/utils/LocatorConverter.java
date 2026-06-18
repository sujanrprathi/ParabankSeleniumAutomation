package test.parabank.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LocatorConverter {
    public static WebElement convertByToWebElement(By locator){
        return DriverManager.getDriver().findElement(locator);
    }
}
