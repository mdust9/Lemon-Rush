package me.game.main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Keys.Keys;
import me.game.gamestates.GameStateManager;
//import me.game.tilemap.TileMap;


public class GamePanel extends JPanel implements Runnable,KeyListener {

	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	public static final int SCALE = 2;
	
	private Thread thread;
	private boolean running;
	
	private GameStateManager gsm;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private int FPS = 60;
	
	
	
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	// FUNCTIONS
	public void addNotify(){
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
		}
		addKeyListener(this);
	}
	
	private void init() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		running = true;
		

		
		gsm = new GameStateManager();
		
	}
	
	public void run() {
		
		init();
		
		long startTime;
		long URDTimeMillis;
		long waitTime;
		long totalTime = 0;
		
		int frameCount = 0;
		int maxFrameCount = FPS;
		
		long targetTime = 1000 / FPS;
		
		while(running){
			
			startTime = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			URDTimeMillis = (System.nanoTime()- startTime) / 1000000;
			waitTime = targetTime - URDTimeMillis;
			
			try {
				Thread.sleep(waitTime);
			}
			catch(Exception e) {
			}
			
			totalTime += (System.nanoTime() - startTime);
			frameCount++;
			if(frameCount == maxFrameCount) {
				frameCount = 0;
				totalTime = 0;
			}
			
		}
	}
	
	public void update() {
		gsm.update();
		Keys.update();
	}
	
	public void draw() {	
		gsm.draw(g);
		
	}
	
	public void drawToScreen() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image,0,0,null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key) {}
	public void keyPressed(KeyEvent key) {
		Keys.keySet(key.getKeyCode(), true);
	}
	public void keyReleased(KeyEvent key) {
		Keys.keySet(key.getKeyCode(), false);
	}



}
