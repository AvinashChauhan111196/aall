package com.maveric.project;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestSuite {
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("beforeSuite()");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("afterSuite()");
	}
}
