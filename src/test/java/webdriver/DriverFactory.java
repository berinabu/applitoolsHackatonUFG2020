package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    private static DriverType selectedDriverType;

    public static WebDriver createInstance() {
        try {
            selectedDriverType = DriverType.valueOf(System.getProperty("browser").toUpperCase());

        } catch (IllegalArgumentException ignored) {
            System.err.println("Unknown driver specified, defaulting to '" + selectedDriverType + "'...");
        } catch (NullPointerException ignored) {
            System.err.println("No driver specified, defaulting to '" + selectedDriverType + "'...");
        }
        return selectedDriverType.getWebDriverObject(new DesiredCapabilities());
    }
}