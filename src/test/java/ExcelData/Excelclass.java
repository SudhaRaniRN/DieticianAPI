package ExcelData;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import EndPoints.URLs;
import Utilities.ExcelReader;

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
	
	
	
	public static HashMap<String, Object> UserData(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException
	{
		
		 HashMap<String,Object>map = new HashMap<String,Object>(); 
		List<Map<String, String>>data = ER.getData(URLs.Excelpath, Sheetname);
		userpassword =  (String) map.put("password",data.get(rownumber).get("password") );
		mailId= (String) map.put("userLoginEmail", data.get(rownumber).get("userLoginEmail") );
		return map;
	}
	
	public void patientInfo(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException{
		
	
	
		List<Map<String, String>> formDataList = ER.getData(URLs.Excelpath2, Sheetname);
		for (Map<String, String> formData : formDataList) {
             
            String FirstName = formData.get("FirstName");
            String LastName = formData.get("LastName");
            String ContactNumber = formData.get("ContactNumber");
            String Email = formData.get("Email");
            String Allergy = formData.get("Allergy");
            String FoodCategory = formData.get("FoodCategory"); 
            String DateOfBirth = formData.get("DateOfBirth");
			
		
		
		
	}
	}
}
	
	
             


