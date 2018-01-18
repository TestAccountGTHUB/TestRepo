package com.pfizer.commonFunctions;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtils {
	

	public String CaptureScreenshot(String ScreenshotName, WebDriver driver) {
		String Path = null;

		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			Date date = new Date();
			Path = System.getProperty("user.dir")
					+ "/src/test/resources/Screenshots/" + ScreenshotName + "_"
					+ dateFormat.format(date) + ".png";
			Thread.sleep(5000);
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Path));
			return Path;

		} catch (Exception e) {
			System.out.println("Exception while taking the screenshot"
					+ e.getMessage());
		}
		return Path;

	}
}