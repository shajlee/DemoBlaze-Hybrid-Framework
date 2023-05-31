package com.qa.demoblaze.utilities;

import java.util.Date;

public class Demoblaze_Utilities {
	
	public static String generateEmailDateAndTimeStamp() {
		Date date = new Date();
		String emailTimeStamp = date.toString().replace("", "_").replace(":", "_");
		return "chowdhurygs" +emailTimeStamp+ "@gmail.com";
	}
	public static String generatePasswordDateAndTimeStamp() {
		Date date1 = new Date();
		String passwordTimeStamp = date1.toString().replace("", "_").replace(":", "_");
		return "Shajlee" +passwordTimeStamp;
	}
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGELOAD_TIME = 10;
	public static final int SCRIPTLOAD_TIME = 100;
	
}


