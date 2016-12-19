import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShapeRunnable squareRunnable;
	private ShapeRunnable square2Runnable;
	private ShapeRunnable square3Runnable;
	public MovableShape square;
	public MovableShape square2;
	public MovableShape square3;
	
	public CenterPanel() {
		setPreferredSize(new Dimension(480, 360));
		setBackground(Color.WHITE);
		
		square = new MovableShape(65, 165, 30, 30, 1, Color.RED);
		square2 = new MovableShape(225, 165, 40, 40, -1, Color.BLUE);
		square3 = new MovableShape(385, 165, 50, 50, 1, Color.GREEN);
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(square.color);
		g.fillRect(square.getX(), square.getY(), square.getWidth(), square.getHeight());

		g.setColor(square2.color);
		g.fillRect(square2.getX(), square2.getY(), square2.getWidth(), square2.getHeight());

		g.setColor(square3.color);
		g.fillRect(square3.getX(), square3.getY(), square3.getWidth(), square3.getHeight());
	}
	
	void startAllThread(){
		squareRunnable = new ShapeRunnable(square, null);
		Thread t = new Thread(squareRunnable);
		
		square2Runnable = new ShapeRunnable(square2, t);
		square3Runnable = new ShapeRunnable(square3, t);
		
		Thread t2 = new Thread(square2Runnable);
		Thread t3 = new Thread(square3Runnable);

		t.start();
		t2.start();
		t3.start();
	}

}
