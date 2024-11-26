package com.maveric.project;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SampleTestClass1 {
	
	@BeforeTest
	public void sampleTestBeforeTest() {
		System.out.println("----> sampleTest1BeforeTest()");
	}
	@BeforeClass
	public void sampleTestBeforeClass()
	{
		System.out.println("----> sampleTest1BeforeClass");
	}
	
	@Test(priority=2)
	public void sampleTest1TestScenario1()
	{
		System.out.println("----> sampleTest1TestScenario1");
	}
	
	@Test(priority=1)
	public void sampleTest2TestScenario2()
	{
		System.out.println("----> sampleTest1TestScenario2");
	}
	
	@AfterTest
	public void sampleTestAfterTest() {
		System.out.println("----> sampleTest1BeforeTest()");
	}
	@AfterClass
	public void sampleTestAfterClass()
	{
		System.out.println("----> sampleTest1BeforeClass");
	}
	
	
}
