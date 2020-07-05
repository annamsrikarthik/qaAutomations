package org.qa.api.rahulShetty.APITest;

import static org.junit.Assert.assertTrue;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.qa.apiUtilities.apiUtilities;

import io.restassured.RestAssured;

/**
 * Unit test for simple App.
 */
public class basics 
{
   
    @Test
    public void addPlaces()
    {
    	RestAssured.baseURI="https://rahulshettyacademy.com";
    	String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
    						.body(apiUtilities.getPOSTBody()).when().post("maps/api/place/add/json").then().assertThat()
    						.log().all().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
    System.out.println("Response: "+response);
    JsonPath jp =apiUtilities.raw2Json(response);
    String getPlaceID = jp.getString("place_id");
    System.out.println("PlaceID: "+getPlaceID);
    String newAddress = "Summer Walk Amman Street, India";
    
    String updatedAddress=given().log().all().header("Content-Type","application/json")
    .body(apiUtilities.getPUTBody(getPlaceID, newAddress)).when().put("maps/api/place/update/json").then()
    .assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated")).extract().response().asString();
    System.out.println("Updated Address Message : "+updatedAddress);
    
    String getUpdatedAddress=given().log().all().queryParam("place_id", getPlaceID).queryParam("key", "qaclick123").when().get("maps/api/place/get/json").then()
    	    .assertThat().log().all().statusCode(200).extract().response().asString();
    
    System.out.println("Get Updated Address: "+getUpdatedAddress);
    
    JsonPath jpUpAdd=apiUtilities.raw2Json(getUpdatedAddress);
    
    System.out.println("Get New Address: "+jpUpAdd.getString("address"));
    
    Assert.assertEquals(newAddress, jpUpAdd.getString("address"));
    	    
    	 
    
    
    }
}
