package logic;

import java.awt.Graphics2D;

import lib.ConfigurableOption;
import lib.DrawingUtility;
import lib.GameManager;
import lib.IRenderableObject;

public class PlayerStatus implements IRenderableObject {

	private int remainingTime = 0;
	private int score = 0;
	private Gun currentGun = null;
	private boolean pause = false;
	
	public PlayerStatus(){
		/* fill code */
		remainingTime = ConfigurableOption.timelimit*GameManager.TICK_PER_SECONDS;
	}

	/* fill required getter & setter */
	public int getRemainingTime() {
		return remainingTime;
	}

	public int getScore() {
		return score;
	}

	public Gun getCurrentGun() {
		return currentGun;
	}

	public boolean isPause() {
		return pause;
	}

	public void setCurrentGun(Gun currentGun) {
		this.currentGun = currentGun;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public void decreaseRemainingTime(int amount) {
		/* fill code */ 
		remainingTime -= amount;
		if(remainingTime < 0) remainingTime = 0;
	}
	
	public void increaseScore(int score) {
		/* fill code */;
		this.score += score;
	}

	public boolean isDisplayingArea(int x,int y){
		return y < 40;
	}
	
	/* fill code interface methods */
	@Override
	public boolean isVisible() {
		return true;
	}
	
	@Override
	public int getZ() {
		return Integer.MAX_VALUE;
	}

	@Override
	public void render(Graphics2D g2) {
		DrawingUtility.drawStatusBar(g2, remainingTime/GameManager.TICK_PER_SECONDS, score, currentGun, pause);
	}
}
