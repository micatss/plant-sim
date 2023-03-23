package com.micatss.plantsim.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.micatss.game.drawable.DrawableWithPosition;
import com.micatss.game.drawable.Position;

public class DisplayStand extends DrawableWithPosition {
	
	private ShapeRenderer sr = new ShapeRenderer();
	
	private int width;
	private int height;
	private Color color;
	
	public DisplayStand(Position position, int width, int height, Color color) {
		super(position);
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void draw() {
		sr.setColor(color);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.rect(position.getX(), position.getY(), this.width, this.height);
		sr.end();
	}

	@Override
	public void draw(SpriteBatch batch) {
		
		
	}
}
