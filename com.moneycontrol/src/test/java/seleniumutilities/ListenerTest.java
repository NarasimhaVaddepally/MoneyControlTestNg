package seleniumutilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test run is successfull");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Test run Finished");
		
	}

}
