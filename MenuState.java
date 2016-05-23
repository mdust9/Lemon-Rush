package me.game.gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Keys.Keys;
import me.game.main.GamePanel;

public class MenuState extends GameState {

	private BufferedImage head;

	private int currentChoice = 0;
	private String[] options = { "Start", "Instructions", "Quit", "Credits" };// added
																				// Instructions

	private Color titleColor;
	private Font titleFont;

	private Font font;
	private Font font2;

	public MenuState(GameStateManager gsm) {
		super(gsm);

		try {

			// load floating head
			head = ImageIO.read(getClass().getResourceAsStream("/graphics/Hud.gif")).getSubimage(0, 12, 12, 11);

			// titles and fonts
			titleColor = Color.WHITE;
			titleFont = new Font("Times New Roman", Font.PLAIN, 56);
			font = new Font("Arial", Font.PLAIN, 28);
			font2 = new Font("Arial", Font.PLAIN, 20);
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
		// draw bg
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("D U N K E Y  K O N G", 70, 180);

		// draw menu options
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Start", 290, 290);
		g.drawString("Instructions", 290, 330);
		g.drawString("Credits", 290, 370);
		g.drawString("Exit", 290, 410);
		g.drawString("Press Space to select an option", 120, 210);

		// draw floating head
		if (currentChoice == 0)
			g.drawImage(head, 250, 268, null);
		else if (currentChoice == 1)
			g.drawImage(head, 250, 308, null);
		else if (currentChoice == 2)
			g.drawImage(head, 250, 348, null);
		else if (currentChoice == 3)
			g.drawImage(head, 250, 388, null);

		// other
		g.setFont(font2);
		g.drawString("AP Compsci 2016", 20, 464);
	}

	private void select() {
		if (currentChoice == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE);
		} else if (currentChoice == 1) {
			gsm.setState(GameStateManager.INSTRUCTIONSSTATE);
		} else if (currentChoice == 2) {
			gsm.setState(GameStateManager.CREDITSSTATE);
		} else if (currentChoice == 3) {
			System.exit(0);
		}
	}

	public void handleInput() {
		if (Keys.isPressed(Keys.SPACE))
			select();
		if (Keys.isPressed(Keys.UP)) {
			if (currentChoice > 0) {
				currentChoice--;
			}
		}
		if (Keys.isPressed(Keys.DOWN)) {
			if (currentChoice < options.length - 1) {
				currentChoice++;
			}
		}
	}

}
