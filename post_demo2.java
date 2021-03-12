package toolsQA;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class post_demo2 {
	
@Test
public class RegistrationSuccessResponse {
 
 // Variable where value of SuccessCode node
 // will be copied
 // Note: The name should be exactly as the node name is 
 // present in the Json
 public String SuccessCode;
 
 // Variable where value of Message node will
 // be copied
 // Note: The name should be exactly as the node name is 
 // present in the Json
 public String Message;
}
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
 
 // Deserialize the Response body into RegistrationSuccessResponse
 RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
 
 // Use the RegistrationSuccessResponse class instance to Assert the values of 
 // Response.
 Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
 Assert.assertEquals("Operation completed successfully", responseBody.Message);
}
}
