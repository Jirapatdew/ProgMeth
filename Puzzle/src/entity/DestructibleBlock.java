package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import config.configs;
import render.Resource;

public class DestructibleBlock extends Block{

	public boolean isDestroyed;
	public DestructibleBlock(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.isDestroyed=false;
	}

	public boolean update(boolean isMoving) {
		// TODO Auto-generated method stub
		if(isMoving) return false;
		else{
			return isDestroyed;
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.cyan);
		int startX=this.x*configs.singleWidth+configs.mapOffsetX;
		int startY=this.y*configs.singleHeight+configs.mapOffsetY;
		g2d.drawImage(Resource.destructible_block, startX,startY,configs.singleWidth,configs.singleHeight,null);
	}

	@Override
	void update() {
		// TODO Auto-generated method stub
		return;
	}
}
