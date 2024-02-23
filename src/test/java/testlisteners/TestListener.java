package testlisteners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import commonutils.Contstants;


public class TestListener implements ITestListener {

	private ExtentReports extent = ExtentManager.createInstance();

	private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public void onStart(ITestContext context) {
		System.out.println("Started");
	}

	public void onFinish(ITestContext context) {
		Contstants.driver.quit();
		extent.flush();
		System.out.println("Test Finished");
		
	}

	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
		System.out.println("Test Started");
	}

	public void OnTestSuccess(ITestContext context) {
		test.get().pass("Test Passed");
		System.out.println("Passed");
	}

	public void onTestFailure(ITestResult resultt) {
		Contstants.driver.quit();
		test.get().fail(resultt.getThrowable());
		System.out.println("Failed");
		
	}

	public void onTestSkipped(ITestContext context) {
		Contstants.driver.quit();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestContext context) {
		Contstants.driver.quit();
	}

}
