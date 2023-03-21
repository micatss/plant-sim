package com.micatss.plantsim.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.micatss.plantsim.PlantSim;
import com.micatss.plantsim.files.config.ScreenConfig;
import com.micatss.plantsim.util.FontHelper;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class MainMenuScreen implements Screen {

	final PlantSim game;

//	OrthographicCamera camera;
	SpriteBatch batch;
	Texture img;
//	Music bgMusic;
//	Sound dropSound;

	public MainMenuScreen(final PlantSim game) {
		this.game = game;
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void show() {
		System.out.println("show() called");
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 1, 0, 1);
		batch.begin();
//		cameraSizeStatMessage.draw(batch,camera.viewportWidth + "x" + camera.viewportHeight,camera.viewportWidth - 100,camera.viewportHeight - 100);
		
		batch.draw(img, 0,0);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		game.updateScreenConfig(width, height);
	}

	@Override
	public void pause() {
		System.out.println("pause() called");
	}

	@Override
	public void resume() {
		System.out.println("resume() called");
		
	}

	@Override
	public void hide() {
		System.out.println("hide() called");
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}

}
