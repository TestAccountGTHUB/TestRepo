package com.pfizer.testCasesIOS;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pfizer.baseTest.BaseTest;
import com.pfizer.businessLogicIOS.SharedAfibBL;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import utils.extentReports.ExtentTestManager;

public class SharedAFib extends BaseTest {
	private DesiredCapabilities capabilities;
	BaseTest baseTest;
	Properties prop = new Properties();
	String environment;
	String platform;
	InputStream input;
	SharedAfibBL sharedAFibLib;
	int riskFactorGeneration, verfiyRiskCount;
	String riskText;
	private static Logger APP_LOGS = Logger.getLogger("PfizerAppAutomationLog");

	@BeforeTest
	public void setCapabilities() {
		try {
			input = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/config.properties");
			// load a properties file
			prop.load(input);
			environment = prop.getProperty("Environment");
			platform = prop.getProperty("Platform");
			if (environment.equals("Local")) {
				setCapabilitiesIOSLocal();
			}
			if (environment.equals("Cloud")) {
				setCapabilitiesIOSCloud();
			}
		} catch (Exception e) {
			System.out.println("Exception while setting up the test capabilities");
		}
	}

	@BeforeMethod
	public void invokeDriver() {
		try {
			if (environment.equals("Local")) {
				driver = new AppiumDriver<WebElement>(new URL(getAppiumServiceUrl()), capabilities);
			} else if (environment.equals("Cloud")) {
				driver = new AppiumDriver<WebElement>(new URL("https://us1.appium.testobject.com/wd/hub"),
						capabilities);
				System.out.println(
						"Test live view: " + driver.getCapabilities().getCapability("testobject_test_live_view_url"));
				System.out.println(
						"Test report: " + driver.getCapabilities().getCapability("testobject_test_report_url"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception while invoking driver");
		}
	}

	@Test(priority = -1, description = "With Invalid Referral Code")
	public void invalidReferralcode() {
		// ExtentReports Description
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test With Invalid Referral Code",
				"Likely Risk Assessment");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.invalidReferralcode(driver, reports);
	}

	@Test(priority = 0, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelyZero() {
		// // ExtentReports Description
		riskFactorGeneration = 0;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test RiskFactor Zero",
				"Likely Risk Assessment for all possible scores-Zero");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 1, description = "Shared Afib Test E2E")
	public void riskScoreAssesmentLikelyZero() {
		// // ExtentReports Description
		riskFactorGeneration = 0;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Score Zero",
				"Likely Risk Assessment for all possible scores-Zero");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibRiskScore(driver, reports, riskFactorGeneration);
	}

	@Test(priority = 2, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelyOne() {
		// // ExtentReports Description
		riskFactorGeneration = 1;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor 1",
				"Likely Risk Assessment for all possible scores-1");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 3, description = "Shared Afib Test E2E")
	public void riskScoreAssesmentLikelyOne() {
		// // ExtentReports Description
		riskFactorGeneration = 1;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Score One",
				"Likely Risk Assessment for all possible scores-Zero");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibRiskScore(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 4, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelyTwo() {
		// // ExtentReports Description
		riskFactorGeneration = 2;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor 2",
				"Likely Risk Assessment for all possible scores-2");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 5, description = "Shared Afib Test E2E")
	public void riskScoreAssesmentLikelyTwo() {
		// // ExtentReports Description
		riskFactorGeneration = 2;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Score Two",
				"Likely Risk Assessment for all possible scores-Zero");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibRiskScore(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 6, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelyThree() {
		// // ExtentReports Description
		riskFactorGeneration = 3;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk  Factor 3",
				"Likely Risk Assessment for all possible scores-3");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 7, description = "Shared Afib Test E2E")
	public void riskScoreAssesmentLikelyThree() {
		// // ExtentReports Description
		riskFactorGeneration = 3;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Score Three",
				"Likely Risk Assessment for all possible scores-Zero");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibRiskScore(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 8, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelyFour() {
		// // ExtentReports Description
		riskFactorGeneration = 4;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor 4",
				"Likely Risk Assessment for all possible scores-4");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 9, description = "Shared Afib Test E2E")
	public void riskScoreAssesmentLikelyFour() {
		// // ExtentReports Description
		riskFactorGeneration = 4;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Score Four",
				"Likely Risk Assessment for all possible scores-Zero");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibRiskScore(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 10, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelyFive() {
		// // ExtentReports Description
		riskFactorGeneration = 5;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor 5",
				"Likely Risk Assessment for all possible scores-5");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);
	}

