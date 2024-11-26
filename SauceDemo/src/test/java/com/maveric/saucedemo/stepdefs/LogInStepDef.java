package com.maveric.saucedemo.stepdefs;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.maveric.saucedemo.databeans.UserBean;
import com.maveric.saucedemo.pagebean.LoginPageBean;
import com.maveric.saucedemo.utils.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Scenario;

public class LogInStepDef {

	private LoginPageBean pageBean;

	private WebDriver driver;

	@Test
	@Before
	public void setUpEnv() {
		System.out.println("Before  ");
		driver = DriverFactory.getDriver();
		pageBean = PageFactory.initElements(driver, LoginPageBean.class);
	}

	@Given("User is on saucedemo loging page")
	public void user_is_on_saucedemo_loging_page() {
		driver.get("https://www.saucedemo.com/");
	}
	
	@DataTableType
	public UserBean userBeanData(Map<String, String> inputData) {
		UserBean bean = new UserBean();
		bean.setUserName(inputData.get("userName"));
		bean.setPasswsord(inputData.get("password"));
		return bean;
	}

	@When("User enter wrong credentials")
	public void user_enter_wrong_credentials(UserBean bean) {
		pageBean.setUsername(bean.getUserName());
		pageBean.setPassword(bean.getPasswsord());
		pageBean.signIn();
		String expectedErrorMsg = "Epic sadface: Username and password do not match any user in this service";
		String actualErrorMsg = pageBean.getErrorMessage();
		Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}

	@When("click on submit")
	public void click_on_submit() {
	  
	}

	@Then("{string} message should display")
	public void message_should_display(String string) {
	
	}

	@When("User enter valid credentials")
	public void user_enter_valid_credentials(UserBean bean) {
		pageBean.setUsername(bean.getUserName());
		pageBean.setPassword(bean.getPasswsord());
		pageBean.signIn();
	}

	@Then("user able to see home page of corresponding saucedemo account")
	public void user_able_to_see_home_page_of_corresponding_saucedemo_account() {
	    
	}	
	
	@After
	public void tearDownEnv(Scenario scenario) throws InterruptedException {
		if(scenario.isFailed()) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			byte [] screenShot= takesScreenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", "errorScreen");
		}
		Thread.sleep(1000);
		driver.quit();
	}
	
}
