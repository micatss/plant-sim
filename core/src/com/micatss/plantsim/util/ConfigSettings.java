package com.micatss.plantsim.util;

import java.io.File;
import java.io.IOException;

public class ConfigSettings {
	
	private static final String USER_HOME = System.getProperty("user.home");
	
	private static final String DEFAULT_DIRECTORY = ".plantsim/";
	private static final String SCREEN_CONFIG_FILENAME = "screen.conf";
	
	private final File configDirectory;
	
	public ConfigSettings() {
		this(DEFAULT_DIRECTORY);
	}
	public ConfigSettings(String configDirectory) {
		this(new File(USER_HOME + "/" + configDirectory));
	}
	public ConfigSettings(File configDirectory) {
		this.configDirectory = configDirectory;
		System.out.println("Config directory set to " + configDirectory.getAbsolutePath());
	}
	
	public void initializeFiles() throws IOException {
		if(!configDirectory.exists()) {
			configDirectory.mkdir();
		}
		File screenConfig = new File(configDirectory + "/" + SCREEN_CONFIG_FILENAME);
		ProgramLog.log(screenConfig.getAbsolutePath());
		if(!screenConfig.exists()) {
			screenConfig.createNewFile();
		}
	}
}
