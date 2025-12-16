package controller.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.GamePanel;

/**
 * This will take care of keys being pressed, released and typed. Good for movement and typing.
 */
public class KeyboardInputs implements KeyListener {
	
	private GamePanel gamePanel;
	
	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("Key Typed!");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("Key Pressed!");
		
		int speed = 16;
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			gamePanel.changeYDelta(-speed);
			break;
		case KeyEvent.VK_A:
			gamePanel.changeXDelta(-speed);
			break;
		case KeyEvent.VK_S:
			gamePanel.changeYDelta(speed);
			break;
		case KeyEvent.VK_D:
			gamePanel.changeXDelta(speed);
			break;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("Key Released!");
	}

}
