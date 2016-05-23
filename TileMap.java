package me.game.tilemap;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.imageio.ImageIO;

public class TileMap {
	private int x;
	private int y;
	
	private int tileSize;
	private int [][] map;
	private int mapWidth;
	private int mapHeight;
	
	File file;
	private BufferedImage tileSet;
	private Tile[][] tiles;
	
	public TileMap(String s, int tileSize){
		this.tileSize = tileSize;
		
		try {
			file = new File(s);
			Scanner sc = new Scanner(System.in);
			sc = new Scanner(file);
			mapWidth = Integer.parseInt(sc.nextLine());
			mapHeight = Integer.parseInt(sc.nextLine());
			
			map = new int[mapHeight][mapWidth];
			
			String delimiters = "\\s+";
			for(int row = 0; row < mapHeight; row++) {
				String line = sc.nextLine();
				String[] tokens = line.split(delimiters);
				for(int col = 0; col < mapWidth; col++) {
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
		}
		catch(Exception e) {}
	}
	
public void loadTiles(String s) {
		
		try {
			
			tileSet = ImageIO.read(new File(s));
			int numTilesAcross = (tileSet.getWidth() + 1) / (tileSize + 1);
			tiles = new Tile[2][numTilesAcross];
			
			BufferedImage subimage;
			for(int col = 0; col < numTilesAcross; col++) {
				subimage = tileSet.getSubimage(
					col * tileSize + col,
					0,
					tileSize,
					tileSize
				);
				tiles[0][col] = new Tile(subimage, false);
				subimage = tileSet.getSubimage(
					col * tileSize + col,
					tileSize + 1,
					tileSize,
					tileSize
				);
				tiles[1][col] = new Tile(subimage, true);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
public void setX(int i) {
	x = i;
}
public void setY(int i) {
	y = i;
}
	public int getX() { return x; }
	public int getY() { return y; }
	
	public int getColTile(int x) {
		return x / tileSize;
	}
	public int getRowTile(int y) {
		return y / tileSize;
	}
	public int getTile(int row, int col) {
		return map[row][col];
	}
	public int getTileSize() {
		return tileSize;
	}
	public boolean isBlocked(int row, int col) {
		int rc = map[row][col];
		int r = rc / tiles[0].length;
		int c = rc % tiles[0].length;
		return tiles[r][c].isBlocked();
	}
	
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g){
		
		for(int row = 0; row < mapHeight; row++) {
			for(int col = 0; col < mapWidth; col++) {
				
				int rc = map[row][col];
				
				int r = rc / tiles[0].length;
				int c = rc % tiles[0].length;
				
				g.drawImage(
					tiles[r][c].getImage(),
					col * tileSize,
					row * tileSize,
					null
				);
				
			}
		}
	}
}
