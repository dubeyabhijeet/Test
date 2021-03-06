package com.appium.framework.ExecutableCommands;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.appium.framework.bootstrap.bootstrap;
import com.appium.framework.masterexec.MasterExecuter;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class StartApp  {
	private static AndroidDriver<AndroidElement> dr;
	private static StartApp instance = new StartApp();

	private StartApp(){
		
	}
	public static StartApp getInstance() {
        return instance;
    }
	
	public AndroidDriver<AndroidElement> getAppiumDriver() {
        return dr;
    }   
	@SuppressWarnings("static-access")
	
	@Test
	public void execute1(JSONObject command) throws IOException, JSONException, InterruptedException{

			DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	        capabilities.setCapability("deviceName","Nexus 5");
	        capabilities.setCapability("platformVersion", "4.4.4");
	        capabilities.setCapability("platformName","Android");
		// capabilities.setCapability("app", app.getAbsolutePath());
	        
	        capabilities.setCapability("appPackage","com.android.calendar");
	        capabilities.setCapability("appActivity","com.android.calendar.AllInOneActivity");

	       dr = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	       
	}
}