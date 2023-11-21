package StepDefinitions;

import java.io.File;

import EndPoints.URLs;
import TestRequests.RequestSpec;
import TestRunner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.cucumber.java.en.Then;

public class DieticianRaghavySD {
	Response getallMorbidityResponse;
	Response InvalidendpointgetallMorbidityResponse;
	Response emptyNameMorbidity;
	Response getaMorbiditybyname;
	Response InvalidNameMorbidity;
	String token;
	Object retrievedToken = TestRunner.scenarioContext.getContext("Token", token);
	
	@Given("User creates GET Request for the API endpoint to get all morbidities")
	public void user_creates_get_request_for_the_api_endpoint_to_get_all_morbidities() {
	   
	    getallMorbidityResponse = RestAssured
	    		.given()
	    		.header("Authorization","Bearer "+retrievedToken)
		    	.spec(RequestSpec.GetAllMorbidity())
		    	.when()
		    	.get();
	    //System.out.println(retrievedToken);
	          		
	}

	@When("User sends GET request")
	public void user_sends_get_request() {
		getallMorbidityResponse.then().log().all().extract().response();
	    	    
	    	     	    
	            		}

	@Then("Response status code should be {int} OK and response body contains all the morbidities")
	public void response_status_code_should_be_ok_and_response_body_contains_all_the_morbidities(Integer int1) {
	  	    
	  	 getallMorbidityResponse.then().statusCode(200);
			
	}

	@Given("User sets valid URL and invalid endpoint")
	public void user_sets_valid_url_and_invalid_endpoint() {
		InvalidendpointgetallMorbidityResponse = RestAssured
	    		.given()
	    		.header("Authorization","Bearer "+retrievedToken)
		    	.spec(RequestSpec.WrongendpointGetAllMorbidity())
		    	.when()
		    	.get();
	    
	}
	@When("User sends GET request for invalid endpoint")
	public void user_sends_get_request_for_invalid_endpoint() {
		InvalidendpointgetallMorbidityResponse.then().log().all().extract().response();
	}
	@Then("Response status code should be {int} Not Found and response body contains error message")
	public void response_status_code_should_be_not_found_and_response_body_contains_error_message(Integer int1) {
		InvalidendpointgetallMorbidityResponse.then().statusCode(404);
	  
	}

//	@Given("User sets valid URL and valid endpoint")
//	public void user_sets_valid_url_and_valid_endpoint() {
//	    // Write code here that turns the phrase above into concrete actions
//	   
//	}
//
//	@When("User send Get Request with empty response body")
//	public void user_send_get_request_with_empty_response_body() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
	
	@Given("User sets valid URL and valid endpoint")
	public void user_sets_valid_url_and_valid_endpoint() {
		getaMorbiditybyname = RestAssured
	    		.given()
	    		.header("Authorization","Bearer "+retrievedToken)
		    	.spec(RequestSpec.FastingGlucose())
		    	.when()
		    	.get();
	    
	}
	@When("User sends GET request with a valid test name")
	public void user_sends_get_request_with_a_valid_test_name() {
		
		
		getaMorbiditybyname.then().log().all().extract().response();
	}

	@Then("Response status code should be {int} OK and response body contains morbidity searched for")
	public void response_status_code_should_be_ok_and_response_body_contains_morbidity_searched_for(Integer int1) {
		getaMorbiditybyname.then().statusCode(200);
	}
	
	@Given("User sets valid URL and valid getallmobidity")
	public void user_sets_valid_url_and_valid_getallmobidity() {
		InvalidNameMorbidity = RestAssured
	    		.given()
	    		.header("Authorization","Bearer "+retrievedToken)
	    		.spec(RequestSpec.InvalidMorbidityName())
		    	.when()
		    	.get();
	    
	}

	@When("User sends GET request with an invalid test name")
	public void user_sends_get_request_with_an_invalid_test_name() {
          
		InvalidNameMorbidity.then().log().all().extract().response();
	}
   @Then("Response status code for invalid test name should be {int} Not Found and response body contains error message")
    public void response_status_code_for_invalid_test_name_should_be_not_found_and_response_body_contains_error_message(Integer int1)
        {
	InvalidNameMorbidity.then().statusCode(404);		    
		}	
   /*@Given("User sets valid URL and valid for empty morbidity name")
   public void user_sets_valid_url_and_valid_for_empty_morbidity_name() {
	   emptyNameMorbidity = RestAssured
	    		.given()
	    		.header("Authorization","Bearer "+retrievedToken)
	    		.spec(RequestSpec.emptyMorbidityName())
		    	.when()
		    	.get();
   }	
   
   
	@When("User sends GET request with empty test name")
	public void user_sends_get_request_with_empty_test_name() {
		emptyNameMorbidity.then().log().all().extract().response();
	}

	@Then("Response status code for empty testName should be {int} Not Found and response body contains error message")
	public void response_status_code_for_empty_test_name_should_be_not_found_and_response_body_contains_error_message(Integer int1) {
		emptyNameMorbidity.then().statusCode(404);
	}*/
	

}
