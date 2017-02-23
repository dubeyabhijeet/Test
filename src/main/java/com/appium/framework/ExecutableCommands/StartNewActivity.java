package com.appium.framework.ExecutableCommands;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.appium.framework.masterexec.MasterExecuter;
import com.appium.framework.utils.JsonParser;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class StartNewActivity extends MasterExecuter{
	




public StartNewActivity(ExtentTest test) {
	// TODO Auto-generated constructor stub
	this.test=test;

}

@SuppressWarnings("static-access")
@Override
public void execute(JSONObject command) throws IOException, JSONException, ParseException{
	test.log(LogStatus.INFO, "Execute Click");
	Parser2= new JsonParser(test);
	String k = Parser2.Parser(command, "params")+"\n";
	JSONObject k2 =(JSONObject)new JSONParser().parse(k);
	
	StartApp d = StartApp.getInstance() ;
	String apppackage = Parser2.Parser(k2, "text");
	String activity =Parser2.Parser(k2, "text2");

	try {
		dr1=d.getAppiumDriver();
		dr1.startActivity(apppackage,activity);
		//test.log(LogStatus.INFO, "Started new activity w" + Parser.Parser((JSONObject)new JSONParser().parse(k), "text2").toString());
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Clicked");
	//test;
}	
}

