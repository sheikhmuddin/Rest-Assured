package toolsQA;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Post_customer {
	@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="https://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "63userf2d3d2011");
		requestParams.put("Password", "password1");	
		requestParams.put("Email",  "ed26dff39@gmail.com");

		request.body(requestParams.toJSONString());
		Response response = request.post("/register");

		ResponseBody body = response.getBody();
		System.out.println(response.body().asString());

		if(response.statusCode() == 200)
		{
			// Deserialize the Response body into RegistrationFailureResponse
			RegistrationFailureResponse responseBody = body.as(RegistrationFailureResponse.class);

			// Use the RegistrationFailureResponse class instance to Assert the values of 
			// Response.
			Assert.assertEquals("User already exists", responseBody.FaultId);
			Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.fault);	
		}
		else if (response.statusCode() == 201)
		{
			// Deserialize the Response body into RegistrationSuccessResponse
			RegistrationFailureResponse responseBody = body.as(RegistrationFailureResponse.class);
			// Use the RegistrationSuccessResponse class instance to Assert the values of 
			// Response.
			Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
			Assert.assertEquals("Operation completed successfully", responseBody.Message);	
		}	
	}

}
