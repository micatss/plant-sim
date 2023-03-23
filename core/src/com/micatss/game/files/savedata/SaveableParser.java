package com.micatss.game.files.savedata;

import org.json.simple.JSONObject;

public abstract class SaveableParser {

	public static final String SAVE_TYPE = "SAVE_TYPE";
	
	public abstract Saveable parse(JSONObject json);
}
