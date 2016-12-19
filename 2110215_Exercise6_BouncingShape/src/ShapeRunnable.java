
public class ShapeRunnable implements Runnable {
	
	private MovableShape shape;
	private Thread prevThread;
	private int bouncedCount;
	
	public ShapeRunnable(MovableShape shape, Thread prevThread) {
		super();
		this.shape = shape;
		this.prevThread = prevThread;
		bouncedCount = 0;
	}
	
	@Override
	public void run() {
		try {
			if(prevThread != null) prevThread.join();
			
			shape.isMoving = true;
			
			while(true) {
				Thread.sleep(50);
				
				synchronized(shape) {
					shape.move();
					if(shape.isBouncing()) {
						shape.flipDirection();
						bouncedCount++;
					}
					if(prevThread == null && bouncedCount == 3) {
						break;
					}
					if(!shape.isMoving) {
						shape.wait();
					}
					
					Main.getCenterPanel().repaint();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
