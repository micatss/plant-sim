package com.micatss.plantsim.screens;

import java.util.Collection;
import java.util.LinkedList;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.micatss.plantsim.PlantSim;
import com.micatss.plantsim.config.configfile.ScreenConfig;
import com.micatss.plantsim.game.DisplayStand;
import com.micatss.plantsim.game.Drawable;
import com.micatss.plantsim.game.Pot;
import com.micatss.plantsim.game.bonsai.Bonsai;
import com.micatss.plantsim.util.FontHelper;

public class GardenScreen implements Screen {

	private final PlantSim game;
	private final ScreenConfig screenConfig;
	private final OrthographicCamera camera;
	
//	Music bgMusic;
//	Sound dropSound;
	
	private final SpriteBatch batch;

	private Collection<Drawable> drawables = new LinkedList<Drawable>();
	private Collection<Texture> textures = new LinkedList<Texture>();
	
	private final BitmapFont cameraSizeStatMessage = FontHelper.h1;

	public GardenScreen(final PlantSim game) {
		this.game = game;
		this.screenConfig = game.getConfigSettings().getScreenConfig();
		this.camera = new OrthographicCamera(screenConfig.getWidth(),screenConfig.getHeight());
		this.batch = new SpriteBatch();
		
		drawables.add(new DisplayStand((int)camera.viewportWidth/2,0,50,200,Color.BROWN));
		textures.add(new Bonsai(new Pot(Color.BLUE)).asTexture());
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
		for(Texture texture : textures) {
			batch.draw(texture, 0, 0);
		}
//		cameraSizeStatMessage.draw(batch,camera.viewportWidth + "x" + camera.viewportHeight,camera.viewportWidth - 150,camera.viewportHeight - 150);
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		game.updateScreenConfig(width, height);
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
		for(Texture texture : textures) {
			texture.dispose();
		}
	}

}
