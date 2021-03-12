package Dummy_employee;

import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_employee {
	@Test
	void getweatherDetails() {
		
		//Specify base URI
		  RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		   
		  //Request paylaod sending along with post request
		  JSONObject requestParams=new JSONObject();
		  
		  requestParams.put("name","JohnXYZ");
		  requestParams.put("salary",124);
		  requestParams.put("age",23);
		  
		  httpRequest.header("Content-Type","application/json");
		  
		  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		  
		  //Response object
		  Response response=httpRequest.request(Method.POST,"/create");
		    
		  
		  //print response in console window
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  
		  //status code validation
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		  Assert.assertEquals(statusCode, 200);
		  
		  //success code validation
		  
		  String successCode=response.jsonPath().get("status");
		  System.out.println(successCode);
		  Assert.assertEquals(successCode, "success");
		  
		  String message=response.jsonPath().get("message");
		  Assert.assertEquals(message, "Successfully! Record has been added.");  
		  
		 
		   
		  
	}


}
