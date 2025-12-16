package game;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

import model.util.Constants;

public class GameWindow extends JFrame {
	
	public GameWindow(GamePanel gamePanel) {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(Constants.GameConfig.getWindowTitle());
		
		this.add(gamePanel);
		this.pack();
		this.setResizable(false);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		this.addWindowFocusListener(new WindowFocusListener() {
			
			@Override
			public void windowLostFocus(WindowEvent e) {
				gamePanel.getGame().windowFocusLost();
			}
			
			@Override
			public void windowGainedFocus(WindowEvent e) {
				System.out.println("Windows gained focus");
			}
		});
	}

}
