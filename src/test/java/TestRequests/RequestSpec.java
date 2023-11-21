package TestRequests;

import EndPoints.URLs;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

	
	static RequestSpecBuilder req = new RequestSpecBuilder();
	
	public static RequestSpecification createPatient() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.createPatient);
		req.setContentType("multipart/*");
		  //req.setAccept(ContentType.JSON);
		RequestSpecification res = req.build();
		return res;
	}
	
	public static RequestSpecification UpdatePatient() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.UpdatePatient);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification DeletePatient() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.DeletePatient);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification GetAllPatient() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.GetAllPatient);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification GetTestReport() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.GetTestReport);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification GetPatientFile() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.GetPatientFile);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification UserLogin() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.loginendpoint);
		req.setContentType(ContentType.JSON);
		  req.setAccept(ContentType.JSON);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification DLogout() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.logoutendpoint);
		RequestSpecification res = req.build();
		return res;
	}
	public RequestSpecification GetAllMorbidity() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.GetAllMorbidity);
		RequestSpecification res = req.build();
		return res;
	}
	
	public RequestSpecification GetMorbidityByName() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.GetMorbidityByName);
		RequestSpecification res = req.build();
		return res;
	}
	
	public static RequestSpecification Neg_getallpatients() {
		req.setBaseUri(URLs.InvalidBaseUrl);
		req.setBasePath(URLs.GetAllPatient);
		RequestSpecification res =req.build();
		return res;
				}
	public static RequestSpecification InvalidEP_getallpatients() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.InvalidEP);
		RequestSpecification res =req.build();
		return res;
	}
	
}
