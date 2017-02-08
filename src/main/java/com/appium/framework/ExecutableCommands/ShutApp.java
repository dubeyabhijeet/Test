package com.appium.framework.ExecutableCommands;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;

import com.appium.framework.masterexec.MasterExecuter;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ShutApp extends MasterExecuter{
	public ShutApp(ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.test=test;

	}

	@SuppressWarnings("static-access")
	@Override
	public void execute(JSONObject command) throws IOException, JSONException{
		test.log(LogStatus.INFO, "Execute Click");
		StartApp d = StartApp.getInstance() ;
		
		
		
		
		try {
			dr1=d.getAppiumDriver();
			dr1.quit();
			test.log(LogStatus.INFO, "App Closed :");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Clicked");
		//test;
	}	
}
