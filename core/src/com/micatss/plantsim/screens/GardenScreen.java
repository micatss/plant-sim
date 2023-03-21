package com.micatss.plantsim.screens;

import java.util.Collection;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.micatss.plantsim.PlantSim;
import com.micatss.plantsim.files.save.SaveData;
import com.micatss.plantsim.files.save.Saveable;
import com.micatss.plantsim.game.Bonsai;
import com.micatss.plantsim.game.DisplayStand;
import com.micatss.plantsim.game.Drawable;
import com.micatss.plantsim.game.Spritable;
import com.micatss.plantsim.util.FontHelper;
import com.micatss.plantsim.util.ProgramLog;

public class GardenScreen extends DynamicScreen implements Screen, InputProcessor {

	private final PlantSim game;
	private final SaveData saveData;
	
//	Music bgMusic;
//	Sound dropSound;
	
	private final SpriteBatch batch;

	private Collection<Drawable> drawables = new LinkedList<Drawable>();
	private Collection<Spritable> sprites = new LinkedList<Spritable>();
	
	private final BitmapFont basicText = FontHelper.h1;

	public GardenScreen(final PlantSim game) {
		super(game.getConfigSettings().getScreenConfig());
		this.game = game;
		this.saveData = game.getConfigSettings().getSaveData();
		Gdx.input.setInputProcessor(this);
		
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
	public void render(float delta) {
		super.render(delta);
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
		super.resize(width,height);
	}

	@Override
	public void show() {
		super.show();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void hide() {
		super.hide();
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		for(Spritable sprite : sprites) {
			sprite.asTexture().dispose();
		}
	}

	@Override
	public boolean keyDown(int keycode) {
		ProgramLog.info("keyDown:" + keycode);
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		ProgramLog.info("keyUp:" + keycode);
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		ProgramLog.info("keyTyped:" + character);
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		ProgramLog.info("touchDown:(" + screenX + "," + screenY + "),pointer:" + pointer + ",button:" + button);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		ProgramLog.info("touchUp:(" + screenX + "," + screenY + "),pointer:" + pointer + ",button:" + button);
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		ProgramLog.info("touchDragged:(" + screenX + "," + screenY + "),pointer:" + pointer);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
//		ProgramLog.info("mouseMoved:(" + screenX + "," + screenY + ")");
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		ProgramLog.info("scrolled:(" + amountX + "," + amountY + ")");
		zoom(amountY);
		refreshBatch();
		return false;
	}
	
	private void refreshBatch() {
		batch.setProjectionMatrix(camera.combined);
	}

}
