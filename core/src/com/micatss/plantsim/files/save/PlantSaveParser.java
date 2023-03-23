package com.micatss.plantsim.files.save;

import org.json.simple.JSONObject;

import com.micatss.game.files.savedata.Saveable;
import com.micatss.game.files.savedata.SaveableParser;
import com.micatss.plantsim.game.Bonsai;

public class PlantSaveParser extends SaveableParser {
	PlantSaveParser() {}
	
	@Override
	public Saveable parse(JSONObject json) {
		if(json.get(SAVE_TYPE).equals(Bonsai.saveType())) {
			return Bonsai.parse(json);
		}
		return null;
	}
}
