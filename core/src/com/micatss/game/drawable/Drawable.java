package com.micatss.game.drawable;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public interface Drawable {
	public void dispose();
	public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer);
}
