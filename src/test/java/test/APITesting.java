package test;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.io.Files;

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
	 
	@Test(priority = 0)
	public void POJOTest() throws IOException
	{
	    ObjectMapper objectMapper = new ObjectMapper();
		   
		BakeryItems bakeryitems = new BakeryItems();
		
		Batter batter = new Batter();
		Batter batter2 = new Batter();
		Batter batter3 = new Batter();
		Batter batter4 = new Batter();
		
		Topping topping1 = new Topping();
		Topping topping2 = new Topping();
		Topping topping3 = new Topping();
		Topping topping4= new Topping();
		Topping topping5 = new Topping();
		Topping topping6 = new Topping();
		Topping topping7 = new Topping();
		
		bakeryitems.setId(0001);
		bakeryitems.setType("donut");
		bakeryitems.setName("Cake");
		bakeryitems.setPPU(0.55);
		
		batter.setId(1001);
		batter.setType("Regular");
		
		batter2.setId(1002);
		batter2.setType("Chocolate");
		
		batter3.setId(1003);
		batter3.setType("Blueberry");
		
		batter4.setId(1004);
		batter4.setType("Devil's Food");
	
		
		topping1.setId(5001);
		topping1.setType("None");
		
		topping2.setId(5002);
		topping2.setType("Glazed");
		
		topping3.setId(5003);
		topping3.setType("Chocolate");
		
		topping4.setId(5004);
		topping4.setType("Maple");
		
		topping5.setId(5005);
		topping5.setType("Sugar");
		
		topping6.setId(5006);
		topping6.setType("Chocolate with Sprinkles");
		
		topping7.setId(5007);
		topping7.setType("Powdered Sugar");
		
		List<Batter> batters=new ArrayList();
		batters.add(batter);
		batters.add(batter2);
		batters.add(batter3);
		batters.add(batter4);
		
		List<Topping> toppings=new ArrayList();
		toppings.add(topping1);
		toppings.add(topping2);
		toppings.add(topping3);
		toppings.add(topping4);
		toppings.add(topping5);
		toppings.add(topping6);
		toppings.add(topping7);
		
		
		bakeryitems.setBatter(batters);
		bakeryitems.setTopping(toppings);
			
		String bakeryitemsresponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bakeryitems);
		System.out.println("BakeryItems details in Json format is : \n"+ bakeryitemsresponse);
		
		byte[] responseAsStringByte=bakeryitemsresponse.getBytes();
		File bakeryitemsjsonfile=new File("./output/Bakery_Items.json");
		
		Files.write(responseAsStringByte, bakeryitemsjsonfile);
		
		
	}
	
	
	
	
	
}
