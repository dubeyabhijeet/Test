package com.appium.framework.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.relevantcodes.extentreports.LogStatus;

public class TestCaseReader {
	public static ArrayList<JSONObject> jsons;
	public static String FolderPath;
	public TestCaseReader(){
			}
	
public static ArrayList<String> ReadJSON(File fileName) throws FileNotFoundException, ParseException, org.json.simple.parser.ParseException {
			   
				ArrayList<String> ReadString=new ArrayList<String>();
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

		               		//obj = (JSONObject) new JSONParser().parse(line);
		       			ReadString.add(line);
		       		}   
		       
		      	 	// Always close files.
		      	 	bufferedReader.close();         
		   	  }
		   	catch(FileNotFoundException ex) {  
				ex.printStackTrace();
		      		//test.log(LogStatus.INFO,   "Unable to open file '" + fileName + "'");
		   	}
		   	catch(IOException ex) {
		      	ex.printStackTrace();
		//	test.log(LogStatus.INFO,   "Error reading file '" + fileName + "'");
		   }

			return ReadString;

		}

}
