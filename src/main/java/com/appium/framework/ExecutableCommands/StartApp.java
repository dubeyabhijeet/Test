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

import com.appium.framework.bootstrap.back;
import com.appium.framework.masterexec.MasterExecuter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class StartApp extends MasterExecuter  {
	
	@SuppressWarnings("static-access")
	@Override
	@Test
	public void execute(JSONObject command) throws IOException, JSONException, InterruptedException{
	//AndroidDriver dr;
	//JSONObject k = ((Object) command).getJSONObject("params");
	//String m = k.getString("text");
		
		JSONObject k = (JSONObject) command.get("params");
		String m = k.get("text").toString();
		String n = k.get("text2").toString();
	//String n = null;
	//	File app = new File("F:\\Mobile-testing\\apps\\com.whatsapp-2.apk");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	        capabilities.setCapability("deviceName","Nexus 5");
	        capabilities.setCapability("platformVersion", "4.4.4");
	        capabilities.setCapability("platformName","Android");
		// capabilities.setCapability("app", app.getAbsolutePath());

	     capabilities.setCapability("appPackage", m);
	       capabilities.setCapability("appActivity", n);

	       dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	       
	       new back(dr);
	}
}