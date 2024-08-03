package Pkg.Extent;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class DummyCustomListener implements ITestListener{
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test success");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("test failed and the message is: "+result.getThrowable().getMessage());
	}
}
