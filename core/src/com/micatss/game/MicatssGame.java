package com.micatss.game;

import java.util.Collection;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.micatss.game.files.UserData;
import com.micatss.game.files.UserDataLoader;
import com.micatss.game.files.config.ScreenConfig;
import com.micatss.game.files.savedata.SaveData;
import com.micatss.game.files.savedata.Saveable;

public abstract class MicatssGame extends Game {
	
	private UserData userData;
	
	public void create (UserDataLoader loader) {
		this.userData = loader.loadUserData();
		Gdx.graphics.setWindowedMode(getScreenConfig().getWidth(), getScreenConfig().getHeight());
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
	
	public UserData getUserData() {
		return userData;
	}
	
	public void setUserData(UserData userdata) {
		this.userData = userdata;
	}
	
	public SaveData getSaveData() {
		return this.userData.getSaveData();
	}
	
	public ScreenConfig getScreenConfig() {
		return this.userData.getScreenConfig();
	}
	
	public void updateSavedata(Collection<Saveable> saveables) {
		getSaveData().getSaveables().clear();
		getSaveData().getSaveables().addAll(saveables);
		getSaveData().save();
	}
	
	public void updateScreenConfig(int width, int height){
		getScreenConfig().setHeight(height);
		getScreenConfig().setWidth(width);
		getScreenConfig().save();
	}
}
