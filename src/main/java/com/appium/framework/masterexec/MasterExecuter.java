package com.appium.framework.masterexec;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.appium.framework.utils.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public abstract class MasterExecuter {
	
	public AndroidDriver<AndroidElement> dr1;
	public AndroidElement Element;
	public ExtentTest test;
	public static JsonParser Parser2;
	public void execute(JSONObject command) throws IOException, JSONException, InterruptedException, ParseException {
		
		// TODO Auto-generated method stub
		
	}
	
	
	
	
		
		
		
		
	}


