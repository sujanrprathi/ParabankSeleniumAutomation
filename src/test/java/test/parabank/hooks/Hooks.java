package test.parabank.hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import test.parabank.reporting.ExtentReportManager;
import test.parabank.reporting.ExtentTestManager;
import test.parabank.utils.ConfigReader;
import test.parabank.utils.DriverManager;
import test.parabank.utils.ScreenShotUtil;

public class Hooks {

    private static final ConfigReader configReader = new ConfigReader();

    @Before
    public void setUp(Scenario scenario) {

            configReader.setValues();
            DriverManager.setDriver(configReader.browser);
            DriverManager.setWaitTime(configReader.wait);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().get(configReader.url);

        ExtentTestManager.startTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            String screenshotPath = ScreenShotUtil.takeFullScreenShot("FAILED"+scenario.getName());
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            ExtentTestManager.getTest().fail("Scenario Failed").addScreenCaptureFromPath(screenshotPath);
        }
        ExtentReportManager.getInstance().flush();
        DriverManager.quitDriver();
    }
}
