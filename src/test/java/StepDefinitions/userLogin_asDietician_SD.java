package StepDefinitions;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import EndPoints.URLs;
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
import TestRequests.*;
public class userLogin_asDietician_SD {
	
	ExcelReader ER = new ExcelReader();   
	Excelclass EC = new Excelclass();
	Extract_values_JsonResponse EVJ = new Extract_values_JsonResponse();
	Response loginresponse;
	Response  logoutResponse;
	 private LinkedHashMap<String, String> map;
	 String token;
	 
//	@Given("User creates POST Request {string} and {int} for the API endpoint with valid credentials")
//	public void user_creates_post_request_for_the_api_endpoint_with_valid() throws InvalidFormatException, IOException  {
//		
//		Response[] responses = null;
//		HashMap<String,Object>map = new HashMap<String,Object>(); 
//		List<Map<String, String>>data = ER.getData(URLs.Excelpath,"Sheet1");
//		
//		int rownumber = 0;
//		map.put("password", data.get(rownumber).get("password"));
//		map.put("userLoginEmail", data.get(rownumber).get("userLoginEmail"));
//		response= RestAssured.given().spec(RequestSpec.UserLogin()).body(map).when().post();
//		if (responses == null) {
//            responses = new Response[data.size()];
//            }
//	}
//
//	@When("User sends HTTPS Request and  request Body with mandatory fields")
//	public void user_sends_https_request_and_request_body_with_mandatory_fields() {
//	  
//	}
//
//	@Then("User is able to login and response status code should be {int}")
//	public void user_is_able_to_login_and_response_status_code_should_be(Integer int1) {
//	  
//	}
	
	@Given("User creates POST Request {string} and {int} for the API endpoint with valid credentials")
	public void user_creates_post_request_and_for_the_api_endpoint_with_valid_credentials(String string, Integer int1) throws InvalidFormatException, IOException {
		Response[] responses = null;
		
		 map = EC.UserData(URLs.Excelpath, "Sheet1");
		
		System.out.println(map);
		
          
	}

	@When("User sends HTTPS Request and  request Body with mandatory fields")
	public void user_sends_https_request_and_request_body_with_mandatory_fields() {
		 // Assert that 'map' is not null before using it
		//System.out.println(map);
        Assert.assertNotNull("Map is null. Make sure it is initialized in the previous step.", map);

        RequestSpecification requestSpec = RequestSpec.UserLogin();
        
        loginresponse = RestAssured.given().spec(requestSpec).body(map).when().post();
        
        
//        Response response1 = RestAssured.given()
//                .headers("Authorization", "bearer " + EVJ.parseTokenFromResponseBody(loginresponse.getBody().asString()),
//                        "Content-Type", ContentType.JSON,
//                        "Accept", ContentType.JSON)
//                // ... other headers or request configuration ...
//                .when()
//                .post(URLs.loginendpoint);  // Replace with your actual endpoint
    }
       
	    

//		response= RestAssured.given().spec(requestSpec).body(map).when().post();
//		
//		
//		String responseBody = response.getBody().asString();
//		System.out.println("Response Body: " + responseBody);

	

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
	       	 
	            
	            String token = EVJ.parseTokenFromResponseBody(responseBody);
	            System.out.println(token);
	            
	            System.out.println("Bearer "+token);
	            RestAssured.given().header("Authorization","Bearer "+token,
	   				 "Content-Type", ContentType.JSON,
	                    "Accept", ContentType.JSON);

	        }
//	        Response response1 = RestAssured.given()
//	                .headers("Authorization", "bearer " + EVJ.parseTokenFromResponseBody(loginresponse.getBody().asString()),
//	                        "Content-Type", ContentType.JSON,
//	                        "Accept", ContentType.JSON)
//	                // ... other headers or request configuration ...
//	                .when()
//	                .post(URLs.loginendpoint);  // Replace with your actual endpoint
	        
	}

	@Given("User creates GET Request for the API endpoint")
	public void user_creates_get_request_for_the_api_endpoint() {
		
//		 RequestSpecBuilder Uri = RequestSpec.userlogout();
       	 //String token = EVJ.parseTokenFromResponseBody(loginresponse.getBody().asString());




		 logoutResponse = RestAssured.given().spec(RequestSpec.userlogout()).when().get();
				 
				 
//				 
//				 .header("Authorization","Bearer"+" "+token,
//				 "Content-Type", ContentType.JSON,
//                 "Accept", ContentType.JSON)
//         
//         .when()
//         .get("https://dietician-dev-41d9a344a720.herokuapp.com/dietician/logoutdietician");  // Replace with your actual endpoin
//		 
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
