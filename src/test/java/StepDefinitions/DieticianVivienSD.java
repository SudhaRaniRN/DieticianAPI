package StepDefinitions;

import TestRequests.RequestSpec;
import TestRunner.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;




public class DieticianVivienSD {
	
	String token;
	String CreatedpatientId;
	
	Object retrievedToken = TestRunner.scenarioContext.getContext("Token", token);
	Object retrivepatientId = TestRunner.scenarioContext.getContext("retrivepatientId",CreatedpatientId);
	
	//int patientId ;
	Response response;
	@Given("User creates DELETE Request for valid API endpoint  and  valid patientID")
	public void user_creates_delete_request_for_valid_api_endpoint_and_valid_patient_id() {
		 
		 
	}

	@When("User sends HTTPS Request")
	public void user_sends_https_request() {
		response = RestAssured
	            .given()
	            .header("Authorization","Bearer "+retrievedToken)
	            .spec(RequestSpec.DeletePatient())
	            .pathParam("patientId", retrivepatientId) 
	            .delete("/patient/retrivepatientId");
		 response.then().log().all();
	}

	@Then("User receives {int} Ok status with message")
	public void user_receives_ok_status_with_message(Integer int1) {
		response.then().statusCode(200);
	}
	@Given("User creates DELETE Request for valid API endpoint  and  invalid patient ID")
	public void user_creates_delete_request_for_valid_api_endpoint_and_invalid_patient_id() {
	    
	}

	@When("User sends HTTPS Request with invalid PatientID")
	public void user_sends_https_request_with_invalid_patient_id() {
		response = RestAssured
	            .given()
	            .header("Authorization","Bearer "+retrievedToken)
	            .spec(RequestSpec.DeletePatient())
	            .pathParam("patientId", 00000) 
	            .delete("/patient/{patientId}");
		 response.then().log().all();
	}

	@Then("User receives {int} Bad Request Status")
	public void user_receives_bad_request_status(Integer int1) {
		response.then().statusCode(404);
	}

	@Given("User creates DELETE Request for invalid API endpoint and valid patient ID")
	public void user_creates_delete_request_for_invalid_api_endpoint_and_valid_patient_id() {
	    
	}

	@When("User sends HTTPS Request with invalid endpoint")
	public void user_sends_https_request_with_invalid_endpoint() {
		response = RestAssured
	            .given()
	            .header("Authorization","Bearer "+retrievedToken)
	            .spec(RequestSpec.DeleteINvPatient())
	            .pathParam("patientId", retrivepatientId) 
	            .delete("/patient/{patientId}");
		 response.then().log().all();
	}

	@Then("User receives {int} Not Found Status")
	public void user_receives_not_found_status(Integer int1) {
		response.then().statusCode(201);
	}


}
