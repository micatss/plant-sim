package com.micatss.plantsim.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.micatss.game.screens.StaticScreen;
import com.micatss.plantsim.PlantSim;

public class MainMenuScreen extends StaticScreen {
	SpriteBatch batch;
	Texture img;
//	Music bgMusic;
//	Sound dropSound;

	public MainMenuScreen(final PlantSim game) {
		super(game,null);
		batch = new SpriteBatch();
		img = new Texture("bonsai_1.png");
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
	public void dispose() {
		batch.dispose();
		img.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		// TODO Auto-generated method stub
		return false;
	}

}
