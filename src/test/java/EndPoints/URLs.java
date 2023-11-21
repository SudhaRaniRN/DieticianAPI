package EndPoints;

public class URLs {
   
	public static String BaseURL = "https://dietician-dev-41d9a344a720.herokuapp.com/dietician";
	public static String createPatient = "/patient";
	public static String UpdatePatient = "/patient/{patientId}";
	public static String DeletePatient = "/patient";
	public static String GetAllPatient= "/patient";
	public static String GetTestReport = "/patient/testReports/{patientId}";
	public static String GetPatientFile = "/patient/testReports/viewFile/{fileId}";
	public static String GetAllMorbidity =  "/morbidity";
	public static String GetMorbidityByName=  "/morbidity/{morbidityName}";
	public static String loginendpoint = "/login";
	public static String Excelpath = "./src/main/resources/TestData/UserCredentials.xlsx";
	
	public static String logoutendpoint = "/logoutdietician";
	public static String filePath = "./src/main/resources/TestData/Copy of Hypo Thyroid-Report.pdf.pdf";
	public static String Excelpath2 = "./src/main/resources/TestData/TestData (1).xlsx";
	
}
