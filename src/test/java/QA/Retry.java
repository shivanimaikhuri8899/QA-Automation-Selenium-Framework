package QA;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
    private int attempts=0;
    private int maxAttempt=3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(attempts<maxAttempt){
            System.out.println("Retrying "+iTestResult.getName());
            attempts++;
            return true;
        }

        return false;
    }
}
