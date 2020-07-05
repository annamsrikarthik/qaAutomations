package org.Frmwrk.API_Automatn.APIAutomatn;

import java.util.Random;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class empDetailsAPI {

	@Test
	public void testApp() throws JSONException {		
		RestAssured.baseURI ="https://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		Random r = new Random();
		int ran = r.nextInt(1000);
		System.out.println(ran);
		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); 
		requestParams.put("LastName", "Singh");
		 
		requestParams.put("UserName", "simpleuser"+ran);
		requestParams.put("Password", "password1");
		requestParams.put("Email",   ran+"someuser@gmail.com");
		
		requestParams.put("FirstName", "Virender"); 
		requestParams.put("LastName", "Singh");
		 
		requestParams.put("UserName", "simpleuser"+ran);
		requestParams.put("Password", "password1");
		requestParams.put("Email",  ran+"someuser@gmail.com");
		
		requestParams.put("FirstName", "Virender"); 
		requestParams.put("LastName", "Singh");
		 
		requestParams.put("UserName", "simpleuser"+ran);
		requestParams.put("Password", "password1");
		requestParams.put("Email",  ran+"someuser@gmail.com");
		
		requestParams.put("FirstName", "Virender"); 
		requestParams.put("LastName", "Singh");
		 
		requestParams.put("UserName", "simpleuser"+ran);
		requestParams.put("Password", "password1");
		requestParams.put("Email",  ran+"someuser@gmail.com");
		//Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());
		// Post the request and check the response
		 Response response = request.post("/register");
		 
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode, "201");
		 String successCode = response.jsonPath().get("SuccessCode");
		 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}
}
