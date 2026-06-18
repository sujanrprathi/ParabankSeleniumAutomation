package test.parabank.reporting;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager
{
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentTest startTest(String name) {
        ExtentTest extentTest= ExtentReportManager.getInstance().createTest(name);
        test.set(extentTest);
        return extentTest;
    }

    public static ExtentTest getTest() {
        return test.get();
    }
}
