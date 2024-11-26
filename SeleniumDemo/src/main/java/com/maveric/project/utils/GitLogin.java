package com.maveric.project.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GitLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://github.com/login");
		driver.findElement(By.name("login")).sendKeys("BalajiPatil8087");
		driver.findElement(By.name("password")).sendKeys("Yamaha@4583");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String element =driver.findElement(By.xpath("//div[contains(text(),'Incorrect username or password')]")).getText();
		System.out.println(element);

	}

}
