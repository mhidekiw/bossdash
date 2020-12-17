package com.marcelohwatanabe.bossdash.states;

public class StateManager {
	
	private State currentState = null;
	
	public void setState(State state) {
		currentState = state;
	}
	
	public State getState() {
		return currentState;
	}
}
