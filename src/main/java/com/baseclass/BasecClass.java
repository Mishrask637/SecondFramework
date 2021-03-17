package com.baseclass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BasecClass {

	public static AppiumDriver<WebElement> driver;
	DesiredCapabilities cap = new DesiredCapabilities();
	
	public void startAppiumServer() 
	  { 
	  CommandLine cmd = new CommandLine("C:\\Program Files\\nodejs\\node.exe"); 
	  cmd.addArgument("C:\\Users\\LENOVO\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");            //      C:\\Program Files\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js
	  cmd.addArgument("--address"); 
	  cmd.addArgument("0.0.0.0");
	  cmd.addArgument("--port"); 
	  cmd.addArgument("4727");
	 
	  DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
	  DefaultExecutor executor = new DefaultExecutor(); 
	  executor.setExitValue(1);
	  try { 
			  executor.execute(cmd, handler); 
			  Thread.sleep(10000);
			  System.out.println("Appium server started successfully"); 
	  	  } catch(IOException | InterruptedException e) { 
	  		  		e.printStackTrace(); 
	  	  		} 
	  	  }
	
	
	 public void stopAppiumServer() 
	 { 
		  Runtime runtime = Runtime.getRuntime(); try {
		  runtime.exec("taskkill /F /IM node.js");
		  runtime.exec("taskkill /F /IM node.exe");
		  System.out.println("Server Stopped successfully"); 
		  } 
		  catch (IOException e){
			  e.printStackTrace(); 
		  } 
	 }
	
	 public void initialise(String deviceName,String platformName, String platfromVersion, String appPackage, String appActivity, String udid, String noReset, String automationName)
	 {
		 cap.setCapability("deviceName", deviceName);
		 cap.setCapability("platformName", platformName);
		 cap.setCapability("platfromVersion", platfromVersion);
		 cap.setCapability("appPackage", appPackage);
		 cap.setCapability("appActivity", appActivity);
		 cap.setCapability("udid", udid);
		 cap.setCapability("noReset", noReset);
		// cap.setCapability("automationName", automationName);
		 
		 
		 try {
			driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4727/wd/hub"),cap);
			System.out.println("Sevver Connected");
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	 }
	 
	 
}
