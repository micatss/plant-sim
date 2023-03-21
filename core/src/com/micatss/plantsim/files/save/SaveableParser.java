package com.micatss.plantsim.files.save;

import org.json.simple.JSONObject;

import com.micatss.plantsim.game.Bonsai;

public class SaveableParser {
	private SaveableParser() {}

	public static final String SAVE_TYPE = "SAVE_TYPE";
	
	public static Saveable parse(JSONObject json) {
		if(json.get(SAVE_TYPE).equals(Bonsai.saveType())) {
			return Bonsai.parse(json);
		}
		return null;
	}
}
