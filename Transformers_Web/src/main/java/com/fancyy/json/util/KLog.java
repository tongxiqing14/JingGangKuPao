package com.fancyy.json.util;


public class KLog {
	public static boolean debug = true;
	

	public static void e(String tag, Exception e) {
		e.printStackTrace();
	}

	public static void handleLog(Exception e) {
		e.printStackTrace();
	}
	
	public static void log(String s) {
	}

}
