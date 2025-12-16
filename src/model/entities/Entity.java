package model.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	
	protected float x, y;
	protected int width, height;
	protected Rectangle hitbox;

	public Entity(float x, float y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		initializeHitbox();
	}

	private void initializeHitbox() {
		hitbox = new Rectangle((int)x, (int)y, width, height);
	}
	
	protected void updateHitbox() {
		hitbox.x = (int) x;
		hitbox.y = (int) y;
	}
	
	protected void renderHitbox(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
}
