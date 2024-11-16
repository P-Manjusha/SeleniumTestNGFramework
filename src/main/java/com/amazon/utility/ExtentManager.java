package com.amazon.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
			
		public static ExtentHtmlReporter htmlReporter;
		public static ExtentReports extent;
		public static ExtentTest test;
		
		public static void setExtent() {
			//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+BaseClass.getCurrentTime()+".html");
		    htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extentConfig.xml");

			
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			
			extent.setSystemInfo("HostName", "MyHost");
			extent.setSystemInfo("ProjectName", "AmazonTestingProject");
			extent.setSystemInfo("Tester", "Manjusha");
			extent.setSystemInfo("OS", "Win11");
			extent.setSystemInfo("Browser", "Chrome");
		}
		public static void endReport() {
			extent.flush();
		}
	}

