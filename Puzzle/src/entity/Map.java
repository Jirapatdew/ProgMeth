package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.concurrent.CopyOnWriteArrayList;

import config.configs;
import render.IRenderable;
import utility.MapUtility;

public class Map implements IRenderable{

	public int[][] mapArray = null;
	public int starCount;
	public boolean finished;
	int singleWidth,singleHeight;
	Color backgroundColor;
	Color foregoundColor;
	CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<Entity>();
	public Map(int mapNumber,Color bg,Color fg){
		String mapDirectory="res/map/map"+mapNumber+".txt";
		this.mapArray=MapUtility.readMap(mapDirectory);
		this.entities= new CopyOnWriteArrayList<Entity>();
		this.backgroundColor=bg;
		this.foregoundColor=fg;
		this.singleHeight=configs.singleHeight;
		this.singleWidth=configs.singleWidth;
		this.starCount=countAllStar();
		finished=false;
	}
	public int countAllStar(){
		int ret=0;
		for(int i=2;i<mapArray.length-2;i++){
			for(int j=2;j<mapArray[i].length-2;j++){
				if(mapArray[i][j]==MapUtility.POINT) ret++;
			}
		}
		return ret;
	}
	public void addEntity(Entity e){
		entities.add(e);
	}
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		//System.out.println(222);
		for(int i=2;i<mapArray.length-2;i++){
			for(int j=2;j<mapArray[i].length-2;j++){
				if(mapArray[i][j]==MapUtility.UNPASSABLE_TERRAIN) g2d.setColor(backgroundColor);
				else g2d.setColor(foregoundColor);
				
				int startY=singleHeight*(i-2)+configs.mapOffsetY;
				int startX=singleHeight*(j-2)+configs.mapOffsetX;
				g2d.fillRect(startX, startY, singleWidth, singleHeight);
				//System.out.println(startX+" "+startY+" "+mapArray[i][j]);
			}
		}
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
