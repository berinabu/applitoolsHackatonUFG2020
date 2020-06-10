package testSteps;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.DriverManager;

public abstract class BaseModernSteps extends DriverManager {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected VisualGridRunner runner;
    protected Eyes eyes;

    public BaseModernSteps() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(getDriver(), 10);
        this.runner = getRunner();
        this.eyes = getEyes();
        setUpEyes();
    }

    private void setUpEyes() {
        // Set up Eyes
        Configuration config = new Configuration();

        // You can get your api key from the Applitools dashboard
        config.setApiKey("97yPAhdbLzgQhJRdTAKCs8HKlKb3NTuHnJ4y7ZNt106PK0110");

        // create a new batch info instance and set it to the configuration
        config.setBatch(new BatchInfo("UFG Hackathon"));

        // Add browsers with different viewports
        config.addBrowser(1200, 700, BrowserType.CHROME);
        config.addBrowser(1200, 700, BrowserType.FIREFOX);
        config.addBrowser(1200, 700, BrowserType.EDGE_CHROMIUM);
        config.addBrowser(768, 700, BrowserType.CHROME);
        config.addBrowser(768, 700, BrowserType.FIREFOX);
        config.addBrowser(768, 700, BrowserType.EDGE_CHROMIUM);

        // Add mobile emulation devices in Portrait mode
        config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);

        // Set the configuration object to eyes
        eyes.setConfiguration(config);
    }
}
