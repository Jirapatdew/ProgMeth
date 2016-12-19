package utility;

import java.io.FileNotFoundException;
import java.util.Scanner;

import config.configs;
import render.Resource;

public class MapUtility {
	public static int PLAYER=4;
	public static int PASSABLE_TERRAIN=0;
	public static int UNPASSABLE_TERRAIN=1;
	public static int MOVABLE_BLOCK=2;  //// hard
	public static int DESTRUCTIBLE_BLOCK=3; ////white
	public static int POINT=5;
	public static int mapOffsetX=10;
	public static int mapOffsetY=10;
	public static int[][] readMap(String directory) {
		int[][] mapArray=new int[configs.mapGridHeight+4][configs.mapGridWidth+4];
		
		Scanner s = new Scanner(Resource.getInput(directory));
		
		for(int i=0;i<configs.mapGridHeight+4;i++) for(int j=0;j<configs.mapGridWidth+4;j++) mapArray[i][j]=1;
		for(int i=0;i<configs.mapGridHeight;i++){
			for(int j=0;j<configs.mapGridWidth;j++){
				mapArray[i+2][j+2]=s.nextInt();
			}
		}
		
		s.close();
		return mapArray;
	}
	public static void main(String[] args) throws FileNotFoundException{
		int[][] mapArray = readMap("res/map/map1.txt");
		for(int i=0;i<mapArray.length;i++){
			for(int j=0;j<mapArray[i].length;j++){
				System.out.print(mapArray[i][j]+" ");
			}System.out.println();
		}
	}
	public static void printMap(int[][] map){
		for(int i=2;i<map.length-2;i++){
			for(int j=2;j<map[i].length-2;j++){
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}
}
