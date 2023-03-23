package com.micatss.game.files;

import java.io.File;
import java.io.IOException;

import com.micatss.game.GameLogger;
import com.micatss.game.files.config.ScreenConfig;
import com.micatss.game.files.savedata.SaveData;
import com.micatss.game.files.savedata.SaveableParser;

public abstract class UserDataLoader {
	
	private static final String USER_HOME = System.getProperty("user.home");
	private static final String GAME_DIRECTORY = ".plantsim/";
	
	private final File configDirectory;
	private final SaveableParser saveableParser;
	
	public UserDataLoader(SaveableParser saveableParser) {
		this(saveableParser,GAME_DIRECTORY);
	}
	public UserDataLoader(SaveableParser saveableParser, String configDirectory) {
		this(saveableParser,new File(USER_HOME + "/" + configDirectory));
	}
	public UserDataLoader(SaveableParser saveableParser, File configDirectory) {
		this.saveableParser = saveableParser;
		this.configDirectory = configDirectory;
	}
	
	public UserData loadUserData() {
		SaveData saveData = new SaveData(saveableParser,loadFileFromConfigDirectory(SaveData.FILENAME));
		ScreenConfig screenConfig = new ScreenConfig(loadFileFromConfigDirectory(ScreenConfig.FILENAME));
		try {
			makeConfigDirectory();
		} catch (Throwable t) {
			GameLogger.error(t.toString());
		}
		return new UserData(saveData,screenConfig);
	}
	
	private void makeConfigDirectory() throws IOException {
		GameLogger.info("Config directory set to " + configDirectory.getAbsolutePath());
		if(!configDirectory.exists()) {
			GameLogger.info("Config directory does not exist -- making new config directory.");
			configDirectory.mkdir();
		}
	}
	
	private File loadFileFromConfigDirectory(String filename) {
		try {
			File configFile = new File(configDirectory + "/" + filename);
			GameLogger.info("Loading file: " + configFile.getAbsolutePath());
			if(!configFile.exists()) {
				GameLogger.info("Creating new file: " + configFile.getAbsolutePath());
				configFile.createNewFile();
			}
			return configFile;
		} catch (Throwable t) {
			return null;
		}
	}
	
	
	
}
