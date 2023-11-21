package StepDefinitions;
import java.io.IOException;
import java.util.HashMap;

import org.junit.Assert;

import ExcelData.Excelclass;
import TestRequests.RequestSpec;
import TestRunner.TestRunner;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;
import Utilities.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class DieticianReshmaSD {
	
	ExcelReader ER = new ExcelReader();   
	Excelclass EC = new Excelclass();
	Response loginresponse;
	Response  logoutResponse;
	 private HashMap<String, Object> map;
	 String token;
	 String Token;
	 int rownumber;

	 private ScenarioContext scenarioContext;
	 RequestSpecBuilder requestspec; 
	 RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
	 
	 
	@Given("Create POST Request {string} and {int} for the API endpoint")
	public void create_post_request_and_for_the_api_endpoint(String Sheetname, Integer rownumber)throws InvalidFormatException,IOException {
Response[] responses = null;
		
		
		
		// map = EC.UserData(URLs.Excelpath, "Sheet1");
		//map = EC.UserData("Sheet1", rownumber);
		map = Excelclass.UserData(Sheetname, rownumber);
		System.out.println(map);
	      
	}

	@When("User send HTTPS Request and  request Body with mandatory fields")
	public void user_send_https_request_and_request_body_with_mandatory_fields() {
		 // Assert that 'map' is not null before using it
		//System.out.println(map);
        Assert.assertNotNull("Map is null. Make sure it is initialized in the previous step.", map);

        RequestSpecification requestSpec = RequestSpec.UserLogin();
        
        loginresponse = RestAssured.given().spec(requestSpec).body(map).when().post();
        //.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("C:\\Users\\yours\\git\\DieticianAPI\\src\\test\\resources\\Data\\UserSchemaValidation.json"));
	      
	}

	@Then("User is able to login and response status code should be {int} ok")
	public void user_is_able_to_login_and_response_status_code_should_be_ok(Integer int1) {
		 String responseBody = loginresponse.getBody().asString();
	        System.out.println(responseBody);
	        if (loginresponse != null) {
	            int statusCode = loginresponse.getStatusCode();
	            //System.out.println(loginresponse.asString());
	            Assert.assertEquals(statusCode, 200);
	            //System.out.println(statusCode);
	           // LoggerLoad.info(statusCode);
	       	 
	            String token = loginresponse.jsonPath().getString("token");
	           
	            System.out.println(token);
//	            
//		loginresponse.then().statusCode(200)
//	    .body("password", containsString("Bloom20"))
//	    .body("programStatus", equalTo("Active"))
//     .header("Content-Type", equalTo("application/json"))
//     .body("programName", instanceOf(String.class))
//     .body("programId", instanceOf(Integer.class))
//     .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ProgramModule.json"));
//	            
	           
	            // Storing data (token) in one step
	            
	            Object settoken = TestRunner.scenarioContext.setContext("Token", token);
				
	            System.out.println("Settoken" + settoken);
	            System.out.println("Bearer "+token);
	            RestAssured.given().header("Authorization","Bearer "+token);
	        }
	      
	}

	@Given("Create GET Request for the API endpoint")
	public void create_get_request_for_the_api_endpoint() {
		// Retrieving the stored data in another step
		
				Object gettoken =  TestRunner.scenarioContext.getContext("Token", token);
			    System.out.println("gettoken " +gettoken);
			    RequestSpecification requestSpec1 = RequestSpec.DLogout();
				// logoutResponse = RestAssured.given().spec(requestSpec1).when().get();
				
				 logoutResponse = RestAssured.given().header("Authorization", "Bearer " + gettoken).spec(requestSpec1).when().get();
			       
				
				
				 System.out.println("Status Code: " + logoutResponse.getStatusCode());
				    System.out.println("Response Body: " + logoutResponse.getBody().asString());
				    System.out.println("Headers: " + logoutResponse.getHeaders());
	      
	}

	@When("Send HTTPS Request with valid Url and valid endpoint")
	public void send_https_request_with_valid_url_and_valid_endpoint() {
	      
	      
	}

	@Then("User is able to logout with response status {int} OK")
	public void user_is_able_to_logout_with_response_status_ok(Integer int1) {
	      
	      
	}

	@When("Send HTTPS Request and  request Body with mandatory fields")
	public void send_https_request_and_request_body_with_mandatory_fields() {
		 // Assert that 'map' is not null before using it
		//System.out.println(map);
        Assert.assertNotNull("Map is null. Make sure it is initialized in the previous step.", map);

        RequestSpecification requestSpec = RequestSpec.UserLogin();
        
        loginresponse = RestAssured.given().spec(requestSpec).body(map).when().post();
        //.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("C:\\Users\\yours\\git\\DieticianAPI\\src\\test\\resources\\Data\\UserSchemaValidation.json"));
	      
	}

	@Then("User should not login and response status code should be {int}")
	public void user_should_not_login_and_response_status_code_should_be(Integer int1) {
		String responseBody = loginresponse.getBody().asString();
        System.out.println(responseBody);
        if (loginresponse != null) {
            int statusCode = loginresponse.getStatusCode();
            //System.out.println(loginresponse.asString());
            Assert.assertEquals(statusCode, 401);
            //System.out.println(statusCode);
            //LoggerLoad.info1(statusCode);
	}
	      
	}

	@When("User sends HTTPS Request and  request Body with Invalid URL")
	public void user_sends_https_request_and_request_body_with_invalid_url() {
		Assert.assertNotNull("Map is null. Make sure it is initialized in the previous step.", map);

        RequestSpecification requestSpec = RequestSpec.Invalid_BaseURL();
        
        loginresponse = RestAssured.given().spec(requestSpec).body(map).when().post();    
	      
	}

	@Then("User should not be logged-in and response status code should be {int}")
	public void user_should_not_be_logged_in_and_response_status_code_should_be(Integer int1) {
		String responseBody = loginresponse.getBody().asString();
        System.out.println(responseBody);
        if (loginresponse != null) {
            int statusCode = loginresponse.getStatusCode();
            //System.out.println(loginresponse.asString());
            Assert.assertEquals(statusCode, 404);
            //System.out.println(statusCode);
            //LoggerLoad.info(statusCode);
	      
	}
	}

	@When("User sends HTTPS Request and  request Body with Invalid Endpoint")
	public void user_sends_https_request_and_request_body_with_invalid_endpoint() {
	      
		
			Assert.assertNotNull("Map is null. Make sure it is initialized in the previous step.", map);

	        RequestSpecification requestSpec = RequestSpec.Invalid_loginend();
	        
	       loginresponse = RestAssured.given().spec(requestSpec).body(map).when().post(); 
		}
	



}
