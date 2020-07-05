package org.qa.api.rahulShetty.addBooks;


import org.qa.apiUtilities.apiUtilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class addBookes {
	
	/*
	 * @Test public void createBooks() {
	 * RestAssured.baseURI="http://216.10.245.166"; String response =
	 * given().log().all().header("Content-Type","application/json").body(
	 * apiUtilities.addBookPayload("abc","0989"))
	 * .when().post("/Library/Addbook.php").then().log().all().assertThat().
	 * statusCode(200).extract().response().asString(); JsonPath jp =
	 * apiUtilities.raw2Json(response); String bookID = jp.get("ID");
	 * System.out.println("BookID: "+bookID); }
	 */
	//array=collection of elements
	//mutli.dim arry = collectn of arrays
	@DataProvider(name="BooksData")
	public Object[][] parmetrizeBooksInfo(){
		return new Object[][] {{"a2se","3344"},{"re2f","2222"},{"de5r","567"}};
	}
	
	@Test(dataProvider = "BooksData")
	public void createBooks4mDP(String aisle, String isbn) {
		RestAssured.baseURI="http://216.10.245.166";
		String response = given().log().all().header("Content-Type","application/json").body(apiUtilities.addBookPayload(aisle,isbn))
						  .when().post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath jp = apiUtilities.raw2Json(response);
		String bookID = jp.get("ID");
		System.out.println("BookID: "+bookID);	
	}
	
	
}
