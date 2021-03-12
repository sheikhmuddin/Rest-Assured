package reqres_demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class deletUser_rest {
	@Test
	 public void deleteUser() {
	  RestAssured.baseURI = "https://reqres.in/api/users​";
	  
	  Response response = RestAssured.given()
	    .contentType(ContentType.JSON)
	    .delete("1");
	  
	  int statuCode = response.getStatusCode();
	  
	  Assert.assertEquals(statuCode, 204,"correct Status code");
	 }

}
