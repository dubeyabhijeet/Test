package com.appium.framework.ExecutableCommands;
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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

import com.appium.framework.ExecutableCommands.Click;
import com.appium.framework.ExecutableCommands.ClickbyDesc;
import com.appium.framework.ExecutableCommands.ShutApp;
import com.appium.framework.ExecutableCommands.StartApp;


public class back  {
	
	public static InputStream is;
	public static InputStreamReader isr;
	public static BufferedReader br;
	public static OutputStream os;
	public static OutputStreamWriter osw;
	public static BufferedWriter bw;
	public static JSONObject jsondata=null;
	private static HashMap<String, MasterExecuter> map = new HashMap<String, MasterExecuter>();
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	
	public back() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException, JSONException, InterruptedException {
		report = ExtentManager.getInstance();
		test=report.startTest("Start test");
		test.log(LogStatus.INFO, "Start Test Suite");
		Initialize();
		report.endTest(test);
		report.flush();
		report.close();
		
	}
	
	
	public static void Initialize() throws IOException, ParseException, org.json.simple.parser.ParseException, JSONException, InterruptedException{
		 
		 //Input the test suite path
		 String FileName="D:\\Sample";
	
		 //Read all files names and store in list
		 List<String> results = new ArrayList<String>();


		 File[] files = new File(FileName).listFiles();
		 //If this pathname does not denote a directory, then listFiles() returns null. 

		 for (File file : files) {
		     if (file.isFile()) {
		         results.add(file.getName());
		         System.out.println(FileName+"\\"+file.getName());
		     }
		 }
		 
		 for(int k=0;k<results.size();k++){
			 		ArrayList<JSONObject> jsons=ReadJSON(new File(FileName+"\\"+results.get(k)));
       
			 		bootfire(jsons);
			 			
		 }
	}   

public static ArrayList<JSONObject> ReadJSON(File fileName) throws FileNotFoundException, ParseException, org.json.simple.parser.ParseException {
   
		ArrayList<JSONObject> json=new ArrayList<JSONObject>();
    		JSONObject obj;
  		// The name of the file to open.

		// This will reference one line at a time
   		String line = null;

  	 try {
    		   // FileReader reads text files in the default encoding.
    		   FileReader fileReader = 
    		   new FileReader(fileName);

       		 // Always wrap FileReader in BufferedReader.
      		 BufferedReader bufferedReader = 
          	 new BufferedReader(fileReader);

       		while((line = bufferedReader.readLine()) != null) {

               		obj = (JSONObject) new JSONParser().parse(line);
               		json.add(obj);
       		}   
       
      	 	// Always close files.
      	 	bufferedReader.close();         
   	  }
   	catch(FileNotFoundException ex) {  
		ex.printStackTrace();
      		test.log(LogStatus.INFO,   "Unable to open file '" + fileName + "'");
   	}
   	catch(IOException ex) {
      	ex.printStackTrace();
	test.log(LogStatus.INFO,   "Error reading file '" + fileName + "'");
   }

	return json;

}

																			
public static void bootfire(ArrayList<JSONObject> inputLine) throws IOException, JSONException, org.json.simple.parser.ParseException, InterruptedException{
		StartApp d = StartApp.getInstance() ;
		String cmds1 = inputLine.get(0).toString()+"\n"; 
		JSONParser parser1 = new JSONParser(); 
		JSONObject jsondata1 = (JSONObject) parser1.parse(cmds1);
		d.execute1(jsondata1);
		
		for(int l=1;l<inputLine.size();l++){
			
			String cmds = inputLine.get(l).toString()+"\n"; 
    			JSONParser parser = new JSONParser(); 
    	 		JSONObject jsondata = (JSONObject) parser.parse(cmds);
    	 
    	 	map.put("click", new Click(test));
        	map.put("clickbydes", new ClickbyDesc(test));
       		map.put("shutdown", new ShutApp(test));
        
        
		if(map.containsKey(jsondata.get("action"))){
			
			map.get(jsondata.get("action")).execute(jsondata);       
		
		}

}
}
}
							

		
		
		


