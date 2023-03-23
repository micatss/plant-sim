package com.micatss.plantsim.dialogue;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.micatss.plantsim.util.DrawableWithPosition;
import com.micatss.plantsim.util.FontHelper;

public class DialogueBox extends DrawableWithPosition {
	
	private final String message;
	
	private static final Color boxColor = Color.YELLOW;
	private static final ShapeRenderer SHAPE_RENDERER = new ShapeRenderer();
	private static final BitmapFont font = FontHelper.h1;
	
	private static final int margin = 10;
	
	public DialogueBox(int x, int y, String message, SpriteBatch batch) {
		super(x,y,batch);
		this.message = message;
	}
	
	@Override
	public void draw() {
		drawBox();
		drawText();
	}
	
	private void drawBox() {
		SHAPE_RENDERER.setColor(boxColor);
		SHAPE_RENDERER.begin(ShapeRenderer.ShapeType.Filled);
		SHAPE_RENDERER.rect(this.x, this.y, 200, 150);
		SHAPE_RENDERER.end();
	}
	
	private void drawText() {
		font.draw(getBatch(), message, x+margin, y+margin);
	}

}
