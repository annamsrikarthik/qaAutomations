package org.qa.api.rahulShetty.addBooks;

import org.junit.Test;
import org.qa.apiUtilities.apiUtilities;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class staticJsonFromFile {

	@Test
	public void createBooks() throws Exception {
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json")
				.body(GenerateStringfromResurce("C:\\Users\\vinayaka yana maha\\Documents\\UdemyCucumber\\APIRahulShetty\\APITest\\src\\test\\resources\\addressBook.json")).when().post("/Library/Addbook.php").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		JsonPath jp = apiUtilities.raw2Json(response);
		String bookID = jp.get("ID");
		System.out.println("BookID: " + bookID);
	}
	
	public static String GenerateStringfromResurce(String path) throws Exception {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}
