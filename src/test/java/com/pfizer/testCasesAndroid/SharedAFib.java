package com.pfizer.testCasesAndroid;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pfizer.baseTest.BaseTest;
import com.pfizer.businessLogicAndroid.SharedAfibBL;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
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
			System.out.println("Setting Capabilities " + environment);
			if (environment.equalsIgnoreCase("Local")) {
				setCapabilitiesAndroidLocal();
			}
			if (environment.equalsIgnoreCase("Cloud")) {
				setCapabilitiesAndroidCloud();
			}

		} catch (Exception e) {
			System.out.println("Exception while setting up the test capabilities");
		}
	}

	@BeforeMethod
	public void invokeDriver() {
		try {
			if (environment.equalsIgnoreCase("Local")) {
				driver = new AppiumDriver<WebElement>(new URL(getAppiumServiceUrl()), capabilities);
				driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			}
			if (environment.equalsIgnoreCase("Cloud")) {
				driver = new AppiumDriver<WebElement>(new URL("https://us1.appium.testobject.com/wd/hub"),
						capabilities);
				System.out.println(
						"Test live view: " + driver.getCapabilities().getCapability("testobject_test_live_view_url"));
				System.out.println(
						"Test report: " + driver.getCapabilities().getCapability("testobject_test_report_url"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception while invoking driver");
		}
	}

	@Test(priority = -1, description = "With Invalid Referral Code")
	public void invalidReferralcode() { // // ExtentReports
		// Description
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test With Invalid Referral Code",
				"Likely Risk Assessment");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.invalidReferralcode(driver, reports);
	}

	@Test(priority = 0, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelyZero() { // // ExtentReports
											// Description
		riskFactorGeneration = 0;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor Zero",
				"Likely Risk Assessment For Risk Factor Zero");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 1, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelyOne() { // // ExtentReports
											// Description
		riskFactorGeneration = 1;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor 1",
				"Likely Risk Assessment For Risk Factor 1");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 2, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelyTwo() { // ExtentReports
											// Description
		riskFactorGeneration = 2;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor 2",
				"Likely Risk Assessment For Risk Factor 2");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 3, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelyThree() { // //
												// ExtentReports
												// Description
		riskFactorGeneration = 3;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor 3",
				"Likely Risk Assessment For Risk Factor 3");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 4, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelyFour() { // // ExtentReports
											// Description
		riskFactorGeneration = 4;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor 4",
				"Likely Risk Assessment For Risk Factor 4");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 5, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelyFive() { // // ExtentReports
											// Description
		riskFactorGeneration = 5;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor 5",
				"Likely Risk Assessment For Risk Factor 5");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);
	}

	@Test(priority = 6, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelySix() { // // ExtentReports
											// Description
		riskFactorGeneration = 6;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor 6",
				"Likely Risk Assessment For Risk Factor 6");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);

	}

	@Test(priority = 7, description = "Shared Afib Test E2E")
	public void riskAssesmentLikelySeven() {
		// // ExtentReports Description
		riskFactorGeneration = 7;
		ExtentTest reports = ExtentTestManager.startTest("Shared Afib Test Risk Factor 7",
				"Likely Risk Assessment For Risk Factor 7");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.sharedAfibE2E(driver, reports, riskFactorGeneration);
	}

	@Test(priority = 8, description = "Saved Questionnaire Resumed After Version Update")
	public void savedQuestoinnaireResumedAfterVersionUpdate() {
		// ExtentReports Description
		riskFactorGeneration = 5;
		ExtentTest reports = ExtentTestManager.startTest("Saved Questionnaire Resumed After Version Update",
				"Saved Questionnaire Resumed After Version Update");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.resumedQuestionarrie(driver, reports, riskFactorGeneration);
	}

	@Test(priority = 9, description = "Likely Risk Assessment For Possible Scores Zero")
	public void likelyRiskAssessmentForPossibleScoresZero() {
		riskFactorGeneration = 0;
		ExtentTest reports = ExtentTestManager.startTest("Likely Risk Assessment For Possible Scores Zero",
				"Likely Risk Assessment For Possible Scores Zero");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.likelyRiskAssessmentForPossibleScores(driver, reports, riskFactorGeneration);
	}

	@Test(priority = 10, description = "Likely Risk Assessment For Possible Scores-1")
	public void likelyRiskAssessmentForPossibleScoresOne() {
		riskFactorGeneration = 1;
		ExtentTest reports = ExtentTestManager.startTest("Likely Risk Assessment For Possible Scores-1",
				"Likely Risk Assessment For Possible Scores-1");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.likelyRiskAssessmentForPossibleScores(driver, reports, riskFactorGeneration);
	}

	@Test(priority = 11, description = "Likely Risk Assessment For Possible Scores-2")
	public void likelyRiskAssessmentForPossibleScoresTwo() {
		riskFactorGeneration = 2;
		ExtentTest reports = ExtentTestManager.startTest("Likely Risk Assessment For Possible Scores-2",
				"Likely Risk Assessment For Possible Scores-2");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.likelyRiskAssessmentForPossibleScores(driver, reports, riskFactorGeneration);
	}

	@Test(priority = 12, description = "Likely Risk Assessment For Possible Scores-3")
	public void likelyRiskAssessmentForPossibleScoresThree() {
		riskFactorGeneration = 3;
		ExtentTest reports = ExtentTestManager.startTest("Likely Risk Assessment For Possible Scores-3",
				"Likely Risk Assessment For Possible Scores-3");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.likelyRiskAssessmentForPossibleScores(driver, reports, riskFactorGeneration);
	}

	@Test(priority = 13, description = "Likely Risk Assessment For Possible Scores-4")
	public void likelyRiskAssessmentForPossibleScoresFour() {
		riskFactorGeneration = 4;
		ExtentTest reports = ExtentTestManager.startTest("Likely Risk Assessment For Possible Scores-4",
				"Likely Risk Assessment For Possible Scores-4");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.likelyRiskAssessmentForPossibleScores(driver, reports, riskFactorGeneration);
	}

	@Test(priority = 14, description = "Likely Risk Assessment For Possible Scores-5")
	public void likelyRiskAssessmentForPossibleScoresFive() {
		riskFactorGeneration = 5;
		ExtentTest reports = ExtentTestManager.startTest("Likely Risk Assessment For Possible Scores-5",
				"Likely Risk Assessment For Possible Scores-5");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.likelyRiskAssessmentForPossibleScores(driver, reports, riskFactorGeneration);
	}

	@Test(priority = 15, description = "Likely Risk Assessment For Possible Scores-7")
	public void likelyRiskAssessmentForPossibleScoresSeven() {
		riskFactorGeneration = 6;
		ExtentTest reports = ExtentTestManager.startTest("Likely Risk Assessment For Possible Scores-7",
				"Likely Risk Assessment For Possible Scores-7");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.likelyRiskAssessmentForPossibleScores(driver, reports, riskFactorGeneration);
	}

	@Test(priority = 16, description = "Likely Risk Assessment For Possible Scores-8")
	public void likelyRiskAssessmentForPossibleScoresEight() {
		riskFactorGeneration = 7;
		ExtentTest reports = ExtentTestManager.startTest("Likely Risk Assessment For Possible Scores-8",
				"Likely Risk Assessment For Possible Scores-8");
		SharedAfibBL sharedAFibLib = new SharedAfibBL();
		sharedAFibLib.likelyRiskAssessmentForPossibleScores(driver, reports, riskFactorGeneration);
	}

	@AfterMethod
	public void tearDownDriver() {
		System.out.println("Stop driver");
		driver.quit();
	}

	public void setCapabilitiesAndroidLocal() {
		try {
			input = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/androidConfig.properties");

			prop.load(input);
			String deviceName = prop.getProperty("deviceName");
			String osVersion = prop.getProperty("osVersion");
			// Set Capabilities
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", osVersion);
			capabilities.setCapability("newCommandTimeout", 300000);
		        capabilities.setCapability("skipUnlock", true);
		        capabilities.setCapability("unicodeKeyboard", true);
		        capabilities.setCapability("resetKeyboard", true);
			capabilities.setCapability("app",
					System.getProperty("user.dir") + "/src/test/resources/APK/SharedAfib.apk");
			capabilities.setCapability("appPackage", "com.pfizer.us.sharedafib");
			capabilities.setCapability("appActivity", "com.pfizer.us.sharedafib.features.splash.SplashActivity");
			capabilities.setCapability("fullReset", "true");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			APP_LOGS.error("Exception while Invoking Appium Service");
		}

	}

	public void setCapabilitiesAndroidCloud() throws MalformedURLException {
		try {
			input = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/androidConfig.properties");

			prop.load(input);
			String TestObjectApiKey = prop.getProperty("TestObjectApiKey");
			// Set Capabilities
			capabilities = new DesiredCapabilities();
			// Set my TestObject API Key
			capabilities.setCapability("testobject_api_key", TestObjectApiKey);
			// Dynamic device allocation of an Device
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("unicodeKeyboard", "true");
			capabilities.setCapability("resetKeyboard", "true");
			// capabilities.setCapability("platformVersion", "8.0.0");
			// capabilities.setCapability("deviceName", "LG Nexus 5X");
			// Set allocation from private device pool only
			capabilities.setCapability("phoneOnly", "false");
			capabilities.setCapability("tabletOnly", "false");
			capabilities.setCapability("privateDevicesOnly", "false");
			// Set Application under test
			// capabilities.setCapability("testobject_app_id", "1");
			// capabilities.setCapability("name", "SharedAFib Android Test");
			// Set Appium version
			// capabilities.setCapability("appiumVersion", "1.7.1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			APP_LOGS.error("Exception while setting capabilities");
		}

	}
}
