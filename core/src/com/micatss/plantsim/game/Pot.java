package com.micatss.plantsim.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Pot {
	private Color color;
	
	public Pot(Color color) {
		this.color = color;
	}
	
	public Rectangle asTexture() {
		return new Rectangle();
	}
}
