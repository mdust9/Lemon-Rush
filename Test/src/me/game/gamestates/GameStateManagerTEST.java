package me.game.gamestates;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManagerTEST {

/*	private static ArrayList<GameState> gameStates;
	private static int currentState;
	private static int prevState;
	
	public static final int MENUSTATE = 0;
	public static final int PAUSESTATE = 1;
	public static final int MAP1STATE = 2;
	public static final int MAP2STATE = 3;
	
	public GameStateManager() {
		gameStates = new ArrayList<GameState>();
		
		gameStates.add(new MenuState(this));
		gameStates.add(new PauseState(this));
		gameStates.add(new Map1State(this));
		gameStates.add(new Map2State(this));
		
		currentState = MENUSTATE;
	}
	
	public static int getPrevState() {
		return prevState;
	}
	
	public void setCurrentState(int i, int p) {
		currentState = i;
		prevState = p;
	}
	
	public static void nextGameState() {
		if(currentState < gameStates.size()-1){
			currentState++;
		}
	}
	
	public void update(){
		gameStates.get(currentState).update();
	}
	public void draw(Graphics2D g) {
		gameStates.get(currentState).draw(g);
	}
	public void keyPressed(int k) {
		gameStates.get(currentState).keyPressed(k);
	}
	public void keyReleased(int k) {
		gameStates.get(currentState).keyReleased(k);
	}*/
}
