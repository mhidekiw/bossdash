package com.marcelohwatanabe.bossdash.states;

import java.awt.Graphics;

import com.marcelohwatanabe.bossdash.graphics.Assets;
import com.marcelohwatanabe.bossdash.sprites.Sprite;

public class GameState extends State{
/* Main game state */	
	
	private Sprite player = new Sprite(100.0, 100.0);
	
	public GameState() {
		
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}
	
	
}
