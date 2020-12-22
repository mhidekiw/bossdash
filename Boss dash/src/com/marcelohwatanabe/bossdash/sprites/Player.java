package com.marcelohwatanabe.bossdash.sprites;

import com.marcelohwatanabe.bossdash.Game;
import com.marcelohwatanabe.bossdash.input.KeyManager;

public class Player extends Sprite {
	
	private KeyManager keyManager;
	
	private double speed;
	
	public Player(Game game, double x, double y, double width, double height) {
		super(game, x, y, width, height);
		this.keyManager = KeyManager.getInstance();
		this.speed = 10;
	}
	
	public void tick() {
		super.tick();
		move();
	}
	
	private void move() {
		if (keyManager.keyDown(KeyManager.UP)) velocityY = -speed;
		else if (keyManager.keyDown(KeyManager.DOWN)) velocityY = speed;
		else velocityY = 0;
		
		if (keyManager.keyDown(KeyManager.LEFT)) velocityX = -speed;
		else if (keyManager.keyDown(KeyManager.RIGHT)) velocityX = speed;
		else velocityX = 0;
	}
}
