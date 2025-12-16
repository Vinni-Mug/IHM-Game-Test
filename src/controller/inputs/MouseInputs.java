package controller.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import game.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener{

	private GamePanel gamePanel;
	
	//========== CONSTRUCTOR ==========
	public MouseInputs(GamePanel gamePanel) {
		super();
		this.gamePanel = gamePanel;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		gamePanel.setRecPos(e.getX() - 32, e.getY() - 32);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		gamePanel.setRecPos(e.getX() - 32, e.getY() - 32);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		gamePanel.setRecPos(e.getX() - 32, e.getY() - 32);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
