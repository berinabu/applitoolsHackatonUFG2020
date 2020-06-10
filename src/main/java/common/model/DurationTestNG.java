package common.model;

public class DurationTestNG {
    private static long suiteExecutionTime;

    public DurationTestNG() {
    }

    public static long getSuiteExecutionTime() {
        return suiteExecutionTime;
    }

    public static void setSuiteExecutionTime(long suiteExecutionTime) {
        DurationTestNG.suiteExecutionTime = suiteExecutionTime;
    }
}