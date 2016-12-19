package entity;

import java.awt.Graphics2D;

import config.configs;
import render.Resource;

public class MovableBlock extends Block implements Movable{

	public int exactX,exactY;
	public int lastX,lastY;
	public boolean isMoving;
	public int speed;
	public MovableBlock(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		exactX=this.x*configs.singleWidth+configs.mapOffsetX;
		exactY=this.y*configs.singleHeight+configs.mapOffsetY;
		lastX=exactX;
		lastY=exactY;
		isMoving=false;
		speed=configs.playerSpeed;
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		int dif;
		if(lastX!=exactX){
			dif=lastX-exactX;
			dif=dif/Math.abs(dif);
			exactX+=dif*speed;
		}
		else if(lastY!=exactY){
			dif=lastY-exactY;
			dif=dif/Math.abs(dif);
			exactY+=dif*speed;
		}
	}
	public void update(){
		if(exactX==lastX&&exactY==lastY) isMoving=false;
		if(!isMoving) return;
		move();
	}
	public void setNewPlace(int finalX,int finalY){
		super.x=finalX;
		super.y=finalY;
		lastX=finalX*configs.singleWidth+configs.mapOffsetX;
		lastY=finalY*configs.singleHeight+configs.mapOffsetY;
		isMoving=true;
//		System.out.println(exactX+" "+exactY);
//		System.out.println(lastX+" "+lastY);
	}
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.movable_block, exactX,exactY,configs.singleWidth,configs.singleHeight,null);
	}
}
