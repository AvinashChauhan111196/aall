package com.maveric.project.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.maveric.project.utils.DriverFactory;

public class ScreenshotDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		
		WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src = section.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\Screenshot\\firstscreenshot.png");
		FileUtils.copyFile(src,trg);
	}

}
