package com.micatss.plantsim.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class DisplayStand implements Drawable {
	
	private ShapeRenderer sr = new ShapeRenderer();
	
	private int width;
	private int height;
	private int x;
	private int y;
	private Color color;
	
	public DisplayStand(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	@Override
	public void draw() {
		sr.setColor(color);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.rect(this.x, this.y, this.width, this.height);
		sr.end();
	}
}
