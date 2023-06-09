package com.micatss.plantsim.screens;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.micatss.game.GameLogger;
import com.micatss.game.MicatssGame;
import com.micatss.game.drawable.Drawable;
import com.micatss.game.drawable.Position;
import com.micatss.game.files.savedata.Saveable;
import com.micatss.game.screens.DynamicScreen;
import com.micatss.plantsim.dialogue.DialogueBox;
import com.micatss.plantsim.game.Bonsai;
import com.micatss.plantsim.game.DisplayStand;

public class GardenScreen extends DynamicScreen {

	private static final Music backgroundMusic = null;
//	Sound dropSound;

	private Collection<Drawable> drawables = new LinkedList<Drawable>();
	private List<DialogueBox> dialogueBoxes = new LinkedList<DialogueBox>();
	private int currentDialogIndex = 0;

	public GardenScreen(final MicatssGame game) {
		super(game, backgroundMusic);
		
		for(Saveable saveable : game.getSaveData().getSaveables()) {
			if(saveable.getSaveType().equals(Bonsai.saveType())) {
				drawables.add((Bonsai)saveable);
			}
		}
		drawables.add(new DisplayStand(new Position((int)camera.viewportWidth/2,0),50,200,Color.BROWN));
		drawables.add(new Bonsai(new Position((int)camera.viewportWidth/2, 200), "bonsai_1.png"));

		dialogueBoxes.add(new DialogueBox(new Position(400,500),"Welcome to the garden."));
	}

	@Override
	public void render(float delta) {
		super.render(delta);
//		ScreenUtils.clear(1, 0, 0, 1);

		spriteBatch.begin();
//		shapeRenderer.begin();
		for(Drawable drawable : drawables) {
			drawable.draw(spriteBatch, shapeRenderer);
		}
		processDialogue();
		
		spriteBatch.end();
		shapeRenderer.end();
	}
	
	private void processDialogue() {
		if(currentDialogIndex<=dialogueBoxes.size()) {
			DialogueBox dialogueBox = dialogueBoxes.get(currentDialogIndex);
			if(dialogueBox.showing()){
				dialogueBox.draw(spriteBatch, shapeRenderer);
			}
		}
	}
	
	
	private Collection<Saveable> collectAllSaveables(){
		Collection<Saveable> saveables = new LinkedList<Saveable>();
		for(Drawable drawable : drawables) {
			if(drawable instanceof Bonsai) {
				saveables.add((Bonsai)drawable);
			}
		}
		return saveables;
	}

	@Override
	public void dispose() {
		super.dispose();
		for(Drawable drawable : drawables) {
			drawable.dispose();
		}
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode==Input.Keys.M) {
			game.updateSavedata(collectAllSaveables());
		}
//		GameLogger.info("keyDown:" + keycode);
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
//		GameLogger.info("keyTyped:" + character);
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//		GameLogger.info("touchDown:(" + screenX + "," + screenY + "),pointer:" + pointer + ",button:" + button);
		if(currentDialogIndex<=dialogueBoxes.size()) {
			DialogueBox dialog = dialogueBoxes.get(currentDialogIndex);
			dialog.show();
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//		GameLogger.info("touchUp:(" + screenX + "," + screenY + "),pointer:" + pointer + ",button:" + button);
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
//		GameLogger.info("touchDragged:(" + screenX + "," + screenY + "),pointer:" + pointer);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
//		ProgramLog.info("mouseMoved:(" + screenX + "," + screenY + ")");
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		GameLogger.info("scrolled:(" + amountX + "," + amountY + ")");
		zoom(amountY);
		refreshBatch();
		return false;
	}
	
	private void refreshBatch() {
		spriteBatch.setProjectionMatrix(camera.combined);
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

}
