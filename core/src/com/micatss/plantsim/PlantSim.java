package com.micatss.plantsim;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.micatss.plantsim.config.ConfigSettings;
import com.micatss.plantsim.config.configfile.ScreenConfig;
import com.micatss.plantsim.screens.MainMenuScreen;

public class PlantSim extends Game {
	
	private final ConfigSettings configSettings = new ConfigSettings();
	private final ScreenConfig screenConfig = configSettings.getScreenConfig();
	
	@Override
	public void create () {
		Gdx.graphics.setWindowedMode(screenConfig.getWidth(), screenConfig.getHeight());
		this.setScreen(new MainMenuScreen(this));
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
}
