package Utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Extract_values_JsonResponse {

	
	public String parseTokenFromResponseBody(String response ) {
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        JsonNode jsonNode = objectMapper.readTree(response.trim());

	        if (jsonNode.has("token")) {
	        	String token = jsonNode.get("token").asText();
	            System.out.println("Extracted Token: " + token);
	            return token;
	        } else {
	            // Handle the case where "token" is not present in the JSON
	            System.err.println("Error: 'token' not found in JSON response.");
	            return null;
	        }
	    } catch (JsonProcessingException e) {
	        // Handle the exception or log it
	        e.printStackTrace();
	        return null;
	    }
	}


}
