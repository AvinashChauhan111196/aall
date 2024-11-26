package com.maveric.git.test;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.maveric.git.pagebean.LoginPageBean;
import com.maveric.project.utils.DriverFactory;

public class LoginTest {
  
	private WebDriver driver;
	private LoginPageBean pageBean ;

	@BeforeMethod
	public void setSupTestEnv() {
		driver = DriverFactory.getDriver();
		driver.get("https://github.com/login");
		pageBean = PageFactory.initElements(driver, LoginPageBean.class);
	}

	@Test (testName = "Test Git Sign-In Service for invalid credentials ")
	public void test1() {	
		pageBean.setUsername("Jdjkdjd");
		pageBean.setPassword("jhdewhjewj");
		pageBean.signIn();
		String expectedErrorMsg ="Incorrect username or password.";
		String actualErrorMsg = pageBean.getErrorMessage();
		Assertions.assertEquals(expectedErrorMsg, actualErrorMsg);
		
		
	}
	@Test (testName = "Test Git Sign-In Service for valid credentials ")
	
	public void test2() {

		pageBean.setUsername("GauravTelgu");
		pageBean.setPassword("Gt@250398");
		pageBean.signIn();
		//String expectedErrorMsg ="Incorrect username or passwo";
		//String actualErrorMsg = pageBean.getErrorMessage();
		//Assertions.assertEquals(expectedErrorMsg, actualErrorMsg);
	}
	
	@AfterMethod
	public void tearDownTestEnv() {
		driver.quit();
	}
	}
