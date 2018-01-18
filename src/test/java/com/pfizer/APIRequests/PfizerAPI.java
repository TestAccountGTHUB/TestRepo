package com.pfizer.APIRequests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.extentReports.ExtentTestManager;

public class PfizerAPI {

	int flag = 0;
	Object object;
	Response response;
	List<String> answersList = new ArrayList<String>();

	JSONParser parser = new JSONParser();
	JSONObject jsonobject, questionsArray;
	org.json.JSONObject jsonObj_Question;
	org.json.JSONObject attributesjson;
	String response_data, token, id, questionId, responseItemsArray, riskFactor, responseText, answers;
	Boolean Statuscode;
	String url = "https://newton-api-dev.cloudhub.io/api/v1/instance/158d5b38-b5b8-4019-ac3c-4ad1e971f36a";
	String jsonFileDir = System.getProperty("user.dir") + "/src/test/resources/APIJsonFiles";
	HashMap<String, Object> map1 = new HashMap<String, Object>();
	HashMap<String, String> map2 = new HashMap<String, String>();
	private static Logger APP_LOGS = Logger.getLogger("PfizerAppAutomationLog");
	ObjectMapper mapper = new ObjectMapper();

	// For Generating Token
	// @Test
	public void janrainAccessTokenAndroid() {
		RestAssured.baseURI = "https://pfizer-consumer-newton-dev.us-dev.janraincapture.com/oauth/auth_native_traditional";
		response = RestAssured.given().formParam("client_id", "w964rdvxkunt3bdjhrk3r9ptqghtmfpc")
				.formParam("flow", "newton").formParam("flow_version", "20170209144935785535")
				.formParam("form", "signInForm").formParam("locale", "en-US")
				.formParam("redirect_uri", "http://www.example.com").formParam("response_type", "token")
				.formParam("signInEmailAddress", "afib.decisions@pfizer.com").formParam("currentPassword", "Pfizer@123")
				.header("Content-Type", "application/x-www-form-urlencoded").request().post(RestAssured.baseURI);
		response_data = response.body().asString();
		// String getAPIName = new Object() {
		// }.getClass().getEnclosingMethod().getName();
		// Statuscode = status(response, reports, getAPIName);
		// assertEquals(Statuscode,"true");
		try {
			jsonobject = (JSONObject) parser.parse(response_data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		token = (String) jsonobject.get("access_token");
	}

	// @Test(dependsOnMethods = "JanrainAccessTokenAndroid")
	/*
	 * public void CreateQuestionnaireAssetType() throws Exception { ExtentTest
	 * reports = ExtentTestManager.startTest("CreateQuestionnaireAssetType API",
	 * "CreateQuestionnaireAssetType API Test"); object = parser.parse(new
	 * FileReader(jsonFileDir + "\\Create Questionnaire Asset Type.json"));
	 * jsonobject = (JSONObject) object; response =
	 * RestAssured.given().auth().basic("AFIBANDROIDCHE_AdmPX", "swU_8Th5chEh")
	 * // .header("Authorization",
	 * "Basic // RENJT1NDSEVfQWRtUFg6SDQ5ZGxOQmRzNGg=")
	 * .header("X-JANRAIN-TOKEN-ID", token).header("Content-Type",
	 * "application/json").request() .body(jsonobject).post(url + "/assettype");
	 * response_data = response.body().asString(); String getAPIName = new
	 * Object() { }.getClass().getEnclosingMethod().getName(); Statuscode =
	 * status(response, reports, getAPIName); //
	 * assertEquals(Statuscode,"true"); jsonobject = (JSONObject)
	 * parser.parse(response_data); id = (String) jsonobject.get("id");
	 * System.out.println("Id Generated is : " + id); map1.put(
	 * "id of CreateQuestionnaireAssetType API", id); }
	 */

	/*
	 * @Test(dependsOnMethods = "CreateQuestionnaireAssetType") public void
	 * CreateQuestionnaireAsset() throws Exception { ExtentTest reports =
	 * ExtentTestManager.startTest("CreateQuestionnaireAsset API",
	 * "CreateQuestionnaireAsset API Test"); object = parser.parse(new
	 * FileReader(jsonFileDir + "\\Create Questionnaire Asset.json"));
	 * jsonobject = (JSONObject) object; jsonobject.put("type", id); response =
	 * RestAssured.given().auth().basic("AFIBANDROIDCHE_AdmPX", "swU_8Th5chEh")
	 * .header("X-JANRAIN-TOKEN-ID", token).header("Content-Type",
	 * "application/json").request() .body(jsonobject).post(url + "/asset");
	 * response_data = response.body().asString(); String getAPIName = new
	 * Object() { }.getClass().getEnclosingMethod().getName(); Statuscode =
	 * status(response, reports, getAPIName); //
	 * assertEquals(Statuscode,"true"); jsonobject = (JSONObject)
	 * parser.parse(response_data); id = (String) jsonobject.get("id");
	 * System.out.println("Id Generated is : " + id); map1.put(
	 * "id of CreateQuestionnaireAsset", id);
	 * 
	 * }
	 */

	/*
	 * @Test(dependsOnMethods = "CreateQuestionnaireAsset") public void
	 * CreateQuestionnaireResponseEventType() throws Exception { ExtentTest
	 * reports = ExtentTestManager.startTest(
	 * "CreateQuestionnaireResponseEventType API",
	 * "CreateQuestionnaireResponseEventType API Test"); object =
	 * parser.parse(new FileReader(jsonFileDir +
	 * "\\Create QuestionnaireResponse Event Type.json")); jsonobject =
	 * (JSONObject) object; response =
	 * RestAssured.given().auth().basic("AFIBANDROIDCHE_AdmPX", "swU_8Th5chEh")
	 * .header("X-JANRAIN-TOKEN-ID", token).header("Content-Type",
	 * "application/json").request() .body(jsonobject).post(url + "/eventtype");
	 * response_data = response.body().asString(); String getAPIName = new
	 * Object() { }.getClass().getEnclosingMethod().getName(); Statuscode =
	 * status(response, reports, getAPIName); assertEquals(Statuscode,"true"); }
	 */

	// @Test(dependsOnMethods = "janrainAccessTokenAndroid")

	public List<String> getQuestionnaireExample(ExtentTest reports, int riskFactorGeneration) {
		response = RestAssured.given().auth().basic("AFIBANDROIDCHE_AdmPX", "swU_8Th5chEh")
				.header("X-JANRAIN-TOKEN-ID", token).request().get(url
						+ "/asset?type=e46b7c72-49bc-4e26-81aa-e51fab4d1e79&isActive=true&lastModifiedTimeSince=2017-11-02T18:12:05.319Z");
		response_data = response.body().asString();
		String getAPIName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		Statuscode = status(response, reports, getAPIName);
		JSONArray jsonArrayResponseData = new JSONArray(response_data);
		answersList.add("Yes"); // For 1st question
		for (int i = 0; i < jsonArrayResponseData.length(); i++) {
			org.json.JSONObject jsonobject = jsonArrayResponseData.getJSONObject(i);
			attributesjson = jsonobject.getJSONObject("attributes");
		}
		// For questionId and Response item
		JSONArray questionsArray = attributesjson.getJSONArray("questions"); // *********************

		for (int j = 2; j < questionsArray.length(); j++) {
			jsonObj_Question = questionsArray.getJSONObject(j);
			// String questionId = jsonObj1.optString("questionId");
			// String questionText = jsonObj1.optString("questionText");
			responseItemsArray = jsonObj_Question.optString("responseItems");

			// For risk factor
			JSONArray responseScoreValuesJArray = new JSONArray(responseItemsArray);
			// responseScoreValuesJArray.length()

			for (int k = 0; k < responseScoreValuesJArray.length(); k++) {
				org.json.JSONObject jsonObj_ResponseScoreValues = responseScoreValuesJArray.getJSONObject(k);
				responseText = (String) jsonObj_ResponseScoreValues.get("responseText");
				org.json.JSONObject responseScoreValues = jsonObj_ResponseScoreValues
						.getJSONObject("responseScoreValues");
				riskFactor = (String) responseScoreValues.get("riskFactor");
				if (answersList.size() <= riskFactorGeneration) {
					if (riskFactor.equals("Risk")) {
						answersList.add(responseText);
						break;
					}
				}

				if (answersList.size() > riskFactorGeneration) {

					if (riskFactor.equals("Not a Risk")) {
						answersList.add(responseText);
						break;
					}
					if (riskFactor.equals("")) {
						answersList.add(responseText);
						break;
					}
				}
			}
		}
		// System.out.println("The Final list is :- " + list);
		return answersList;

	}

	public boolean status(Response response, ExtentTest reports, String getAPIName) {
		int statuscode = response.getStatusCode();
		if (statuscode == 200 || statuscode == 201 || statuscode == 202 || statuscode == 204 || statuscode == 301
				|| statuscode == 302 || statuscode == 303 || statuscode == 304 || statuscode == 307) {
			reports.log(LogStatus.PASS, getAPIName + " API Test statuscode is" + statuscode);
			APP_LOGS.info(getAPIName + " API Test is Pass");
			return true;
		} else {
			reports.log(LogStatus.FAIL, getAPIName + " API Test statuscode is" + statuscode);
			APP_LOGS.info(getAPIName + " API Test is Fail");
			return false;
		}
	}
}
