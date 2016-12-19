import java.awt.Color;


public class MovableShape {

	public Color color;
	public boolean isMoving;
	private int x, y;
	private int	width, height;
	private int	movingDirection;
	private int	upperBound, lowerBound;

	public MovableShape(int x, int y, int width, int height, int movingDirection, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.movingDirection = movingDirection;
		this.color = color;
		
		isMoving = false;
		upperBound = 0;
		lowerBound = 360;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public void move(){
		this.y += 10 * this.movingDirection;
	}
	
	public boolean isBouncing() {
		return y <= upperBound || y >= lowerBound - height;
	}
	
	public void flipDirection(){
		movingDirection *= -1;
	}
}
