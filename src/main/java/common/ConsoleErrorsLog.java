package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.ArrayList;
import java.util.Date;

public class ConsoleErrorsLog {

    private ArrayList<String> globalIgnoreList() {
        ArrayList<String> ignoreList = new ArrayList<>();
        ignoreList.add("https://www.googletagmanager.com/gtm.js?id=GTM-WD3BTPT");

        return ignoreList;
    }

    public ArrayList<String> consoleLogs(WebDriver driver) {
        ArrayList<String> consoleLogs = new ArrayList<>();

        if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

            logEntries.forEach(entry -> consoleLogs.add(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage()));
        }
        return consoleLogs;
    }

    public ArrayList<String> consoleErrors(WebDriver driver, ArrayList<String> specificIgnoreList) {
        ArrayList<String> consoleErrors = new ArrayList<>();

        if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

            ArrayList<String> globalIgnoreList = new ArrayList<>(globalIgnoreList());
            if (specificIgnoreList != null)
                globalIgnoreList.addAll(specificIgnoreList);

            for (LogEntry entry : logEntries) {
                if (entry.getLevel().toString().equalsIgnoreCase("SEVERE")) {
                    consoleErrors.add(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
                }
            }

            for (String ignoreItem : globalIgnoreList) {
                consoleErrors.removeIf(s -> s.contains(ignoreItem));
            }
        }
        return consoleErrors;
    }
}