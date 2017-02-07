package com.appium.framework.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Driver {

	public static void FireCommandInSocket() throws IOException, ParseException, org.json.simple.parser.ParseException{
		 String FileName="d:\\sample.txt";
	
		 //Read all files names and store in list
		 List<String> results = new ArrayList<String>();


		 File[] files = new File("/path/to/the/directory").listFiles();
		 //If this pathname does not denote a directory, then listFiles() returns null. 

		 for (File file : files) {
		     if (file.isFile()) {
		         results.add(file.getName());
		     }
		 }
        ArrayList<JSONObject> jsons=ReadJSON(new File(FileName),"UTF-8");
       
		 for(int i=0;i<jsons.size();i++){
		    String cmds = jsons.get(i).toString()+"\n"; 
		    System.out.println("k");
		    System.out.println(cmds);
			String message;
		
			
		 }
		 }   

public static ArrayList<JSONObject> ReadJSON(File MyFile,String Encoding) throws FileNotFoundException, ParseException, org.json.simple.parser.ParseException {
    
	Scanner scn=new Scanner(MyFile,Encoding);
    ArrayList<JSONObject> json=new ArrayList<JSONObject>();

    while(scn.hasNext()){
        JSONObject obj= (JSONObject) new JSONParser().parse(scn.nextLine());
 
        json.add(obj);
    }

    return json;
} 


	
//	Execute adb
	
public static void execAdbRun(String[] command) throws InterruptedException {
		
		// run the adb bridge
		try {
			ProcessBuilder pb = new ProcessBuilder(command);
			
			
	      
	        	pb.redirectErrorStream(true);
		        Process process = pb.start();
	        	System.out.println("love u");
	        process.waitFor();
	        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
	      
	        
			} catch (IOException e) {
							System.err.println(e.getMessage());
				}
		
	}

}
