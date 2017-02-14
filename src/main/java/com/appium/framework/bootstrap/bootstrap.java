package com.appium.framework.bootstrap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.JSONException;

import java.io.DataOutputStream;
import com.appium.framework.masterexec.MasterExecuter;
import com.appium.framework.utils.ExtentManager;
import com.appium.framework.utils.TestCaseReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

import com.appium.framework.ExecutableCommands.Click;
import com.appium.framework.ExecutableCommands.ShutApp;
import com.appium.framework.ExecutableCommands.StartApp;
import com.appium.framework.ExecutableCommands.StartNewActivity;


public class bootstrap  {
	
	public static InputStream is;
	public static InputStreamReader isr;
	public static BufferedReader br;
	public static OutputStream os;
	public static OutputStreamWriter osw;
	public static BufferedWriter bw;
	public static JSONObject jsondata=null;
	public static JSONObject JsondataNull=null;
	private static HashMap<String, MasterExecuter> map = new HashMap<String, MasterExecuter>();
	public static ExtentReports report;
	public static ExtentTest test;
	public static StartApp InitDriver = StartApp.getInstance();
	public static  ArrayList<JSONObject> jsons=null;
	
	
	public bootstrap() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public static void StartTest() throws IOException, ParseException, org.json.simple.parser.ParseException, JSONException, InterruptedException {
		

		TestCaseReader R = new TestCaseReader();
		
		 //Input the test suite path
		 String FileName="D:\\Sample";
	
		 //Read all files names and store in list
		 List<String> results = new ArrayList<String>();


		 File[] files = new File(FileName).listFiles();
		 //If this pathname does not denote a directory, then listFiles() returns null. 

		 for (File file : files) {
		     if (file.isFile()) {
		        // results.add(file.getName());
		    	 report = ExtentManager.getInstance();		 	
		         test=report.startTest(file.getName());
			 	 test.log(LogStatus.INFO, "Start Test Suite");
				 ArrayList<JSONObject> jsons=R.ReadJSON(new File(FileName+"\\"+file.getName()));
	      
				 bootfire(jsons);
				 report.endTest(test);
				 report.flush(); 
		     }
		 }
		 
			report.close();
	}
	

																			
public static void bootfire(ArrayList<JSONObject> inputLine) throws IOException, JSONException, org.json.simple.parser.ParseException, InterruptedException{
		
		//Instantiate Android driver
			
			
			InitDriver.execute1(jsondata);
		
			for(int l=0;l<inputLine.size();l++){
			
			String cmds = inputLine.get(l).toString()+"\n"; 
    		JSONParser parser = new JSONParser(); 
    	 	JSONObject jsondata = (JSONObject) parser.parse(cmds);
    	 
    	 	map.put("click", new Click(test));
       		map.put("shutdown", new ShutApp(test));
       		map.put("startact", new StartNewActivity(test));
        
        
       		if(map.containsKey(jsondata.get("action"))){
			
       		map.get(jsondata.get("action")).execute(jsondata);       
		
		}

}

}
}
							

		
		
		


