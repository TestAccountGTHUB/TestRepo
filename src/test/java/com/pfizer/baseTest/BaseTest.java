package com.pfizer.baseTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.pfizer.businessLogicIOS.SharedAfibBL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseTest {
	public AppiumDriver<WebElement> driver;
	public WebDriverWait wait;
	AppiumDriverLocalService appiumService;
	private AppiumServiceBuilder builder;
	public String appiumServiceUrl;
	Properties prop = new Properties();
	String environment;
	String platform;
	InputStream input;
	SharedAfibBL sharedAFibLib;
	int riskFactorGeneration, verfiyRiskCount;
	String riskText;
	private static Logger APP_LOGS;

	public WebDriver getDriver() {
		return driver;
	}

	public String getAppiumServiceUrl() {
		appiumServiceUrl = appiumService.getUrl().toString();
		return appiumServiceUrl;
	}

	@BeforeSuite
	public void setup() {
		APP_LOGS = Logger.getLogger("PfizerAppAutomationLog");
		try {
			input = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/config.properties");
			// load a properties file
			prop.load(input);
			environment = prop.getProperty("Environment");
			if (environment.equalsIgnoreCase("Local")) {
				invokeAppiumServiceLocal();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			APP_LOGS.error("Exception while Invoking Appium Service");
		}
	}

	@AfterSuite
	public void tearDownAppium() {
		System.out.println("Stop appium service");
		appiumService.stop();
	}

	public void invokeAppiumServiceLocal() {
		// Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("eu1.appium.testobject.com");
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
		appiumService = AppiumDriverLocalService.buildDefaultService();
		appiumService.start();
	}
}
