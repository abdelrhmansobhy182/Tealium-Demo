package reports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String folderPath = System.getProperty("user.dir") + "/test-output/screenshots/";
            String fullPath = folderPath + screenshotName + ".png";

            FileUtils.copyFile(src, new File(fullPath));
            return "screenshots/" + screenshotName + ".png";
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
