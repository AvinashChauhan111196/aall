package com.maveric.project.radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.maveric.project.utils.DriverFactory;

public class RadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		WebElement checkbox=driver.findElement(By.name("radiooptions"));
		boolean selected=checkbox.isSelected();
		
		if(!selected) {
			checkbox.click();
		}
	}

}
