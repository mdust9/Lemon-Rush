package me.game.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Keys.Keys;
import Objects.Obstacle;
import Objects.ObstacleNEW;
import Objects.Player;
import me.game.main.GamePanel;
import me.game.tilemap.TileMap;

public class Map1State extends GameState {

	private TileMap tileMap;
	private Player player;
	private ObstacleNEW o1;
	//private ArrayList<ObstacleNEW> obstacles;

	public void init() {
		tileMap = new TileMap("/Maps/Map1.txt", 32);
		tileMap.loadTiles("/Tilesets/TileSet.gif");

		player = new Player(tileMap);
		player.setX(250);
		player.setY(450);
		
		o1 = new ObstacleNEW(tileMap);
		o1.setX(50);
		o1.setY(50);
		//obstacles.add(o1);
	}

	public Map1State(GameStateManager gsm) {
		super(gsm);
		init();
	}

	public void update() {
		tileMap.update();
		player.update();
		o1.update();
		/*updateObstacles();
		ObstacleNEW o2 = new ObstacleNEW(tileMap);
		o2.setX(50);
		o2.setY(50);
		obstacles.add(o2);*/
		handleInput();
	}

	public void draw(Graphics2D g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

		tileMap.draw(g);
		player.draw(g);
		o1.draw(g);
		/*for(ObstacleNEW o: obstacles){
			o.draw(g);
		}*/
	}

	public void handleInput() {
		if (Keys.isPressed(Keys.ESCAPE))
			gsm.setPaused(true);
		if (Keys.isPressed(Keys.UP))
			player.setJumping(true);
		if (Keys.keyState[Keys.LEFT])
			player.setLeft(true);
		else
			player.setLeft(false);
		if (Keys.keyState[Keys.RIGHT])
			player.setRight(true);
		else
			player.setRight(false);
		/*if (Keys.isPressed(Keys.SPACE))
			player.setJumping(true);*/

	}
	
	/*public void updateObstacles(){
		for(ObstacleNEW o: obstacles){
			o.update();
		}
	}*/
	
}
