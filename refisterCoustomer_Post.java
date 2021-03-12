package OPenWeather;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class refisterCoustomer_Post {
	

	 
		
		@Test
		void getweatherDetails() {
			
			//Specity base URI
			RestAssured.baseURI="https://restapi.demoqa.com/customer";
			//Request Object
			RequestSpecification httprequest= RestAssured.given();
			
			
			
			//Request paylod senting along with poat request
			JSONObject requestParams=new JSONObject();
			requestParams.put("FirstName","Sheikh");
			requestParams.put("LastName", "Uddin");
			requestParams.put("UserName","sheikh123");
			requestParams.put("Password", "sheikhxys");
			requestParams.put("Email", "sheikhxyz@gmail.com");
			
			httprequest.header("Content-Type","application/json");
			httprequest.body(requestParams).toString();
			
			//Response object
			Response response =httprequest.request(Method.POST,"/register");
			
//			//print response in console window
			String responseBody = response.getBody().asString();
			 System.out.println("Response Body is =>  " + responseBody);
			
			 //status code validation
			 int statusCode=response.getStatusCode();
			 System.out.println("status Code is : "+statusCode);
			 Assert.assertEquals(statusCode, 201);
			 
			 String SuccesCode=response.jsonPath().get("SuccessCode");
			 Assert.assertEquals(SuccesCode, "OPERATION_SUCCESS");
			 
		 
		}

}
