package com.appium.framework.ExecutableCommands;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;

import com.appium.framework.masterexec.MasterExecuter;
import com.appium.framework.utils.test;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class Click extends MasterExecuter{
	




public Click(ExtentTest test, AndroidDriver dr) {
	// TODO Auto-generated constructor stub
	this.test=test;
	this.dr=dr;
}

@SuppressWarnings("static-access")
@Override
public void execute(JSONObject command) throws IOException, JSONException{
	test.log(LogStatus.INFO, "Execute Click");

	JSONObject k = (JSONObject) command.get("params");
	String m = k.get("text").toString();
	
	System.out.println("UiSelector().text("+m+")");
	
	try {
		
		dr.findElementByAndroidUIAutomator("UiSelector().resourceId(\""+m+"\")").click();
		test.log(LogStatus.INFO, "Clicked on item with rsource id :" +m);
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Clicked");
	//test;
}	
}
