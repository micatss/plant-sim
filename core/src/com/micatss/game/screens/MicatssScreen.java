package com.micatss.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.micatss.game.MicatssGame;
import com.micatss.game.files.config.ScreenConfig;

public abstract class MicatssScreen implements Screen, InputProcessor {

	protected final ScreenConfig screenConfig;
	protected final OrthographicCamera camera;
	protected final Music backgroundMusic;

	public MicatssScreen(MicatssGame game, Music backgroundMusic) {
		Gdx.input.setInputProcessor(this);
		this.screenConfig = game.getUserData().getScreenConfig();
		this.camera = new OrthographicCamera(screenConfig.getWidth(),screenConfig.getHeight());
		this.backgroundMusic = backgroundMusic;
	}

	@Override
	public void show() {}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(Color.WHITE);
	}

	@Override
	public void resize(int width, int height) {
		screenConfig.setWidth(width);
		screenConfig.setHeight(height);
		screenConfig.save();
		camera.setToOrtho(false, width, height);
		refreshCamera();
	}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {}
	
	protected void zoom(float amountY) {
		camera.zoom += amountY;
		refreshCamera();
	}
	
	protected void refreshCamera() {
		camera.update();
	}

}
