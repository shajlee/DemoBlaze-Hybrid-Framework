package com.qa.demoblaze.utilities;

public class Demoblaze_System {
	
	public static void main(String[]args) {
		System.getProperties().list(System.out);
		System.out.println("*******************************************************************************************************************************************");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("java.vendor"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.country"));
		System.out.println(System.getProperty("user.language"));
	}

}
