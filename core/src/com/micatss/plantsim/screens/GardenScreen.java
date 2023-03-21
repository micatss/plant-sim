package com.micatss.plantsim.screens;

import java.util.Collection;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.micatss.plantsim.PlantSim;
import com.micatss.plantsim.files.config.ScreenConfig;
import com.micatss.plantsim.files.save.SaveData;
import com.micatss.plantsim.files.save.Saveable;
import com.micatss.plantsim.game.Bonsai;
import com.micatss.plantsim.game.DisplayStand;
import com.micatss.plantsim.game.Drawable;
import com.micatss.plantsim.game.Pot;
import com.micatss.plantsim.game.Spritable;
import com.micatss.plantsim.util.FontHelper;

public class GardenScreen implements Screen {

	private final PlantSim game;
	private final SaveData saveData;
	private final ScreenConfig screenConfig;
	private final OrthographicCamera camera;
	
//	Music bgMusic;
//	Sound dropSound;
	
	private final SpriteBatch batch;

	private Collection<Drawable> drawables = new LinkedList<Drawable>();
	private Collection<Spritable> sprites = new LinkedList<Spritable>();
	
	private final BitmapFont basicText = FontHelper.h1;

	public GardenScreen(final PlantSim game) {
		this.game = game;
		this.saveData = game.getConfigSettings().getSaveData();
		this.screenConfig = game.getConfigSettings().getScreenConfig();
		this.camera = new OrthographicCamera(screenConfig.getWidth(),screenConfig.getHeight());
		
		this.batch = new SpriteBatch();
		
		for(Saveable saveable : saveData.getSaveables()) {
			if(saveable.getSaveType().equals(Bonsai.saveType())) {
				sprites.add((Bonsai)saveable);
			}
		}
		drawables.add(new DisplayStand((int)camera.viewportWidth/2,0,50,200,Color.BROWN));
		sprites.add(new Bonsai((int)camera.viewportWidth/2, 200, "bonsai_1.png"));
	}

	@Override
	public void show() {
		System.out.println("show() called");
	}

	@Override
	public void render(float delta) {
		
		ScreenUtils.clear(1, 0, 0, 1);
		for(Drawable drawable : drawables) {
			drawable.draw();
		}
		batch.begin();
		for(Spritable sprite : sprites) {
			batch.draw(sprite.asTexture(), sprite.getX(), sprite.getY());
		}
		
		basicText.draw(batch, "FPS: " + String.format("%d", Gdx.graphics.getFramesPerSecond()), 400, 400);
		batch.end();
		
	}
	
	private Collection<Saveable> collectAllSaveables(){
		Collection<Saveable> saveables = new LinkedList<Saveable>();
		for(Spritable sprite : sprites) {
			if(sprite instanceof Bonsai) {
				saveables.add((Bonsai)sprite);
			}
		}
		return saveables;
	}

	@Override
	public void resize(int width, int height) {
		game.updateScreenConfig(width, height);
		game.updateSavedata(collectAllSaveables());
		camera.setToOrtho(false, width, height);
		camera.update();
//		viewport.update(width, height, true);
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
		for(Spritable sprite : sprites) {
			sprite.asTexture().dispose();
		}
	}

}
