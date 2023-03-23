package com.micatss.game.screens;

import com.badlogic.gdx.audio.Music;
import com.micatss.game.MicatssGame;

public abstract class DynamicScreen extends MicatssScreen {

	public DynamicScreen(MicatssGame game, Music backgroundMusic) {
		super(game,backgroundMusic);
	}
	
	@Override
	protected void zoom(float amountY) {
		camera.zoom += amountY;
		refreshCamera();
	}

}
