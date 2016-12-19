package entity;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import render.RenderableHolder;
import render.Resource;

public class GameLogic {
	private static GameLogic instance = new GameLogic();
	protected Player player;
	protected PlayerStatus playerStatus;
	protected List<Apple> apples;
	private static final int SPAWN_DELAY = 100;
	private int spawnDelayCounter;
	
	public static GameLogic getInstance() {
		return instance;
	}
	public GameLogic() {
		player = new Player();
		playerStatus = new PlayerStatus();
		apples = new CopyOnWriteArrayList<Apple>();
		spawnDelayCounter = 0;
		RenderableHolder.getInstance().add(player);
		RenderableHolder.getInstance().add(playerStatus);
	}
	public void logicUpdate() {
		player.update();
		for (int i = 0; i < apples.size(); i++) {
				Apple apple = apples.get(i);
				if(apple.collideWith(player)) {
					apple.destroyed = true;
					playerStatus.addScore(1);
					Resource.coinSound.play();
	
					RenderableHolder.getInstance().getRenderableList().remove(apple);
					apples.remove(i);
					i--;
			
					continue;
				}
				if (!apple.isDestroyed()) {
					apple.update();
				}
				else {
					playerStatus.subtractionScore(1);
					
					RenderableHolder.getInstance().getRenderableList().remove(apple);
					apples.remove(i);
				}
			}
	
			spawnDelayCounter++;
			if (spawnDelayCounter >= SPAWN_DELAY) {
				spawnDelayCounter = 0;
				int x = RandomUtility.random(0, 600);
				Apple newApple = new Apple(x);
				apples.add(newApple);
				RenderableHolder.getInstance().add(newApple);
			}
	}	
}
