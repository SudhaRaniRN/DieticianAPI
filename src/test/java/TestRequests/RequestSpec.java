package TestRequests;

import io.restassured.specification.RequestSpecification;


import java.net.URI;

import EndPoints.URLs;
import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import Utilities.*;
public class RequestSpec {
	
	static ScenarioContext SC;
	 static RequestSpecBuilder req = new RequestSpecBuilder();
//	 
//	 @Before
//	 public void setUpScenarioContext(ScenarioContext scenarioContext) {
//	     this.SC = scenarioContext;
//	 }

	 
//	 static  {
//	        SC = new ScenarioContext();
//	        req = new RequestSpecBuilder();
//	 }
	 public static  RequestSpecification  UserLogin()  {
		
			
		  req.setBaseUri(URLs.BaseURL);
		  req.setBasePath(URLs.loginendpoint);
		  req.setContentType(ContentType.JSON);
		  req.setAccept(ContentType.JSON);
		  RequestSpecification reqspec = req.build();		
		  return reqspec;
	 
}
	 public static RequestSpecification userlogout() {
		  req.setBaseUri(URLs.BaseURL);
		  req.setBasePath(URLs.logoutendpoint);
		  req.setContentType(ContentType.JSON);
		  req.setAccept(ContentType.JSON);
		 

	        
		  RequestSpecification reqspec1 = req.build();		
		  return reqspec1;
		
		  
	 }
	 
}
