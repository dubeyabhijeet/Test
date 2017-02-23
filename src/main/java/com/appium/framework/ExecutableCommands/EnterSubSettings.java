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
				Element=Parser.IsElementPresent(command,test,dr1);
				if(Element!=null){
					Element.click();
					}else{
						new ShutApp(test).execute(null);
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("f");
				Parser.getScreenshot(dr1,"D:\\Reports","TC2");
				test.log(LogStatus.FAIL, "Fail" + e);
				test.log(LogStatus.FAIL,"Fail" + e+"\n",test.addScreenCapture("D:\\Reports"+"\\"+"TC2"+".png"));
			}
		}	
		}
