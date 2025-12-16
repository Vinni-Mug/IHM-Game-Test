package game;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	
	
	public GameWindow(GamePanel gamePanel) {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1280, 720);  // 1280, 640 and then add the black borders
		this.setTitle(GameConfig.getWindowTitle());
		
		this.add(gamePanel);
		
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
