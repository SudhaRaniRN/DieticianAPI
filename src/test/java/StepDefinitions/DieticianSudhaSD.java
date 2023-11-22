package StepDefinitions;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import EndPoints.URLs;
import ExcelData.Excelclass;
import TestRequests.RequestSpec;
import TestRunner.TestRunner;
import Utilities.ExcelReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class DieticianSudhaSD {
	
	ExcelReader ER= new ExcelReader();
	private HashMap<String, Object> map1;
	Response response;
	String token;
	Object retrievedToken = TestRunner.scenarioContext.getContext("Token", token);
	String FirstName;
	String LastName;
	String ContactNumber;
	String Email;
	String Allergy;
	String FoodCategory;
	String DateOfBirth;
	String patientInfoJson;
	Object setpatientId;
	
	
	
	@Given("User creates POST Request {string} and {int} for the API endpoint")
	public void user_creates_post_request_and_for_the_api_endpoint(String Sheetname, Integer rownumber) throws Exception {
 
		
		List<Map<String, String>> map1 = ExcelReader.getData(URLs.Excelpath2, Sheetname );
		
		        for (Map<String, String> data : map1) {
		            // Access individual values using data.get("ColumnName")
		            String FirstName = data.get("FirstName");
		            String LastName = data.get("LastName");
		            String ContactNumber = data.get("ContactNumber");
		            String Email = data.get("Email");
		            String Allergy = data.get("Allergy");
		            String FoodCategory = data.get("FoodCategory");
		            String DateOfBirth = data.get("DateOfBirth");

	           
	             patientInfoJson = "{" +
	                    "\"FirstName\": \"" + FirstName + "\"," +
	                    "\"LastName\": \"" + LastName + "\"," +
	                    "\"ContactNumber\": \"" + ContactNumber + "\"," +
	                    "\"Email\": \"" + Email + "\"," +
	                    "\"Allergy\": \"" + Allergy + "\"," +
	                    "\"FoodCategory\": \"" + FoodCategory + "\"," +
	                    "\"DateOfBirth\": \"" + DateOfBirth + "\"" +
	                    "}";

	           
	        }
	    }
	        

	@When("User sends HTTPS Request and request Body with mandatory, additional fields.")
	public void user_sends_https_request_and_request_body_with_mandatory_additional_fields() {
		 response= RestAssured.given().spec(RequestSpec.createPatient())
			    	.header("Authorization","Bearer "+retrievedToken)
			    	.header("Content-Type","multipart/form-data")
			    	.multiPart("file", new File( URLs.filePath))
			        .formParam("patientInfo", patientInfoJson)
				    .when()
			        .post();
					   response.then().log().all().extract().response();
	}

	@Then("Response status code should be {int} Created and response body contains created patient with details")
	public void response_status_code_should_be_created_and_response_body_contains_created_patient_with_details(Integer int1) {
		response.then().statusCode(201)
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("patientInfo.json"));
		String CreatedpatientId = response.jsonPath().getString("patientId");
		 
		  setpatientId = TestRunner.scenarioContext.setContext("retrivepatientId",CreatedpatientId);
	}
	
	

	@Then("Response status code should be {int} bad request and response body contains error message")
	public void response_status_code_should_be_bad_request_and_response_body_contains_error_message(Integer int1) {
		response.then().statusCode(400);
		
	}

	@When("User sends HTTPS Request and request Body  \\(missing mandatory fields)")
	public void user_sends_https_request_and_request_body_missing_mandatory_fields() {
		response= RestAssured.given().spec(RequestSpec.createPatient())
		    	.header("Authorization","Bearer "+retrievedToken)
		    	.header("Content-Type","multipart/form-data")
		    	.multiPart("file", new File( URLs.filePath))
		        .formParam("patientInfo", patientInfoJson)
			    .when()
		        .post();
				   response.then().log().all().extract().response();
	}

	@When("User send POST request with invalid endpoint")
	public void user_send_post_request_with_invalid_endpoint() {
		response= RestAssured.given().spec(RequestSpec.createPatientInv())
		    	.header("Authorization","Bearer "+retrievedToken)
		    	.header("Content-Type","multipart/form-data")
		    	.multiPart("file", new File( URLs.filePath))
		        .formParam("patientInfo", patientInfoJson)
			    .when()
		        .post();
				   response.then().log().all().extract().response();
	}

	@Then("Response status code should be {int} Not Found and response body contains all the programs")
	public void response_status_code_should_be_not_found_and_response_body_contains_all_the_programs(Integer int1) {
		response.then().statusCode(404);
	}


}
