package concortHotel.utilities;

import lombok.SneakyThrows;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " is starting");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " is completed successfully");
    }


    @SneakyThrows
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " is failed, screenshot captured");
        ReusableMethods.getScreenshotIfFails(result);
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {

    }
}
