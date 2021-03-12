package reqres_demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class get_wether {
	
	@Test 
	public void getWeatherStatus() {    
	RestAssured.baseURI = "http://api.weatherapi.com";
	
	RequestSpecification httpResponse = RestAssured.given();  
	
	Response response = httpResponse.request(Method.GET,"/v1/current.json?key=6483ec3700b74ecf81585748202811&q=London");   
	

	 String statusLine=response.getStatusLine();
	 System.out.println("status Line is : "+statusLine);
	 
	 int statusCode=response.getStatusCode();
	 System.out.println("status Code is : "+statusCode);
	 Assert.assertEquals(statusCode, 200);
	}
	
	

}
