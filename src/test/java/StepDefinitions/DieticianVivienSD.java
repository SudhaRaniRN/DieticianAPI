package StepDefinitions;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import EndPoints.URLs;
import TestRequests.RequestSpec;
import TestRunner.TestRunner;
import Utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class DieticianVivienSD {
	
//	String token;
//	Object retrievedToken = TestRunner.scenarioContext.getContext("Token", token);
//	Response deleteResponse;
//	int patientId = 200;
//	
//	@Given("User creates DELETE Request for valid API endpoint and valid patientID")
//	public void user_creates_delete_request_for_valid_api_endpoint_and_valid_patient_id() {
//		
//		deleteResponse = RestAssured.given()
//				.header("Authorization", "Bearer "+ retrievedToken)
//				.spec(RequestSpec.DeletePatient(patientId))
//				.when()
//				.delete();
//		
//		
//		 
//	}
//
//
//	@When("User sends HTTPS Request")
//	public void user_sends_https_request() {
//	}
//
//	@Then("User receives {int} Ok status with message")
//	public void user_receives_ok_status_with_message(Integer int1) {
//		Assert.assertEquals(204, deleteResponse.getStatusCode());
//	}
//
//
//	@Given("User creates DELETE Request for valid API endpoint and invalid patient ID")
//	public void user_creates_delete_request_for_valid_api_endpoint_and_invalid_patient_id() {
//		deleteResponse= RestAssured.given()
//				.spec(RequestSpec.DeletePatient())
//				.body(map)
//				.delete("/patient/{invalidpatientId}");
//	}
//	
//	@When("User send HTTPS Request")
//	public void user_send_https_request() {
//	    }
//
//	@Then("User receives {int} Bad Request Status")
//	public void user_receives_bad_request_status(Integer int1) {
//		Assert.assertEquals(400, deleteResponse.getStatusCode());}
//
//	@Given("User creates DELETE Request for invalid API endpoint and valid patient ID")
//	public void user_creates_delete_request_for_invalid_api_endpoint_and_valid_patient_id() {
//		deleteResponse= RestAssured.given()
//				.spec(RequestSpec.DeletePatient())
//				.body(map)
//				.delete("/patients/{patientId}");
//	}
//	
//	@When("The user sends HTTPS Request")
//	public void the_user_sends_https_request() {
//	    }
//
//	@Then("User receives {int} Not Found Status")
//	public void user_receives_not_found_status(Integer int1) {
//		Assert.assertEquals(404, deleteResponse.getStatusCode());
//		}
//
//}
//
	String token;
	String CreatedpatientId;
	
	Object retrievedToken = TestRunner.scenarioContext.getContext("Token", token);
	Object retrivepatientId = TestRunner.scenarioContext.getContext("retrivepatientId",CreatedpatientId);
	
	//int patientId;
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
	            .delete("/{patientId}");
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
	            .pathParam("patientId", retrivepatientId) 
	            .delete();
		 response.then().log().all();
	}

	@Then("User receives {int} Bad Request Status")
	public void user_receives_bad_request_status(Integer int1) {
		response.then().statusCode(400);
	}

	@Given("User creates DELETE Request for invalid API endpoint and valid patient ID")
	public void user_creates_delete_request_for_invalid_api_endpoint_and_valid_patient_id() {
	}

	@When("User sends HTTPS Request with invalid endpoint")
	public void user_sends_https_request_with_invalid_endpoint() {
//		response = RestAssured
//	            .given()
//	            .header("Authorization","Bearer "+retrievedToken)
//	            .spec(RequestSpec.DeleteINvPatient())
//	            .pathParam("patientId", retrivepatientId) 
//	            .delete();
//		 response.then().log().all();
	}

	@Then("User receives {int} Not Found Status")
	public void user_receives_not_found_status(Integer int1) {
		response.then().statusCode(404);
	}


}
	
