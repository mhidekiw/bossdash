package com.marcelohwatanabe.bossdash;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.marcelohwatanabe.bossdash.graphics.Assets;
import com.marcelohwatanabe.bossdash.graphics.ImageLoader;
import com.marcelohwatanabe.bossdash.graphics.SpriteSheet;
import com.marcelohwatanabe.display.Display;

public class Game implements Runnable {
	
	private Display display;
	
	public String title;
	public int width, height;
	
	private Thread thread;
	
	private boolean running = false;
	
	// Graphics and rendering
	private BufferStrategy bs;
	private Graphics g;
	
	// Game constructor
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	// Game initialization
	private void init() {
		display = new Display(title, width, height);
		Assets.init();
	}
	int x;
	private void tick() {
		x++;
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
		g.drawImage(Assets.img3, x, 100, null);
		
		// Render and finalization
		bs.show(); // Works the buffers and shows the final image
		g.dispose(); // Closes (properly) the graphics used to draw the current frame
	}
	
	@Override
	public void run() {
		
		init();
		
		// Time control
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double timeToNextFrame = timePerTick;
		long now;
		long lastTime = System.nanoTime();
		long initialTime = lastTime;
		
		int ticks = 0;
		
		while (running) {
			
			now = System.nanoTime();
			
			if (now - lastTime >= (long) timeToNextFrame) {
				
				// Update time
				long extraTime = now - (lastTime + (long) timeToNextFrame);
				lastTime = now;
				timeToNextFrame = (long) timePerTick + extraTime;
				
				// Game update
				tick();
				render();
			}
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
