package com.micatss.plantsim.config.configfile;

import java.io.File;
import java.io.FileNotFoundException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.micatss.plantsim.config.GameConfiguration;

public class ScreenConfig extends ConfigFile implements GameConfiguration {

	public static final String SCREEN_CONFIG_FILENAME = "screen.conf";
	public String getFilename() {
		return SCREEN_CONFIG_FILENAME;
	}

	private static final String SCREEN_WIDTH = "screen.width";
	private static final String SCREEN_HEIGHT = "screen.height";
	
	public ScreenConfig() {
		defaultSettings();
	}
	public ScreenConfig(File file) {
		super(file);
	}
	
	private int width;
	private int height;
	
	public void parse() throws ParseException, FileNotFoundException {
		JSONObject json = loadJsonFromFile();
		this.width = ((Long)json.get(SCREEN_WIDTH)).intValue();
		this.height = ((Long)json.get(SCREEN_HEIGHT)).intValue();
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put(SCREEN_WIDTH, getWidth());
		json.put(SCREEN_HEIGHT, getHeight());
		return json;
	}
	
	public void defaultSettings() {
		this.width = 1280;
		this.height = 720;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
