package testSteps;

import common.SeleniumCommon;
import common.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.DriverManager;

public abstract class BasePageSteps extends DriverManager {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Util util;
    protected SeleniumCommon seleniumCommon;

    public BasePageSteps() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(getDriver(), 10);
        util = new Util();
        seleniumCommon = new SeleniumCommon();
    }
}