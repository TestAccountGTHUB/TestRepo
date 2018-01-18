package com.pfizer.businessLogicAndroid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pfizer.APIRequests.PfizerAPI;
import com.pfizer.commonFunctions.CommonUtills;
import com.pfizer.pageRepositoryAndroid.SharedAFibPL;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.android.AndroidKeyCode;

public class SharedAfibBL {
	Date startTime, endTime;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	SharedAFibPL sharedAFibPage;
	CommonUtills commonLib = new CommonUtills();
	PfizerAPI pfizerAPI = new PfizerAPI();
	boolean flag;
	String riskText, verfiyRiskCount;

	public void sharedAfibE2E(AppiumDriver<WebElement> driver, ExtentTest reports, int riskFactorGeneration) {
		sharedAFibPage = PageFactory.initElements(driver, SharedAFibPL.class);
		commonLib.assertCondition(driver, reports, sharedAFibPage.getTermAndPolicyCheckBox(), "App Opened");
		commonLib.click(driver, reports, sharedAFibPage.getTermAndPolicyCheckBox(), "Term And Policy CheckBox");
		commonLib.click(driver, reports, sharedAFibPage.getAgreeButton(), "I Agree Button");
		commonLib.click(driver, reports, sharedAFibPage.getStartButton(), "Start Button");
		commonLib.click(driver, reports, sharedAFibPage.getSkipStepLink(), "Skip Step Link");
		if (commonLib.isElementDisplayed(driver, reports, sharedAFibPage.getNewRiskQuestionnaireButton(),
				"Take New Risk Questionnaire Button", 10)) {
			commonLib.click(driver, reports, sharedAFibPage.getNewRiskQuestionnaireButton(),
					"Take New Risk Questionnaire Buttone Button");
		}
		if (commonLib.isElementDisplayed(driver, reports, sharedAFibPage.getTakeRiskQuestionnaireButton(),
				"Take Risk Questionnaire Button", 10)) {
			commonLib.logOnSuccess(driver, reports, "Take Risk Questionnaire Button");
			commonLib.click(driver, reports, sharedAFibPage.getTakeRiskQuestionnaireButton(),
					"Take Risk Questionnaire Button");
		}
		commonLib.typeText(driver, reports, sharedAFibPage.getFirstNameTextBox(), "First Name Text Box");
		commonLib.typeText(driver, reports, sharedAFibPage.getLastNameTextBox(), "Last Name Text Box");
		commonLib.click(driver, reports, sharedAFibPage.getEnterNameCheckbox(), "Enter Name CheckBox");
		commonLib.click(driver, reports, sharedAFibPage.getLetsBeginButton(), "Let's Begin Button");
		pfizerAPI.janrainAccessTokenAndroid();
		List<String> answer_list = pfizerAPI.getQuestionnaireExample(reports, riskFactorGeneration);

		Iterator<String> iterator = answer_list.iterator();
		int i = 1;
		while (iterator.hasNext()) {
			String element = (String) iterator.next();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			commonLib.click(driver, reports, commonLib.findElementByXpath(driver, sharedAFibPage.setQuestion(element)),
					"Question " + i);
			// System.out.println("Question " + i + ":::" + element);
			i++;
		}

		commonLib.click(driver, reports, sharedAFibPage.getReviewButton(), "Review Button");
		commonLib.click(driver, reports, sharedAFibPage.getContinueButton(), "Continue Button");
		if (riskFactorGeneration == 0) {
			verfiyRiskCount = commonLib.getTextFromElement(driver, reports, sharedAFibPage.getSummaryTitle(),"Summary Title");
			String zeroRiskStatement = "You do not have any risk factors for stroke";
			if (verfiyRiskCount.equals(zeroRiskStatement)) {
				commonLib.logOnSuccess(driver, reports,
						"Scuccessfully generated the " + riskFactorGeneration + " risk factor");
			} else {
				commonLib.logOnError(driver, reports, "Risk generated is not the same");
			}

		} else {
			verfiyRiskCount = commonLib
					.getTextFromElement(driver, reports, sharedAFibPage.getSummaryTitle(), "Summary Title")
					.replaceAll("[^0-9]", "");
			if (Integer.parseInt(verfiyRiskCount) == riskFactorGeneration) {
				commonLib.logOnSuccess(driver, reports,
						"Scuccessfully generated the " + riskFactorGeneration + " risk factor");
			} else {
				commonLib.logOnError(driver, reports, "Risk generated is not the same");
			}

		}
		commonLib.click(driver, reports, sharedAFibPage.getContinueForRiskFactorButton(),
				"Risk Factor Continue Button");
		commonLib.click(driver, reports, sharedAFibPage.getFAQ1(), "FAQ1");
		commonLib.click(driver, reports, sharedAFibPage.getFAQ2(), "FAQ2");
		commonLib.click(driver, reports, sharedAFibPage.getFAQ3(), "FAQ3");
		commonLib.click(driver, reports, sharedAFibPage.getSessionSummary(), "Review Session Summary");
		commonLib.click(driver, reports, sharedAFibPage.getCompleteForReviewWithHCP(), "Complete For Review with HCP");
		commonLib.waitForElement(driver, reports, sharedAFibPage.getShareWithHCP(), "Share with HCP");

	}

