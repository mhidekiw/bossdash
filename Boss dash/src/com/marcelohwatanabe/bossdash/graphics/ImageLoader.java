package com.marcelohwatanabe.bossdash.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage loadImage(String path) {
		
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
			// The path can be written in the form "/textures/image.png",
			// because the resources folder was added to the Classpath of
			// the project (project properties -> java build path -> classpath)
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
