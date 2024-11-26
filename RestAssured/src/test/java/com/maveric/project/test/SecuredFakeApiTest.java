package com.maveric.project.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maveric.project.auths.ClientAuthConstant;
import com.maveric.project.pojo.AirlinePojo;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SecuredFakeApiTest {

	@BeforeClass
	public static void setUpAuthEnv() {
		ClientAuthConstant.BEARER_TOKEN = RestAssured.given()
				.contentType("application/x-www-form-urlencoded; charset=utf-8")
				.formParam("grant_type", ClientAuthConstant.GRANT_TYPE)
				.formParam("scope", ClientAuthConstant.SCOPE)
				.formParam("username", ClientAuthConstant.USER_NAME)
				.formParam("password", ClientAuthConstant.PASSWORD)
				.formParam("client_id", ClientAuthConstant.CLIENT_ID)
				.when()
				.post("https://dev-457931.okta.com/oauth2/aushd4c95QtFHsfWt4x6/v1/token").then().extract()
				.path("access_token");
	}

 
	@BeforeClass
	public static void setUpAPIEnv() {
		RestAssured.baseURI = "https://api.instantwebtools.net/v2";
	}
	@Test(testName = "Get all airlines details")
	public void test1() {
		String airlinesDetails= RestAssured.given().headers(
	              "Authorization",
	              "Bearer " + ClientAuthConstant.BEARER_TOKEN,
	              "Content-Type",
	              ContentType.JSON,
	              "Accept",
	              ContentType.JSON)
		.when()
		.get("/airlines")
		.then()
		.log().body().toString();
		System.out.println("======= " +airlinesDetails );
	}
	@Test(testName = "Get sepcific airline details")
	public void test2() {
		RestAssured.given().headers(
	              "Authorization",
	              "Bearer " + ClientAuthConstant.BEARER_TOKEN,
	              "Content-Type",
	              ContentType.JSON,
	              "Accept",
	              ContentType.JSON)
		.when()
		.get("/airlines/73dd5420-3bf9-48f3-a0b6-17cf7aa61b19")
		.then()
		.assertThat()
		.log().body().toString();
		//.body("name", equalToObject("American Airlines"));

	}
	
	@Test(testName = "Create airline data.")
	public void test3() throws StreamReadException, DatabindException, IOException {
		
		ObjectMapper Mapper = new ObjectMapper();
	
		FileInputStream stream = new FileInputStream(new File("./TestData/AirlineData.json"));
	    AirlinePojo payload = Mapper.readValue(stream, AirlinePojo.class);
		
	    RestAssured.given().headers(
	              "Authorization",
	              "Bearer " + ClientAuthConstant.BEARER_TOKEN,
	              "Content-Type",
	              ContentType.JSON,
	              "Accept",
	              ContentType.JSON)
	    
	    .when()
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

}
