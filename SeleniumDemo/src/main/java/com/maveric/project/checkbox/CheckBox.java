package com.maveric.project.checkbox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.maveric.project.utils.DriverFactory;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		WebElement checkbox=driver.findElement(By.id("checkbox1"));
		boolean selected=checkbox.isSelected();
		
		if(!selected) {
			checkbox.click();
		}
		List<WebElement> allCheckBox= driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		System.out.println(allCheckBox.size());
		//driver.quit();
	}

}
