package com.maveric.project.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maveric.project.pojos.LoginPojo;
import com.maveric.project.pojos.RegisterPojo;
import com.maveric.project.pojos.RegisterUnSuccessPojo;
import com.maveric.project.pojos.User;
import com.maveric.project.pojos.UserPojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestApiTest {

	@BeforeClass
	public static void setUpEnv(){
		RestAssured.baseURI="https://reqres.in/";
	}
	
	@Test(testName = "list users")
	public void test1() {
		String responsebody = RestAssured.get("/api/users?page=2").then().assertThat().statusCode(200).and().log().body()
				.extract().asString();
	}
	
	@Test(testName = "Single User")
	public void test2() {
		String responseBody = RestAssured.get("/api/users/2").then().assertThat().statusCode(200).log().body()
				.toString();
		System.out.println(responseBody);
	}
 
	@Test(testName = "SINGLE USER NOT FOUND")
	public void test3() {
		String responseBody = RestAssured.get("/api/users/23").then().assertThat().statusCode(404).log().body()
				.toString();
		System.out.println(responseBody);
	}
 
	@Test(testName = "LIST <RESOURCE>")
	public void test4() {
		String responseBody = RestAssured.get("/api/unknown").then().assertThat().statusCode(200).log().body()
				.toString();
		System.out.println(responseBody);
	}
 
	@Test(testName = "SINGLE <RESOURCE>")
	public void test5() {
		String responseBody = RestAssured.get("/api/unknown/2").then().assertThat().statusCode(200).log().body()
				.toString();
		System.out.println(responseBody);
	}
 
	@Test(testName = "SINGLE <RESOURCE> NOT FOUND")
	public void test6() {
		String responseBody = RestAssured.get("/api/unknown/23").then().assertThat().statusCode(404).log().body()
				.toString();
		System.out.println(responseBody);
	}
  //POST
	
	@Test(testName = "Create ")
	public void test7() throws StreamReadException, DatabindException, IOException   {
       
		ObjectMapper mapper = new ObjectMapper();
		
		FileInputStream stream = new FileInputStream(new File("./TestData/UserData.json"));
		UserPojo payLoad = mapper.readValue(stream,UserPojo.class);
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.body(payLoad)
		.post("/api/users")
		.then()
		.assertThat().statusCode(201).log().body();
 
	}
	
	//put
	@Test(testName="Update user details")
	public void test8() {
		  User updatedUser = new User("morpheus","zion resident");
		
		 RestAssured.given()
		.contentType(ContentType.JSON)
		.body(updatedUser)
		.put("/api/users/2")
		.then()
		.assertThat().statusCode(200).log().body();
 
		
	}
	//Patch
	@Test(testName="Update user details")
	public void test9() {
		 User updatedUser = new User("morpheus","zion resident");
			
		 RestAssured.given()
		.contentType(ContentType.JSON)
		.body(updatedUser)
		.patch("/api/users/2")
		.then()
		.assertThat().statusCode(200).log().body();
 
	}
	//Delete
	@Test(testName="Delete user details")
	public void test10() {
		
		 RestAssured.given()
		.contentType(ContentType.JSON)
		.delete("/api/users/2")
		.then()
		.assertThat().statusCode(204).log().body();
 
	}
	
	//Post Register
	@Test(testName = "Register User using RegisterData.json file")
	public void test11() throws StreamReadException, DatabindException, IOException   {
       
		ObjectMapper mapper = new ObjectMapper();
		
		FileInputStream stream = new FileInputStream(new File("./TestData/RegisterData.json"));
		RegisterPojo payLoad = mapper.readValue(stream,RegisterPojo.class);
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.body(payLoad)
		.post("/api/register")
		.then()
		.assertThat().statusCode(200).log().body();
		
 
	}
	//Post Register unsuccessful
		@Test(testName = "Unsuccessful user using RegisterDataUnSucess.json file")
		public void test12() throws StreamReadException, DatabindException, IOException   {
	       
			ObjectMapper mapper = new ObjectMapper();
			
			FileInputStream stream = new FileInputStream(new File("./TestData/RegisterDataUnSuccess.json"));
			RegisterUnSuccessPojo payLoad = mapper.readValue(stream,RegisterUnSuccessPojo.class);
			
			RestAssured.given()
			.contentType(ContentType.JSON)
			.body(payLoad)
			.post("/api/register")
			.then()
			.assertThat().statusCode(400).log().body();
			
 
		}
		
		//Post Login successful
				@Test(testName = "Successful")
				public void test13() throws StreamReadException, DatabindException, IOException   {
			       
					ObjectMapper mapper = new ObjectMapper();
					
					FileInputStream stream = new FileInputStream(new File("./TestData/LoginData.json"));
					LoginPojo payLoad = mapper.readValue(stream,LoginPojo.class);
					
					RestAssured.given()
					.contentType(ContentType.JSON)
					.body(payLoad)
					.post("/api/login")
					.then()
					.assertThat().statusCode(200).log().body();
					
 
				}
			
			// Login unsuccessful using post	
				@Test(testName = "Login unsuccessful using LoginUnsuccess.json file")
				public void test14() throws StreamReadException, DatabindException, IOException   {
			       
					ObjectMapper mapper = new ObjectMapper();
					
					FileInputStream stream = new FileInputStream(new File("./TestData/LoginUnsuccess.json"));
					LoginPojo payLoad = mapper.readValue(stream,LoginPojo.class);
					
					RestAssured.given()
					.contentType(ContentType.JSON)
					.body(payLoad)
					.post("/api/login")
					.then()
					.assertThat().statusCode(400).log().body();
					
 
				}
				
				@Test(testName = "delay response")
				public void test15() {
					String responseBody = RestAssured.get("/api/users?delay=3").then().assertThat().statusCode(200).and().log().body()
							.extract().asString();
					
					System.out.println(responseBody);
				}
				
	
	
	
	@AfterClass
	public static void tearDownEnv() {
		RestAssured.reset();
	}
}
