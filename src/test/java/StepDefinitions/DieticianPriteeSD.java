package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

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

public class DieticianPriteeSD {
	
	ExcelReader ER= new ExcelReader();
	private HashMap<String, Object> map;
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
	String CreatedpatientId;
	int patientId;
	
	Object retrivepatientId = TestRunner.scenarioContext.getContext("retrivepatientId",CreatedpatientId);
	
	@Given("User creates PUT Request {string} and {int} for the API endpoint with Valid patientId")
	public void user_creates_put_request_and_for_the_api_endpoint_with_valid_patient_id(String Sheetname, Integer int1) throws InvalidFormatException, IOException{
	   
		List<Map<String, String>> formDataList = ER.getData(URLs.Excelpath2, Sheetname);
		for (Map<String, String> formData : formDataList) {
             
            String FirstName = formData.get("FirstName");
            String LastName = formData.get("LastName");
            String ContactNumber = formData.get("ContactNumber");
            String Email = formData.get("Email");
            String Allergy = formData.get("Allergy");
            String FoodCategory = formData.get("FoodCategory"); 
            String DateOfBirth = formData.get("DateOfBirth");
			
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

	@When("User sends HTTPS Request  and  request Body with mandatory, additional  fields")
	public void user_sends_https_request_and_request_body_with_mandatory_additional_fields() {
		 response= RestAssured.given().spec(RequestSpec.UpdatePatient()) // Send a Rest Assured request with form data
			    	.header("Authorization","Bearer "+retrievedToken)
			    	.header("Content-Type","multipart/form-data")
			    	.multiPart("file", new File( URLs.filePath))
			        .formParam("patientInfo", patientInfoJson)
			        .pathParam("patientId", retrivepatientId) // Replace {patientId} with the actual patientId
			        .put();
					   response.then().log().all().extract().response();
	
	}

	@Then("User receives {int} OK Status with updated value in response body")
	public void user_receives_ok_status_with_updated_value_in_response_body(Integer int1) {
		response.then().statusCode(200);
	}

	@Given("User creates PUT Request {string} and {int} for the API endpoint with INValid patientID")
	public void user_creates_put_request_and_for_the_api_endpoint_with_in_valid_patient_id(String Sheetname, Integer int1) throws InvalidFormatException, IOException  {
	
			   
			List<Map<String, String>> formDataList = ER.getData(URLs.Excelpath2, Sheetname);
			for (Map<String, String> formData : formDataList) {
	             
	            String FirstName = formData.get("FirstName");
	            String LastName = formData.get("LastName");
	            String ContactNumber = formData.get("ContactNumber");
	            String Email = formData.get("Email");
	            String Allergy = formData.get("Allergy");
	            String FoodCategory = formData.get("FoodCategory"); 
	            String DateOfBirth = formData.get("DateOfBirth");
				
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
	
	@When("User sends HTTPS Request  and  request Body with mandatory, additional  fields and Invalid PatientID")
	public void user_sends_https_request_and_request_body_with_mandatory_additional_fields_and_invalid_patient_id() {
		response= RestAssured.given().spec(RequestSpec.UpdateInvPatient()) // Send a Rest Assured request with form data
		    	.header("Authorization","Bearer "+retrievedToken)
		    	.header("Content-Type","multipart/form-data")
		    	.multiPart("file", new File( URLs.filePath))
		        .formParam("patientInfo", patientInfoJson)
		        .pathParam("patientId", retrivepatientId) // Replace {patientId} with the actual patientId
		        .put("/patient/{patientId}");
				   response.then().log().all().extract().response();
	}

	@Then("User receives {int} Not Found Status with message and boolean success details")
	public void user_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
		response.then().statusCode(404);
	}

	@Given("User creates PUT Request {string} and {int} for the API endpoint and missing mandatory Field")
	public void user_creates_put_request_and_for_the_api_endpoint_and_missing_mandatory_Field(String Sheetname, Integer int1) throws InvalidFormatException, IOException   {
		List<Map<String, String>> formDataList = ER.getData(URLs.Excelpath2, Sheetname);
		for (Map<String, String> formData : formDataList) {
             
          String FirstName = formData.get("FirstName");
            String LastName = formData.get("LastName");
//            String ContactNumber = formData.get("ContactNumber");
            String Email = formData.get("Email");
            String Allergy = formData.get("Allergy");
            String FoodCategory = formData.get("FoodCategory"); 
            String DateOfBirth = formData.get("DateOfBirth");
			
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

	@When("User sends HTTPS Request and request Body \\(missing mandatory fields)")
	public void user_sends_https_request_and_request_body_missing_mandatory_fields() {
		response= RestAssured.given().spec(RequestSpec.UpdatePatient()) // Send a Rest Assured request with form data
		    	.header("Authorization","Bearer "+retrievedToken)
		    	.header("Content-Type","multipart/form-data")
		    	.multiPart("file", new File( URLs.filePath))
		        .formParam("patientInfo", patientInfoJson)
		        .pathParam("patientId", retrivepatientId) // Replace {patientId} with the actual patientId
		        .put();
				   response.then().log().all().extract().response();

}

	@Then("User receives {int} Bad Request Status with message and boolean success details")
	public void user_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) {
		response.then().statusCode(400);
		}

	@Given("User creates PUT Request for the API with invalid endpoint")
	public void user_creates_put_request_for_the_api_with_invalid_endpoint() {
	   }

	@When("User sends HTTPS Request  and request Body  \\(invalid endpoint)")
	public void user_sends_https_request_and_request_body_invalid_endpoint() {
		response= RestAssured.given().spec(RequestSpec.InvEndPoint()) // Send a Rest Assured request with form data
		    	.header("Authorization","Bearer "+retrievedToken)
		    	.header("Content-Type","multipart/form-data")
		    	.multiPart("file", new File( URLs.filePath))
		        .formParam("patientInfo", patientInfoJson)
		        .pathParam("patientId", retrivepatientId) // Replace {patientId} with the actual patientId
		        .put();
				   response.then().log().all().extract().response();

}

	}




	