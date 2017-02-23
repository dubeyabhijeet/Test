package com.appium.framework.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class JsonParser {
public static String str;
public static JSONObject js;
public static JSONObject js_final;
public static ExtentTest test;
public static AndroidElement AndEle=null;
public JsonParser(ExtentTest test) {
	// TODO Auto-generated constructor stub
	this.test=test;

}
public static String Parser(JSONObject command, String id){
		try{
			str = command.get(id).toString();
		 		System.out.println(str + "in parser");
		}catch (Exception e){
			test.log(LogStatus.FAIL, e + "Fail to parse json");
		}
		return str;
	}

@SuppressWarnings("rawtypes")
public static AndroidElement IsElementPresent(JSONObject JsonObj,ExtentTest test,AndroidDriver d) throws IOException{
		
	try{

		if(JsonObj.containsKey("id")){			
			AndEle=(AndroidElement) d.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().resourceId("+(Parser(JsonObj,"id"))+"));"));
			test.log(LogStatus.INFO, "Clicked on item with rsource id :" + (Parser(JsonObj,"id")));
			}else if(JsonObj.containsKey("desc")){
			AndEle=(AndroidElement)d.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().description("+(Parser(JsonObj,"desc"))+"));"));
				test.log(LogStatus.INFO, "Clicked on item with description :" + (Parser(JsonObj,"id")));
			}else if(JsonObj.containsKey("text")){
			AndEle=(AndroidElement)d.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text("+(Parser(JsonObj,"text"))+"));"));
				test.log(LogStatus.INFO, "Clicked on item with description :" + (Parser(JsonObj,"id")));
			}
		
		return AndEle;
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("f");
		getScreenshot(d,"D:\\Reports","TC2");
		test.log(LogStatus.FAIL, "Fail" + e);
		test.log(LogStatus.FAIL,"Fail" + e+"\n",test.addScreenCapture("D:\\Reports"+"\\"+"TC2"+".png"));
		return AndEle=null;
	}
	
}

@SuppressWarnings("rawtypes")
public static void getScreenshot(AndroidDriver driver, String outputlocation, String TCName ) throws IOException {
	
	File srcFile=driver.getScreenshotAs(OutputType.FILE);
    File targetFile=new File(outputlocation+"\\"+TCName+".png");
    
    try {
    FileUtils.copyFile(srcFile, targetFile);
    } catch (IOException e) {
    	   e.printStackTrace();
    	  }
}
}
