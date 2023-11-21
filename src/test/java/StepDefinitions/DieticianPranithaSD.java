package StepDefinitions;

import TestRequests.RequestSpec;
import TestRunner.TestRunner;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DieticianPranithaSD {
Response response;
private String token;
Object retrievedToken = TestRunner.scenarioContext.getContext("Token", token);	
	//Get all patients
	@Given("Dieticien create GET Request for the API endpoint")
	public void dieticien_create_get_request_for_the_api_endpoint() {
		
		 response = RestAssured.given()
		            .header("Authorization", "Bearer " + retrievedToken)
		            .header("Content-Type", ContentType.JSON)
		            .header("Accept", ContentType.JSON)
		            .spec(RequestSpec.GetAllPatient())
		            .get();
		 
	}


//@Given("Dietician creates GET Request for the API endpoint")
//public void dietician_create_get_request_for_the_api_endpoint() {
//    System.out.println(retrievedToken);
//
//    response = RestAssured.given()
//            .header("Authorization", "Bearer " + retrievedToken)
//            .header("Content-Type", ContentType.JSON)
//            .header("Accept", ContentType.JSON)
//            .spec(RequestSpec.GetAllPatient())
//            .get();
//
//    // Rest of your code...
//}

		
	

	@When("Dieticien send HTTPS Request")
	public void dieticien_send_https_request() {
	 response.then().log().all();
	 
	 //ggerLoad.info("The Response of the req is:"+response.jsonPath().
	}

	@Then("Dieticien get all Patient details and Response status code should be {int} ok")
	public void dieticien_get_all_patient_details_and_response_status_code_should_be_ok(Integer int1) {
	 response.then().statusCode(200);
	
	}
	@Given("Dieticien create GET Request with Invalid URL")
	public void dieticien_create_get_request_with_invalid_url() {
		response =RestAssured.given().spec(RequestSpec.Neg_getallpatients()).when().get();
	}

	@Then("Dieticien should not be logged-in and Response status code should be {int}")
	public void dieticien_should_not_be_logged_in_and_response_status_code_should_be(Integer int1)  {
		 response.then().log().all().extract().response();
		 LoggerLoad.info("The Response of the req is:"+response);
		  response.then().statusCode(404);
	}

	@Given("Dieticien create GET Request with Invalid EndPoint")
	public void dieticien_create_get_request_with_invalid_end_point() {
		response =RestAssured.given().spec(RequestSpec.InvalidEP_getallpatients())
				.header("Authorization", "Bearer " + retrievedToken)
	            .header("Content-Type", ContentType.JSON)
	            .header("Accept", ContentType.JSON)
				.when().get();
	}



}
