package com.appium.framework.ExecutableCommands;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;

import com.appium.framework.masterexec.MasterExecuter;
import com.appium.framework.utils.JsonParser;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EnterSubSettings extends MasterExecuter{
public static	JsonParser Parser;
		public EnterSubSettings(ExtentTest test) {
			// TODO Auto-generated constructor stub
			this.test=test;

		}

		public EnterSubSettings() {
			// TODO Auto-generated constructor stub
		}

		@SuppressWarnings("static-access")
		@Override
		public void execute(JSONObject command) throws IOException, JSONException{
			
			test.log(LogStatus.INFO, "Enter Settings");
			StartApp d = StartApp.getInstance() ;
			Parser= new JsonParser(test);
		
			try {
				dr1=d.getAppiumDriver();
				dr1.startActivity("com.android.settings","com.android.settings.Settings");
				dr1.scrollTo(Parser.Parser(command,"text")).click();
			
				test.log(LogStatus.INFO, "Clicked on menu item :" + Parser.Parser(command,"text"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		}
