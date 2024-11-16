package com.amazon.utility;

import java.util.logging.Logger;

public class Log {
	
	public static Logger Log =  Logger.getLogger(Log.class.getName());
	
	public static void startTestCase(String sTestCaseName) {
		Log.info("================"+sTestCaseName+" Test Started================");		
	}
	
	public static void endTestCase(String sTestCaseName) {
		Log.info("================"+sTestCaseName+" Test Ended================");		
	}
	
	public static void info(String message) {
		Log.info(message);		
	}

}
