package com.micatss.plantsim;

import com.badlogic.gdx.Game;
import com.micatss.plantsim.screens.MainMenuScreen;
import com.micatss.plantsim.util.ConfigSettings;

public class PlantSim extends Game {
	
	private final ConfigSettings configSettings = new ConfigSettings();
	
	@Override
	public void create () {
		try {
			configSettings.initializeFiles();
		} catch (Throwable t) {
			t.printStackTrace();
		}
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
}
