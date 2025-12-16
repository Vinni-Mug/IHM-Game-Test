package model.util;


//import model.util.Constants;

public class Constants {
	
	// ========== CONFIGURATIONS ==========
	public static class GameConfig {
		
		/*
		 * Final Recommendations
		 * 	FPS Cap: 60 (prevents screen tearing, smooth visuals).
		 * 	UPS Cap: 120 (better physics precision) or 60 (simpler synchronization).
		 * 	Use a fixed time-step loop (like the one above) to manage FPS & UPS separately.
		 *  If your game feels "choppy" at 60 UPS, increase it to 120 UPS, but keep FPS capped at 60.

		 */
		public static final int FPS_SET = 60;
		public static final int UPS_SET = 120;
		
		public static boolean debugMode = false;
		
	    public static final String MAJOR_VERSION = "0";
	    public static final String MINOR_VERSION = "9";
	    public static final String PATCH_VERSION = "0";
	    
	    public static final String TITLE = "College IHM Game Title";
	    
	    /**
	     * public static final int JAVA_VERSION = 8 \\
	     * The Java version in which this game is being coded with. 
	     * I have chosen version 8 (or 1.8) due to its stability.
	     * When coding with other versions, like 17 or 21, sometimes,
	     * the application might just not run in other systems.
	     * With Java 8, I never have a problem. Keep this is mind.
	     */
	    public static final int JAVA_VERSION = 8;
	    
	    /** 
	     * public static final String \\
	     * The stage in which the game is currently on. \\
	     * Stages: Pre-Alpha, Alpha, Beta, Pre-Release, and Release
	     */
	    public static final String STAGE = "pre-alpha";

	    public static String getVersion() {
	        return "v" + MAJOR_VERSION + "." + MINOR_VERSION + "." + PATCH_VERSION + "-" + STAGE;
	    }
	    
	    public static String getWindowTitle() {
	        return TITLE + " (" + getVersion() + ")";
	    }
	}
	
	
	
	public static class Game {
		public final static float SCALE = 1.5f;  // Default: 1.5f
		
		/**
		 * The default size of the tiles in an image. 32 pixels by 32.
		 */
		public final static int TILES_DEFAULT_SIZE = 32;
		public final static int TILES_IN_WIDTH = 26;
		public final static int TILES_IN_HEIGHT = 14;
		
		/**
		 * The size of the tile (32) times the scale. The tile size we will be using.
		 */
		public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
		public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
		public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
	}
	
	
	
	public static class GameLevels {
		public final static String LEVEL_ONE_DATA = "/levels_data/0.png";
	}
	
	
	
	// ========== PLAYER ==========
	/**
     * <html>
     * <b>Player's Constants:</b> A class that has every constant related to the player,<br>
     * like animation state, sprite sheet path, etc.
     * 
     * <ul>
     * <li><b>SPRITE_SHEET_PATH:</b> Path to the player's sprite sheet.<br>
	 * Used for loading character animations.
	 * 
	 * <li><b>ACTION_AMOUNT:</b> The number of actions (animations) the player has.</li>
     * <li><b>MAX_SPRITE_AMOUNT:</b> The maximum number of sprites an animation can have.</li>
	 * 
     * <li><b>IDLE:</b> Standing still animation.</li>
     * <li><b>WALK:</b> Walking animation.</li>
     * <li><b>JUMP:</b> Jumping animation.</li>
     * <li><b>FALL:</b> Falling animation.</li>
     * 
     * <li><b>getSpriteAmount:</b> Returns the number of frames for each animation.<br>
	 * Uses a switch case to determine the sprite count based on the action type.
     * </ul>
     * 
     * </html>
     */
	public static class Player {
		
		public static final int PLAYER_WIDTH = Game.TILES_SIZE * 2;
		public static final int PLAYER_HEIGHT = Game.TILES_SIZE * 2;
		
	    /**
	     * <b>SPRITE_SHEET_PATH:</b> Path to the player's sprite sheet.<br>
	     */
	    public static final String SPRITE_SHEET_PATH = "/player_00_sprite_sheet.png";
	    
	    public static final int ACTION_AMOUNT = 4;
	    public static final int MAX_SPRITE_AMOUNT = 16;
	    
	    public static final int IDLE = 0;
	    public static final int WALK = 1;
	    public static final int JUMP = 2;
	    public static final int FALL = 3;
	    public static final int ATTACK = 4;
	    
	    /**
	     * 
	     * <b>getSpriteAmount:</b> Returns the number of frames for each animation.<br>
	     * Uses a switch case to determine the sprite count based on the action type.
	     *
	     * 
	     * @param action - The player's current action.
	     * @return Number of frames for the specified action.
	     */
	    public static int getSpriteAmount(int action) {
	        switch (action) {
	            case IDLE:
	                return 16;
	            case WALK:
	                return 4;
	            case JUMP:
	                return 3;
	            case FALL:
	                return 1;
	            case ATTACK:
	                return 5;
	            default:
	                return 1;
	        }
	    }
	}
	
	public static class Level {
		public static final String SPRITE_SHEET_PATH = "/tiles_sprite_sheet.png";
		public static final int SPRITES_IN_ATLAS_WIDTH = 10;
		public static final int SPRITES_IN_ATLAS_HEIGHT = 1;
		public static final int NUMBER_OF_SPRITES_IN_ATLAS = (
				SPRITES_IN_ATLAS_WIDTH * 
				SPRITES_IN_ATLAS_HEIGHT
				);  // Width * height
		
	}
	
	// ========== DIRECTIONS ==========
	public static class Direction {
		public static final int UP = 0;
		public static final int LEFT = 1;
		public static final int DOWN = 2;
		public static final int RIGHT = 3;
	}
}
