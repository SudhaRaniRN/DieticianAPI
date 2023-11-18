package TestRequests;

import io.restassured.specification.RequestSpecification;

import java.net.URI;

import EndPoints.URLs;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class RequestSpec {
	 static RequestSpecBuilder req = new RequestSpecBuilder();
	 
	 public static  RequestSpecification  UserLogin()  {
		//RequestSpecBuilder req = new RequestSpecBuilder();
			
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
