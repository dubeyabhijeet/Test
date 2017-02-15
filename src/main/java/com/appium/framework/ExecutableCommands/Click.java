package com.appium.framework.ExecutableCommands;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.appium.framework.masterexec.MasterExecuter;
import com.appium.framework.utils.JsonParser;
import com.appium.framework.utils.test;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class Click extends MasterExecuter{
	public static	JsonParser Parser;
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
	Parser= new JsonParser(test);
	JSONObject k = (JSONObject) command.get("params");
	
	try {
		dr1=d.getAppiumDriver();
		
		if(k.containsKey("id")){
		dr1.findElementByAndroidUIAutomator("UiSelector().resourceId(\""+Parser.Parser(command,"id")+"\")").click();
		test.log(LogStatus.INFO, "Clicked on item with rsource id :" + Parser.Parser(command,"id"));
		}else if(k.containsKey("desc")){
			dr1.findElementByAndroidUIAutomator("UiSelector().description(\""+Parser.Parser(command,"desc")+"\")").click();
			test.log(LogStatus.INFO, "Clicked on item with description :" + Parser.Parser(command,"desc"));
		}else if(k.containsKey("text")){
			dr1.findElementByAndroidUIAutomator("UiSelector().text(\""+Parser.Parser(command,"text")+"\")").click();
			test.log(LogStatus.INFO, "Clicked on item with description :" + Parser.Parser(command,"text"));
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
