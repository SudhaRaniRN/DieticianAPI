package StepDefinitions;

import java.util.HashMap;

import org.junit.Assert;

import ExcelData.Excelclass;
import TestRequests.RequestSpec;
import TestRunner.TestRunner;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class userLogin_asDietician_SD  {
	
	ExcelReader ER = new ExcelReader();   
	Response loginresponse;
	Response logoutResponse;
	private HashMap<String, Object> map;
	String token;
	
	@Given("User creates POST Request {string} and {int} for the API endpoint with valid credentials")
	public void user_creates_post_request_and_for_the_api_endpoint_with_valid_credentials(String Sheetname, Integer rownumber) throws Exception {
		
			map = Excelclass.UserData(Sheetname, rownumber);
			System.out.println(map);
	}

	@When("User sends HTTPS Request and  request Body with mandatory fields")
	public void user_sends_https_request_and_request_body_with_mandatory_fields() {
		
		Assert.assertNotNull("Map is null. Make sure it is initialized in the previous step.", map);
	
        loginresponse = RestAssured
        		.given()
        		.spec(RequestSpec.UserLogin())
        		.body(map)
        		.when().post();
        token = loginresponse.jsonPath().getString("token");
      Object gettoken = TestRunner.scenarioContext.setContext("Token", token); 
        System.out.println(gettoken);
        loginresponse.then().log().all().extract().response();
		LoggerLoad.info("the response of the rquest is " + loginresponse);
        
	  
	}

	@Then("User is able to login and response status code should be {int}")
	public void user_is_able_to_login_and_response_status_code_should_be(Integer int1) {
		RestAssured.given().header("Authorization","Bearer "+token,
 				 "Content-Type", ContentType.JSON,
                  "Accept", ContentType.JSON);
	    loginresponse.then().statusCode(200)
	    
	   .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("DieticianLoginSchema.json"));
	                
	}

	

}
