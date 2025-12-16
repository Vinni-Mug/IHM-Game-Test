package model.util;

import java.awt.geom.Rectangle2D;

import model.util.Constants;

public class HelpMethods {
	
	
	/**
	 * It is going to check for the position and if that position overlaps any type of tiles.
	 * @return 'true' if entered Entity isn't overlapping a tile. Therefore it can move.
	 */
	public static boolean canMoveHere(Rectangle2D.Float hitbox, int[][] levelData) {
		return canMoveHere(hitbox.x, hitbox.y, hitbox.width, hitbox.height, levelData);
	}
	
	
	/**
	 * It is going to check for the position and if that position overlaps any type of tiles.
	 * @return 'true' if entered Entity isn't overlapping a tile. Therefore it can move.
	 */
	public static boolean canMoveHere(float x, float y, float width, float height, int[][] levelData) {
		
		// Checking top left
		if (!isSolid(x, y, levelData)) {
			// Checking bottom right
			if (!isSolid(x + width, y + height, levelData)) {
				// Checking top right
				if (!isSolid(x + width, y, levelData)) {
					// Checking bottom left
					if (!isSolid(x, y + height, levelData)) {
						// If all of these check are false, it means that we CAN move!
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean isSolid(float x, float y, int[][] levelData) {
		
		// Is the player inside the game window?
		if (x < 0 || x >= Constants.Game.GAME_WIDTH) {return true;}
		if (y < 0 || y >= Constants.Game.GAME_HEIGHT) {return true;}
		
		float xIndex = x / Constants.Game.TILES_SIZE;
		float yIndex = y / Constants.Game.TILES_SIZE;
		
		int value = levelData[(int) yIndex][(int) xIndex];
		
		/**
		 * The "|| value != 0" is there because the tile with ID 0 is nothing.
		 */
		if (value >= Constants.Level.NUMBER_OF_SPRITES_IN_ATLAS 
				|| value < 0
				|| value != 0) 
		{  
			return true;
		}
		
		return false;
	}
}
