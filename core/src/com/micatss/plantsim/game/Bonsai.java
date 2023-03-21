package com.micatss.plantsim.game;

import org.json.simple.JSONObject;

import com.badlogic.gdx.graphics.Texture;
import com.micatss.plantsim.files.save.Saveable;
import com.micatss.plantsim.files.save.SaveableParser;
import com.micatss.plantsim.util.Position;

public class Bonsai extends Position implements Saveable<Bonsai>, Spritable {

	private final String imageFile;
	private Texture texture;

	private static final String X = "X";
	private static final String Y = "Y";
	private static final String TEXTURE_FILE = "TEXTURE_FILE";
	
	public Bonsai(int x, int y, String imageFile) {
		super(x,y);
		this.imageFile = imageFile;
	}
	
	@Override
	public Texture asTexture() {
		if(texture==null) {
			texture = new Texture(imageFile);
		}
		return texture;
	}

	@Override
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put(SaveableParser.SAVE_TYPE, saveType());
		json.put(X, this.x);
		json.put(Y, this.y);
		json.put(TEXTURE_FILE, this.imageFile);
		return json;
	}

	public static Bonsai parse(JSONObject json) {
		return new Bonsai(
				((Long)json.get(X)).intValue(),
				((Long)json.get(Y)).intValue(),
				(String)json.get(TEXTURE_FILE));
	}
	
	public String getSaveType() {
		return saveType();
	}

	public static String saveType() {
		return Bonsai.class.getName();
	}
}
