package com.micatss.plantsim;

import java.util.Collection;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.micatss.plantsim.files.UserData;
import com.micatss.plantsim.files.config.ScreenConfig;
import com.micatss.plantsim.files.save.SaveData;
import com.micatss.plantsim.files.save.Saveable;
import com.micatss.plantsim.screens.*;

public class PlantSim extends Game {
	
	private final UserData configSettings = new UserData();
	private final ScreenConfig screenConfig = configSettings.getScreenConfig();
	private final SaveData saveData = configSettings.getSaveData();
	
	@Override
	public void create () {
		Gdx.graphics.setWindowedMode(screenConfig.getWidth(), screenConfig.getHeight());
		this.setScreen(new MainMenuScreen(this));
		this.setScreen(new GardenScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
	
	public UserData getConfigSettings() {
		return configSettings;
	}
	
	public void updateSavedata(Collection<Saveable> saveables) {
		saveData.getSaveables().clear();
		saveData.getSaveables().addAll(saveables);
		saveData.save();
	}
	
	public void updateScreenConfig(int width, int height){
		screenConfig.setHeight(height);
		screenConfig.setWidth(width);
		screenConfig.save();
	}
}
