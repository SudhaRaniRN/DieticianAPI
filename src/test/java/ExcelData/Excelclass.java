package ExcelData;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import EndPoints.URLs;
import Utilities.ExcelReader;
import Utilities.ExcelReader2;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class Excelclass {
	
	static ExcelReader ER = new ExcelReader();  
	public static String userpassword;
	public static  String mailId;
	//public static LinkedHashMap<String, String> ExcelDataMap;
	
	public static String FirstName;
	public static String LastName;
	public static String ContactNumber;
	public static String Email;
	public static String Allergy;
	public static String FoodCategory;
	public static String DateOfBirth;
	static String patientInfoJson;
	
	
	public static HashMap<String, Object> UserData(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException
	{
		
		 HashMap<String,Object>map = new HashMap<String,Object>(); 
		List<Map<String, String>>data = ER.getData(URLs.Excelpath, Sheetname);
		userpassword =  (String) map.put("password",data.get(rownumber).get("password") );
		mailId= (String) map.put("userLoginEmail", data.get(rownumber).get("userLoginEmail") );
		return map;
	
}
	
//	public static HashMap<String, Object> patientInfo(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException{
//		
//	
//	
//		HashMap<String,Object>map1 = new HashMap<String,Object>();
//	     List<Map<String, String>> data = ExcelReader2.getData(URLs.Excelpath2, Sheetname);
////			
//	             
//	             FirstName = (String) map1.put("FirstName",data.get(rownumber).get("FirstName") );
//	             LastName = (String) map1.put("LastName",data.get(rownumber).get("LastName") );
//	             ContactNumber =(String) map1.put("ContactNumber",data.get(rownumber).get("ContactNumber") );
//	             Email = (String) map1.put("Email",data.get(rownumber).get("Email") );
//	             Allergy = (String) map1.put("Allergy",data.get(rownumber).get("Allergy") );
//	             FoodCategory = (String) map1.put("FoodCategory",data.get(rownumber).get("FoodCategory") ); 
//	             DateOfBirth = (String) map1.put("DateOfBirth",data.get(rownumber).get("DateOfBirth") );
//	             
//	             patientInfoJson = "{" +
//	                     "\"FirstName\": \"" + FirstName + "\"," +
//	                     "\"LastName\": \"" + LastName + "\"," +
//	                     "\"ContactNumber\": \"" + ContactNumber + "\"," +
//	                     "\"Email\": \"" + Email + "\"," +
//	                     "\"Allergy\": \"" + Allergy + "\"," +
//	                     "\"FoodCategory\": \"" + FoodCategory + "\"," +
//	                     "\"DateOfBirth\": \"" + DateOfBirth + "\"" +
//	                     "}";
//				return map1;
		//return map1;
			
		
//	public static HashMap<String, Object> patientInfo(String sheetName, int rowNumber) throws InvalidFormatException, IOException {
//
//	    HashMap<String, Object> map1 = new HashMap<>();
//	    List<String> data = ExcelReader2.getData(URLs.Excelpath2, sheetName);
//
//	    map1.put("FirstName", data.get(rowNumber).get("FirstName"));
//	    map1.put("LastName", data.get(rowNumber).get("LastName"));
//	    map1.put("ContactNumber", data.get(rowNumber).get("ContactNumber"));
//	    map1.put("Email", data.get(rowNumber).get("Email"));
//	    map1.put("Allergy", data.get(rowNumber).get("Allergy"));
//	    map1.put("FoodCategory", data.get(rowNumber).get("FoodCategory"));
//	    map1.put("DateOfBirth", data.get(rowNumber).get("DateOfBirth"));
//
//	    // Create JSON string
//	    ObjectMapper objectMapper = new ObjectMapper();
//	    try {
//	        patientInfoJson = objectMapper.writeValueAsString(map1);
//	    } catch (JsonProcessingException e) {
//	        e.printStackTrace();
//	    }
//
//	    return map1;
//	}

		
//	public static HashMap<String, Object> getPatientInfo(String sheetName, int rowNumber) throws InvalidFormatException, IOException {
//	    HashMap<String, Object> map = new HashMap<String, Object>();
//	    int totalRows = ER.getData(URLs.Excelpath2, "Sheet1").size();
//	    
//	    for (int i = 0; i < totalRows; i++) {
//	       // HashMap<String, Object> patientInfo = getPatientInfo("YourSheetName", i);
//	    List<Map<String, String>> data = ER.getData(URLs.Excelpath2, sheetName);
//
//	    if (rowNumber >= 0 && rowNumber < data.size()) {
//	        Map<String, String> rowData = data.get(rowNumber);
//
//	        map.put("FirstName", rowData.get("FirstName"));
//	        map.put("LastName", rowData.get("LastName"));
//	        map.put("ContactNumber", rowData.get("ContactNumber"));
//	        map.put("Email", rowData.get("Email"));
//	        map.put("Allergy", rowData.get("Allergy"));
//	        map.put("FoodCategory", rowData.get("FoodCategory"));
//	        map.put("DateOfBirth", rowData.get("DateOfBirth"));
//	    } else {
//	        System.out.println("Invalid row number: " + rowNumber);
//	    }
//
//	   
//	}
//		return map;

	
	
	}


	

	
	
             


