package StepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import Utilities.*;
import EndPoints.URLs;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import EndPoints.URLs;
import Utilities.ExcelReader;

public class Excelclass {
//	static ExcelReader ER = new ExcelReader();  
//	public static String userpassword;
//	public static  String mailId;
//	public static LinkedHashMap<String, String> ExcelDataMap;
//	
//	
//	public static LinkedHashMap<String, String> UserData(String Excelpath,String Sheet1) throws InvalidFormatException, IOException {
//		
//		ExcelDataMap = ER.getData(URLs.Excelpath, Sheet1);
//		userpassword = ExcelDataMap.get("password");
//		mailId = ExcelDataMap.get("userLoginEmail");
//		return ExcelDataMap ;
//	
////	ExcelReader ER = new ExcelReader(); 
////	HashMap<String,Object>map = new HashMap<String,Object>(); 
////	List<Map<String, String>>data = ER.getData(URLs.Excelpath,"Sheet1");
////	
////	int rownumber = 0;
////	Object userpassword =  map.put("password", data.get(rownumber).get("password"));
////	Object usermail = map.put("userLoginEmail", data.get(rownumber).get("userLoginEmail"));
////	return null;
//
//	
//}
	
	
	static ExcelReader ER = new ExcelReader();  
	public static String userpassword;
	public static  String mailId;
	//public static LinkedHashMap<String, String> ExcelDataMap;
	public static HashMap<String,Object>map;
	public static String FirstName;
	public static String LastName;
	public static String ContactNumber;
	public static String Email;
	public static String Allergy;
	public static String FoodCategory;
	public static String DateOfBirth;
	
	
	
	public static HashMap<String, Object> UserData(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		
//		ExcelDataMap = (LinkedHashMap<String, String>) ER.getData(URLs.Excelpath, Sheet1);
//		userpassword = ExcelDataMap.get("password");
//		mailId = ExcelDataMap.get("userLoginEmail");
//		return ExcelDataMap ;
		
		map = new HashMap<String,Object>(); 
		List<Map<String, String>>data = ER.getData(URLs.Excelpath, Sheetname);
		userpassword =  (String) map.put("password",data.get(rownumber).get("password") );
		mailId= (String) map.put("userLoginEmail", data.get(rownumber).get("userLoginEmail") );
		return map;
	}
}
