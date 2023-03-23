package com.micatss.game.files;

import com.micatss.game.files.config.ScreenConfig;
import com.micatss.game.files.savedata.SaveData;

public class UserData {
	
	private ScreenConfig screenConfig;
	private SaveData saveData;
	
	UserData(SaveData saveData, ScreenConfig screenConfig) {
		this.saveData = saveData;
		this.screenConfig = screenConfig;
	}
	
	public ScreenConfig getScreenConfig() {
		return screenConfig;
	}
	
	public SaveData getSaveData() {
		return saveData;
	}
	
	
	
}
