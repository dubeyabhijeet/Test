package com.appium.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	public void testApp() throws MalformedURLException, InterruptedException{

		
		//	File app = new File("F:\\Mobile-testing\\apps\\com.whatsapp-2.apk");
			 DesiredCapabilities capabilities = new DesiredCapabilities();
		        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		        capabilities.setCapability("deviceName","Nexus 5");
		        capabilities.setCapability("platformVersion", "4.4.4");
		        capabilities.setCapability("platformName","Android");
			// capabilities.setCapability("app", app.getAbsolutePath());

		       capabilities.setCapability("appPackage", "com.htc.launcher");
		       capabilities.setCapability("appActivity", "com.htc.launcher.Launcher");

		       AndroidDriver  dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		       dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		      dr.startActivity("com.android.settings", "com.android.settings.Settings");
		       
		       	}
		
}
