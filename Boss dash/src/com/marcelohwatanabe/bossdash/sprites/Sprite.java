package com.marcelohwatanabe.bossdash.sprites;

import java.awt.Graphics;

import com.marcelohwatanabe.bossdash.Game;
import com.marcelohwatanabe.bossdash.graphics.Assets;

public class Sprite {
	
	private double x, y;
	
	private Game game;
	
	//private Animation animation;
	//private double velocityX;
	//private double velocityY;
	//private double scale;
	//private boolean visible;
	//private double rotation;
	//private boolean debug;
	
	//collider, tint, rotateToDirection, mirrorX, mirrorY, depth, lifetime, bounciness
	
	public Sprite (Game game, double x, double y) {
		this.game = game;
		this.x = x;
		this.y = y;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g){
		g.drawImage(Assets.img1, (int) x, (int) y, null);
	}
}
