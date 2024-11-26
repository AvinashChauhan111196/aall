package com.maveric.project.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static WebDriver WebDriverExplicitConfig() {
		// Explicit way to Configure Selenium Driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\avinashkc\\Documents\\selenium_driver\\chromedriver-win64\\chromedriver.exe");
 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.setBinary("C:\\Users\\avinashkc\\Documents\\selenium_driver\\chrome-win64\\chrome.exe");
		return new ChromeDriver(options);
 
	}
 
	// Implicit way to Configure Selenium Driver
 
	private static WebDriver WebDriverImplicitConfig() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("start-maximized");
		return new ChromeDriver(options);
	}
 
	public static WebDriver getDriver() {
		WebDriver driver = WebDriverExplicitConfig();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
 
	}
}
