package reports;

import com.aventstack.extentreports.ExtentTest;

import java.io.IOException;

public class StepLogger {
    private static ThreadLocal<ExtentTest> currentTest = new ThreadLocal<>();

    public static void setTest(ExtentTest test) {
        currentTest.set(test);
    }

    public static void logStep(String stepDescription) {
        currentTest.get().info(stepDescription);
    }

    public static void logPass(String message) {
        currentTest.get().pass(message);
    }

    public static void logFail(String message) {
        currentTest.get().fail(message);
    }

    public static void logWithScreenshot(String message, String screenshotPath) {
        currentTest.get().addScreenCaptureFromPath(screenshotPath);
        currentTest.get().info(message);
    }
}
