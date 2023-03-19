package com.micatss.plantsim;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class MainMenuScreen implements Screen {

	final PlantSim game;

	OrthographicCamera camera;
	SpriteBatch batch;
	Texture img;
	Music bgMusic;
	Sound dropSound;
	Rectangle bucket;
	
	final BitmapFont cameraSizeStatMessage;

	public MainMenuScreen(final PlantSim game) {
		this.game = game;

		cameraSizeStatMessage = FontHelper.h1;
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);
	}

	@Override
	public void show() {
		System.out.println("show() called");
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 1, 0, 1);
		batch.begin();
		cameraSizeStatMessage.draw(batch,camera.viewportWidth + "x" + camera.viewportHeight,camera.viewportWidth - 100,camera.viewportHeight - 100);
		
		batch.draw(img, camera.viewportWidth/2, camera.viewportHeight/2);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("resize() called");
		camera.setToOrtho(false, width, height);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
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
