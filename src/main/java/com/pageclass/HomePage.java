package com.pageclass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage{

	AppiumDriver<WebElement> driver;
	static boolean isavailable = false;
	
	@AndroidFindBy(id="in.amazon.mShop.android.shopping:id/rs_search_src_text")
	MobileElement searchButton;
	@AndroidFindBy(id="com.shaadi.android:id/edt_username") 
	MobileElement userName;
	
	@AndroidFindBy(id="in.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text")
	MobileElement firstSearch;
	
	@AndroidFindBy(id="com.shaadi.android:id/btn_login")
	MobileElement login;
	
	@AndroidFindBy(id="com.shaadi.android:id/menu_skip")
	MobileElement skip;
	
//	@AndroidFindBy(uiAutomator="new UiSelector().textContains(\"Enter MPIN\")")
//	MobileElement Password;
	
	@AndroidFindBy(id="com.shaadi.android:id/tvMyShaadi")
	MobileElement myShadi;
	
	@AndroidFindBy(id="com.shaadi.android:id/menu_skip")
	MobileElement skipButton;
	
	
	public HomePage(AppiumDriver<WebElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	
	
	
	
	
	public void SearchShoes()
	{
		searchButton.click();
		searchButton.sendKeys("shoes");
		firstSearch.click();
		assertEquals(true, new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("in.amazon.mShop.android.shopping:id/glow_subnav_label"))).isDisplayed());
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
	
	public OrderBookPage ordBook()
	{
		return new OrderBookPage(driver);
	}
	
	
	
}
