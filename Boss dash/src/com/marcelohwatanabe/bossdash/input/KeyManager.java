package com.marcelohwatanabe.bossdash.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	// Singleton object for class
	private static KeyManager instance = new KeyManager();
	
	// Currently pressed keys
	private boolean[] keys;
	
	// Went down after last tick
	private boolean[] pressedOnLastTick;
	
	// Pressed on last tick
	private boolean[] alreadyDown;
	
	public static final int UP = KeyEvent.VK_UP,
							DOWN = KeyEvent.VK_DOWN,
							LEFT = KeyEvent.VK_LEFT,
							RIGHT = KeyEvent.VK_RIGHT,
							SPACE = KeyEvent.VK_SPACE;
	
 	public void tick() {
		/* 
		 * Updates references
		 * 
		 * Should be called on main game loop
		 */
 		
 		for (int i = 0; i < keys.length; i++) {
 			keyWentDown(i);
 			keyDown(i);
 		}
 		
 		for (int i = 0; i < keys.length; i++) {
 			alreadyDown[i] = keyDown(i);
 		}
 		
 		for (int i = 0; i < pressedOnLastTick.length; i++) {
 			pressedOnLastTick[i] = false;
 		}
 		
	}
 	
	private KeyManager() {
		/*
		 * Private constructor to prevent outside initialization
		 */
		keys = new boolean[256];
		alreadyDown = new boolean[256];
		pressedOnLastTick = new boolean[256];
	}
	
	public static void init() {
		/*
		 * Initializes singleton instance
		 */
		if (instance == null)
			instance = new KeyManager();
	}
	
	public static KeyManager getInstance() {
		if (instance == null) {
			init();
		}
		return instance;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		pressedOnLastTick[e.getKeyCode()] = true;
	}
	
	public boolean keyDown(int keyCode) {
		
		//if (keys[keyCode]) System.out.println("keyDown: " + keyCode);
		return keys[keyCode];
	}
	
	public boolean keyWentDown(int keyCode) {
		
		if (pressedOnLastTick[keyCode] && !alreadyDown[keyCode]) {
			System.out.println("Went down: " + keyCode);
			return true;
		}
		else return false;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
