package com.pfizer.pageRepositoryIOS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SharedAFibPL {

	@FindBy(name = "checkbox")
	private WebElement termAndPolicyCheckBox;

	@FindBy(name = "I agree")
	private WebElement agreeButton;

	@FindBy(name = "Start")
	private WebElement startButton;

	@FindBy(name = "Skip Step")
	private WebElement skipStepLink;

	@FindBy(name = "Take Risk Questionnaire")
	private WebElement takeRiskQuestionnaireButton;

	@FindBy(xpath = "//*[@value='First Name']")
	private WebElement firstNameTextBox;

	@FindBy(xpath = "//*[@value='Last Name']")
	private WebElement lastNameTextBox;

	@FindBy(name = "caregiverCheckbox")
	private WebElement enterCaregiverCheckbox;

	@FindBy(name = "Let's Begin")
	private WebElement letsBeginButton;

	@FindBy(name = "Review")
	private WebElement reviewButton;

	@FindBy(name = "Summarize My Risk Factors")
	private WebElement summaryButtonForRiskFactors;

	@FindBy(name = "Continue")
	private WebElement continueButtonForRiskFactors;

	@FindBy(xpath = "//*[contains(@name,'Based on the answers you submitted')]")
	private WebElement summaryTitle;
	
	@FindBy(xpath = "//*[contains(@name,'you do not have')]")
	private WebElement summaryTitleZero;

	@FindBy(xpath = "//*[contains(@name,'How might my condition or my medication')]")
	private WebElement faq1;

	@FindBy(xpath = "//*[contains(@name,'Should I avoid any food')]")
	private WebElement faq2;

	@FindBy(xpath = "//*[contains(@name,'I’d like to learn more about my diagnosis')]")
	private WebElement faq3;

	@FindBy(name = "Review My Session Summary")
	private WebElement sessionSummary;

	@FindBy(name = "Complete for review with HCP")
	private WebElement completeForReviewWithHCP;

	@FindBy(xpath = "//*[@value='Enter Code']")
	private WebElement referralcode;

	@FindBy(name = "Continue")
	private WebElement continuebuttonForReferralCode;

	@FindBy(name = "Take A New Questionnaire")
	private WebElement takeANewQuestionnaire;
	
	public WebElement getTakeANewQuestionnaire() {
		return takeANewQuestionnaire;
	}
	
	@FindBy(name = "I'm with My Health Care Provider")
	private WebElement withMyHCP;
	
	public WebElement getWithMyHCP() {
		return withMyHCP;
	}

	public String setQuestion(String text, int i) {
		String questionXpathText = "(//XCUIElementTypeButton[@name='" + text + "'])[" + i + "]";
		return questionXpathText;
	}
	

	@FindBy(name = "Confirm and View Score")
	private WebElement viewScore;
	
	public WebElement getViewScore() {
		return viewScore;
	}
	@FindBy(name = "Wrong code, please try again.")
	private WebElement errorMessageForReferralCode;

	@FindBy(xpath = "//*[contains(@name,'detailed_score')]")
	private WebElement scoreValue;

	public WebElement getScoreValue() {
		return scoreValue;
	}
	
	public WebElement getTermAndPolicyCheckBox() {
		return termAndPolicyCheckBox;
	}

	public WebElement getAgreeButton() {
		return agreeButton;
	}

	public WebElement getStartButton() {
		return startButton;
	}

	public WebElement getSkipStepLink() {
		return skipStepLink;
	}

	public WebElement getTakeRiskQuestionnaireButton() {
		return takeRiskQuestionnaireButton;
	}

	public WebElement getFirstNameTextBox() {
		return firstNameTextBox;
	}

	public WebElement getLastNameTextBox() {
		return lastNameTextBox;
	}

	public WebElement getEnterNameCheckbox() {
		return enterCaregiverCheckbox;
	}

	public WebElement getLetsBeginButton() {
		return letsBeginButton;
	}

	public WebElement getReviewButton() {
		return reviewButton;
	}

	public WebElement getEnterCaregiverCheckbox() {
		return enterCaregiverCheckbox;
	}

	public WebElement getSummaryButtonForRiskFactors() {
		return summaryButtonForRiskFactors;
	}

	public WebElement getFaq1() {
		return faq1;
	}

	public WebElement getFaq2() {
		return faq2;
	}

	public WebElement getFaq3() {
		return faq3;
	}

	public WebElement getContinuebuttonForReferralCode() {
		return continuebuttonForReferralCode;
	}

	public WebElement getSessionSummary() {
		return sessionSummary;
	}

	public WebElement getCompleteForReviewWithHCP() {
		return completeForReviewWithHCP;
	}

	public WebElement getReferralcode() {
		return referralcode;
	}

	public WebElement getErrorMessageForReferralCode() {
		return errorMessageForReferralCode;
	}

	public WebElement getSummaryTitle() {
		return summaryTitle;
	}
	
	public WebElement getSummaryTitleZero() {
		return summaryTitleZero;
	}


	public WebElement getContinueButtonForRiskFactors() {
		return continueButtonForRiskFactors;
	}
}
