package button;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

import javax.swing.*;


public class RoundButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	protected BufferedImage bimg;
	public RoundButton(BufferedImage bimg) {
		this.bimg = bimg;
		setFocusable(false);
		
		/*
		 * These statements enlarge the button so that it becomes a circle
		 * rather than an oval.
		 */
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);

		/*
		 * This call causes the JButton not to paint the background. This allows
		 * us to paint a round background.
		 */
		setContentAreaFilled(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		if (getModel().isRollover()) {
			g2d.setColor(new Color(255, 255, 255, 100));
			g2d.fillOval(0, 0, getSize().width , getSize().height );
		}
		g2d.drawImage(bimg, 0, 0, getSize().width , getSize().height , null);
		super.paintComponent(g2d);
	}

	@Override
	protected void paintBorder(Graphics g) {
		
	}

	// Hit detection.
	Shape shape;

	@Override
	public boolean contains(int x, int y) {
		// If the button has changed size, make a new shape object.
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}
}