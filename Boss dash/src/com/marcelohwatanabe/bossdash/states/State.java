package com.marcelohwatanabe.bossdash.states;

import java.awt.Graphics;

import com.marcelohwatanabe.bossdash.Game;

public abstract class State {
	
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}
