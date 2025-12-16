package game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.DebugGraphics;

import model.entities.Player;
import model.levels.LevelManager;
import model.tiles.Tiles;
import model.util.Constants;
import model.util.Constants.Game.*;
import model.util.LoadSave;

public class Game implements Runnable{
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private Player player;
	private LevelManager levelManager;
	
	int gameUpdates = 0, gameFrames = 0;
	
	//========== GAME CONSTRUCTOR ==========
	public Game() {
		//String message = GameConfig.getWindowTitle() + " Click to move the Square or use WASD to move it.";
		//JOptionPane.showMessageDialog(null, message);
		
		System.out.println("Class: Game -> STARTED");
		
		initializeClasses();
		
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		
		startGameLoop();
		
		System.out.println("Class: Game -> FINISHED");
	}
	
	private void initializeClasses() {
		Tiles.loadTilesData();
		
		levelManager = new LevelManager(this);
		player = new Player(200, 200, Constants.Player.PLAYER_WIDTH, Constants.Player.PLAYER_HEIGHT);
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void update() {
		//gamePanel.updateGame();
		player.update();
		levelManager.update();
	}
	
	public void render(Graphics g) {
		levelManager.render(g);
		player.render(g);
		
		if (Constants.GameConfig.debugMode) {debugInfoScreen(g);}
		
	}
	
	
	
	private void debugInfoScreen(Graphics g) {
		g.setColor(Color.black);
		g.drawString("FPS: " + gameFrames + " | UPS: " + gameUpdates, 0, g.getFont().getSize());
	}
	
	
	
	//========== GAME LOOP // GAME THREAD ==========
	@Override
	public void run() {
	    /**
	     * <html>
	     * <b>Game Loop:</b> Manages the update and render cycles of the game.<br>
	     * Runs indefinitely, ensuring smooth gameplay by controlling updates per second (UPS) and frames per second (FPS).
	     * </html>
	     */
	    
	    // 1 Billion nanoseconds (1 second) divided by the desired UPS/FPS
	    double timePerUpdate = 1000000000 / Constants.GameConfig.UPS_SET;
	    double timePerFrame = 1000000000 / Constants.GameConfig.FPS_SET;
	    
	    // Counters for tracking updates and frames per second
	    int updates = 0, frames = 0;
	    
	    // Timing variables
	    long previousTime = System.nanoTime();
	    long currentTime;
	    long lastCheck = System.currentTimeMillis();
	    
	    double deltaU = 0, deltaF = 0;
	    
	    
	    // Infinite game loop
	    while (true) {
	        currentTime = System.nanoTime();
	        
	        // Calculate time passed since last update/frame
	        deltaU += (currentTime - previousTime) / timePerUpdate;
	        deltaF += (currentTime - previousTime) / timePerFrame;
	        previousTime = currentTime;
	        
	        // Update the game logic when necessary
	        if (deltaU >= 1) {
	            update();
	            updates++;
	            deltaU--;
	        }
	        
	        // Render the game when necessary
	        if (deltaF >= 1) {
	            gamePanel.renderGame();
	            frames++;
	            deltaF--;
	        }
	        
	        // Display FPS and UPS every second
	        if (System.currentTimeMillis() - lastCheck >= 1000) {
	            lastCheck = System.currentTimeMillis();
	            //System.out.println("FPS: " + frames + " | UPS: " + updates);
	            gameFrames = frames;
	            gameUpdates = updates;
	            frames = updates = 0;
	        }
	    }
	}
	
	public void windowFocusLost() {
		player.resetDirectionBooleans();
	}
	
	// ========== GETTERS ==========
	public Player getPlayer() {return player;}

	
	
}
