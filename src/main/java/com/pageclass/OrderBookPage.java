package com.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OrderBookPage {

	AppiumDriver<WebElement> driver = null;
	
	
	@AndroidFindBy(id="in.amazon.mShop.android.shopping:id/rs_search_src_text")
	MobileElement searchButton;
	@AndroidFindBy(id="com.shaadi.android:id/edt_username") 
	MobileElement userName;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'shirts')]")
	MobileElement firstSearch;
	
	
	public OrderBookPage(AppiumDriver<WebElement> driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	public void searchShirts()
	{
		searchButton.clear();
		searchButton.click();
		searchButton.sendKeys("shirts");
		firstSearch.click();
	}
	
	public void back()
	{
		boolean homePage = false;
		
		while(!homePage)
		{
		driver.navigate().back();
		
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("in.amazon.mShop.android.shopping:id/chrome_action_bar_home_logo"))).isDisplayed();
			homePage=true;
		}
		catch(Exception e)
		{
			System.out.println("Not Home page");
		}
	  }
	}
}
