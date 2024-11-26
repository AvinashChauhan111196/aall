package com.maveric.project.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.maveric.project.utils.DriverFactory;

public class ActionClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");
		driver.switchTo().frame("iframeResult");
		Actions act = new Actions(driver);
		WebElement DoubleClick = driver.findElement(By.xpath("//button[normalize-space()='Double-click me']"));
		act.doubleClick(DoubleClick).perform();
		
	}

}
