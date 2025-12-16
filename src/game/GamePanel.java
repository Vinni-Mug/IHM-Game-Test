package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import controller.inputs.KeyboardInputs;
import controller.inputs.MouseInputs;

public class GamePanel extends JPanel {
	
	private MouseInputs mouseInput;
	private float xDelta = 0, yDelta = 0;
	private float xDir = 4, yDir = 4;
	
	private Color color = new Color(0, 0, 0);
	private Random random;
	
	//========== WHERE THE CODE RUNS ==========
	public GamePanel () {
		random = new Random();
		
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(new KeyboardInputs(this));
		
		mouseInput = new MouseInputs(this);
		
		this.addMouseListener(mouseInput);
		this.addMouseMotionListener(mouseInput);
	}
	
	public void changeXDelta(int v) {
		
		// This If Statement prevents the square from going too much to the right and leaving the screen.
		if (xDelta + 64 >= this.getWidth() && v > 0) {
			xDir *= -1.01;
			color = getRandomColor();
			return;
		}
		
		// This If Statement prevents the square from going too much to the left and leaving the screen.
		if (xDelta <= 0 && v < 0) {
			xDir *= -1.01;
			color = getRandomColor();
			return;
		}
		
		xDelta += v;
		//repaint();
	}
	
	public void changeYDelta(int v) {
		
		// This If Statement prevents the square from going too much to the right and leaving the screen.
		if (yDelta + 64 >= this.getHeight() && v > 0) {
			yDir *= -1.01; 
			color = getRandomColor();
			return;
		}
		
		// This If Statement prevents the square from going too much to the left and leaving the screen.
		if (yDelta <= 0 && v < 0) {
			yDir *= -1.01; 
			color = getRandomColor();
			return;
		}
		
		yDelta += v;
		//repaint();
	}
	
	public void setRecPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		//repaint();
	}
	
	//========== DRAWING THE CANVAS ==========
	public void paintComponent(Graphics g) {
		super.paintComponent(g);  // Important to avoid image bugs.
		
		updateRectangle();
		
		g.setColor(color);
		g.fillRect((int) xDelta, (int) yDelta, 64, 64);
		
		
	}

	private void updateRectangle() {
		changeXDelta((int) xDir);
		changeYDelta((int) yDir);
	}
	
	private Color getRandomColor() {
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
}
