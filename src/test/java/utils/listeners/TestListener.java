package utils.listeners;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.pfizer.baseTest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import utils.extentReports.ExtentManager;
import utils.extentReports.ExtentTestManager;

public class TestListener extends BaseTest implements ITestListener, IExecutionListener {
	static Properties prop = new Properties();
	static String environment;
	static String platform;
	static InputStream input;

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("Report Start method " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", this.driver);
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("Report Finish method " + iTestContext.getName());
		// Do tier down operations for extentreports reporting!
		ExtentTestManager.endTest();
		ExtentManager.getReporter().flush();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("Report TestStart method " + getTestMethodName(iTestResult) + " start");
		// Start operation for extentreports.
		// ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),
		// "");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("Report TestSuccess method " + getTestMethodName(iTestResult) + " succeed");
		// Extentreports log operation for passed tests.
		Object testClass = iTestResult.getInstance();
		AppiumDriver<WebElement> webDriver = (AppiumDriver<WebElement>) ((BaseTest) testClass).getDriver();
		// Take base64Screenshot screenshot.
		String base64Screenshot = "data:image/png;base64,"
				+ webDriver.getScreenshotAs(OutputType.BASE64);
		// Extentreports log and screenshot operations for failed tests.
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed",
				ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("Report TestFailure method " + getTestMethodName(iTestResult) + " failed");
		// Get driver from BaseTest and assign to local webdriver variable.
		Object testClass = iTestResult.getInstance();
		@SuppressWarnings("unchecked")
		AppiumDriver<WebElement> webDriver = (AppiumDriver<WebElement>) ((BaseTest) testClass).getDriver();
		// Take base64Screenshot screenshot.
		String base64Screenshot = "data:image/png;base64,"
				+  webDriver.getScreenshotAs(OutputType.BASE64);
		// Extentreports log and screenshot operations for failed tests.
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed",
				ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("Report TestSkipped method " + getTestMethodName(iTestResult) + " skipped");
		// Extentreports log operation for skipped tests.
		ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

	@Override
	public void onExecutionStart() {
		// TODO Auto-generated method stub
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			Date date = new Date();
			input = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/config.properties");
			prop.load(input);
			// load a properties file
			environment = prop.getProperty("Environment");
			platform = prop.getProperty("Platform");
			System.setProperty("PfizerAppAutomationLog",
					System.getProperty("user.dir") + "/src/test/resources/Logs/PfizerAppAutomationLog_" + platform + "_"
							+ dateFormat.format(date) + ".log");
		} catch (Exception e) {
			System.out.println("Exception while creating Report");
		}
	}

	@Override
	public void onExecutionFinish() {
		// TODO Auto-generated method stub

	}

}
