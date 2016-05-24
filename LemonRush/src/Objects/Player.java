package Objects;

import java.awt.Color;
import java.awt.Graphics2D;

import me.game.gamestates.GameStateManager;
import me.game.main.GamePanel;
import me.game.tilemap.TileMap;

public class Player {
	private double x;
	private double y;
	private double dx;
	private double dy;

	private int width;
	private int height;


	private boolean left;
	private boolean right;
	private boolean jumping;
	private boolean falling;

	private double moveSpeed;
	private double maxSpeed;
	private double maxFallingSpeed;
	private double stopSpeed;
	private double jumpStart;
	private double gravity;

	private TileMap tileMap;

	private boolean topLeft;
	private boolean topRight;
	private boolean bottomLeft;
	private boolean bottomRight;
	
	private boolean tlWin;
	private boolean trWin;
	private boolean blWin;
	private boolean brWin;

	public Player(TileMap tm) {

		tileMap = tm;

		width = 20;
		height = 20;

		moveSpeed = 0.6;
		maxSpeed = 4.2;
		maxFallingSpeed = 12;
		stopSpeed = 0.30;
		jumpStart = -11.0;
		gravity = 0.64;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}

	public void setLeft(boolean b) {
		left = b;
	}
	public void setRight(boolean b) {
		right = b;
	}
	public void setJumping(boolean b) {
		if(!falling) {
			jumping = b;
		}
	}
	

	private void calculateCorners(double x, double y) {
		int leftTile = tileMap.getColTile((int)(x - width /2));
		int rightTile = tileMap.getColTile((int)(x + width / 2) - 1);
		int topTile = tileMap.getRowTile((int)(y - height / 2));
		int bottomTile = tileMap.getRowTile((int)(y + height / 2) - 1);
		topLeft = tileMap.isBlocked(topTile, leftTile);
		topRight = tileMap.isBlocked(topTile, rightTile);
		bottomLeft = tileMap.isBlocked(bottomTile, leftTile);
		bottomRight = tileMap.isBlocked(bottomTile, rightTile);
		//Check win tiles
		tlWin = tileMap.getTile(topTile,leftTile) == 2;
		trWin = tileMap.getTile(topTile, rightTile) == 2;
		blWin = tileMap.getTile(bottomTile, leftTile) == 2;
		brWin = tileMap.getTile(bottomTile, rightTile) == 2;
	}

	////////////////////////////////////////////

	public void update() {

		// determine next position
				if(left) {
					dx -= moveSpeed;
					if(dx < -maxSpeed) {
						dx = -maxSpeed;
					}
				}
				else if(right) {
					dx += moveSpeed;
					if(dx > maxSpeed) {
						dx = maxSpeed;
					}
				}
				else {
					if(dx > 0) {
						dx -= stopSpeed;
						if(dx < 0) {
							dx = 0;
						}
					}
					else if(dx < 0) {
						dx += stopSpeed;
						if(dx > 0) {
							dx = 0;
						}
					}
				}
				
				if(jumping) {
					dy = jumpStart;
					falling = true;
					jumping = false;
				}
				
				if(falling) {
					dy += gravity;
					if(dy > maxFallingSpeed) {
						dy = maxFallingSpeed;
					}
				}
				else {
					dy = 0;
				}
				
				// check collisions
				
				int currCol = tileMap.getColTile((int) x);
				int currRow = tileMap.getRowTile((int) y);
				 
				double tox = x + dx;
				double toy = y + dy;
				
				double tempx = x;
				double tempy = y;
				
				calculateCorners(x, toy);
				if(dy < 0) {
					/*if(tlWin || trWin){
						GameStateManager.nextGameState();
					}*/
					if(topLeft || topRight) {
						dy = 0;
						tempy = currRow * tileMap.getTileSize() + height / 2;
					}
					else {
						tempy += dy;
					}
				}
				if(dy > 0) {
					if(bottomLeft || bottomRight) {
						dy = 0;
						falling = false;
						tempy = (currRow + 1) * tileMap.getTileSize() - height / 2;
					}
					else {
						tempy += dy;
					}
				}
				
				calculateCorners(tox, y);
				if(dx < 0) {
					if(blWin || brWin){
						
					}
					if(topLeft || bottomLeft) {
						dx = 0;
						tempx = currCol * tileMap.getTileSize() + width / 2;
					}
					else {
						tempx += dx;
					}
				}
				if(dx > 0) {
					if(topRight || bottomRight) {
						dx = 0;
						tempx = (currCol + 1) * tileMap.getTileSize() - width / 2;
					}
					else {
						tempx += dx;
					}
				}
				
				if(!falling) {
					calculateCorners(x, y + 1);
					if(!bottomLeft && !bottomRight) {
						falling = true;
					}
				}
				
				x = tempx;
				y = tempy;
				
				
				// move the map
				//tileMap.setX((int) (GamePanel.WIDTH / 2 - x));
				//tileMap.setY((int) (GamePanel.HEIGHT / 2 - y));
				
			}
	

	public void draw(Graphics2D g) {

		int tx = 0;
		int ty = 0;

		g.setColor(Color.RED); 
		g.fillRect(
				(int) (tx + x - width / 2),
				(int) (ty + y - height / 2),
				width, height);

	}
}
