package Dummy_employee;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_weather2 {
	@Test
	void getweatherDetails() {
		
		//Specity base URI
		RestAssured.baseURI="http://api.weatherapi.com";
		//Request Object
		RequestSpecification httprequest= RestAssured.given();
		//Response object
		Response response =httprequest.request(Method.GET,"/v1/current.json?key=6483ec3700b74ecf81585748202811&q=London");
		//print response in console window
		String responseBody = response.getBody().asString();
		 System.out.println("Response Body is =>  " + responseBody);
		
		 //status code validation
		 int statusCode=response.getStatusCode();
		 System.out.println("status Code is : "+statusCode);
		 Assert.assertEquals(statusCode, 200);
//		 
//		 //Sratus line varification
		 String statusLine=response.getStatusLine();
		 System.out.println("status Line is : "+statusLine);
		 Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}


}
