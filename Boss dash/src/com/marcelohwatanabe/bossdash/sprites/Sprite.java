package com.marcelohwatanabe.bossdash.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.marcelohwatanabe.bossdash.graphics.Assets;

public class Sprite {
	
	public static final int DEFAULT_LIFETIME = -1;
	public static final double DEFAULT_SCALE = 1;
	public static final double DEFAULT_WIDTH = 100, DEFAULT_HEIGHT = 100;
	public static final BufferedImage DEFAULT_ANIMATION = Assets.img1; //temp
	
	private double x, y;
	private double width, height;
	
	private double scale;
	
	private int lifetime;
		
	//private Animation animation;
	private BufferedImage animation; //temp
	
	
	private double velocityX;
	private double velocityY;
	
	//private double scale;
	//private boolean visible;
	//private double rotation;
	//private boolean debug;
	
	//collider, tint, rotateToDirection, mirrorX, mirrorY, depth, lifetime, bounciness
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public double getScale() {
		return scale;
	}
	
	public void setScale(double scale) {
		this.scale = scale;
	}

	public int getLifetime() {
		return lifetime;
	}

	public void setLifetime(int lifetime) {
		this.lifetime = lifetime;
	}

	public double getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Sprite (double x, double y, double width, double height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.lifetime = DEFAULT_LIFETIME;
		this.scale = DEFAULT_SCALE;
		this.animation = DEFAULT_ANIMATION;
		this.velocityX = 0;
		this.velocityY = 0;
	}
	
	public Sprite (double x, double y) {
		this.x = x;
		this.y = y;
		this.width = DEFAULT_WIDTH;
		this.height = DEFAULT_HEIGHT;
		this.lifetime = DEFAULT_LIFETIME;
		this.scale = DEFAULT_SCALE;
		this.animation = DEFAULT_ANIMATION;
		this.velocityX = 0;
		this.velocityY = 0;
	}
	
	public void tick() {
		
		if (lifetime > 0) {
			lifetime--;
		}
		
		updatePosition();
	}
	
	public void updatePosition() {
		
		x += velocityX;
		y += velocityY;
	}
	
	public void render(Graphics g){
		g.drawImage(animation, (int) x, (int) y, (int) (width * scale), (int) (height * scale), null);
	}
}
