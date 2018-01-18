package com.pfizer.businessLogicIOS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pfizer.APIRequests.PfizerAPI;
import com.pfizer.commonFunctions.CommonUtills;
import com.pfizer.pageRepositoryIOS.SharedAFibPL;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;

public class SharedAfibBL {
	Date startTime, endTime;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	SharedAFibPL sharedAFibPageIOS;
	CommonUtills commonLib = new CommonUtills();
	PfizerAPI pfizerAPI = new PfizerAPI();
	boolean flag;

	String riskText;
	String verfiyRiskCount;

	public void invalidReferralcode(AppiumDriver<WebElement> driver, ExtentTest reports) {
		sharedAFibPageIOS = PageFactory.initElements(driver, SharedAFibPL.class);
		commonLib.assertCondition(driver, reports, sharedAFibPageIOS.getTermAndPolicyCheckBox(), "App Opened");
		commonLib.click(driver, reports, sharedAFibPageIOS.getTermAndPolicyCheckBox(), "Term And Policy CheckBox");
		commonLib.click(driver, reports, sharedAFibPageIOS.getAgreeButton(), "I Agree Button");
		commonLib.click(driver, reports, sharedAFibPageIOS.getStartButton(), "Start Button");
		commonLib.typeTextIOS(driver, reports, sharedAFibPageIOS.getReferralcode(), "1234");
		commonLib.click(driver, reports, sharedAFibPageIOS.getContinuebuttonForReferralCode(),
				"ContinueButtonForReferralCode");
		String VerifyErrorOnInvalidReferral = commonLib.getTextFromElement(driver, reports,
				sharedAFibPageIOS.getErrorMessageForReferralCode(), "Error Message");
		String ExpectedErrorOnInvalidReferral = "Wrong code, please try again.";
		if (VerifyErrorOnInvalidReferral.equals(ExpectedErrorOnInvalidReferral)) {
			commonLib.logOnSuccess(driver, reports, "Code Is Invalid");
		} else {
			commonLib.logOnError(driver, reports, "Code is Valid");
		}
	}

