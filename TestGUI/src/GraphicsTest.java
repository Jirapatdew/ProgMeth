

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class GraphicsTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GraphicsTest() {
		this.setTitle("Remember g for Graphics");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
	protected static final AlphaComposite transcluentWhite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
	protected static final AlphaComposite opaque = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);

	public void paint(Graphics g) {
		Graphics2D ga = (Graphics2D)g;
		
		
		g.setColor(Color.BLACK);
		g.drawRect(40, 40, 30, 30);
		
		ga.setColor(Color.BLACK);
		ga.setStroke(new BasicStroke(2.0f));
		ga.drawOval(80, 80, 100, 100);
		g.setColor(Color.RED);
		g.fillOval(80, 80, 100, 100);

		
		g.setColor(Color.BLACK);
		g.fillOval(248, 78, 104, 104);
		g.setColor(Color.RED);
		g.fillOval(250, 80, 100, 100);
		
		ga.setComposite(transcluentWhite);
		ga.setColor(Color.WHITE);
		ga.fillOval(250, 80, 100, 100);
		ga.setComposite(opaque);
		
	}

	public static void main(String[] args) {
		new GraphicsTest();
	}

}