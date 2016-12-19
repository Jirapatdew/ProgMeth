package model;

import java.awt.Color;

public class Tank extends Entity {
	private int life;
	private Color color;
	private int bulletType;
	private int firingDelay;
	private int firingDelayCounter;
	public Tank(Field field, int x, int y, int direction, int movingDelay, int firingDelay, int bulletType, int life, Color color) {
		super(field, x, y, direction, movingDelay);
		if(life <= 0) life = 1;
		if(color == null) color = Color.black;
		this.life = life;
		this.color = color;
		this.bulletType = bulletType;
		this.firingDelay = firingDelay;
		this.firingDelayCounter = firingDelay;
	}
	public int getLife() {
		return life;
	}
	public Color getTankColor() {
		return color;
	}
	public void decreaseLife(int amount) {
		life -= amount;
		if(life <= 0) {
			life = 0;
			super.isDestroyed = true;
		}
	}
	protected void calculateNextState() {
		//If it cannot advance, it randomly either turns left or right.
		nextX = x;
		nextY = y;
		nextDirection = direction;
		if(direction == WEST) nextX--;
		else if(direction == NORTH) nextY--;
		else if(direction == EAST) nextX++;
		else if(direction == SOUTH) nextY++;
		if(field.outOfField(nextX, nextY) || field.getTerrainAt(nextX,nextY) !=0) {
			nextX = x;
			nextY = y;
			int r = utility.Utility.random(0,1);
			if(r == 0) nextDirection--;
			else nextDirection++;
			nextDirection=(nextDirection+4)%4;
		}
		
	}
	public void update() {
		//Step1: Check whether or not the tank is destroyed. If yes, do nothing.
		if(isDestroyed) return;
		
		//Step2: Move the tank
		if(!move()) return;
		
		//Step3: Update the value of firingDelayCounter
		if(firingDelayCounter > 0) {
			firingDelayCounter--;
			return;
		}
		firingDelayCounter = firingDelay;
		//Step4: Fire a bullet only if the tank has moved by firingDelay cells. There are two kinds of bullets: (normal) Bullet and Extra Bullet. Their powers are 1 and 2, respec-tively.
		if(bulletType == 0) new Bullet(field,x,y,direction,1, 1, this);
		else new ExtraBullet(field,x,y,direction,1, 2, this);
	}
}
