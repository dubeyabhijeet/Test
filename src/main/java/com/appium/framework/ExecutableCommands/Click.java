package com.appium.framework.ExecutableCommands;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.appium.framework.masterexec.MasterExecuter;
import com.appium.framework.utils.test;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class Click extends MasterExecuter{
	public static Click c = new Click();

public Click(ExtentTest test) {
	// TODO Auto-generated constructor stub
	this.test=test;

}

public Click() {
	// TODO Auto-generated constructor stub
}

@SuppressWarnings("static-access")
@Override
public void execute(JSONObject command) throws IOException, JSONException{
	test.log(LogStatus.INFO, "Execute Click");
	StartApp d = StartApp.getInstance() ;
	JSONObject k = (JSONObject) command.get("params");
	String m = k.get("text").toString();
	
	try {
		dr1=d.getAppiumDriver();
		
		if(k.containsKey("id")){
		dr1.findElementByAndroidUIAutomator("UiSelector().resourceId(\""+k.get("id").toString()+"\")").click();
		test.log(LogStatus.INFO, "Clicked on item with rsource id :" +m);
		}else if(k.containsKey("desc")){
			dr1.findElementByAndroidUIAutomator("UiSelector().description(\""+k.get("desc").toString()+"\")").click();
			test.log(LogStatus.INFO, "Clicked on item with description :" +m);
		}else if(k.containsKey("text")){
			dr1.findElementByAndroidUIAutomator("UiSelector().text(\""+k.get("text").toString()+"\")").click();
			test.log(LogStatus.INFO, "Clicked on item with description :" +m);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("f");
		getScreenshot(dr1,"D:\\Reports","TC2");
		test.log(LogStatus.FAIL, "Fail" + e);
		test.log(LogStatus.FAIL,"Fail" + e+"\n",test.addScreenCapture("D:\\Reports"+"\\"+"TC2"+".png"));
	}

}	
}
