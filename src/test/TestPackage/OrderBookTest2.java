package com.TestPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.baseclass.BasecClass;
import com.pageclass.OrderBookPage;

public class OrderBookTest extends BasecClass{

	OrderBookPage page;
	
	
	@BeforeClass
	public void testconstructor()
	{
		page=new OrderBookPage(driver);
	}

	
	@Test(priority =1)
	  public void start()
	  {
		  page.searchShirts();
		  page.back();
	  }
	
	@AfterClass
	public void quit()
	{
		driver.quit();
	}
	
}
