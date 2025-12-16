package model.tiles;

import java.awt.Color;

public class Tile {
	private int id;
	private Color colorId;
	
	public Tile(int id, Color colorId) {
		this.id = id;
		this.colorId = colorId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Color getColorId() {
		return colorId;
	}

	public void setColorId(Color colorId) {
		this.colorId = colorId;
	}
}
