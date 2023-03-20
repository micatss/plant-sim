package com.micatss.plantsim;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.micatss.plantsim.config.ConfigSettings;
import com.micatss.plantsim.config.configfile.ScreenConfig;
import com.micatss.plantsim.screens.*;

public class PlantSim extends Game {
	
	private final ConfigSettings configSettings = new ConfigSettings();
	private final ScreenConfig screenConfig = configSettings.getScreenConfig();
	
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
	
	public ConfigSettings getConfigSettings() {
		return configSettings;
	}
	
	public void updateScreenConfig(int width, int height){
		ScreenConfig screenConfig = getConfigSettings().getScreenConfig();
		screenConfig.setHeight(height);
		screenConfig.setWidth(width);
		screenConfig.save();
	}
}
