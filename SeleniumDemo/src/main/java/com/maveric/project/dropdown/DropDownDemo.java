package com.maveric.project.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.maveric.project.utils.DriverFactory;

public class DropDownDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//driver.findElement(By.id("dropdown-class-example")).click();
		WebElement drp = driver.findElement(By.id("dropdown-class-example"));
		Select s = new Select(drp);
 
		List<WebElement> allopt = s.getOptions();
 
		for (WebElement ele : allopt) {
			s.selectByIndex(1);
		}

}
}
