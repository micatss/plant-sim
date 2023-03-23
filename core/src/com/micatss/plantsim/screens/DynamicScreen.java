package com.micatss.plantsim.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.micatss.plantsim.files.config.ScreenConfig;

public abstract class DynamicScreen implements Screen {

	private final ScreenConfig screenConfig;
	protected final OrthographicCamera camera;

	public DynamicScreen(ScreenConfig screenConfig) {
		this.screenConfig = screenConfig;
		this.camera = new OrthographicCamera(screenConfig.getWidth(),screenConfig.getHeight());
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
