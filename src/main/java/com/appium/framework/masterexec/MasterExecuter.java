package com.appium.framework.masterexec;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



public abstract class MasterExecuter {
	/*public UiObject arbitrary;*/
	public AndroidDriver<MobileElement> dr1;
	public ExtentTest test;

	

	public void execute(JSONObject command) throws IOException, JSONException, InterruptedException {
		// TODO Auto-generated method stub
		
	}

}