	@Test(priority = 11, description = "Shared Afib Test E2E")
	public void riskScoreAssesmentLikelyFive() {
		// // ExtentReports Description
		riskFactorGeneration = 5;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Score Five",
				"Likely Risk Assessment for all possible scores-Zero");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibRiskScore(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 12, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelySix() {
		// // ExtentReports Description
		riskFactorGeneration = 6;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor 6",
				"Likely Risk Assessment for all possible scores-6");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 13, description = "Shared Afib Test E2E")
	public void riskScoreAssesmentLikelySeven() {
		// // ExtentReports Description
		riskFactorGeneration = 6;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk  Score Seven",
				"Likely Risk Assessment for all possible scores-Zero");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibRiskScore(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 14, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelySeven() {
		// // ExtentReports Description
		riskFactorGeneration = 7;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor 7",
				"Likely Risk Assessment for all possible scores-7");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);
	}

	@Test(priority = 15, description = "Shared Afib Test E2E")
	public void riskScoreAssesmentLikelyEight() {
		// // ExtentReports Description
		riskFactorGeneration = 7;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Score Eight",
				"Likely Risk Assessment for all possible scores-Zero");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibRiskScore(driver, reports, riskFactorGeneration);

	}

	@AfterMethod
	public void tearDownDriver() {
		System.out.println("Stop driver");
		driver.quit();
	}

	public void setCapabilitiesIOSLocal() {
		// Set Capabilities
		try {
			input = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/iOSConfig.properties");
			prop.load(input);
			String deviceType = prop.getProperty("deviceType");
			String deviceName = prop.getProperty("deviceName");
			String osVersion = prop.getProperty("osVersion");
			String deviceUDID = prop.getProperty("deviceUDID");
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("noReset", "true");
			capabilities.setCapability("newCommandTimeout", "true");
			capabilities.setCapability("connectHardwareKeyboard", "true");
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("platformName", "iOS");
			if (deviceType.equals("simulator")) {
				capabilities.setCapability("app",
						"/Users/callsoft/Library/Developer/Xcode/DerivedData/Shared_AFib-bmahlwxrcqcbazgddfoqjhtvvhmk/Build/Products/Debug-iphonesimulator/Shared AFib.app");
			} else if (deviceType.equals("device")) {
				capabilities.setCapability("platformVersion", osVersion);
				capabilities.setCapability("udid", deviceUDID);
			}
			capabilities.setCapability("automationName", "XCUITest");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			APP_LOGS.error("Exception while Invoking Appium Service");

		}
	}

	public void setCapabilitiesIOSCloud() throws MalformedURLException {

		// Set Capabilities
		try {
			input = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/iOSConfig.properties");
			prop.load(input);
			String TestObjectApiKey = prop.getProperty("TestObjectApiKey");
			// Set Capabilities
			capabilities = new DesiredCapabilities();
			// Set my TestObject API Key
			capabilities.setCapability("testobject_api_key", TestObjectApiKey);
			// Dynamic device allocation of an Device
			capabilities.setCapability("platformName", "iOS");
			// Set allocation from private device pool only
			capabilities.setCapability("phoneOnly", "false");
			capabilities.setCapability("tabletOnly", "false");
			capabilities.setCapability("privateDevicesOnly", "false");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			APP_LOGS.error("Exception while Invoking Appium Service");
		}
	}

}
/*
     










*/