package com.appium.framework.ExecutableCommands;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;

import com.appium.framework.masterexec.MasterExecuter;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EnterSubSettings extends MasterExecuter{
	
		public EnterSubSettings(ExtentTest test) {
			// TODO Auto-generated constructor stub
			this.test=test;

		}

		@SuppressWarnings("static-access")
		@Override
		public void execute(JSONObject command) throws IOException, JSONException{
			
			test.log(LogStatus.INFO, "Enter Settings");
			StartApp d = StartApp.getInstance() ;
			
			JSONObject k = (JSONObject) command.get("params");
			String m = k.get("text").toString();
			
			try {
				dr1=d.getAppiumDriver();
				dr1.startActivity("com.android.settings","com.android.settings.Settings");
				test.log(LogStatus.INFO, "Clicked on item with rsource id :" +m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		}
