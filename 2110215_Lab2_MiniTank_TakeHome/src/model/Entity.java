package model;

public abstract class Entity {
	public static final int WEST = 0, NORTH = 1, EAST = 2, SOUTH = 3;
	protected int x, y, direction;
	protected int nextX, nextY, nextDirection;
	private int movingDelay;
	private int movingDelayCouter;
	protected boolean isDestroyed;
	protected boolean isDestroyedInNextState;
	Field field;
	
	public Entity(Field field, int x, int y, int direction, int movingDelay) {
		if(field.outOfField(x,y)) x = y = 0;
		if(direction < 0 || direction > 3) direction = 2;  
		this.field = field;
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.movingDelay = movingDelay;
		movingDelayCouter = movingDelay;
		field.addEntity(this);
		calculateNextState();
	}
	
	abstract void update();
	abstract void calculateNextState();
	protected boolean move() {
		if(isDestroyed) return false;
		if(movingDelayCouter > 0) {
			movingDelayCouter--;
			return false;
		}
		movingDelayCouter = movingDelay;
		
		x = nextX;
		y = nextY;
		direction = nextDirection;
		calculateNextState();
		return true;
		
	}
	public boolean isSamePosition(Entity other) {
		if(x == other.getX() && y == other.getY()) return true;
		return false;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDirection() {
		return direction;
	}
	public int getNextX() {
		return nextX;
	}
	public int getNextY() {
		return nextY;
	}
	public int getNextDirection() {
		return nextDirection;
	}
	public int getMovingDelayCouter() {
		return movingDelayCouter;
	}
	public void setMovingDelayCouter(int movingDelayCouter) {
		this.movingDelayCouter = movingDelayCouter;
	}
	public int getMovingDelay() {
		return movingDelay;
	}
	public boolean isDestroyed() {
		return isDestroyed;
	}
	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
	
}
