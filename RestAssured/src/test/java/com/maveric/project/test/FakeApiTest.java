package com.maveric.project.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
 
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
 
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maveric.project.pojo.AirlinePojo;
import com.maveric.project.pojo.PassengerPojo;
 
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
 
public class FakeApiTest {
	@BeforeClass
	public static void setUpEnv() {
		RestAssured.baseURI = "https://api.instantwebtools.net/v1";
	}
 
	@Test(testName = "Get all the Airline Details")
	public void test1() throws JsonMappingException, JsonProcessingException {
 
		// validate respone
		String responseBody = RestAssured.get("/airlines").then().assertThat().statusCode(200).log().body()
				.toString();
		System.out.println(responseBody);
	}
	
	
	@Test(testName = "Create airline data.")
	public void test2() throws StreamReadException, DatabindException, IOException {
 
		ObjectMapper Mapper = new ObjectMapper();
	
		FileInputStream stream = new FileInputStream(new File("./TestData/Airlinedata.json"));
	    AirlinePojo payload = Mapper.readValue(stream, AirlinePojo.class);
		
	    ValidatableResponse response = RestAssured.given()
		.contentType(ContentType.JSON)
		.body(payload)
		.post("/airlines")
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_OK)
		.and()
		.body("name",equalTo("Sri Lankan Airways"))
		.log()
		.all();
		
		
 
	}
	
	@Test(testName = "UPDATE passenger name with correct passenger ID.")
	public void test3() {
		String passengerID = "667aafa07ad8fbcd834342a6";
		String newName = "Jospeh Francis";
 
		String payload = "{\"name\": \"" + newName + "\"}";
 
		RestAssured.given().contentType(ContentType.JSON).pathParam("id", passengerID).body(payload).when()
				.patch("/passenger/{id}").then().assertThat().statusCode(200).and()
				.body("message", equalToObject("Passenger data updated successfully.")).log().all();
	}
	
	@Test(testName = "Update every detail of a passenger.")
	public void test4() {		
		String passengerID = "6679447b7ad8fb3f5e433c33";
		String newname = "Haulmer Airlines";
	    int trips = 500;
	    int airline = 10;
	     String requestBody = "{\n" +
	             "    \"name\": \"" + newname + "\",\n" +
	             "    \"salary\": " + trips + ",\n" +
	             "    \"age\": " + airline + "\n" +
	             "}";     
	             Response response = RestAssured.given()
	             .contentType(ContentType.JSON)
	             .pathParam("id",passengerID)
	             .body(requestBody)
	             .put("/passenger/{id}");
	             System.out.println(requestBody);
	}
 
	@AfterClass
	public static void tearDownEnv() {
		RestAssured.reset();
	}
}