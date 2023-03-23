package com.micatss.plantsim;

import com.micatss.game.MicatssGame;
import com.micatss.plantsim.files.save.PlantUserDataLoader;
import com.micatss.plantsim.screens.MainMenuScreen;

public class PlantSim extends MicatssGame {
	
	@Override
	public void create () {
		super.create(new PlantUserDataLoader());
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
