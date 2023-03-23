package com.micatss.plantsim.util;

public abstract class Position {
	protected int x;
	protected int y;

	protected Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
