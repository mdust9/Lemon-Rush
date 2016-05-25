package me.game.gamestates;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import me.game.main.GamePanel;
import Keys.Keys;

public class InstructionsState extends GameState {
	private Font font;

	public InstructionsState(GameStateManager gsm) {

		super(gsm);
try {
	font = new Font("Century Gothic", Font.PLAIN, 14);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void init() {}

	public void update() {
		handleInput();
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("INSTRUCTIONS", 35, 30);
		g.drawString("Try to reach the goal without hitting the", 25, 70);
		g.drawString("   obstacles", 25, 90);
		g.drawString("Press the Left and Right arrow keys to move", 25, 110);
		g.drawString("   left or right respectively", 25, 130);
		g.drawString("Press the space button to jump, up arrow", 25, 150);
		g.drawString("   button to move up a ladder", 25, 170);
		g.drawString("If you run into an obstacle, you lose", 25, 190);
	}

	public void handleInput() {
		if (Keys.isPressed(Keys.ESCAPE))
			gsm.setState(GameStateManager.MENUSTATE);
	}
}
