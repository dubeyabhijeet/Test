package com.appium.framework.utils;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.appium.framework.ExecutableCommands.StartApp;
import com.appium.framework.masterexec.MasterExecuter;
import com.appium.framework.utils.JsonParser;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class test {

	public void test2(){
	String cmds ="";
	JSONParser parser = new JSONParser();
	JSONObject k=null;
	try {
		k = (JSONObject) parser.parse(cmds);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
System.out.println(k.get("text2").toString());
	
		}
}

