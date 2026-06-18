package test.parabank.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager
{
    private static ExtentReports extent;
    public static ExtentReports getInstance(){
         if(extent==null){
              String timeStamp=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
              String reportPath="target/reports/extentReport_"+timeStamp+".html";

              ExtentSparkReporter spark=new ExtentSparkReporter(reportPath);
              spark.config().setTheme(Theme.DARK);
              spark.config().setDocumentTitle("ParaBank Test Automation Report");
              spark.config().setReportName("Functional Test Report");

              extent=new ExtentReports();
              extent.attachReporter(spark);
         }
         return extent;
    }
}
