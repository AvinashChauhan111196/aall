package com.maveric.project.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearch {
	public static void main(String args[]) {
		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://www.google.co.in");
		By byName = By.name("q");
		WebElement element = driver.findElement(byName);
		element.sendKeys("Agile");
		WebElement submitBtn = driver.findElement(By.name("btnK"));
		submitBtn.submit();
		driver.close();
		
	}

}
