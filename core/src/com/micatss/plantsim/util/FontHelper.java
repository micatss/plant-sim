package com.micatss.plantsim.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class FontHelper {
	private FontHelper() {}
	
	public static BitmapFont h1 = getH1();
	
	private static BitmapFont getH1() {
		BitmapFont font = new BitmapFont();
		font.setColor(Color.BLACK);
		return font; 
	}
}
