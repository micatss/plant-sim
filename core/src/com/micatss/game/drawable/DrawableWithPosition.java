package com.micatss.game.drawable;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class DrawableWithPosition implements Drawable {
	protected Position position;
	protected DrawableWithPosition(Position position) {
		this.position = position;
	}
	public abstract void draw(SpriteBatch batch);
	public void dispose() {
		
	}
}
