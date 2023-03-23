package com.micatss.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.micatss.game.MicatssGame;
import com.micatss.game.files.config.ScreenConfig;

public abstract class MicatssScreen implements Screen, InputProcessor {

	protected final MicatssGame game;
	protected final OrthographicCamera camera;
	protected final Music backgroundMusic;
	protected final SpriteBatch spriteBatch;
	protected final ShapeRenderer shapeRenderer;

	public MicatssScreen(MicatssGame game, Music backgroundMusic) {
		Gdx.input.setInputProcessor(this);
		this.game = game;
		this.camera = new OrthographicCamera(getScreenConfig().getWidth(),getScreenConfig().getHeight());
//		camera.setToOrtho(false, getScreenConfig().getWidth(), getScreenConfig().getHeight());
		this.backgroundMusic = backgroundMusic;
		this.spriteBatch = new SpriteBatch();
		this.shapeRenderer = new ShapeRenderer();
		
		
	}
	
	protected ScreenConfig getScreenConfig() {
		return game.getScreenConfig();
	}

	@Override
	public void show() {}

	@Override
	public void render(float delta) {
//		ScreenUtils.clear(Color.WHITE);
	}

	@Override
	public void resize(int width, int height) {
		getScreenConfig().setWidth(width);
		getScreenConfig().setHeight(height);
		getScreenConfig().save();
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
	public void dispose() {
		spriteBatch.dispose();
		shapeRenderer.dispose();
	}
	
	protected abstract void zoom(float amountY);
	
	protected void refreshCamera() {
		camera.update();
	}

}
