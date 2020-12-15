package com.marcelohwatanabe.bossdash;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.marcelohwatanabe.bossdash.graphics.ImageLoader;
import com.marcelohwatanabe.display.Display;

public class Game implements Runnable {
	
	private Display display;
	
	public String title;
	public int width, height;
	
	private Thread thread;
	
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//temp
	private BufferedImage testImage;
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	private void init() {
		display = new Display(title, width, height);
		//temp
		testImage = ImageLoader.loadImage("/textures/test.png");
	}
	
	private void tick() {
		
	}
	
	private void render() {
		
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {	// Runs the first time the method is called
			display.getCanvas().createBufferStrategy(3);	// creates the buffer strategy game will use the given number of buggers
			return;
		}
		g = bs.getDrawGraphics(); // Initializes graphic object to draw on screen
		
		// Clear screen
		g.clearRect(0, 0, width, height);
		
		// Drawing
		g.drawImage(testImage, 20, 20, null);
		
		// Render and finalization
		bs.show(); // Works the buffers and shows the final image
		g.dispose(); // Closes (properly) the graphics used to draw the current frame
	}
	
	@Override
	public void run() {
		
		init();
		
		while (running) {
			tick();
			render();
		}
		
		stop();
	}
	
	public synchronized void start() {
		if (running) return;		// protects the code if the method is called while game is already running
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running) return;		// protects the code if the method is called if the game is not running
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
