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

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class Driver {

	

	

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
