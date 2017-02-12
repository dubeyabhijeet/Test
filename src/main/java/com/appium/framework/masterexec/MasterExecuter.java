package com.appium.framework.masterexec;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



public abstract class MasterExecuter {
	
	public AndroidDriver<MobileElement> dr1;
	public ExtentTest test;

	public void execute(JSONObject command) throws IOException, JSONException, InterruptedException {
		
		// TODO Auto-generated method stub
		
	}
	
	public static void getScreenshot(AndroidDriver driver, String outputlocation, String TCName ) throws IOException {
		System.out.println(outputlocation);
		File srcFile=driver.getScreenshotAs(OutputType.FILE);
	    File targetFile=new File(outputlocation+"\\"+TCName+".png");
	    
	    try {
	    FileUtils.copyFile(srcFile, targetFile);
	    } catch (IOException e) {
	    	   e.printStackTrace();
	    	  }
	}

}
