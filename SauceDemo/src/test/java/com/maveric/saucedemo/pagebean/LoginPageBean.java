package com.maveric.saucedemo.pagebean;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageBean {
	
	@FindBy( how = How.ID,  id = "user-name")
	private WebElement username;
	
	@FindBy(how = How.NAME, name="password")
	private WebElement password;
	
	@FindBy(how = How.XPATH, xpath="//*[@id=\"login-button\"]")
	private WebElement commit;
	
	
	@FindBy(how = How.XPATH, xpath ="//div[@class='error-message-container error']/h3")
	private WebElement errorMessage;
		
	
	public String getUsername() {
		return username.getText();
	}


	public void setUsername(String username) {
		this.username.sendKeys(username);
	}


	public String  getErrorMessage() {
		return errorMessage.getText();
	}


	public String  getPassword() {
		return password.getText();
	}


	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	
	
	public void signIn() {
		commit.submit();
	}
}
