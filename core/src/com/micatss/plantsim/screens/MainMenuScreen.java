package com.micatss.plantsim.screens;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.micatss.game.GameLogger;
import com.micatss.game.MicatssGame;
import com.micatss.game.clickable.Button;
import com.micatss.game.drawable.Drawable;
import com.micatss.game.drawable.Position;
import com.micatss.game.screens.StaticScreen;
import com.micatss.plantsim.game.Bonsai;

public class MainMenuScreen extends StaticScreen {
	
//	Music bgMusic;
//	Sound dropSound;

	private List<Drawable> drawables = new LinkedList<Drawable>();
	private List<Button> buttons = new LinkedList<Button>();
	private Button startButton = new Button(0,200,0,150);

	public MainMenuScreen(final MicatssGame game) {
		super(game,null);
		drawables.add(new Bonsai(new Position(0,0),"start.jpg"));
		buttons.add(startButton);
	}

	@Override
	public void show() {
		System.out.println("show() called");
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 1, 0, 1);
		spriteBatch.begin();
		for(Drawable button : drawables) {
			button.draw(spriteBatch,shapeRenderer);
		}
		spriteBatch.end();
	}

	@Override
	public void dispose() {
		super.dispose();
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
	private boolean startButton_pressed(int x, int y) {
		return startButton.isClicked(x, y);
	}
	private void startButton() {
		game.setScreen(new GardenScreen(game));
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		GameLogger.info("touchdown " + screenX + "," + screenY);
		if(startButton_pressed(screenX,screenY)) {
			startButton();
		}
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
