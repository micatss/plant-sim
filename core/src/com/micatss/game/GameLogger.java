package com.micatss.game;

public class GameLogger {
	private GameLogger() {}
	
	public static void info(String message) {
		System.out.println(message);
	}
	
	public static void error(String message) {
		System.err.println(message);
	}
	
}
