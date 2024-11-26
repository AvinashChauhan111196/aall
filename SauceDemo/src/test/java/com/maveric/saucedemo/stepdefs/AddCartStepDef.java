package com.maveric.saucedemo.stepdefs;

import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.maveric.saucedemo.databeans.CustomerBean;
import com.maveric.saucedemo.databeans.ProductBean;
import com.maveric.saucedemo.pagebean.AddCartPageBean;
import com.maveric.saucedemo.pagebean.LoginPageBean;
import com.maveric.saucedemo.utils.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCartStepDef {

	private LoginPageBean pageBean;
	private WebDriver driver;	
	private AddCartPageBean addBean;	
	String url = "https://www.saucedemo.com/";

	
	@Before
	public void setUpEnv() {
		driver = DriverFactory.getDriver();
		pageBean = PageFactory.initElements(driver, LoginPageBean.class);
		addBean = PageFactory.initElements(driver, AddCartPageBean.class);
	}

	@DataTableType
	public ProductBean productBeanData(Map<String,String> productBean) {
		ProductBean bean=new ProductBean();
		bean.setProduct1(productBean.get("product1"));
		bean.setProduct2(productBean.get("product2"));
		bean.setProduct3(productBean.get("product3"));
		return bean;
	}
	
	@Given("User has already login")
	public void user_has_already_login() throws InterruptedException {
		driver.get(url);
		pageBean.setUsername("standard_user");
		pageBean.setPassword("secret_sauce");
		pageBean.signIn();
		}

	@When("User add product in cart")
	public void user_add_product_in_cart(ProductBean productbean) throws InterruptedException {
		if(productbean.getProduct1().equals("product1"))addBean.clickProduct1();
		if(productbean.getProduct2().equals("product2"))addBean.clickProduct2();
		if(productbean.getProduct3().equals("product3"))addBean.clickProduct3();
		Thread.sleep(1000);
		
	}

	@When("User click on cart icon")
	public void user_click_on_cart_icon() throws InterruptedException {
	 
		addBean.cartBtnClick();
		Thread.sleep(1000);
	}

	@When("User click on checkout")
	public void user_click_on_checkout() throws InterruptedException {
	 
		addBean.checkoutButtonClicked();
		Thread.sleep(1000);
	}
	
	@DataTableType
	public CustomerBean CustomerDetailsBeanData(Map<String,String> CustBean) {
	CustomerBean bean=new CustomerBean();
	bean.setFirstname(CustBean.get("FirstName"));
	bean.setLastname(CustBean.get("LastName"));
	bean.setPostalcode(CustBean.get("PostalCode"));
	return bean;
	}
	
	@When("User fill details")
	public void user_fill_details(CustomerBean bean) throws InterruptedException {
		addBean.setFirstname(bean.getFirstname());
		addBean.setLastname(bean.getLastname());
		addBean.setPostalcode(bean.getPostalcode());
	    Thread.sleep(1000);
	}

	@When("User click on continue")
	public void user_click_on_continue() throws InterruptedException {
	    addBean.continueBtnClicked();
	    Thread.sleep(1000);
	}

	@When("User able to finish")
	public void user_able_to_finish() throws InterruptedException {
	addBean.finishBtnClick();
	Thread.sleep(1000);
	}

	@Then("{string} should display message")
	public void should_display_message(String string) {
	
		String expectedMsg = "Thank you for your order!";
		String actualMsg = addBean.getFinishmsg();
		Assert.assertEquals(expectedMsg, actualMsg);
	}

	
}
