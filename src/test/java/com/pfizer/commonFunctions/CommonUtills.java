package com.pfizer.commonFunctions;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import utils.extentReports.ExtentManager;
import utils.extentReports.ExtentTestManager;

public class CommonUtills extends ExtentManager {

	boolean flag;
	protected String username = System.getProperty("user.name");
	protected String project_path = System.getProperty("user.dir");
	private static Logger APP_LOGS = Logger.getLogger("PfizerAppAutomationLog");

	public void waitForPageToLoad(AppiumDriver<WebElement> driver) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void pageRefresh(AppiumDriver<WebElement> driver) {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			APP_LOGS.error("Exception while refreshing page");
		}
	}

	public boolean conditionalFindElement(AppiumDriver<WebElement> driver, WebElement Element) {
		try {
			if (Element != null) {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(Element));
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			APP_LOGS.error("Exception while finding element");
		}
		return flag;
	}

	public void logOnSuccess(AppiumDriver<WebElement> driver, ExtentTest reports, String message) {
		try {
			reports.log(LogStatus.PASS, message);
			takescreenShotPass(driver);
		} catch (Exception e) {
			APP_LOGS.error("Exception while writing in Report");
		}
	}

	public void logOnError(AppiumDriver<WebElement> driver, ExtentTest reports, String message) {
		try {
			reports.log(LogStatus.FAIL, message);
			takescreenShotFail(driver);
		} catch (Exception e) {
			APP_LOGS.error("Exception while writing in Report");
		}
	}

	public boolean assertCondition(AppiumDriver<WebElement> driver, ExtentTest reports, WebElement Element,
			String message) {
		try {
			if (Element != null) {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(Element));
				flag = true;
				reports.log(LogStatus.PASS, message + " -Pass");
				takescreenShotPass(driver);
			} else {
				flag = false;
				reports.log(LogStatus.FAIL, message + " -Fail");
				takescreenShotFail(driver);
			}
			assertEquals(flag, true, Element + " is not visible");
		} catch (Exception e) {
			APP_LOGS.error("Exception while writing in Report");
		}
		return flag;
	}

	public boolean waitForElement(AppiumDriver<WebElement> driver, ExtentTest reports, WebElement Element,
			String elementName) {
		try {
			if (Element != null) {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(Element));
				reports.log(LogStatus.PASS, elementName, elementName + " is visible");
				APP_LOGS.info(elementName + " is visible");
				flag = true;
			} else {
				flag = false;
				reports.log(LogStatus.FAIL, elementName, elementName + " is not visible");
				APP_LOGS.error(elementName + " is not visible");
			}
			return flag;
		} catch (Exception ex) {
			flag = false;
			APP_LOGS.error(elementName + " is not visible");
			reports.log(LogStatus.FAIL, elementName, elementName + " is not visible");
			return flag;
		}
	}

	public boolean waitForElement(AppiumDriver<WebElement> driver, ExtentTest reports, WebElement Element,
			String elementName, int waitTime) {
		try {
			if (Element != null) {
				WebDriverWait wait = new WebDriverWait(driver, waitTime);
				wait.until(ExpectedConditions.elementToBeClickable(Element));
				reports.log(LogStatus.PASS, elementName, elementName + " is visible");
				APP_LOGS.info(elementName + " is visible");
				flag = true;
			} else {
				flag = false;
				reports.log(LogStatus.FAIL, elementName, elementName + " is not visible");
				APP_LOGS.error(elementName + " is not visible");
			}
			return flag;
		} catch (Exception ex) {
			flag = false;
			APP_LOGS.error(elementName + " is not visible");
			reports.log(LogStatus.FAIL, elementName, elementName + " is not visible");
			return flag;
		}
	}

	public boolean isElementDisplayed(AppiumDriver<WebElement> driver, ExtentTest reports, WebElement Element,
			String elementName, int waitTime) {
		try {
			if (Element != null) {
				WebDriverWait wait = new WebDriverWait(driver, waitTime);
				wait.until(ExpectedConditions.elementToBeClickable(Element));
				reports.log(LogStatus.INFO, elementName, elementName + " is Displayed");
				APP_LOGS.info(elementName + " is Displayed");
				flag = true;
			} else {
				flag = false;
				reports.log(LogStatus.INFO, elementName, elementName + " is not Displayed");
				APP_LOGS.info(elementName + " is not Displayed");
			}
		} catch (Exception e) {
			flag = false;
			APP_LOGS.info(elementName + " is Displayed");
			reports.log(LogStatus.INFO, elementName, elementName + " is not Displayed");
			return flag;
		}
		return flag;
	}

	public WebElement findElementByXpath(AppiumDriver<WebElement> driver, String xPath) {
		try {
			return driver.findElement(By.xpath(xPath));
		} catch (Exception ex) {
			return null;
		}

	}

	public boolean click(AppiumDriver<WebElement> driver, ExtentTest reports, WebElement Element, String elementName) {
		try {
			if (Element != null) {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(Element));
				Element.click();
				flag = true;
				APP_LOGS.info(elementName + " has been clicked");
				reports.log(LogStatus.INFO, elementName, elementName + " has been clicked");
			} else {
				flag = false;
				APP_LOGS.error(elementName + " can not be clicked");
				reports.log(LogStatus.FAIL, elementName, elementName + " can not be clicked");
				assertEquals(flag, "true", Element + " is not visible");
			}
			return flag;
		} catch (Exception ex) {
			APP_LOGS.error(elementName + " can not be clicked");
			reports.log(LogStatus.FAIL, elementName, elementName + " can not be clicked");
			assertEquals(flag, "true", Element + " is not visible");
			return flag;
		}
	}

	public String getTextFromElement(AppiumDriver<WebElement> driver, ExtentTest reports, WebElement Element,
			String elementName) {
		String getText = null;
		try {
			if (Element != null) {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(Element));
				getText = Element.getText();
				flag = true;
				APP_LOGS.info("Value has been fetched from " + elementName);
			} else {
				flag = false;
				APP_LOGS.error(elementName + " is not visible");
				reports.log(LogStatus.FAIL, elementName, elementName + " is not visible");
				assertEquals(flag, "true", Element + " is not visible");
			}
			return getText;
		} catch (Exception ex) {
			APP_LOGS.error(elementName + " is not visible");
			reports.log(LogStatus.FAIL, elementName, elementName + " is not visible");
			assertEquals(flag, "true", Element + " is not visible");
			return getText;
		}
	}

	public boolean typeText(AppiumDriver<WebElement> driver, ExtentTest reports, WebElement Element,
			String fieldValue) {
		try {
			if (Element != null && fieldValue != null) {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(Element));
				Element.clear();
				Element.sendKeys(fieldValue);
				flag = true;
				APP_LOGS.info(fieldValue + " is entered");
				reports.log(LogStatus.INFO, fieldValue + " is entered");
			} else {
				flag = false;
				APP_LOGS.error(fieldValue + " is not entered");
				reports.log(LogStatus.FAIL, fieldValue + " is not visible");
				assertEquals(flag, "true", fieldValue + " is not visible");
			}
			return flag;
		} catch (Exception ex) {
			APP_LOGS.error(fieldValue + " is not entered");
			reports.log(LogStatus.FAIL, Element + " is not visible");
			assertEquals(flag, "true", Element + " is not visible");
			return flag;
		}
	}

	public boolean typeTextIOS(AppiumDriver<WebElement> driver, ExtentTest reports, WebElement Element,
			String fieldValue) {
		try {
			if (Element != null) {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(Element));
				Element.clear();
				Element.sendKeys(fieldValue);
				driver.getKeyboard().pressKey("\n");
				flag = true;
				APP_LOGS.info(fieldValue + " is entered");
				reports.log(LogStatus.INFO, Element + " is entered");
			} else {
				flag = false;
				APP_LOGS.error(fieldValue + " is not entered");
				reports.log(LogStatus.FAIL, Element + " is not visible");
				assertEquals(flag, "true", Element + " is not visible");
			}

			return flag;
		} catch (Exception ex) {
			flag = false;
			APP_LOGS.error(fieldValue + " is not entered");
			reports.log(LogStatus.FAIL, Element + " is not visible");
			assertEquals(flag, "true", Element + " is not visible");
			return flag;
		}

	}

	public WebElement scrollToElementAndroidByText(AppiumDriver<WebElement> driver, String Text) {
		WebElement element;
		try {
			element = driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ Text + "\").instance(0))"));
		} catch (Exception ex) {
			return null;
		}
		return element;
	}

	public void scrollToElement(AppiumDriver<WebElement> driver) {
		JavascriptExecutor viewScroreExectuer = (JavascriptExecutor) driver;
		HashMap<String, String> scrollViewScore = new HashMap<String, String>();
		scrollViewScore.put("direction", "down");
		viewScroreExectuer.executeScript("mobile: scroll", scrollViewScore);
	}

	public void takescreenShotPass(AppiumDriver<WebElement> driver) {
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed", ExtentTestManager.getTest()
				.addBase64ScreenShot("data:image/png;base64," + driver.getScreenshotAs(OutputType.BASE64)));
	}

	public void takescreenShotFail(AppiumDriver<WebElement> driver) {
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Fail", ExtentTestManager.getTest()
				.addBase64ScreenShot("data:image/png;base64," + driver.getScreenshotAs(OutputType.BASE64)));
	}
}
