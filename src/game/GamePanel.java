package game;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import controller.inputs.KeyboardInputs;
import controller.inputs.MouseInputs;
import model.util.Constants;
import model.util.Constants.Game.*;

public class GamePanel extends JPanel {
    
    private MouseInputs mouseInput;
    private Game game;
    
    //========== WHERE THE CODE RUNS ==========//
    public GamePanel(Game game) {
        mouseInput = new MouseInputs(this);
        this.game = game;
        
        setFocusable(true);
        requestFocus(); // Ensure the panel receives keyboard input
        
        setPanelSize(); // Set preferred panel size
        
        // Register input listeners
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }

    public void updateGame() {
    	
	}
    
    public void renderGame() {
    	repaint();
    }
    
    //========== DRAWING THE CANVAS ==========//
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Prevents graphical artifacts
        game.render(g);
    }

	//========== SETTING THE GAME/PANEL SIZE ==========
	private void setPanelSize() {
		System.out.println("Setting GamePanel size: " + Constants.Game.GAME_WIDTH + " x " + Constants.Game.GAME_HEIGHT);
		Dimension size = new Dimension(Constants.Game.GAME_WIDTH, Constants.Game.GAME_HEIGHT);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}
	
	/**
	 * <b> Disclaimer: </b> It's called updateGame instead of update to <br>
	 * avoid confusion with the method update from JPanel
	 */
	
	public Game getGame() {return game;}
}
