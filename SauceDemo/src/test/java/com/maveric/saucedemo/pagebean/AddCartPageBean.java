package com.maveric.saucedemo.pagebean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCartPageBean {
	
	@FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
	private WebElement product1;
	@FindBy(how=How.ID,using="add-to-cart-sauce-labs-bike-light")
	private WebElement product2;
	@FindBy(how=How.ID,using="add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement product3;
	@FindBy(how=How.XPATH,using="//a[@class='shopping_cart_link']")
	private WebElement cartButton;
	@FindBy(how = How.ID,id="checkout")
    private WebElement checkout;
	@FindBy(how=How.ID,id="first-name")
	private WebElement firstname;
	@FindBy(how=How.XPATH,using="//input[@id='last-name']")
	private WebElement lastname;
	@FindBy(how=How.ID,id="postal-code")
	private WebElement postalcode;
	@FindBy(how=How.XPATH,xpath="//input[@type='submit']")
	private WebElement Continue;
	@FindBy(how = How.ID, id = "finish")
	private WebElement finishbtn;
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Thank you for your order!')]")
	private WebElement finishmsg;
	
	public String getFinishmsg() {
		return finishmsg.getText();
	}
	public void setFirstname(String firstname) {
		this.firstname.sendKeys(firstname);
	}
	public void setLastname(String lastname) {
		this.lastname.sendKeys(lastname);
	}
	public void setPostalcode(String postalcode) {
		this.postalcode.sendKeys(postalcode);
	}
	public void continueBtnClicked() {
		this.Continue.click();
	}
	public void clickProduct1() {
		product1.click();
	}
	public void clickProduct2() {
		product2.click();
	}
	public void clickProduct3() {
		product3.click();
	}
	public void cartBtnClick() {
		this.cartButton.click();
	}

	public void checkoutButtonClicked() {
    	this.checkout.click();
    }
	public void finishBtnClick() {
		this.finishbtn.click();
	}
		
	
}
