package org.qa.api.rahulShetty.APITest;

import org.junit.Test;
import org.qa.apiUtilities.apiUtilities;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class ComplexJson {

	@Test
	public void complexJsonDemo() {

		JsonPath jp = new JsonPath(apiUtilities.getComplexJson());

		int courseCount = jp.getInt("courses.size()");
		System.out.println(courseCount);
		int totalAmount = jp.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		String firstCousre = jp.get("courses[0].title");
		System.out.println(firstCousre);
		String courseName = null;
		int coursePrice = 0;
		int totalCoursesAmount = 0, courseCopies = 0;

		for (int i = 0; i < courseCount; i++) {
			courseName = jp.get("courses[" + i + "].title");						
			coursePrice = jp.get("courses[" + i + "].price");
			courseCopies = jp.get("courses[" + i + "].copies");
			totalCoursesAmount += Integer.parseInt(jp.get("courses[" + i + "].price").toString()) * Integer.parseInt(jp.get("courses[" + i + "].copies").toString());
			System.out.println("ForLoop: " + courseName);
			System.out.println("Course Price: " + coursePrice);
			String cypressPrice= (courseName.equals("cypress")?String.valueOf(coursePrice):"Requested course price not avaiable");
			System.out.println("courseName_Ternary Operator: "+cypressPrice);
			
//			if (courseName.equalsIgnoreCase("cypress")) {
//				System.out.println("Get Price for the " + courseName + " : " + jp.getInt("courses[" + i + "].price"));
//				// break;
//			}
		}
		System.out.println("Total Puchase Amount: " + totalCoursesAmount);
		Assert.assertEquals(totalAmount, totalCoursesAmount);

	}
}
