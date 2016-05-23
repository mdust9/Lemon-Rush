package me.game.gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Keys.Keys;
import me.game.main.GamePanel;
//import Main.GamePanel;

public class InstructionsState extends GameState {
	private Font font;

	public InstructionsState(GameStateManager gsm) {

		super(gsm);
		// fonts
		font = new Font("Century Gothic", Font.PLAIN, 14);

	}

	public void init() {
	}

	public void update() {
		handleInput();
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("INSTRUCTIONS", 90, 90);
	}

	public void handleInput() {
		if (Keys.isPressed(Keys.ESCAPE))
			gsm.setState(GameStateManager.MENUSTATE);
	}
}