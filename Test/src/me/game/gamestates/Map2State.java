package me.game.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import me.game.main.GamePanel;
import me.game.objects.Player;
import me.game.tilemap.TileMap;

public class Map2State extends GameState {

	private TileMap tileMap;
	private Player player;

	public void init(){
		tileMap = new TileMap("maps/Map2.txt",32);
		player = new Player(tileMap);
		player.setX(50);
		player.setY(800);
	}

	public Map2State(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	public void update() {
		tileMap.update();
		player.update();
	}
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		tileMap.draw(g);
		player.draw(g);
	}
	public void keyPressed(int k) {
		if(k== KeyEvent.VK_P){
			gsm.setCurrentState(GameStateManager.PAUSESTATE, GameStateManager.MAP2STATE);
		}
		
		if(k== KeyEvent.VK_A) {
			player.setLeft(true);
		}
		if(k== KeyEvent.VK_D) {
			player.setRight(true);
		}
		if(k== KeyEvent.VK_SPACE){
			player.setJumping(true);
		}
	}
	public void keyReleased(int k) {

		if(k== KeyEvent.VK_A) {
			player.setLeft(false);
		}
		if(k== KeyEvent.VK_D) {
			player.setRight(false);
		}
		if(k== KeyEvent.VK_SPACE){
			player.setJumping(false);
		}
		
	}

}
