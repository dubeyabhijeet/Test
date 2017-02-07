package com.appium.framework.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class test {

	public static void main(String[] args) throws org.json.simple.parser.ParseException {
		// TODO Auto-generated method stub
		ArrayList<JSONObject> json=new ArrayList<JSONObject>();
	     JSONObject obj;
	    // The name of the file to open.
	    String fileName = "D:\\Sample\\TC1.txt  ";

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
	        for(int i=0;i<json.size();i++){
			    System.out.println(json.get(i).toString()+"\n");
	        }
	        // Always close files.
	        bufferedReader.close();         
	    }
	    catch(FileNotFoundException ex) {
	        System.out.println(
	            "Unable to open file '" + 
	            fileName + "'");                
	    }
	    catch(IOException ex) {
	        System.out.println(
	            "Error reading file '" 
	            + fileName + "'");                  
	        // Or we could just do this: 
	        // ex.printStackTrace();
	    }
	}



	}

