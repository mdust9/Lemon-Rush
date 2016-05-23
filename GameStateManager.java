//GUI STUFF BELOW HERE

package me.game.gamestates;

import me.game.main.GamePanel;

public class GameStateManager {

	private GameState[] gameStates;
	private static int currentState;

	private PauseState pauseState;
	private boolean paused;

	public static final int NUMGAMESTATES = 16;
	public static final int MENUSTATE = 0;
	public static final int LEVEL1STATE = 2;
	public static final int INSTRUCTIONSSTATE = 1;
	public static final int CREDITSSTATE = 3;

	public GameStateManager() {

		gameStates = new GameState[NUMGAMESTATES];

		pauseState = new PauseState(this);
		paused = false;

		currentState = MENUSTATE;
		loadState(currentState);

	}

	private void loadState(int state) {
		if (state == MENUSTATE)
			gameStates[state] = new MenuState(this);
		else if (state == LEVEL1STATE)
			// THIS NEEDS TO BE CHANGED
			gameStates[state] = new Map1State(this);
		else if (state == CREDITSSTATE)
			gameStates[state] = new CreditsState(this);
	}

	private void unloadState(int state) {
		gameStates[state] = null;
	}

	public void setState(int state) {
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
	}

	public void setPaused(boolean b) {
		paused = b;
	}

	public void update() {
		if (paused) {
			pauseState.update();
			return;
		}
		if (gameStates[currentState] != null)
			gameStates[currentState].update();
	}

	public void draw(java.awt.Graphics2D g) {
		if (paused) {
			pauseState.draw(g);
			return;
		} // GUI STUFF
		if (gameStates[currentState] != null)
			gameStates[currentState].draw(g);
		else {
			g.setColor(java.awt.Color.BLACK);
			g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		}
	}

	public static void nextGameState() {
		currentState = MENUSTATE;
	}
}