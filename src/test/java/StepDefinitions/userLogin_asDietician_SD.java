package StepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import Utilities.ExcelReader;
import Utilities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import Utilities.ScenarioContext;
import TestRequests.*;
import TestRunner.Testrunner;
public class userLogin_asDietician_SD {
	
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

	
	   
	@Given("User creates POST Request {string} and {int} for the API endpoint with valid credentials")
	public void user_creates_post_request_and_for_the_api_endpoint_with_valid_credentials(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		Response[] responses = null;
		
		
		
		// map = EC.UserData(URLs.Excelpath, "Sheet1");
		//map = EC.UserData("Sheet1", rownumber);
		map = Excelclass.UserData(Sheetname, rownumber);
		System.out.println(map);
		
          
	}

	@When("User sends HTTPS Request and  request Body with mandatory fields")
	public void user_sends_https_request_and_request_body_with_mandatory_fields() {
		 // Assert that 'map' is not null before using it
		//System.out.println(map);
        Assert.assertNotNull("Map is null. Make sure it is initialized in the previous step.", map);

        RequestSpecification requestSpec = RequestSpec.UserLogin();
        
        loginresponse = RestAssured.given().spec(requestSpec).body(map).when().post();
        //.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("C:\\Users\\yours\\git\\DieticianAPI\\src\\test\\resources\\Data\\UserSchemaValidation.json"));
        
        
        
	}        

	

	@Then("User is able to login and response status code should be {int}")
	public void user_is_able_to_login_and_response_status_code_should_be(Integer int1) {
	  
		 String responseBody = loginresponse.getBody().asString();
	        System.out.println(responseBody);
	        if (loginresponse != null) {
	            int statusCode = loginresponse.getStatusCode();
	            //System.out.println(loginresponse.asString());
	            Assert.assertEquals(statusCode, 200);
	            //System.out.println(statusCode);
	            LoggerLoad.info(statusCode);
	       	 
	            String token = loginresponse.jsonPath().getString("token");
	           
	            System.out.println(token);
//	            
//		loginresponse.then().statusCode(200)
//	    .body("password", containsString("Bloom20"))
//	    .body("programStatus", equalTo("Active"))
//        .header("Content-Type", equalTo("application/json"))
//        .body("programName", instanceOf(String.class))
//        .body("programId", instanceOf(Integer.class))
//        .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ProgramModule.json"));
//	            
	           
	            // Storing data (token) in one step
	            
	            Object settoken = Testrunner.scenarioContext.setContext("Token", token);
				
	            System.out.println("Settoken" + settoken);
	            System.out.println("Bearer "+token);
	            RestAssured.given().header("Authorization","Bearer "+token);
	        }
	   				
	          
	        }
     
	
	 

	@Given("User creates GET Request for the API endpoint")
	public void user_creates_get_request_for_the_api_endpoint() {
		

		// Retrieving the stored data in another step
		
		Object gettoken =  Testrunner.scenarioContext.getContext("Token", token);
	    System.out.println("gettoken " +gettoken);
	    RequestSpecification requestSpec1 = RequestSpec.userlogout();
		// logoutResponse = RestAssured.given().spec(requestSpec1).when().get();
		
		 logoutResponse = RestAssured.given().header("Authorization", "Bearer " + gettoken).spec(requestSpec1).when().get();
	       
		
		
		 System.out.println("Status Code: " + logoutResponse.getStatusCode());
		    System.out.println("Response Body: " + logoutResponse.getBody().asString());
		    System.out.println("Headers: " + logoutResponse.getHeaders());
 
	}

	@When("User sends HTTPS Request with valid Url and valid endpoint")
	public void user_sends_https_request_with_valid_url_and_valid_endpoint() {
	    
	}

	@Then("User able to logout with response status {int} OK")
	public void user_able_to_logout_with_response_status_ok(Integer int1) {
	  
	}




	
	
}
