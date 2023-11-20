package StepDefinitions;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class DieticianSudhaSD {
	
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
	
	
	
	
	@Given("User creates POST Request {string} and {int} for the API endpoint")
	public void user_creates_post_request_and_for_the_api_endpoint(String Sheetname, Integer rownumber) throws Exception {
 
		
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
	

	@When("User sends HTTPS Request and request Body with mandatory, additional fields.")
	public void user_sends_https_request_and_request_body_with_mandatory_additional_fields() {
		 response= RestAssured.given().spec(RequestSpec.createPatient()) // Send a Rest Assured request with form data
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
	}

}
