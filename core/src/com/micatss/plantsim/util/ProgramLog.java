package com.micatss.plantsim.util;

public class ProgramLog {
	private ProgramLog() {}
	
	public static void info(String message) {
		System.out.println(message);
	}
	
	public static void error(String message) {
		System.err.println(message);
	}
	
}
