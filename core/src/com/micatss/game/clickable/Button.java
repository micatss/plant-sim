package com.micatss.game.clickable;

public class Button {
	private int x_low;
	private int x_high;
	private int y_low;
	private int y_high;
	
	public Button (int x_low, int x_high, int y_low, int y_high) {
		this.x_low = x_low;
		this.x_high = x_high;
		this.y_low = y_low;
		this.y_high = y_high;
	}
	
	public boolean isClicked(int x, int y) {
		if(x>=x_low && x<=x_high
				&& y>=y_low && y<=y_high) {
			return true;
		}
		return false;
	}
}
