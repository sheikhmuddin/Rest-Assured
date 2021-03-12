package reqres_demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class get_01 {
	
	@Test
	 public void verifyResponse() {
		  
		  RestAssured.baseURI = "https://reqres.in/api/users?page=2​";
		  
		  RequestSpecification httpRequest = RestAssured.given();
		  
		  Response response = httpRequest.get();
		  
		  ResponseBody body = response.getBody();
		  
		  String responseBody = body.asString();
		  
		  Assert.assertEquals(responseBody.toLowerCase().contains("total_pages"),true, "correct value");
		 }

}
