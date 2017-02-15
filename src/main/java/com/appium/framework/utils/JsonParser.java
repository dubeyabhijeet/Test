package com.appium.framework.utils;

import org.json.simple.JSONObject;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JsonParser {
public static String str;
public static JSONObject js;
public static JSONObject js_final;
public static ExtentTest test;

public JsonParser(ExtentTest test) {
	// TODO Auto-generated constructor stub
	this.test=test;

}
	public static String Parser(JSONObject command, String text){
		try{
		js = (JSONObject) command.get("params");
		str = js.get(text).toString();
		}catch (Exception e){
			test.log(LogStatus.FAIL, e + "Fail to parse json");
		}
		return str;
	}
}