	public void invalidReferralcode(AppiumDriver<WebElement> driver, ExtentTest reports) {
		sharedAFibPage = PageFactory.initElements(driver, SharedAFibPL.class);
		commonLib.assertCondition(driver, reports, sharedAFibPage.getTermAndPolicyCheckBox(), "App Opened");
		commonLib.click(driver, reports, sharedAFibPage.getTermAndPolicyCheckBox(), "Term And Policy CheckBox");
		commonLib.click(driver, reports, sharedAFibPage.getAgreeButton(), "I Agree Button");
		commonLib.click(driver, reports, sharedAFibPage.getStartButton(), "Start Button");
		commonLib.typeText(driver, reports, sharedAFibPage.getReferralcode(), "1234");
		commonLib.click(driver, reports, sharedAFibPage.getContinueButtonForReferralCode(),
				"ContinueButtonForReferralCode");
		String VerifyErrorOnInvalidReferral = commonLib.getTextFromElement(driver, reports,
				sharedAFibPage.getErrorMessageForReferralCode(), "Error Message");
		String ExpectedErrorOnInvalidReferral = "Wrong code, please try again.";
		if (VerifyErrorOnInvalidReferral.equals(ExpectedErrorOnInvalidReferral)) {
			commonLib.logOnSuccess(driver, reports, "Code Is Invalid");
		} else {
			commonLib.logOnError(driver, reports, "Code is Valid");
		}

	}

	public void resumedQuestionarrie(AppiumDriver<WebElement> driver, ExtentTest reports, int riskFactorGeneration) {
		sharedAFibPage = PageFactory.initElements(driver, SharedAFibPL.class);
		commonLib.assertCondition(driver, reports, sharedAFibPage.getTermAndPolicyCheckBox(), "App Opened");
		commonLib.click(driver, reports, sharedAFibPage.getTermAndPolicyCheckBox(), "Term And Policy CheckBox");
		commonLib.click(driver, reports, sharedAFibPage.getAgreeButton(), "I Agree Button");
		commonLib.click(driver, reports, sharedAFibPage.getStartButton(), "Start Button");
		commonLib.click(driver, reports, sharedAFibPage.getSkipStepLink(), "Skip Step Link");

		if (commonLib.isElementDisplayed(driver, reports, sharedAFibPage.getNewRiskQuestionnaireButton(),
				"Take New Risk Questionnaire Button", 10)) {
			commonLib.click(driver, reports, sharedAFibPage.getNewRiskQuestionnaireButton(),
					"Take New Risk Questionnaire Buttone Button");
		}
		if (commonLib.isElementDisplayed(driver, reports, sharedAFibPage.getTakeRiskQuestionnaireButton(),
				"Take Risk Questionnaire Button", 10)) {
			commonLib.logOnSuccess(driver, reports, "Take Risk Questionnaire Button");
			commonLib.click(driver, reports, sharedAFibPage.getTakeRiskQuestionnaireButton(),
					"Take Risk Questionnaire Button");
		}
		commonLib.typeText(driver, reports, sharedAFibPage.getFirstNameTextBox(), "First Name Text Box");
		commonLib.typeText(driver, reports, sharedAFibPage.getLastNameTextBox(), "Last Name Text Box");
		commonLib.click(driver, reports, sharedAFibPage.getEnterNameCheckbox(), "Enter Name CheckBox");

		((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.HOME);
		driver.launchApp();
		commonLib.assertCondition(driver, reports, sharedAFibPage.getTermAndPolicyCheckBox(), "App Opened");
		commonLib.click(driver, reports, sharedAFibPage.getTermAndPolicyCheckBox(), "Term And Policy CheckBox");
		commonLib.click(driver, reports, sharedAFibPage.getAgreeButton(), "I Agree Button");
		commonLib.click(driver, reports, sharedAFibPage.getStartButton(), "Start Button");
		commonLib.click(driver, reports, sharedAFibPage.getSkipStepLink(), "Skip Step Link");
		commonLib.waitForElement(driver, reports, sharedAFibPage.getLetsContinueButton(), "Let's Continue Button");
	}

	public void likelyRiskAssessmentForPossibleScores(AppiumDriver<WebElement> driver, ExtentTest reports,
			int riskFactorGeneration) {
		sharedAfibE2E(driver, reports, riskFactorGeneration);
		commonLib.click(driver, reports, sharedAFibPage.getiAmWithMyHCPButton(), "I am With HCP Button");
		commonLib.click(driver, reports, sharedAFibPage.getAreYouWithHCPButton(), "Are You With HCP Button");
		commonLib.click(driver, reports, commonLib.scrollToElementAndroidByText(driver, "Confirm and View Score"),
				"Confirm And View Score Button");
		commonLib.waitForElement(driver, reports,
				commonLib.scrollToElementAndroidByText(driver, "While these EHR tools may assist"),
				"Text For Confirm And View Score Button");

	}

}