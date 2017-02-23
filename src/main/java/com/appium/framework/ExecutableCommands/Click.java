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

@SuppressWarnings({ "static-access", "unchecked" })
@Override
public void execute(JSONObject command) throws IOException, JSONException{
	test.log(LogStatus.INFO, "Execute Click");
	StartApp d = StartApp.getInstance() ;
	Parser= new JsonParser(test);
	//JSONObject baseparser = (JSONObject) command.get("params");
	
	try {
		dr1=d.getAppiumDriver();
		Element=Parser.IsElementPresent(command,test,dr1);
		if(Element!=null){
		Element.click();
		}else{
			new ShutApp(test).execute(null);
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("f");
		Parser.getScreenshot(dr1,"D:\\Reports","TC2");
		test.log(LogStatus.FAIL, "Fail" + e);
		test.log(LogStatus.FAIL,"Fail" + e+"\n",test.addScreenCapture("D:\\Reports"+"\\"+"TC2"+".png"));
	}

}	
}
