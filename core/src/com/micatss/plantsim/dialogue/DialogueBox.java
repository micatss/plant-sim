package com.micatss.plantsim.dialogue;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.micatss.game.GameLogger;
import com.micatss.game.drawable.DrawableWithPosition;
import com.micatss.game.drawable.Position;
import com.micatss.plantsim.util.FontHelper;

public class DialogueBox extends DrawableWithPosition {
	
	private final String message;

	private static final Color boxColor = Color.BROWN;
	private static final Color fontColor = Color.BLACK;
	private static final BitmapFont font = new BitmapFont();
	
	private static final int margin = 100;
	
	public DialogueBox(Position position, String message) {
		super(position);
		this.message = message;
	}
	
	@Override
	public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer) {
		drawBox(shapeRenderer);
		drawText(batch);
	}
	
	private void drawBox(ShapeRenderer shapeRenderer) {
		shapeRenderer.setColor(boxColor);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.rect(position.getX(), position.getY(), 200, 150);
//		shapeRenderer.end();
	}
	
	private void drawText(SpriteBatch batch) {
		font.setColor(fontColor);
		font.draw(batch, message, position.getX()+margin, position.getY()+margin);
	}

}
