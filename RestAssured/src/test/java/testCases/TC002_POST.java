package testCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class TC002_POST {
	
	
	@Test
	void getWeatherDetails() {
			
			//specify base URI
			
			RestAssured.baseURI ="https://gorest.co.in/public/v2/users";             //2401
			
			// request object
			RequestSpecification httpRequest = RestAssured.given();
			
			//to pass the body for POST request, create object of JSONObject
			JSONObject reqParameters = new JSONObject();
			
			//now pass the parameters as a JSON format
			reqParameters.put("FirstName", "VVV");
			reqParameters.put("LastName", "PPP");
			reqParameters.put("email", "abc@def,com");
			reqParameters.put("age", "25");
			
			
			httpRequest.header("Content-Type", "application/json");
			
			//attach the body data to the request
			httpRequest.body(reqParameters.toJSONString());
			
			//het the response
			Response res=  httpRequest.request(Method.POST, "/register");
			
			
			// print this response
		String responseBody = res.getBody().asPrettyString();
		
		System.out.println(responseBody);
}
}
