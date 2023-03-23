package com.micatss.plantsim.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.micatss.plantsim.util.DrawableWithPosition;

public class DisplayStand extends DrawableWithPosition {
	
	private ShapeRenderer sr = new ShapeRenderer();
	
	private int width;
	private int height;
	private Color color;
	
	public DisplayStand(int x, int y, int width, int height, Color color) {
		super(x,y,null);
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void draw() {
		sr.setColor(color);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.rect(this.x, this.y, this.width, this.height);
		sr.end();
	}

	@Override
	public SpriteBatch getBatch() {
		// TODO Auto-generated method stub
		return null;
	}
}
