package entity;

import java.awt.Graphics2D;

import render.IRenderable;
import render.Resource;

public class Apple implements IRenderable {
	protected int x;
	protected int y;
	protected int radius;
	protected int speed;
	protected boolean destroyed;
	public Apple(int x) {
		this.x = x;
		radius = 20;
		y = -40;
		speed = RandomUtility.random(2, 7);
		destroyed = false;
	}
	protected void update() {
		y += speed;
		if(y > 480) destroyed = true;
	}
	public boolean isDestroyed() {
		return destroyed;
	}
	public boolean collideWith(Player player) {
		return (player.x - x)*(player.x - x) + (player.y - y)*(player.y - y) <= (player.radius*2)*(player.radius*2);
	}
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.appleSprite, x, y, radius * 2, radius * 2, null);
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return !destroyed;
	}
}
