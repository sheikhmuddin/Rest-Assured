package reqres_demo;

import java.io.IOException;

//import org.testng.Assert;
//import org.testng.annotations.Test;


import org.testng.Assert;
import org.testng.annotations.Test;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import reqres_demo_utils.GenericClass;
//import reqres_demo_utils.GenericClass;

public class Post_creatUser {

	 @Test
	 public void createUser() {
	  
	  String str = "{\r\n" + 
		    "    \"name\": \"lokesh\",\r\n" + 
		    "    \"job\": \"leader\"\r\n" + 
	    "}";
	  
	  RestAssured.baseURI = "https://reqres.in/api/users​";
	  
	  Response response = RestAssured.given().contentType(ContentType.JSON).body(str).post();
	  
	  int code = response.getStatusCode();
	  Assert.assertEquals(code, 201,"Correct Status codes");
	  System.out.println(response);
	 } 
	 
	 
	 
	 @Test
	 public void createUser11() {
	 
		
		try {
			 String path="https://reqres.in/api/users​";
			  RestAssured.baseURI = path;
		  
			  Response response;
			response = RestAssured.given().contentType(ContentType.JSON).body(GenericClass.getData("Sheet1", "TC003"))
					  .post();

			  int code = response.getStatusCode();
			  Assert.assertEquals(code, 201,"Correct Status codes");
			  System.out.println(code);
			  System.out.println(response);
			  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
	  
	 }
	 
	 
	 @Test
	 public void createUser12() {
	 
		
		try {
			 String path="https://reqres.in/api/users​";
			  RestAssured.baseURI = path;
		  
			  Response response;
			response = RestAssured.given().contentType(ContentType.JSON).body(GenericClass.createUserJson("Sheet1", "TC003"))
					  .post();

			  int code = response.getStatusCode();
			  Assert.assertEquals(code, 201,"Correct Status codes");
			  System.out.println(code);
			  System.out.println(response);
			  
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1 .getLocalizedMessage());
		}
	  
	 }
	 
	 @Test
	 public void createUser13() {
	 
		
		try {
			 String path="https://reqres.in/api/users​";
			  RestAssured.baseURI = path;
		  
			  ValidatableResponse response= RestAssured.given().contentType(ContentType.JSON).body(GenericClass.createUserJson("Sheet1", "TC003"))
					  .post().then().statusCode(201);

			//  int code = response.
			   
			 // System.out.println(code);
			  System.out.println(response);
			  
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1 .getLocalizedMessage());
		}
	  
	 }
	 @Test
	 public void createUser14() {
	 
		
		try {
			 String path="https://reqres.in/api/users​";
			  RestAssured.baseURI = path;
		  
			  Response response= RestAssured.given().contentType(ContentType.JSON).body(GenericClass.createUserJson("Sheet1", "TC003"))
					  .patch();

			//  int code = response.
			   
			 // System.out.println(code);
			  System.out.println(response);
			  int statusCode = response.getStatusCode();
			  
			  Assert.assertEquals(statusCode, 200,"Correct Status code");
			  
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1 .getLocalizedMessage());
		}
	  
	 }
	 
	 
//	 @Test
	 public void createUser1() {
	 

		  RestAssured.baseURI = "https://reqres.in/api/users​";
	  
		  Response response = RestAssured.given().contentType(ContentType.JSON)
				    .body(GenericClass.createUserJson("Sheet", "TC003"))
				    .post(); 
	  System.out.println(response); 
	  
	  int code = response.getStatusCode();
	  Assert.assertEquals(code, 201,"Correct Status codes");
	 }
	 
	// @Test
	 public void createUser2() {
	 

		  RestAssured.baseURI = "https://reqres.in/api/users​";
	  
	  ValidatableResponse response = RestAssured.given().contentType(ContentType.JSON)
	    .body(GenericClass.createUserJson("Sheet", "TC003"))
	    .post().then().statusCode(201);
	  
	 }
	 //@Test
	 public void user() {
	  RestAssured.baseURI = "https://reqres.in/api/users​";
	  
	  Response response = RestAssured.given()
	    .contentType(ContentType.JSON)
	    .body(GenericClass.createUserJson("Sheet", "TC001"))
	    .patch();
	  
	  int statusCode = response.getStatusCode();
	  
	  Assert.assertEquals(statusCode, 200,"Correct Status code");
	 }
}
