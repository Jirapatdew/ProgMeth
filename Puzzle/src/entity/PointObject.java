package entity;

import java.awt.Graphics2D;

import config.configs;
import render.Resource;

public class PointObject extends Entity{

	public boolean isDestroyed;
	public int exactX,exactY;
	public PointObject(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.exactX=this.x*configs.singleWidth+configs.mapOffsetX;
		this.exactY=this.y*configs.singleHeight+configs.mapOffsetY;
		this.isDestroyed=false;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.point_object, exactX,exactY,configs.singleWidth,configs.singleHeight,null);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	public void update(int playerExactX,int playerExactY) {
		// TODO Auto-generated method stub
		if(collideWith(playerExactX,playerExactY)) this.isDestroyed=true;
		if(this.isDestroyed) Resource.s_star.play();
	}

	private boolean collideWith(int playerExactX, int playerExactY) {
		// TODO Auto-generated method stub
		int difx=playerExactX-this.exactX;
		int dify=playerExactY-this.exactY;
		difx*=difx;
		dify*=dify;
		double distance = Math.sqrt((double)difx+(double)dify);
		return (distance<35);
	}

	@Override
	void update() {
		// TODO Auto-generated method stub
		
	}

}
