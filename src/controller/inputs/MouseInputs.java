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
//		if (e.getButton() == MouseEvent.BUTTON3) {tpPlayer(e);}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			playerAttack(e);
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			tpPlayer(e);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		if (e.getButton() == MouseEvent.BUTTON3) {tpPlayer(e);}
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
	
	private void  playerAttack(MouseEvent e) {
		gamePanel.getGame().getPlayer().setPlayerAttacking(true);
	}
	
	private void tpPlayer(MouseEvent e) {
		gamePanel.getGame().getPlayer().setPlayerPos(e.getX() - 64, e.getY() - 96);
	}

}
