package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET {
	
	
	@Test
void getWeatherDetails() {
		
		//specify base URI
		
		RestAssured.baseURI ="https://gorest.co.in/public/v2/users";             //2401
		
		// request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//response object
		
		Response res = httpRequest.request(Method.GET, "/2379");
		
		//print this response
	
		
String resBody=	res.getBody().asString();
System.out.println("response ===="  +resBody);


//status code validation
int statusCode=res.getStatusCode();
System.out.println("Status code is ===" +statusCode);

Assert.assertEquals(statusCode, 200);


//status line verification

String statusLine= res.statusLine();
System.out.println("statusLine is ==="  +statusLine);
Assert.assertEquals(statusLine,"HTTP/1.1 200 OK" );


}
}

