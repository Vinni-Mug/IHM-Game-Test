package model.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import game.Game;
import model.util.Constants;
import model.util.LoadSave;

public class Player extends Entity {
	
	private BufferedImage[][] playerAnimations;
	
	private int animationTick, animationIndex, animationSpeed = 4;
    private int playerAction = Constants.Player.IDLE;
    private float playerSpeedDefault = 2.0f;
    private float playerSpeed = playerSpeedDefault * Constants.Game.SCALE;
    private boolean playerMoving = false, playerAttacking = false;
    private boolean up, left, down, right;
	
	// ========== CONSTRUCTOR ==========
	public Player(float x, float y, int width, int height) {
		super(x, y, width, height);
		loadAnimations();
	}
	
	// ========== UPDATING PLAYER ==========
	public void update() {
		updatePosition();
		updateHitbox();
		//updateAnimationTick(); // Update animation frame
    	setAnimation();
    	
	}
	
	private void renderDebugMode(Graphics g) {
		if (!Constants.GameConfig.debugMode) {return;}
		renderHitbox(g);
	}
	
	// ========== RENDERING PLAYER ==========
	public void render(Graphics g) {
		updateAnimationTick(); // Update animation frame
		
		/**
         * <html>
         * <b>Draw player sprite:</b> Renders the current animation frame.<br>
         * The character is drawn at (xDelta, yDelta) with a size of 128x128 pixels.
         * </html>
         */
        g.drawImage(
    		playerAnimations[playerAction][animationIndex], 
    		(int) x, 
    		(int) y, 
    		(int) (width), 
    		(int) (height), 
    		null, 
    		null);
        
        renderDebugMode(g);
	}
    
    public void setPlayerMoving(boolean moving) {
    	playerMoving = moving;
    }
    
    /**
     * 
     * <b>updateAnimationTick:</b> Handles animation timing.<br>
     * Increments animation tick; resets when reaching animation speed limit.<br>
     * Loops animation index within sprite array length.
     * 
     */
    private void updateAnimationTick() {
    	
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            if (animationIndex >= Constants.Player.getSpriteAmount(playerAction)) {
                animationIndex = 0;
                playerAttacking = false;
            }
        }
    }
    
    
    public void setPlayerPos(int x, int y) {
        this.x = x;
        this.y = y;
        // repaint(); // Uncomment if needed to refresh panel
    }
    
    /**
     * Updates the position of the player if isMoving is true when a key is pressed. <br>
     * It takes the direction and adds to xDelta and yDelta.<br>
     * <br>
     * It is a method to be placed in "update()," not to be used by the programmer.
     */
	private void updatePosition() {
		
		playerMoving = false;
		
		
		/* If left is being pressed but right isn't, go left. 
		 * The player might press both at the same time.
		 */
		if (left && !right) {
			x -= playerSpeed;
			playerMoving = true;
		}
		else if (right && !left) {
			x += playerSpeed;
			playerMoving = true;
		}
		
		/* If up is being pressed but down isn't, go up. 
		 */
		if (up && !down) {
			y -= playerSpeed;
			playerMoving = true;
		}
		else if (down && !up) {
			y += playerSpeed;
			playerMoving = true;
		}
	}

	private void setAnimation() {
		int startAnimation = playerAction;
		
		if (playerMoving) {
			playerAction = Constants.Player.WALK;
		}
		else {playerAction = Constants.Player.IDLE;}
		
		if (playerAttacking) {
			playerAction = Constants.Player.ATTACK;
		}
		
		if (startAnimation != playerAction) {
			resetAnimationTicks();
		}
	}
	
	private void resetAnimationTicks() {
		animationIndex = 0;
		animationTick = 0;
	}

	//========== LOADING ARRAY WITH SPRITES ==========//
    private void loadAnimations() {
    	InputStream is = getClass().getResourceAsStream(Constants.Player.SPRITE_SHEET_PATH);
        
    	BufferedImage image = LoadSave.getPlayerAtlas();
        
        playerAnimations = new BufferedImage[5][16];
        
        // ---------- IDLE ANIMATION ----------
        /**
         * <html>
         * <b>Idle animation:</b> Fills the first row (index 0) with 15 identical sprites.<br>
         * The last frame (index 15) is a unique sprite with closed eyes.
         * </html>
         */
        for (int index = 0; index < playerAnimations[0].length - 1; index++) {
            playerAnimations[0][index] = image.getSubimage(1 * 32, 0 * 32, 32, 32);
        }
        playerAnimations[0][15] = image.getSubimage(2 * 32, 0 * 32, 32, 32);
        
        // ---------- OTHER ANIMATIONS ----------
        for (int stage = 1; stage < playerAnimations.length; stage++) {
            for (int sprite = 0; sprite < playerAnimations[stage].length; sprite++) {
                playerAnimations[stage][sprite] = image.getSubimage((1 + sprite) * 32, stage * 32, 32, 32);
            }
        }
    }
    
    /**
     * Reset every player movement to false. It stops the player. <br>
     * This is to be used, like, when the game window loses focus, <br>
     * just so that the player won't be walking by itself <br>
     * when something pops up on the player screen
     */
    public void resetDirectionBooleans() {
		up = false;
		left = false;
		down = false;
		right = false;
	}

    // ========== GETTERS ==========
//    public BufferedImage[][] getPlayerAnimations() {return playerAnimations;}
	public int getPlayerAction() {return playerAction;}
	public float getPlayerSpeed() {return playerSpeed;}
	public boolean isPlayerMoving() {return playerMoving;}
	public boolean isPlayerAttacking() {return playerAttacking;}
	public boolean isUp() {return up;}
	public boolean isLeft() {return left;}
	public boolean isDown() {return down;}
	public boolean isRight() {return right;}
	
	// ========== SETTERS ==========
//	public void setPlayerAnimations(BufferedImage[][] playerAnimations) {
//		this.playerAnimations = playerAnimations;
//	}
//	public void setAnimationTick(int animationTick) {this.animationTick = animationTick;}
//	public void setAnimationIndex(int animationIndex) {this.animationIndex = animationIndex;}
//	public void setAnimationSpeed(int animationSpeed) {this.animationSpeed = animationSpeed;}
	public void setPlayerAction(int playerAction) {this.playerAction = playerAction;}
	public void setPlayerSpeed(float playerSpeed) {this.playerSpeed = playerSpeed;}
	public void setPlayerAttacking(boolean playerAttacking) {this.playerAttacking = playerAttacking;}
	public void setUp(boolean up) {this.up = up;}
	public void setLeft(boolean left) {this.left = left;}
	public void setDown(boolean down) {this.down = down;}
	public void setRight(boolean right) {this.right = right;}
	
}
