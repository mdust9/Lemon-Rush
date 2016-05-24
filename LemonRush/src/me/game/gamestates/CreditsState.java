package me.game.gamestates;

//THIS NEEDS TO BE UPDATED

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

//import GUI.GamePanel;
import Keys.Keys;
import me.game.main.GamePanel;

public class CreditsState extends GameState {
	private Font font;

	public CreditsState(GameStateManager gsm) {

		super(gsm);
		try {
			font = new Font("Century Gothic", Font.PLAIN, 14);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		g.drawString("CREDITS", 35, 30);
		g.drawString("Matthew Duston", 25, 70);
		g.drawString("Chaitanya Kore", 25, 90);
		g.drawString("Anjuman Raha", 25, 110);
		g.drawString("Anish Sathe", 25, 130);
	}

	public void handleInput() {
		if (Keys.isPressed(Keys.ESCAPE))
			gsm.setState(GameStateManager.MENUSTATE);
	}
	
}
