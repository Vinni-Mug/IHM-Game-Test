package game;

import javax.swing.JOptionPane;

public class Game implements Runnable{
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 60;
	
	//========== GAME CONSTRUCTOR ==========
	public Game() {
		//String message = GameConfig.getWindowTitle() + " Click to move the Square or use WASD to move it.";
		//JOptionPane.showMessageDialog(null, message);
		
		System.out.println("Class: Game -> STARTED");
		
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		
		startGameLoop();
		
		System.out.println("Class: Game -> FINISHED");
	}
	
	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	//========== GAME LOOP // GAME THREAD ==========
	@Override
	public void run() {
		
		double timePerFrame = 1000000000 / FPS_SET;  // This 1 Billion is one second in Nanoseconds
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		
		int frames = 0;
		long lastCheck = System.currentTimeMillis();
		
		while (true) {
			now = System.nanoTime();
			if (now - lastFrame >= timePerFrame) {
				gamePanel.repaint();
				lastFrame = now;
				frames++;
			}
			
			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
	}
	
}
