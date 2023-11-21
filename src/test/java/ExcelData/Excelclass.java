package ExcelData;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import EndPoints.URLs;
import Utilities.ExcelReader;
import Utilities.ExcelReader2;

public class Excelclass {
	
	static ExcelReader ER = new ExcelReader(); 
	ExcelReader2 ER2= new ExcelReader2(URLs.Excelpath);
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
	 static String    patientInfoJson;
	
	
	public static HashMap<String, Object> UserData(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException
	{
		
		 HashMap<String,Object>map = new HashMap<String,Object>(); 
		List<Map<String, String>>data = ExcelReader.getData(URLs.Excelpath, Sheetname);
		userpassword =  (String) map.put("password",data.get(rownumber).get("password") );
		mailId= (String) map.put("userLoginEmail", data.get(rownumber).get("userLoginEmail") );
		return map;
	}
}
	
//	public static List<Map<String, String>> patientInfo(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException{
//		List<Map<String, String>> map1 = ER2.getData(URLs.Excelpath2,Sheetname );
//
//        for (Map<String, String> data : map1) {
//            // Access individual values using data.get("ColumnName")
//            String FirstName = data.get("FirstName");
//            String LastName = data.get("LastName");
//            String ContactNumber = data.get("ContactNumber");
//            String Email = data.get("Email");
//            String Allergy = data.get("Allergy");
//            String FoodCategory = data.get("FoodCategory");
//            String DateOfBirth = data.get("DateOfBirth");
//
//            // Construct your JSON string or perform other actions with the data
//             patientInfoJson = "{" +
//                    "\"FirstName\": \"" + FirstName + "\"," +
//                    "\"LastName\": \"" + LastName + "\"," +
//                    "\"ContactNumber\": \"" + ContactNumber + "\"," +
//                    "\"Email\": \"" + Email + "\"," +
//                    "\"Allergy\": \"" + Allergy + "\"," +
//                    "\"FoodCategory\": \"" + FoodCategory + "\"," +
//                    "\"DateOfBirth\": \"" + DateOfBirth + "\"" +
//                    "}";
//			
//		
//			
//	}
//		return map1;
//	}
//}

	
	
             


