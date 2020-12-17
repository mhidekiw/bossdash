package com.marcelohwatanabe.bossdash.states;

import java.awt.Graphics;

import com.marcelohwatanabe.bossdash.graphics.Assets;

public class GameState extends State{
/* Main game state */	
	
	public GameState() {
		
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.img1, 0, 0, null);
	}
	
	
}
