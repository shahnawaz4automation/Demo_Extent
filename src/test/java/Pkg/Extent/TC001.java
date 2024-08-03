package Pkg.Extent;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TC001 extends BaseClass {
	@BeforeTest
	public void startReporter() {
		initializeReport();
	}

	@Test
	public void f1() {
		String methodName = new Exception().getStackTrace()[0].getMethodName();
		// String className = new Exception().getStackTrace()[0].getClassName();

		test = extent.createTest(methodName, "Launch browser and website").assignAuthor("shahnawaz")
				.assignCategory("Smoke Test").assignDevice("chrome");
		test.log(Status.PASS, "user lauched website");
		test.pass("user lauched website verified");
	}

	@Test
	public void f2() {
		String methodName = new Exception().getStackTrace()[0].getMethodName();

		test = extent.createTest(methodName, "Verify login").assignAuthor("shahnawaz").assignCategory("Regression Test")
				.assignDevice("firefox");
		test.info("alerts displaying");
		test.pass("User logged into application");
		test.warning("Reset password alerts displaying");
		Assert.assertTrue(false);
	}

	@Test
	public void f3() {
		String methodName = new Exception().getStackTrace()[0].getMethodName();

		test = extent.createTest(methodName, "Verify Dashboard").assignAuthor("shahnawaz").assignCategory("Sanity Test")
				.assignDevice("ie");
		test.skip("verify dashboard skipped");
	}

	@Test
	public void f4() {
		String methodName = new Exception().getStackTrace()[0].getMethodName();

		test = extent.createTest(methodName, "Verify user send emails from test application").assignAuthor("kalim")
				.assignCategory("Business Test").assignDevice("edge");
		test.fail("unable to send email due as server is down");
	}

	@Test
	public void f5() {
		String methodName = new Exception().getStackTrace()[0].getMethodName();

		test = extent.createTest(methodName, "Verify reports and analytics").assignAuthor("kalim")
				.assignCategory("Functional Test").assignDevice("Safari");
		test.fail("reports getting failed");
	}

	@Test
	public void f6() {
		String methodName = new Exception().getStackTrace()[0].getMethodName();

		test = extent.createTest(methodName, "Verify logout feature").assignAuthor("usman").assignCategory("Smoke Test")
				.assignDevice("chrome");
		test.fail("user logged out of the application");
		test.info("user is directed to login page");
	}
	
	@AfterTest
	public void endReport() {
		extent.flush(); // it will flush/delete previous data in the report and each time a new report
						// is
						// Saving the Report: saving the final test report, ensuring that all logged
						// information is correctly written out and the report is finalized.
		// it saves all the information accumulated in the report object to the
		// underlying report file.
	}
}
