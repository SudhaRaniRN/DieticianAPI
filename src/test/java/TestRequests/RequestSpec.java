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
	public static RequestSpecification createPatientInv() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.createPatientInv);
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
	public static RequestSpecification DeleteINvPatient() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.DeleteInvPatient);
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
		req.setBasePath(URLs.loginendpoint);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification GetAllMorbidity() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.GetAllMorbidity);
		RequestSpecification res = req.build();
		return res;
	}
	
	public static RequestSpecification WrongendpointGetAllMorbidity() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.InvalidEP);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification FastingGlucose() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.MorbidityByName1);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification AverageGlucose() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.MorbidityByName2);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification PlasmaGlucose() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.MorbidityByName3);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification HbA1c() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.MorbidityByName4);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification TSH() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.MorbidityByName5);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification T3() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.MorbidityByName6);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification T4() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.MorbidityByName7);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification BloodPressureLevels() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.MorbidityByName8);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification InvalidMorbidityName() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.NegativeMorbidityByName);
		RequestSpecification res = req.build();
		return res;
	}
	
	
	
	/*public RequestSpecification GetMorbidityByName() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.GetMorbidityByName);
		RequestSpecification res = req.build();
		return res;
	}*/

	public static RequestSpecification Invalid_BaseURL() {
		  req.setBaseUri(URLs.Invalid_BaseURL);
		  req.setBasePath(URLs.logoutendpoint);
		  req.setContentType(ContentType.JSON);
		  req.setAccept(ContentType.JSON);
		  RequestSpecification reqspec2 = req.build();		
		  return reqspec2;
	  }
	  
	  public static RequestSpecification Invalid_loginend() {
		  req.setBaseUri(URLs.BaseURL);
		  req.setBasePath(URLs.Invalid_loginendpoint);
		  req.setContentType(ContentType.JSON);
		  req.setAccept(ContentType.JSON);
		  RequestSpecification reqspec3 = req.build();		
		  return reqspec3;
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
	public static RequestSpecification UpdateInvPatient() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.UpdatePatient);
		RequestSpecification res = req.build();
		return res;
	}
	public static RequestSpecification InvEndPoint() {
		req.setBaseUri(URLs.BaseURL);
		req.setBasePath(URLs.UpdatePatient);
		RequestSpecification res = req.build();
		return res;
	}
}
