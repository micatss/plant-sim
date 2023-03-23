package com.micatss.game.files.savedata;

import org.json.simple.JSONObject;

public interface Saveable<U> {
	public JSONObject asSaveableJson();
	public String getSaveType();
}
