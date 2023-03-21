package com.micatss.plantsim.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.micatss.plantsim.util.Position;

public class DisplayStand extends Position implements Drawable {
	
	private ShapeRenderer sr = new ShapeRenderer();
	
	private int width;
	private int height;
	private Color color;
	
	public DisplayStand(int x, int y, int width, int height, Color color) {
		super(x,y);
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
