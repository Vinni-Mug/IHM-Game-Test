package model.tiles;

import java.awt.Color;

public class Tiles {
	
	private static Tile[] tiles;
	
	public static void loadTilesData() {
		System.out.println("TILES LOADING...");
		
		tiles = new Tile[3];
		
		// Transparent 0
		tiles[0] = new Tile(0, new Color(255, 255, 255));
		
		// Dirt
		tiles[1] = new Tile(1, new Color(121, 85, 58));
		
		// Dirt with Grass
		tiles[2] = new Tile(2, new Color(88, 142, 52));
		
		System.out.println("TILES LOADED.");
	}
	
	public static int getTileIDbyColor(Color color) {
		for (Tile tile : tiles) {
			if (tile.getColorId().equals(color)) {
				return tile.getId();
			}
		}
		return 0;
	}
}
