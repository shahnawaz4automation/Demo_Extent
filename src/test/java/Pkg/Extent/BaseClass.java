package Pkg.Extent;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//https://youtu.be/ZsmFrHMeuqw
//Extent report site notes - https://extentreports.com/docs/versions/5/java/index.html
public class BaseClass {
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;

	@BeforeClass
	public void initializeDriver() {
		driver = new ChromeDriver();
		driver.get("http:/www.google.com");
	}

	public void initializeReport() {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/extentSparkReport.html");
		sparkReporter.config().setDocumentTitle("AutomationReport");
		sparkReporter.config().setReportName("Automation Test Execution Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter); //using the extent reference we are attaching a report which is of type spark
	}

	public static String captureScreenshot(WebDriver driver) throws IOException {
		String FileSeparator = System.getProperty("file.separator"); // On Windows, it returns a backslash (\).
		String Extent_report_path = "." + FileSeparator + "Reports";
		String ScreenshotPath = Extent_report_path + FileSeparator + "screenshots";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotName = "screenshot" + Math.random() + ".png";
		String screenshotpath = ScreenshotPath + FileSeparator + screenshotName;
		File trg = new File(screenshotpath);
		FileUtils.copyFile(src, trg);
		return "." + FileSeparator + "screenshots" + FileSeparator + screenshotName;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}