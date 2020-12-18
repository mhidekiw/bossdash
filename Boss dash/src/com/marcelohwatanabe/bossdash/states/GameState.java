package com.marcelohwatanabe.bossdash.states;

import java.awt.Graphics;

import com.marcelohwatanabe.bossdash.Game;
import com.marcelohwatanabe.bossdash.sprites.Sprite;

public class GameState extends State{
/* Main game state */	
	
	private Sprite player = new Sprite(100.0, 100.0, 16, 16);
	
	public GameState(Game game) {
		super(game);
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}
	
	
}
