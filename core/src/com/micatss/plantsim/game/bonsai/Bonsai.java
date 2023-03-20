package com.micatss.plantsim.game.bonsai;

import com.badlogic.gdx.graphics.Texture;
import com.micatss.plantsim.game.Pot;

public class Bonsai {
	private Pot pot;

	private Texture texture;
	
	public Bonsai(Pot pot) {
		this.pot = pot;
	}
	
	public Texture asTexture() {
		if(texture==null) {
			texture = new Texture("bonsai_1.png");
		}
		return texture;
	}
}
