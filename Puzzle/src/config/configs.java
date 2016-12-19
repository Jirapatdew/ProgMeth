package config;

import java.awt.Color;

import render.Resource;

public class configs {
	public static final int AllMap = 12;
	public static final int starPoint = 10;
	public static int mapGridWidth=12;
	public static int mapGridHeight=14;
	public static int singleWidth=40;
	public static int singleHeight=40;
	
	public static int screenWidth=640;
	public static int screedHeight=800;
	
	public static int mapWidth=mapGridWidth*singleWidth;
	public static int mapHeight=mapGridHeight*singleHeight;
	
	public static int otherPanelWidth=640;
	public static int otherPanelHeight=160;
	
	public static int sideWidth=(configs.screenWidth-configs.mapWidth)/2;
	public static int sideHeight=(configs.screedHeight-configs.mapHeight)/2;
	
	public static int mapOffsetX=sideWidth;
	public static int mapOffsetY=otherPanelHeight;
	
	
	public static Color cblack = Resource.iBlack;
	public static Color cpink = Resource.iPink;
	
	
	public static int PLAYER=4;
	public static int PASSABLE_TERRAIN=0;
	public static int UNPASSABLE_TERRAIN=1;
	public static int MOVABLE_BLOCK=2;
	public static int DESTRUCTIBLE_BLOCK=3;
	
	
	public static int NORTH=0;
	public static int EAST=1;
	public static int SOUTH=2;
	public static int WEST=3;
	
	public static int playerSpeed = 10;
	
}
