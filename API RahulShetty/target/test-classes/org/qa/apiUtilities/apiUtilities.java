package org.qa.apiUtilities;

import io.restassured.path.json.JsonPath;

public class apiUtilities {
	
	public static String getPOSTBody() {
		return "{\r\n" + 
				"\"location\":{\r\n" + 
				"	\"lat\": -34.33443,\r\n" + 
				"	\"lng\": 33.4243\r\n" + 
				"},\r\n" + 
				"\"accuracy\":40,\r\n" + 
				"\"name\":\"Frontline house\",\r\n" + 
				"\"phone_number\":\"(+91) 983 596 5579\",\r\n" + 
				"\"address\": \"23, side layout, cohen 08\",\r\n" + 
				"\"types\": [ \"shoe park\",\"shop\" ],\r\n" + 
				"\"website\": \"https://www.google.co.in\",\r\n" + 
				"\"language\":\"French-IN\"\r\n" + 
				"}";
	}
	
	public static String getPUTBody(String placeID, String address) {
		return "{\r\n" + 
				"\"place_id\":\""+placeID+"\",\r\n" + 
				"\"address\":\""+address+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}";
	}
	
	public static String getComplexJson() {
		return "{\r\n" + 
				"\"dashboard\":{\r\n" + 
				"\"purchaseAmount\": 1700,\r\n" + 
				"\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"},\r\n" + 
				"\"courses\":[\r\n" + 
				"{\r\n" + 
				"\"title\": \"Selenium Python\",\r\n" + 
				"\"price\": 50,\r\n" + 
				"\"copies\": 6\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"title\": \"cypress\",\r\n" + 
				"\"price\": 40,\r\n" + 
				"\"copies\": 10\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"title\": \"Appium\",\r\n" + 
				"\"price\": 100,\r\n" + 
				"\"copies\": 10\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"}";
	}
	
	public static JsonPath raw2Json(String validateString) {
		JsonPath jp=new JsonPath(validateString);
		return jp;
				
	}
	
	public static String addBookPayload(String isbn,String aisle) {
		return "{\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John Foe\"\r\n" + 
				"}\r\n" + 
				"";
	}
	
}
