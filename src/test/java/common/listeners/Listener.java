package common.listeners;

import common.Util;
import common.model.DurationTestNG;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.Date;
import java.util.List;

public class Listener implements ISuiteListener, ITestListener, IInvokedMethodListener, IReporter {

    // This belongs to ISuiteListener and will execute before the Suite start
    @Override
    public void onStart(ISuite iSuite) {
    }

    // This belongs to ISuiteListener and will execute, once the Suite is finished
    public void onFinish(ISuite arg0) {
    }

    // This belongs to ITestListener and will execute before starting of Test set/batch
    public void onStart(ITestContext arg0) {
    }

    // This belongs to ITestListener and will execute, once the Test set/batch is finished
    public void onFinish(ITestContext iTestContext) {
        Util util = new Util();

        Reporter.log("Completed executing " + iTestContext.getName() + ", duration: " + util.getDateDiff(iTestContext.getStartDate(), iTestContext.getEndDate()), true);

        // Concat suites' execution times into durationTestNG upon each suite completion
        long currentDuration = DurationTestNG.getSuiteExecutionTime();
        DurationTestNG.setSuiteExecutionTime(currentDuration + (iTestContext.getEndDate().getTime() - iTestContext.getStartDate().getTime()));
    }

    // This belongs to ITestListener and will execute only when the test is pass
    public void onTestSuccess(ITestResult arg0) {
        printTestResults(arg0);
    }

    // This belongs to ITestListener and will execute only on the event of fail
    // test
    public void onTestFailure(ITestResult arg0) {
        // This is calling the printTestResults method
        printTestResults(arg0);
    }

    // This belongs to ITestListener and will execute before the main test start
    // (@Test)
    public void onTestStart(ITestResult arg0) {
    }

    // This belongs to ITestListener and will execute only if any of the main
    // test(@Test) get skipped
    public void onTestSkipped(ITestResult arg0) {
        printTestResults(arg0);
    }

    // This is just something not needed, ignore this
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    // This is the method which will be executed in case of test pass or fail
    // This will provide the information on the test
    private void printTestResults(ITestResult result) {
        if (result.getParameters().length != 0) {
            String params = null;
            for (Object parameter : result.getParameters()) {
                params += parameter.toString() + ",";
            }
        }

        String status = null;
        String time = null;
        switch (result.getStatus()) {

            case ITestResult.SUCCESS:
                status = "PASS";
                time = "";
                break;
            case ITestResult.FAILURE:
                status = "FAILED";
                time = " at exact time: " + new Date().toString();
                break;
            case ITestResult.SKIP:
                status = "SKIPPED";
                time = "";
        }
        Reporter.log(status + " status for test method: " + result.getMethod().getMethodName() + time, true);
    }

    // This belongs to IInvokedMethodListener and will execute before every
    // method including @Before @After @Test
    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
    }

    // This belongs to IInvokedMethodListener and will execute after every
    // method including @Before @After @Test
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    }

    // This will return method names to the calling function
    @SuppressWarnings("unused")
    private String returnMethodName(ITestNGMethod method) {
        return method.getRealClass().getSimpleName() + "." + method.getMethodName();
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
    }
}