package main;
import javax.swing.JFrame;

import com.sun.glass.events.KeyEvent;

import config.PlayerStatus;
import config.configs;
import entity.DestructibleBlock;
import entity.MovableBlock;
import entity.Player;
import entity.PointObject;
import render.IRenderable;
import render.RenderableHolder;
import render.Resource;
import ui.GameScreen;
import ui.GameWindow;
import utility.InputUtility;
import utility.MapUtility;

public class Main {
	public static GameWindow gameWindow;
	public static GameScreen gamescreen;

	public static void main(String[] args) throws InterruptedException {
		gameWindow = new GameWindow();
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setVisible(true);
		gameWindow.pack();
		while(true){
			Thread.sleep(20);
			logicUpdate();
			gameWindow.repaint();
		}
	}
	public static void logicUpdate(){
		if(!(gameWindow.currentScene instanceof GameScreen)){
			return;
		}
		Player player =null;
		
		//// find player and delete in from renderable holder
		for(IRenderable i : RenderableHolder.getInstance().getRenderableList()){
			if(i instanceof Player){
				player=(Player)i;
				//RenderableHolder.getInstance().getRenderableList().remove(i);
				break;
			}
		}
		
		//// calculate player final point
		if(InputUtility.getKeyTriggered(KeyEvent.VK_UP)){
			player.calculateDestination(configs.NORTH,GameScreen.getMapArray());
		}
		else if(InputUtility.getKeyTriggered(KeyEvent.VK_DOWN)){
			player.calculateDestination(configs.SOUTH,GameScreen.getMapArray());
		}
		else if(InputUtility.getKeyTriggered(KeyEvent.VK_LEFT)){
			player.calculateDestination(configs.WEST,GameScreen.getMapArray());
		}
		else if(InputUtility.getKeyTriggered(KeyEvent.VK_RIGHT)){
			player.calculateDestination(configs.EAST,GameScreen.getMapArray());
		}
		
		InputUtility.postUpdate();
		
		if(player!=null)player.update();
		for(IRenderable obj : RenderableHolder.getInstance().getRenderableList()){
			if(obj instanceof MovableBlock){
				((MovableBlock)obj).update();
			}
			else if(obj instanceof DestructibleBlock){
				if(((DestructibleBlock)obj).update(player.isMoving)){
					RenderableHolder.getInstance().getRenderableList().remove(obj);
					Resource.s_crash.play();
				}
			}
			else if(obj instanceof PointObject){
				((PointObject)obj).update(player.exactX,player.exactY);
				if(((PointObject)obj).isDestroyed){
					PointObject cur = (PointObject)obj;
					GameScreen.currentMap.mapArray[cur.y+2][cur.x+2]=MapUtility.PASSABLE_TERRAIN;
					PlayerStatus.increaseScore(configs.starPoint,1);
					RenderableHolder.getInstance().getRenderableList().remove(obj);
					if(PlayerStatus.collectedStarThisMap>=GameScreen.currentMap.starCount) GameScreen.goToNextMap();
					
				}
			}
		}
			
		
	}
	public static void moveBlock(int currentX, int currentY,int lastX,int lastY) {
		// TODO Auto-generated method stub
		Resource.s_hit.play();
		for(IRenderable cur : RenderableHolder.getInstance().getRenderableList()){
			if(cur instanceof MovableBlock){
				MovableBlock mvb = (MovableBlock)cur;
				if(mvb.x==currentX&&mvb.y==currentY){
					RenderableHolder.getInstance().getRenderableList().remove(cur);
					GameScreen.currentMap.mapArray[currentY+2][currentX+2]=MapUtility.PLAYER;
					GameScreen.currentMap.mapArray[lastY+2][lastX+2]=MapUtility.MOVABLE_BLOCK;
					mvb.setNewPlace(lastX,lastY);
					RenderableHolder.getInstance().getRenderableList().add(mvb);
				}
			}
		}
	}
	public static void destroyBlock(int currentX, int currentY) {
		// TODO Auto-generated method stub
		
		for(IRenderable cur : RenderableHolder.getInstance().getRenderableList()){
			if(cur instanceof DestructibleBlock){
				DestructibleBlock dtb = (DestructibleBlock)cur;
				if(dtb.x==currentX&&dtb.y==currentY){
					RenderableHolder.getInstance().getRenderableList().remove(cur);
					dtb.isDestroyed=true;
					GameScreen.currentMap.mapArray[currentY+2][currentX+2]=MapUtility.PASSABLE_TERRAIN;
					RenderableHolder.getInstance().getRenderableList().add(dtb);
				}
			}
		}
	}
}
