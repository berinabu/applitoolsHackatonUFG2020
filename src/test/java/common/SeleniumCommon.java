package common;

import webdriver.DriverManager;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SeleniumCommon {
    public String getDeviceName() {
        switch (DriverManager.getDriver().manage().window().getSize().width) {
            case 1200:
            default:
                return "Laptop";
            case 768:
                return "Tablet";
            case 500:
                return "Mobile";
        }
    }

    public boolean hackathonReporter(int task, String testName, String domId, boolean comparisonResult) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFileName(), true))) {
            writer.write("Task: " + task + ", Test Name: " + testName + ", DOM Id: " + domId + ", Browser: " +
                    System.getProperty("browser") + ", Viewport: " + DriverManager.getDriver().manage().window().getSize() +
                    ", Device: " + getDeviceName() + ", Status: " + (comparisonResult ? "Pass" : "Fail"));
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Error writing to report file");
            e.printStackTrace();
        }

        // returns the result so that it can be used for further Assertions in the test code.
        return comparisonResult;
    }

    private String getFileName() {
        if (DriverManager.getDriver().getCurrentUrl().contains("V1"))
            return "Traditional-V1-TestResults.txt";
        else
            return "Traditional-V2-TestResults.txt";
    }
}
