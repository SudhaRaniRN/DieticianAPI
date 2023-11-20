package StepDefinitions;

import TestRequests.RequestSpec;
import TestRunner.TestRunner;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LogoutSD {
	String token;
	Response logoutResponse;
	Object retrievedToken = TestRunner.scenarioContext.getContext("Token", token);
	
	@Given("User creates GET Request for the API endpoint")
	public void user_creates_get_request_for_the_api_endpoint() {
		logoutResponse = RestAssured.given().header("Authorization", "Bearer " + retrievedToken).spec(RequestSpec.DLogout()).when().get();
	}

	@When("User sends HTTPS Request with valid Url and valid endpoint")
	public void user_sends_https_request_with_valid_url_and_valid_endpoint() {
		logoutResponse.then().log().all().extract().response();
			LoggerLoad.info("the response of the rquest is " + logoutResponse);
	}

	@Then("User able to logout with response status {int} OK")
	public void user_able_to_logout_with_response_status_ok(Integer int1) {
		logoutResponse.then().statusCode(200);
	}


}
