package model.levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Game;
import model.levels.Level;
import model.util.LoadSave;
import model.util.Constants;

public class LevelManager {
	
	private Game game;
	private BufferedImage[] levelSprites;
	private Level levelOne;
	
	public LevelManager(Game game) {
		super();
		this.game = game;
//		levelSprite = LoadSave.getLevelAtlas();
		importSprites();
		levelOne = new Level(LoadSave.getLevelData());
	}
	
	private void importSprites() {
		BufferedImage image = LoadSave.getLevelAtlas();
		levelSprites = new BufferedImage[Constants.Level.NUMBER_OF_SPRITES_IN_ATLAS];
		
		for (int y = 0; y < Constants.Level.SPRITES_IN_ATLAS_HEIGHT; y++) {
			for (int x = 0; x < Constants.Level.SPRITES_IN_ATLAS_WIDTH; x++) {
				int index = y * Constants.Level.SPRITES_IN_ATLAS_HEIGHT + x;
				levelSprites[index] = image.getSubimage(
						x * Constants.Game.TILES_DEFAULT_SIZE, 
						y * Constants.Game.TILES_DEFAULT_SIZE, 
						Constants.Game.TILES_DEFAULT_SIZE, 
						Constants.Game.TILES_DEFAULT_SIZE);
			}
		}
	}

	public void render(Graphics g) {
		for (int y = 0; y < Constants.Game.TILES_IN_HEIGHT; y++) {
			for (int x = 0; x < Constants.Game.TILES_IN_WIDTH; x++) {
				int index = levelOne.getSpriteIndex(x, y);
				g.drawImage(
						levelSprites[index], 
						x * Constants.Game.TILES_SIZE, 
						y * Constants.Game.TILES_SIZE, 
						Constants.Game.TILES_SIZE,
						Constants.Game.TILES_SIZE,
						null);
			}
		}
		
	}
	
	public void update() {
		
	}
	
	public Level getCurrentLevel() {
		return levelOne;
	}
	
}
