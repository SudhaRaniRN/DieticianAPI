package EndPoints;

public class URLs {
   
	public static String BaseURL = "https://dietician-dev-41d9a344a720.herokuapp.com/dietician";
	public static String createPatient = "/patient";
	public static String UpdatePatient = "/patient/{patientId}";
	public static String DeletePatient = "/patient/{patientId}";
	public static String GetAllPatient= "/patient";
	public static String GetTestReport = "/patient/testReports/{patientId}";
	public static String GetPatientFile = "/patient/testReports/viewFile/{fileId}";
	public static String GetAllMorbidity ="/morbidity";
	public static String NegativeEndpointGetAllMorbidity ="/morbidity1";
	//public static String GetMorbidityByName=  "/morbidity/{morbidityName}";
	public static String loginendpoint = "/login";
	public static String MorbidityByName1 = "/morbidity/Fasting Glucose";
	public static String MorbidityByName2 = "/morbidity/Average Glucose";
	public static String MorbidityByName3 = "/morbidity/Plasma Glucose";
	public static String MorbidityByName4 = "/morbidity/HbA1c";
	public static String MorbidityByName5 = "/morbidity/TSH";
	public static String MorbidityByName6 = "/morbidity/T3";
	public static String MorbidityByName7 = "/morbidity/T4";
	public static String MorbidityByName8 = "/morbidity/Blood Pressure Levels";
	public static String NegativeMorbidityByName ="/morbidity/Cholestrol";
	public static String EmptyMorbidityByName = "/morbidity/";
	public static String Excelpath = "./src/main/resources/TestData/UserCredentials.xlsx";
	
	public static String logoutendpoint = "/logoutdietician";
	public static String filePath = "./src/main/resources/TestData/Copy of Hypo Thyroid-Report.pdf.pdf";
	public static String Excelpath2 = "./src/main/resources/TestData/TestData.xlsx";
}
