package com.micatss.plantsim.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.micatss.plantsim.files.config.ScreenConfig;
import com.micatss.plantsim.files.save.SaveData;
import com.micatss.plantsim.util.ProgramLog;

public class UserData {
	
	private static final String USER_HOME = System.getProperty("user.home");
	private static final String GAME_DIRECTORY = ".plantsim/";
	
	private final File configDirectory;
	
	private ScreenConfig screenConfig;
	private SaveData saveData;
	
	public UserData() {
		this(GAME_DIRECTORY);
	}
	public UserData(String configDirectory) {
		this(new File(USER_HOME + "/" + configDirectory));
	}
	public UserData(File configDirectory) {
		this.configDirectory = configDirectory;
		loadFiles();
	}
	
	private void loadFiles() {
		try {
			makeConfigDirectory();
			screenConfig = new ScreenConfig(loadFileFromConfigDirectory(ScreenConfig.FILENAME));
			saveData = new SaveData(loadFileFromConfigDirectory(SaveData.FILENAME));
		} catch (Throwable t) {
			ProgramLog.error(t.toString());
		}
		
	}
	
	private void makeConfigDirectory() throws IOException {
		ProgramLog.info("Config directory set to " + configDirectory.getAbsolutePath());
		if(!configDirectory.exists()) {
			ProgramLog.info("Config directory does not exist -- making new config directory.");
			configDirectory.mkdir();
		}
	}
	
	private File loadFileFromConfigDirectory(String filename) throws IOException {
		File configFile = new File(configDirectory + "/" + filename);
		ProgramLog.info("Loading file: " + configFile.getAbsolutePath());
		if(!configFile.exists()) {
			configFile.createNewFile();
		}
		return configFile;
	}
	
	public ScreenConfig getScreenConfig() {
		return screenConfig;
	}
	
	public SaveData getSaveData() {
		return saveData;
	}
	
	
	
}
