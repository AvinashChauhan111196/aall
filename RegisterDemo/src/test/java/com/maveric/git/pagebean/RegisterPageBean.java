package com.maveric.git.pagebean;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPageBean {

	
	@FindBy( how = How.XPATH,  xpath = "/html/body/section/div/div/div[2]/form/div[1]/div[1]/input")
	private WebElement firstname;
	
	@FindBy(how = How.XPATH, xpath="/html/body/section/div/div/div[2]/form/div[1]/div[2]/input")
	private WebElement lastname;
	
	@FindBy(how = How.XPATH, xpath="/html/body/section/div/div/div[2]/form/div[3]/div[1]/input")
	private WebElement email;
	
	
	@FindBy(how = How.XPATH, xpath ="/html/body/section/div/div/div[2]/form/div[4]/div/input")
	private WebElement phone;


	public void getFirstname(String firstname) {
		 this.firstname.sendKeys(firstname);
	}


	public void setUsername(String lastname) {
		this.lastname.sendKeys(lastname);
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public void setPhone(String phone) {
		this.phone.sendKeys(phone);
	}

}
