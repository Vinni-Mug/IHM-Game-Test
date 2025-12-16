package model.util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import model.tiles.Tiles;

public class LoadSave {

	/**
	 * 
	 * @return an BufferedImage image that has the player sprite sheet.
	 */
	public static BufferedImage getPlayerAtlas() {
		return getSpriteAtlas(Constants.Player.SPRITE_SHEET_PATH);
	}
	
	public static BufferedImage getLevelAtlas() {
		return getSpriteAtlas(Constants.Level.SPRITE_SHEET_PATH);
	}
	
	public static int[][] getLevelData() {
		BufferedImage image = getSpriteAtlas(Constants.GameLevels.LEVEL_ONE_DATA);
		int[][] levelData = new int[image.getHeight()][image.getWidth()];
		
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				Color color = new Color(image.getRGB(x, y));
				levelData[y][x] = Tiles.getTileIDbyColor(color);
			}
		}
		
		return levelData;
	}
	
	// ========== GETTING SPRITE SHEET ==========
	public static BufferedImage getSpriteAtlas(String fileName) {
		BufferedImage image = null;
		//InputStream is = getClass().getResourceAsStream(fileName);  // This one doesn't work because getClass can't be used in a static method.
		InputStream is = LoadSave.class.getResourceAsStream(fileName);
		
        try {
            image = ImageIO.read(is);
        }
        catch (IOException e) {
        	System.out.println("ERROR IN THE 'LOADSAVE' CLASS");
            e.printStackTrace();
        } 
        finally {
            try {if (is != null) is.close();} 
            catch (IOException e) {e.printStackTrace();}
        }
        
        return image;
	}
	
}
