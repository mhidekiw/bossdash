package com.marcelohwatanabe.bossdash.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	
	public boolean up, down, left, right;
	
	public void tick() {
		/* 
		 * Updates references
		 * 
		 * Should be called on main game loop
		 */
		
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		if (up) {
			System.out.println("up");
		} else if (down) {
			System.out.println("down");
		} else if (left) {
			System.out.println("left");
		} else if (right) {
			System.out.println("right");
		}
	}
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
