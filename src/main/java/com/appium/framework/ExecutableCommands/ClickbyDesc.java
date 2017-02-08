package com.appium.framework.ExecutableCommands;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;

import com.appium.framework.masterexec.MasterExecuter;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ClickbyDesc extends MasterExecuter{
	
	public ClickbyDesc(ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.test=test;
		
	}
public ClickbyDesc() {
		// TODO Auto-generated constructor stub
	}
@SuppressWarnings("static-access")
@Override
public void execute(JSONObject command) throws IOException, JSONException{
	test.log(LogStatus.INFO, "Execute Click");
	StartApp d = StartApp.getInstance() ;
	
	JSONObject k = (JSONObject) command.get("params");
	String m = k.get("text").toString();
	
	System.out.println("UiSelector().text("+m+")");
	
	try {
		
		dr1=d.getAppiumDriver();
		dr1.findElementByAndroidUIAutomator("UiSelector().description(\""+m+"\")").click();
		test.log(LogStatus.INFO, "Clicked on item with description :" +m);
		//dr.pressKeyCode(AndroidKeyCode.HOME);
		//dr.findElementByAndroidUIAutomator("UiSelector().description(\"All apps\")").click();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Clicked");
	//test;
}
}
