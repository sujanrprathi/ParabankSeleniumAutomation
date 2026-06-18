package test.parabank.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.HasFullPageScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtil {
    private static String timeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
    private static final String RUN_FOLDER =
            new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

    private static String buildPath(String name){
        return System.getProperty("user.dir") + "/target/screenshots/" +RUN_FOLDER+"/"+name + "_"+timeStamp() + ".png";
    }

    public static String takeScreenshot(String name){
        WebDriver driver=DriverManager.getDriver();
        File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path=buildPath(name);
        save(src,path);
        return path;
    }
    public static String takeFullScreenShot(String screenshotName) {
        try {
            String folderPath = System.getProperty("user.dir") + "/target/reports/screenshots/";
            File folder = new File(folderPath);
            if (!folder.exists()) folder.mkdirs();

            String filePath = folderPath + screenshotName + ".png";

            File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath);
            FileUtils.copyFile(src, dest);

            // Return RELATIVE path for Extent
            return "screenshots/" + screenshotName + ".png";

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public static String takeElementScreenshot(WebElement element, String name){
        File src=element.getScreenshotAs(OutputType.FILE);
        String path=buildPath(name);
        save(src,path);
        return path;
    }

    private static void save(File src, String path) {
        try {
            FileHandler.createDir(new File("target/screenshots"+"/"+RUN_FOLDER));
            FileHandler.copy(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
