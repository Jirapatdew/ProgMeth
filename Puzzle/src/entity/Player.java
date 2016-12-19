package entity;

import java.awt.Graphics2D;

import config.configs;
import main.Main;
import render.Resource;
import ui.GameScreen;
import utility.MapUtility;

public class Player extends Entity implements Movable{

	public boolean isMoving;
	public int lastX,lastY;
	public int exactX,exactY;
	int speed;
	public Player(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.speed=configs.playerSpeed;
		exactX=this.x*configs.singleWidth+configs.mapOffsetX;
		exactY=this.y*configs.singleHeight+configs.mapOffsetY;
		lastX=exactX;
		lastY=exactY;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.player_img, exactX,exactY,configs.singleWidth,configs.singleHeight,null);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(lastX==exactX&&lastY==exactY){
			isMoving=false;
		}
		if(!isMoving) return;
		move();
		
	}
	public void calculateDestination(int direction,int[][] mapArray){
//		System.out.println("in");
		if(isMoving) return;
		int[] diry={-1,0,1,0};
		int[] dirx={0,1,0,-1};
//		System.out.println("cal"+direction);
//		MapUtility.printMap(mapArray);
		int dx=dirx[direction];
		int dy=diry[direction];
		
		lastX=super.x;
		lastY=super.y;
		int nextTerrain=mapArray[lastY+dy+2][lastX+dx+2];
//		System.out.println(nextTerrain);
		if(nextTerrain==MapUtility.MOVABLE_BLOCK){
			int nextNextTerrain=mapArray[lastY+dy+dy+2][lastX+dx+dx+2];
			if(nextNextTerrain==MapUtility.PASSABLE_TERRAIN){
				lastX+=dx;
				lastY+=dy;
				GameScreen.currentMap.mapArray[super.y+2][super.x+2]=MapUtility.PASSABLE_TERRAIN;
				super.x=lastX;
				super.y=lastY;
				Main.moveBlock(lastX,lastY,lastX+dx,lastY+dy);
				isMoving=true;
				lastX=lastX*configs.singleWidth+configs.mapOffsetX;
				lastY=lastY*configs.singleHeight+configs.mapOffsetY;
				return;
			}
		}
		if(nextTerrain==MapUtility.DESTRUCTIBLE_BLOCK){
			Main.destroyBlock(lastX+dx,lastY+dy);
//			System.out.println(111);
			return;
		}
		while(true){
			
			nextTerrain=mapArray[lastY+dy+2][lastX+dx+2];
			if(nextTerrain!=0){
				
				if(mapArray[lastY+dy+2][lastX+dx+2]!=MapUtility.POINT) break;
			}
//			System.out.println(lastX+" "+lastY);
//			System.out.println(dx+" "+dy);
			lastX+=dx;
			lastY+=dy;
		}
		if(nextTerrain==MapUtility.DESTRUCTIBLE_BLOCK){
			Main.destroyBlock(lastX+dx,lastY+dy);
		}
		if(lastX!=x||lastY!=y)this.isMoving=true;
		GameScreen.currentMap.mapArray[super.y+2][super.x+2]=MapUtility.PASSABLE_TERRAIN;
		super.x=lastX;
		super.y=lastY;
		GameScreen.currentMap.mapArray[super.y+2][super.x+2]=MapUtility.PLAYER;
		lastX=lastX*configs.singleWidth+configs.mapOffsetX;
		lastY=lastY*configs.singleHeight+configs.mapOffsetY;
	}

}
