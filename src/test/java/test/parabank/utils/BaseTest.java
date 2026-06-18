package test.parabank.utils;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import test.parabank.reporting.ExtentReportManager;
import test.parabank.reporting.ExtentTestManager;

import java.lang.reflect.Method;

//import static jdk.nio.zipfs.ZipFileAttributeView.AttrID.method;

public class BaseTest {



    @AfterMethod
    public static void tearDown(ITestResult result) {
        if(result.getStatus()==ITestResult.FAILURE){
            ExtentTestManager.getTest().fail("Test Failed");
        }
        ExtentReportManager.getInstance().flush();
        DriverManager.quitDriver();
    }


//    public boolean verifyHomePageTitle() {
//        return DriverManager.getDriver().getTitle().equals("ParaBank | Welcome | Online Banking");
//    }

    protected void click(By locator) {
        DriverManager.clickObject(locator);
    }
    protected void waitedClick(By locator) {
        DriverManager.waitForFixedTime();
        DriverManager.clickObject(locator);
    }
    protected void enter(By locator, String text){
        DriverManager.enterValue(locator,text);
        //DriverManager.waitForFixedTime();
    }

    protected boolean isDisplayed(By locator) {
        return DriverManager.isDisplayed(locator);
    }

}