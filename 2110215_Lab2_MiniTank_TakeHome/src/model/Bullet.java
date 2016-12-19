package model;

public class Bullet extends Entity {
	protected Tank shooter;
	protected int power;
	public Bullet(Field field, int x, int y, int direction, int movingDelay, int power, Tank shooter) {
		super(field, x, y, direction, movingDelay);
		this.power = power;
		this.shooter = shooter;
		movingDelay = 1;
	}
	public Tank getShooter() {
		return shooter;
	}
	protected void calculateNextState() {
		nextX = x;
		nextY = y;
		nextDirection = direction;
		if(direction == WEST) nextX--;
		else if(direction == NORTH) nextY--;
		else if(direction == EAST) nextX++;
		else if(direction == SOUTH) nextY++;
		if(field.outOfField(nextX, nextY)) {
			nextX = x;
			nextY = y;
			isDestroyedInNextState = true;
		}
		int ter = field.getTerrainAt(nextX,nextY);
		if(ter == -2 || (ter == -1 && power == 1)) {
			nextX = x;
			nextY = y;
			isDestroyedInNextState = true;
		}
	}
	public void update() {
		if(isDestroyedInNextState) {
			isDestroyedInNextState = false;
			isDestroyed = true;
			return;
		}
		move();
	}
	public void hit() {
		for(int i = 0; i < field.getEntities().size(); i++) {
			Entity ent = field.getEntities().get(i);
			if(this.isSamePosition(ent) && ent instanceof Tank) {
				Tank tank = (Tank)ent;
				if(this.shooter == tank) continue;
				tank.decreaseLife(power);
				isDestroyed = true;
			}
		}
	}
}