	public void sharedAfibE2E(AppiumDriver<WebElement> driver, ExtentTest reports, int riskFactorGeneration) {
		sharedAFibPageIOS = PageFactory.initElements(driver, SharedAFibPL.class);

		commonLib.assertCondition(driver, reports, sharedAFibPageIOS.getTermAndPolicyCheckBox(), "App Opened");
		commonLib.click(driver, reports, sharedAFibPageIOS.getTermAndPolicyCheckBox(), "Term And Policy CheckBox");
		commonLib.click(driver, reports, sharedAFibPageIOS.getAgreeButton(), "I Agree Button");
		commonLib.click(driver, reports, sharedAFibPageIOS.getStartButton(), "Start Button");
		commonLib.click(driver, reports, sharedAFibPageIOS.getSkipStepLink(), "Skip Step Link");
		if (commonLib.isElementDisplayed(driver, reports, sharedAFibPageIOS.getTakeANewQuestionnaire(),
				"Take A New Questionnaire", 10)) {
			commonLib.click(driver, reports, sharedAFibPageIOS.getTakeANewQuestionnaire(), "");
		}
		if (commonLib.isElementDisplayed(driver, reports, sharedAFibPageIOS.getTakeRiskQuestionnaireButton(),
				"Take Risk Questionnaire Button", 10)) {
			commonLib.click(driver, reports, sharedAFibPageIOS.getTakeRiskQuestionnaireButton(),
					"Take Risk Questionnaire Button");
		}
		commonLib.typeTextIOS(driver, reports, sharedAFibPageIOS.getFirstNameTextBox(), "First Name Text Box");
		commonLib.typeTextIOS(driver, reports, sharedAFibPageIOS.getLastNameTextBox(), "Last Name Text Box");
		commonLib.click(driver, reports, sharedAFibPageIOS.getEnterNameCheckbox(), "Enter Name Check box");
		commonLib.click(driver, reports, sharedAFibPageIOS.getLetsBeginButton(), "Let's Begin button");

		pfizerAPI.janrainAccessTokenAndroid();
		List<String> answer_list = pfizerAPI.getQuestionnaireExample(reports, riskFactorGeneration);
		Iterator<String> iterator = answer_list.iterator();
		int i = 1;
		int counter = 0;
		while (iterator.hasNext()) {
			String element = (String) iterator.next();
			if (element.equals("Yes") || element.equals("No")) {
				counter++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				commonLib.click(driver, reports,
						commonLib.findElementByXpath(driver, sharedAFibPageIOS.setQuestion(element, counter)),
						"Question " + i);
			} else {
				int newCounter = 1;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				commonLib.click(driver, reports,
						commonLib.findElementByXpath(driver, sharedAFibPageIOS.setQuestion(element, newCounter)),
						"Question " + i);
			}

			System.out.println("Question " + i + ":::" + element);
			i++;
		}

		commonLib.click(driver, reports, sharedAFibPageIOS.getReviewButton(), "Review  Button");
		commonLib.click(driver, reports, sharedAFibPageIOS.getSummaryButtonForRiskFactors(),
				"Continue Button For Risk Factor Button");
		if (riskFactorGeneration == 0) {
			verfiyRiskCount = commonLib.getTextFromElement(driver, reports, sharedAFibPageIOS.getSummaryTitle(),
					"Summary Title");
			// System.err.println(verfiyRiskCount);
			String zeroRiskStatement = "Based on the answers you submitted, you do not have 7 risk factors for stroke.";
			if (verfiyRiskCount.equalsIgnoreCase(zeroRiskStatement)) {
				commonLib.logOnSuccess(driver, reports, "Successfully generated the risk factor");
			} else {
				commonLib.logOnError(driver, reports, "Risk generated is not the same");
			}

		} else {
			verfiyRiskCount = commonLib
					.getTextFromElement(driver, reports, sharedAFibPageIOS.getSummaryTitle(), "Summary Title")
					.replaceAll("[^0-9]", "");

			if (Integer.parseInt(verfiyRiskCount) == riskFactorGeneration) {
				commonLib.logOnSuccess(driver, reports,
						"Scuccessfully generated the " + riskFactorGeneration + " risk factor");
			} else {
				commonLib.logOnError(driver, reports, "Risk generated is not the same");
			}

		}

		System.err.println("*************The Risk Factor is :- " + verfiyRiskCount);

		commonLib.click(driver, reports, sharedAFibPageIOS.getContinueButtonForRiskFactors(),
				"Risk Factor Continue Button");
		commonLib.click(driver, reports, sharedAFibPageIOS.getFaq1(), "FAQ1");
		commonLib.click(driver, reports, sharedAFibPageIOS.getFaq2(), "FAQ2");
		commonLib.click(driver, reports, sharedAFibPageIOS.getFaq3(), "FAQ3");
		commonLib.click(driver, reports, sharedAFibPageIOS.getSessionSummary(), "Review Session Summary");
		commonLib.click(driver, reports, sharedAFibPageIOS.getCompleteForReviewWithHCP(),
				"Complete For Review with HCP");
		commonLib.click(driver, reports, sharedAFibPageIOS.getWithMyHCP(), "I am with My HCP");
	}

	public void sharedAfibRiskScore(AppiumDriver<WebElement> driver, ExtentTest reports, int riskFactorGeneration) {
		sharedAfibE2E(driver, reports, riskFactorGeneration);
		driver.switchTo().alert().accept();
		commonLib.scrollToElement(driver);
		commonLib.click(driver, reports, sharedAFibPageIOS.getViewScore(), "View Score");
		commonLib.scrollToElement(driver);
		System.out.println(
				"Scrore Value based on Risk Factors is " + sharedAFibPageIOS.getScoreValue().getAttribute("name"));

	}
}
