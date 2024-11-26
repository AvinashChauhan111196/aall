package com.maveric.project.test;

import static org.hamcrest.Matchers.equalToObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
import com.maveric.project.pojos.EmployeeCsvPojo;
import com.maveric.project.pojos.EmployeePojo;
import com.opencsv.bean.CsvToBeanBuilder;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class RestApiTest {
	@BeforeClass
	public static void setUpEnv(){
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
	}
	@Ignore
	@Test
	public void test1() throws IOException {
//		Response res=RestAssured.get("/employees");
//		Assert.assertEquals(res.getStatusCode(), 200);
		String responsebody = RestAssured.get("/employees").then().assertThat().statusCode(200).and().log().body()
				.extract().asString();
		//String resBody=RestAssured.get("/employees").then().assertThat().statusCode(200).and().log().body().toString();
		System.out.println(responsebody);
		ObjectMapper objectMapper = new ObjectMapper();
		FileInputStream stream = new FileInputStream(new File("./TestData/EmployeeData.json"));
		EmployeePojo employee = objectMapper.readValue(stream, EmployeePojo.class);
		
		System.out.println("Name: " + employee.getName());
		System.out.println("Salary: " + employee.getSalary());
		System.out.println("Age: " + employee.getAge());
		
	}
	@Ignore
	@Test(testName = "Get Specific Employee details")
 
	public void test2() {
		RestAssured.get("/employee/1").then().assertThat().statusCode(200).and().body("employee_name",equalToObject("Tiger Nixon"));
	}
	@Ignore
	@Test
	public void test3() {
		String payload= "{name:test,salary:3000,age:21}";
		RestAssured.given().contentType(ContentType.JSON).body(payload)
		.post("/create").then().assertThat()
		.statusCode(HttpStatus.SC_CREATED)
		.and()
		.body("message", equalToObject("Successfully! Record has been added."));
	}
	@Ignore
	@Test
	public void test4() {
		//String payload= "{name:test,salary:3000,age:21}";
		HashMap<String, String> payload=new HashMap<>();
		payload.put("name", "ram");
		payload.put("salary", "10000");
		payload.put("age", "18");
		RestAssured.given().contentType(ContentType.JSON).body(payload)
		.post("/create").then().assertThat()
		.statusCode(HttpStatus.SC_CREATED)
		.and()
		.body(CoreMatchers.containsString("Successfully"));
	}
	@Ignore
	@Test
	public void test5() {
		EmployeePojo payload=new EmployeePojo("ram", "15000", "25");
		RestAssured.given().contentType(ContentType.JSON).body(payload)
		.post("/create").then().assertThat()
		.statusCode(HttpStatus.SC_CREATED)
		.and()
		.body(CoreMatchers.containsString("Successfully"));
	}
	@Ignore
	@Test
	public void test6() throws StreamReadException, DatabindException, IOException {
		ObjectMapper ob=new ObjectMapper();
		FileInputStream fis=new FileInputStream("./TestData/EmployeeData.json");
		EmployeePojo payload=ob.readValue(fis, EmployeePojo.class);
		
		RestAssured.given().contentType(ContentType.JSON).body(payload)
		.post("/create").then().assertThat()
		.statusCode(HttpStatus.SC_CREATED)
		.and()
		.body(CoreMatchers.containsString("Successfully"));
	}
	@Test
	public void test8() throws DatabindException, IOException {
		String uri = "/create";
 
		/*
		 * FileReader reader = new FileReader("./TestData/EmployeeMockData.csv");
		 * CsvToBeanBuilder<EmployeeCsvPojo> beanBuilder = new CsvToBeanBuilder(reader);
		 * beanBuilder = beanBuilder.withType(EmployeeCsvPojo.class);
		 * CsvToBean<EmployeeCsvPojo> toBean = beanBuilder.build();
		 * List<EmployeeCsvPojo> beans = toBean.parse();
		 */
 
		List<EmployeeCsvPojo> beans = new CsvToBeanBuilder(new FileReader("./TestData/EmployeeMockData.csv")) // example of builder pattern
				.withType(EmployeeCsvPojo.class).build().parse();
 
		  RestAssured.given()
		  .contentType(ContentType.JSON) .
		  body(beans) .
		  post(uri)
		  .then() .
		  assertThat().
		  body("message",  equalToObject("Successfully! Record has been added."));
	}
	
	@Test(testName = "update employee details")
		public void test9() {
			
			String name = "Avi";
		     int salary = 40000;
		     int age = 26;
		
		     String requestBody = "{\n" +
		             "    \"name\": \"" + name + "\",\n" +
		             "    \"salary\": " + salary + ",\n" +
		             "    \"age\": " + age + "\n" +
		             "}";
		
		     
		             Response response = RestAssured.given()
		             .contentType(ContentType.JSON)
		             .body(requestBody)
		             .put("/employees");
		             System.out.println(requestBody);
		}
	@Test(testName = "delete employee details")
	public void test10() {
			
			String name = "Avinash"; // Assuming you have the employee name you want to delete
 
			Response response = RestAssured.given()
				.contentType(ContentType.JSON)
				.delete("/employees/" + name);
				
			System.out.println("Deleted employee with name: " + name);
		
		
	}
	 
	@AfterClass
	public static void tearDownEnv() {
		RestAssured.reset();
	}
	

}
