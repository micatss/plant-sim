package com.micatss.game.drawable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class DrawableSprite extends DrawableWithPosition {

	protected final String imageFile;
	protected Texture texture;
	
	protected DrawableSprite(Position position, String imageFile) {
		super(position);
		this.imageFile = imageFile;
	}

	@Override
	public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer) {
		batch.draw(asTexture(), position.getX(), position.getY());
	}
	
	public Texture asTexture() {
		if(texture==null) {
			texture = new Texture(imageFile);
		}
		return texture;
	}
	
	@Override
	public void dispose() {
		this.asTexture().dispose();
	}


}
