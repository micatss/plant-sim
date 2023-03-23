package com.micatss.plantsim.game;

import org.json.simple.JSONObject;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.micatss.game.drawable.DrawableSprite;
import com.micatss.game.drawable.Position;
import com.micatss.game.files.savedata.Saveable;
import com.micatss.plantsim.files.save.PlantSaveParser;

public class Bonsai extends DrawableSprite implements Saveable<Bonsai> {

	private Texture texture;

	private static final String X = "X";
	private static final String Y = "Y";
	private static final String TEXTURE_FILE = "TEXTURE_FILE";
	
	public Bonsai(Position position, String imageFile) {
		super(position, imageFile);
	}

	@Override
	public JSONObject asSaveableJson() {
		JSONObject json = new JSONObject();
		json.put(PlantSaveParser.SAVE_TYPE, saveType());
		json.put(X, position.getX());
		json.put(Y, position.getY());
		json.put(TEXTURE_FILE, this.imageFile);
		return json;
	}

	public static Bonsai parse(JSONObject json) {
		return new Bonsai(
				new Position(
					((Long)json.get(X)).intValue(),
					((Long)json.get(Y)).intValue()
				),
				(String)json.get(TEXTURE_FILE));
	}
	
	@Override
	public String getSaveType() {
		return saveType();
	}

	public static String saveType() {
		return Bonsai.class.getName();
	}

	@Override
	public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer) {
		batch.draw(asTexture(), position.getX(), position.getY());
		
	}
}
