package common.listeners;

import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import common.ConsoleErrorsLog;
import common.Util;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import webdriver.DriverFactory;
import webdriver.DriverManager;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DriverListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            try {
                WebDriver driver = DriverFactory.createInstance();
                DriverManager.setWebDriver(driver);

                if (testResult.getTestClass().getName().startsWith("ModernTests")) {
                    VisualGridRunner runner = new VisualGridRunner(10);
                    Eyes eyes = new Eyes(runner);
                    DriverManager.setVisualRunner(runner);
                    DriverManager.setWebEye(eyes);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!testResult.isSuccess()) {
            ConsoleErrorsLog consoleErrorsLog = new ConsoleErrorsLog();

            ArrayList consoleLogs = consoleErrorsLog.consoleLogs(DriverManager.getDriver());
            String consoleLog = "";
            for (Object s : consoleLogs) {
                consoleLog += "<p>" + s + "</p>";
            }

            Reporter.log("FAILURE AT: <a href='" + DriverManager.getDriver().getCurrentUrl() + "'>" + DriverManager.getDriver().getCurrentUrl() + "</a><br>");
            Reporter.log("BROWSER CONSOLE LOG: " + consoleLog);
            try {
                String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
                File screenshotTempFile = Util.getScreenshotTempFile(DriverManager.getDriver(), "target/Error" + timeStamp + ".png");
                Allure.addAttachment("Error.png", FileUtils.openInputStream(screenshotTempFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (method.isTestMethod()) {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null)
                driver.quit();

            Eyes eyes = DriverManager.getEyes();
            if (eyes != null) {
                eyes.closeAsync();
                eyes.abortAsync();
            }

            VisualGridRunner runner = DriverManager.getRunner();
            if (runner != null) {
                TestResultsSummary allTestResults = runner.getAllTestResults(false);
                System.out.println(allTestResults);
            }
        }
    }
}