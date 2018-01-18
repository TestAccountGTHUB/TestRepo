package com.pfizer.pageRepositoryAndroid;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SharedAFibPL {

	@FindBy(id = "com.pfizer.us.sharedafib:id/on_boarding_terms")
	private WebElement termAndPolicyCheckBox;

	@FindBy(id = "com.pfizer.us.sharedafib:id/terms_agree")
	private WebElement agreeButton;

	@FindBy(id = "com.pfizer.us.sharedafib:id/on_boarding_start")
	private WebElement startButton;

	@FindBy(id = "com.pfizer.us.sharedafib:id/organization_code_skip")
	private WebElement skipStepLink;

	@FindBy(id = "com.pfizer.us.sharedafib:id/self_assessment_take")
	private WebElement takeRiskQuestionnaireButton;

	@FindBy(xpath = "//*[@class='android.widget.EditText' and @text='First Name']")
	private WebElement firstNameTextBox;

	@FindBy(xpath = "//*[@class='android.widget.EditText' and @text='Last Name']")
	private WebElement lastNameTextBox;

	@FindBy(xpath = "//*[@class='android.widget.CheckBox' and @text= 'Caregiver']")
	private WebElement enterNameCheckbox;

	@FindBy(id = "com.pfizer.us.sharedafib:id/questionnaire_begin")
	private WebElement letsBeginButton;

	@FindBy(id = "com.pfizer.us.sharedafib:id/questionnaire_review")
	private WebElement reviewButton;

	public WebElement getSummaryTitle() {
		return summaryTitle;
	}

	@FindBy(id = "com.pfizer.us.sharedafib:id/review_continue")
	private WebElement continueButton;

	@FindBy(id = "com.pfizer.us.sharedafib:id/risk_factors_continue")
	private WebElement continueforriskfactorButton;

	@FindBy(id = "com.pfizer.us.sharedafib:id/risk_factor_summary_title")
	private WebElement summaryTitle;

	@FindBy(xpath = "//*[@class='android.widget.LinearLayout' and @index='2']")
	private WebElement faq1;

	@FindBy(xpath = "//*[@class='android.widget.LinearLayout' and @index='4']")
	private WebElement faq2;

	@FindBy(xpath = "//*[@class='android.widget.LinearLayout' and @index='1']")
	private WebElement faq3;

	@FindBy(id = "com.pfizer.us.sharedafib:id/questions_for_doctors_review")
	private WebElement sessionSummary;

	@FindBy(id = "com.pfizer.us.sharedafib:id/risk_factors_continue")
	private WebElement completeForReviewWithHCP;

	@FindBy(id = "com.pfizer.us.sharedafib:id/organization_code_code")
	private WebElement referralcode;

	@FindBy(id = "com.pfizer.us.sharedafib:id/questionnaire_complete_take_new")
	private WebElement newRiskQuestionnaireButton;

	@FindBy(id = "com.pfizer.us.sharedafib:id/organization_code_submit")
	private WebElement continuebuttonForReferralCode;

	@FindBy(id = "com.pfizer.us.sharedafib:id/organization_code_error")
	private WebElement errorMessageForReferralCode;

	@FindBy(id = "com.pfizer.us.sharedafib:id/questionnaire_complete_share")
	private WebElement ShareWithHCP;

	@FindBy(id = "com.pfizer.us.sharedafib:id/questionnaire_complete_continue")
	private WebElement letsContinueButton;
	
	@FindBy(id = "com.pfizer.us.sharedafib:id/questionnaire_complete_with_hcp")
	private WebElement iAmWithMyHCPButton;
	
	@FindBy(id = "android:id/button1")
	private WebElement areYouWithHCPButton;
	
	@FindBy(id = "com.pfizer.us.sharedafib:id/hcp_review_score_confirm")
	private WebElement confirmAndViewScoreButton;
	
	@FindBy(id = "com.pfizer.us.sharedafib:id/hcp_review_score_notice")
	private WebElement textForConfirmAndViewScoreButton;

	public String setQuestion(String text) {
		String questionXpathText = "//*[@class='android.widget.Button' and @text='" + text + "']";
		return questionXpathText;
	}           
	
	public WebElement getTextForConfirmAndViewScoreButton() {
		return textForConfirmAndViewScoreButton;
	}

	public WebElement getConfirmAndViewScoreButton() {
		return confirmAndViewScoreButton;
	}

	public WebElement getAreYouWithHCPButton() {
		return areYouWithHCPButton;
	}

	public WebElement getiAmWithMyHCPButton() {
		return iAmWithMyHCPButton;
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

	public WebElement getNewRiskQuestionnaireButton() {
		return newRiskQuestionnaireButton;
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
		return enterNameCheckbox;
	}

	public WebElement getLetsBeginButton() {
		return letsBeginButton;
	}

	public WebElement getReviewButton() {
		return reviewButton;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getContinueForRiskFactorButton() {
		return continueforriskfactorButton;
	}

	public WebElement getFAQ1() {
		return faq1;
	}

	public WebElement getFAQ2() {
		return faq2;
	}

	public WebElement getFAQ3() {
		return faq3;
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

	public WebElement getContinueButtonForReferralCode() {
		return continuebuttonForReferralCode;
	}

	public WebElement getErrorMessageForReferralCode() {
		return errorMessageForReferralCode;
	}

	public WebElement getLetsContinueButton() {
		return letsContinueButton;
	}

	public WebElement getShareWithHCP() {
		return ShareWithHCP;
	}

}
