package com.TestPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.BasecClass;
import com.pageclass.HomePage;
import com.pageclass.OrderBookPage;

public class LoginTestClass extends BasecClass{

	HomePage home;
	
	@BeforeClass 
	public void AppiumstartServer() { 
		startAppiumServer();
	  
	  }
	  
	  @Parameters({"deviceName", "platformName", "platformVersion",
	  "appPackage", "appActivity","udid", "noReset", "automationName"}) 
	  @BeforeClass
	  public void initialiseAppium(String deviceName,String platformName, String
	  platformVersion, String appPackage, String appActivity,String udid, String
	  noReset, String automationName) 
	  { 
		  initialise(deviceName, platformName, platformVersion, appPackage, appActivity,udid, noReset, automationName); 
		  
	  }
	  
	  @BeforeClass
		public void testconstructor()
		{
			home=new HomePage(driver);
			
		}
	 
	  	
	  
	  @Test(priority =1)
	  public void start()
	  {
		  home.SearchShoes();
		  home.back();
	  }
	  
	  
	  @Test(priority =2)
	  public OrderBookTest ordbook()
	  {
		  
		  return new OrderBookTest();
	  }
	  
	  
	/*
	 * @AfterClass public void quit() { driver.quit(); }
	 */
}
