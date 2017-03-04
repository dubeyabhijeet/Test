package com.appium.framework.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class JsonParser {
public static String str;
public static ExtentTest test;
public static AndroidElement AndEle=null;
public JsonParser(ExtentTest test) {
	// TODO Auto-generated constructor stub
	this.test=test;

}


@SuppressWarnings("rawtypes")
public static AndroidElement IsElementPresent(ExtentTest test,AndroidDriver d) throws IOException{
	return null;
		
	
}

@SuppressWarnings("rawtypes")
public static void getScreenshot(AndroidDriver driver, String outputlocation, String TCName ) throws IOException {
	
	File srcFile=driver.getScreenshotAs(OutputType.FILE);
    File targetFile=new File(outputlocation+"\\"+TCName+".png");
    
    try {
    FileUtils.copyFile(srcFile, targetFile);
    } catch (IOException e) {
    	   e.printStackTrace();
    	  }
}
}
