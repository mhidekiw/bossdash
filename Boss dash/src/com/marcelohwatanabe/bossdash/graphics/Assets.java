package com.marcelohwatanabe.bossdash.graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 16, height = 16;
	
	public static BufferedImage img1, img2, img3, img4;
	
	public static void init() {
		/* Loads assets to game
		 * 
		 * Should be called once on game initialization
		 */
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
		
		img1 = sheet.crop(0, 0, width, height);
		img2 = sheet.crop(width, 0, width, height);
		img3 = sheet.crop(0, height, width, height);
		img4 = sheet.crop(width, height, width, height);
	}
}
