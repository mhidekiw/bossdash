package com.marcelohwatanabe.bossdash.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		/* Constructor */
		
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		/* Gets a specific part of the sprite sheet
		 * 
		 * Given x and y initial positions and width and height inside the sheet
		 */
		
		 return sheet.getSubimage(x, y, width, height);
	}
}
