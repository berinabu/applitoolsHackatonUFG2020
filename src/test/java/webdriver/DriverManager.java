package webdriver;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.rendering.VisualGridEyes;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ThreadLocal<VisualGridRunner> visualRunner = new ThreadLocal<>();
    private static ThreadLocal<Eyes> webEye = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static Eyes getEyes(){return webEye.get();}

    public static void setWebEye(Eyes eye){
        webEye.set(eye);
    }

    public static VisualGridRunner getRunner(){
        return visualRunner.get();
    }

    public static void setVisualRunner(VisualGridRunner runner){
        visualRunner.set(runner);
    }
}