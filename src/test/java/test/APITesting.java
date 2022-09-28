package test;


import java.util.Iterator;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class APITesting {
	
	@Test(priority = 1)
	public void getMehod() {
    RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";   
    RequestSpecification httpRequest = RestAssured.given();
    Response response = httpRequest.get("");  
    ResponseBody body = response.body();
    
    String bodyResponse = body.asString();
    
    System.out.println(response.getStatusLine());
    System.out.println(bodyResponse);
    int statusCode = response.getStatusCode();
    System.out.println("Status code is : "+statusCode);
    Assert.assertEquals(statusCode, 200);

	}
	
	
	@Test(priority = 2)
	public void postMethod() {
		
		RestAssured.baseURI ="https://reqres.in/api/users"; 
	    RequestSpecification request = RestAssured.given(); 
	    JSONObject requestParams = new JSONObject();
	    requestParams.put("name", "Sreeni");
	    requestParams.put("job", "Tester"); 
	    request.body(requestParams.toJSONString());
	    Response response = request.post();
	    ResponseBody body = response.body();
	    

	    String bodyResponse = body.asString();
	    
	    System.out.println(response.getStatusLine());
	    System.out.println(bodyResponse);
	    
	    int statuscode=response.getStatusCode();
	    System.out.println("Status code is : "+statuscode);
	    Assert.assertEquals(statuscode,201);
		
	}
	
	@Test(priority = 3)
	public void putMethod() {
		
		RestAssured.baseURI ="https://reqres.in/api/users/2"; 
	    RequestSpecification request = RestAssured.given(); 
	    JSONObject requestParams = new JSONObject();
	    requestParams.put("name", "Sreeni");
	    requestParams.put("job", "Tester"); 
	    request.body(requestParams.toJSONString());
	    Response response = request.put();
	    ResponseBody body = response.body();
	    
	    String bodyResponse = body.asString();
	    
	    System.out.println(response.getStatusLine());
	    System.out.println(bodyResponse);
	    
	    int statuscode=response.getStatusCode();
	    System.out.println("Status code is : "+statuscode);
	    Assert.assertEquals(statuscode,200);
	}
	
	@Test(priority = 4)
	public void patchMethod() {
		
		RestAssured.baseURI ="https://reqres.in/api/users/2"; 
	    RequestSpecification request = RestAssured.given(); 
	    JSONObject requestParams = new JSONObject();
	    requestParams.put("name", "TestPerson");
	    requestParams.put("job", "Tester2"); 
	    request.body(requestParams.toJSONString());
	    Response response = request.patch();
	    ResponseBody body = response.body();
	    
	    String bodyResponse = body.asString();
	    
	    System.out.println(response.getStatusLine());
	    System.out.println(bodyResponse);
	    
	    int statuscode=response.getStatusCode();
	    System.out.println("Status code is : "+statuscode);
	    Assert.assertEquals(statuscode,200);
	}
	
	
	@Test(priority = 5)
	public void deleteMethod() {
		
		RestAssured.baseURI ="https://reqres.in/api/users/2"; 
	    RequestSpecification request = RestAssured.given(); 
	   
	    Response response = request.delete();
	    ResponseBody body = response.body();
	    
	    String bodyResponse = body.asString();
	    
	    System.out.println(response.getStatusLine());
	    System.out.println(bodyResponse);
	    
	    int statuscode=response.getStatusCode();
	    System.out.println("Status code is : "+statuscode);
	    Assert.assertEquals(statuscode,204);
	}
	
	
	
	
	@Test(priority = 6)
	public void POJOTest() throws JsonProcessingException
	{

		ObjectMapper objectMapper = new ObjectMapper();
	
		ObjectNode bakeryitems = objectMapper.createObjectNode();
		
	
		bakeryitems.put("id", 0001);
		bakeryitems.put("type", "donut");
		bakeryitems.put("name", "Cake");
		bakeryitems.put("ppu", 0.55);
		
		ObjectNode battersdetails = objectMapper.createObjectNode();
		
		ObjectNode batterdetails = objectMapper.createObjectNode();
		
		
		
		batterdetails.put("id", 1001);
		batterdetails.put("type", "Regular");
		
		batterdetails.put("id", 1002);
		batterdetails.put("type", "Chocolate");
		
		
	  //  bakeryitems.set("batters", );
		bakeryitems.set("batter", batterdetails);
		
		
		
		
		
		String createpojoobject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bakeryitems);
		System.out.println("Created POJO Object is : \n"+ createpojoobject);
		
	
	
		
	
	}
 

	
	
	
	
	
}
