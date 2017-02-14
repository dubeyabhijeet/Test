//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html

package com.appium.framework.utils;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;
	
	private ExtentManager(){}

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d= new Date();
			String path="E:\\";
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			extent = new ExtentReports(path+fileName, true, DisplayOrder.NEWEST_FIRST);
		
			//extent.x("http://127.0.0.1:1337/#/");
		//	extent.x("http://127.0.0.1:1337");
		//	extent.x("localhost",1337);
			// optional
		//	extent.config().documentTitle("Automation Report")
		//			.reportName("Regression").reportHeadline("");
			extent.loadConfig(new File("E:\\Self_Core\\Core_Framework\\ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "2.53").addSystemInfo(
					"Environment", "PROD");
		}
		return extent;
	}
}
