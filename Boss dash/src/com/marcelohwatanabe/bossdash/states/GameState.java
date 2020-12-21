package com.marcelohwatanabe.bossdash.states;

import java.awt.Graphics;

import com.marcelohwatanabe.bossdash.Game;
import com.marcelohwatanabe.bossdash.input.KeyManager;
import com.marcelohwatanabe.bossdash.sprites.Player;
import com.marcelohwatanabe.bossdash.sprites.Sprite;

public class GameState extends State{
/* Main game state */	
	
	private Sprite player = new Player(game ,100.0, 100.0, 16, 16);
	private KeyManager keyManager;
	
	public GameState(Game game) {
		super(game);
		keyManager = KeyManager.getInstance();
	}
	
	@Override
	public void tick() {
		player.tick();
		keyManager.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}
	
	
}
