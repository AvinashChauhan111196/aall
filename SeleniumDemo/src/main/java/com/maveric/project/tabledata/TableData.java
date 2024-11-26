package com.maveric.project.tabledata;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.maveric.project.utils.DriverFactory;

public class TableData {
	
	public static void main(String args[])
	{
		WebDriver driver = DriverFactory.getDriver();
		
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		int rows = driver.findElements(By.xpath("//table[@id='customers'//tbody/tr]")).size();
		System.out.println("Number of rows:=" +rows);
		
		int colms = driver.findElements(By.xpath("//table[@id='customers']//tbody/tr/th")).size();
		System.out.println("Number of columns:=" +colms);
		
		String value1 = driver.findElement(By.xpath("//table[@id='customers']//tr[2]/td[3]")).getText();
		System.out.println(value1);
		
		String value2 = driver.findElement(By.xpath("//table[@id='customers']//tr[3]/td[1]")).getText();
		
		for(int r =2;r<=rows;r++)
		{
			for(int c=1;c<=colms;c++)
			{
				String data = driver.findElement(By.xpath("//table[@id='customers']//tr["+r+"]/d["+c+"]")).getText();
				System.out.print(data+"");
				
			}
			System.out.println();
		}
		
	}

}
