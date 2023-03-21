package com.micatss.plantsim.files.save;

import org.json.simple.JSONObject;

public interface Saveable<U> {
	public JSONObject toJson();
	public String getSaveType();
}
