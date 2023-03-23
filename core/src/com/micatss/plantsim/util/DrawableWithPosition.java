package com.micatss.plantsim.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.micatss.plantsim.game.Drawable;

public abstract class DrawableWithPosition extends Position implements Drawable {
	private final SpriteBatch batch;
	protected DrawableWithPosition(int x, int y, SpriteBatch batch) {
		super(x,y);
		this.batch = batch;
	}
	public SpriteBatch getBatch() {
		return batch;
	}
	public abstract void draw();
}
