package com.maveric.project.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.maveric.project.utils.DriverFactory;

public class MouseOverAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Actions act = new Actions(driver);
		WebElement mouseover = driver.findElement(By.id("mousehover"));
		WebElement mouseTop = driver.findElement(By.xpath("//a[normalize-space()='Reload']"));
		act.moveToElement(mouseover).moveToElement(mouseTop).click().perform();
		driver.close();
	}

}
