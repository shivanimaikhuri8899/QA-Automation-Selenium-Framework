package QA;

import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

public class Listener implements ITestListener {
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName());

    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName());
    }

}
