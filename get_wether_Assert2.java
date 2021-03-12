package reqres_demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class get_wether_Assert2 {
	
	@Test
	 public void validateResponseStatus() {
	  
	  RestAssured.baseURI = "http://api.weatherapi.com";
	  
	  RequestSpecification httpResponse = RestAssured.given();
	  
	  Response response = httpResponse.request(Method.GET,"/v1/current.json?key=6483ec3700b74ecf81585748202811&q=London");
	  
	  int statusCode = response.getStatusCode();
	  
	  Assert.assertEquals(statusCode,200, "Correct status code");
	 }
	 
	 @Test
	 public void validateResponseStatus1() {
	  
	  RestAssured.baseURI = "http://api.weatherapi.com";
	  
	  RequestSpecification httpResponse = RestAssured.given();
	  
	  Response response = httpResponse.request(Method.GET,"/v1/current.json?key=6483ec3700b74ecf81585748202811&q=1");
	  
	  int statusCode = response.getStatusCode();
	  
	  Assert.assertEquals(statusCode,400, "Correct status code");
	 }
	 

	 @Test
	 public void validateResponseStatus2() {    
			RestAssured.baseURI = "http://api.weatherapi.com";
			
			RequestSpecification httpResponse = RestAssured.given();  
			
			Response response = httpResponse.request(Method.GET,"/v1/current.json?key=6483ec3700b74ecf81585748202811&q=22030");   
			

			 String statusLine=response.getStatusLine();
			 System.out.println("status Line is : "+statusLine);
			 Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
			 
			 int statusCode=response.getStatusCode();
			 System.out.println("status Code is : "+statusCode);
			 Assert.assertEquals(statusCode, 200);
			}
	 @Test
	 public void validateResponseStatus3() {
	  
	  RestAssured.baseURI = "http://api.weatherapi.com";
	  
	  RequestSpecification httpResponse = RestAssured.given();
	  
	  Response response = httpResponse.request(Method.GET,"/v1/current.json?key=6483ec3700b74ecf81585748202812&q=London");
	  
	  int statusCode = response.getStatusCode();
	  
	  Assert.assertEquals(statusCode,401, "Correct status code");
	 }
	 
	

}
