package com.marcelohwatanabe.bossdash.sprites;

import com.marcelohwatanabe.bossdash.Game;
import com.marcelohwatanabe.bossdash.input.KeyManager;

public class Player extends Sprite {
	
	private KeyManager keyManager;
	
	public Player(Game game, double x, double y, double width, double height) {
		super(game, x, y, width, height);
		this.keyManager = KeyManager.getInstance();
	}
	
	public void tick() {
		super.tick();
		move();
	}
	
	private void move() {
		if (keyManager.keyDown(KeyManager.UP)) velocityY = -1;
		else if (keyManager.keyDown(KeyManager.DOWN)) velocityY = 1;
	}
}
