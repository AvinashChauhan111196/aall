package com.maveric.project.waitdemo;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maveric.project.utils.DriverFactory;

public class WaitDemo {
	
	
	public static void main(String[] args) {
		explicitWait();
	}

	public static void implictWait() {
		WebDriver driver = DriverFactory.getDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   
	}
	public static void explicitWait() {
		WebDriver driver = DriverFactory.getDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
		ExpectedCondition<Boolean> elementSelectable = ExpectedConditions.elementToBeSelected(By.xpath(""));
		wait.until(elementSelectable);
		
		ExpectedCondition<WebElement> elementClickable  = ExpectedConditions.elementToBeClickable(By.xpath(""));
		wait.until(elementClickable);
		
		ExpectedCondition<Alert> alret = ExpectedConditions.alertIsPresent();
		wait.until(alret);
		
		ExpectedCondition<WebDriver> elementFrame = ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(""));
		wait.until(elementFrame);
		
		ExpectedCondition<WebElement> elemenCondition = ExpectedConditions.visibilityOf(driver.findElement(By.xpath("")));
		wait.until(elemenCondition);
	}
	public static void fluentWait() {
		
		WebDriver driver = DriverFactory.getDriver();
		
		
		Wait<WebDriver>wait = new FluentWait<>(driver).
								withTimeout(Duration.ofSeconds(10)).
								pollingEvery(Duration.ofSeconds(2)).
								ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
		
				
		
	}
}