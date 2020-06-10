package common;

import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({"Duplicates", "unused"})
public class Util {
    public void threadSleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getDateDiff(Date date1, Date date2) {
        long duration = date2.getTime() - date1.getTime();

        return String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(duration), TimeUnit.MILLISECONDS.toMinutes(duration), TimeUnit.MILLISECONDS.toSeconds(duration));
    }

    public String getLongDiff(long startTime, long endTime) {
        long duration = endTime - startTime;

        return String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(duration), TimeUnit.MILLISECONDS.toMinutes(duration), TimeUnit.MILLISECONDS.toSeconds(duration));
    }

    public String getDurationFromMilliSeconds(long duration) {
        return String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(duration), TimeUnit.MILLISECONDS.toMinutes(duration), TimeUnit.MILLISECONDS.toSeconds(duration));
    }

    public static synchronized File getScreenshotTempFile(WebDriver driver) {
        return getScreenshotFile(driver, new File("screenshotTmp.png"));
    }

    public static synchronized File getScreenshotTempFile(WebDriver driver, String pngFileName) {
        return getScreenshotFile(driver, new File(pngFileName));
    }

    private static File getScreenshotFile(WebDriver driver, File screenshotTaken) {
        try {
            ImageIO.write(Objects.requireNonNull(ImageHandler.createScreenshotOfFullPage(driver)), "png", screenshotTaken);
            return screenshotTaken;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}