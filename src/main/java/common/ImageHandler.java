package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public class ImageHandler {
    public static BufferedImage createScreenshotOfFullPage(WebDriver driver) {
        Util util = new Util();

        // Get entire page screenshot and return it as a buffered image
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        util.threadSleep(2000);
        try {
            return ImageIO.read(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createScreenshotOfWebElement(WebDriver driver, WebElement ele, String screenshotPath) throws IOException {
        // Get entire page screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location of element on the page
        Point point = ele.getLocation();

        // Get width and height of the element
        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();

        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);

        // Copy the element screenshot to disk
        File screenshotLocation = new File(screenshotPath);
        FileUtils.copyFile(screenshot, screenshotLocation);
    }

    public static BufferedImage createWebElementScreenshot(WebDriver driver, WebElement ele) throws IOException {
        // Get entire page screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location of element on the page
        Point point = ele.getLocation();

        // Get width and height of the element
        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();

        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);

        return eleScreenshot;
    }
}