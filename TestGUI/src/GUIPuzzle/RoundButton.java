package GUIPuzzle;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import GUIPuzzle.Resource;

import java.awt.event.*;

public class RoundButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage bimg;
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
			//g2d.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
		}
		g2d.drawImage(bimg, 0, 0, getSize().width , getSize().height , null);
		//g2d.drawImage(bimg, 0, 0, getSize().width - 1, getSize().height - 1, null);
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








//package GUIPuzzle;
//
//import java.awt.*;
//import java.awt.geom.*;
//import javax.swing.*;
//
//import GUIPuzzle.Resource;
//
//import java.awt.event.*;
//
//public class RoundButton extends JButton {
//
//	public RoundButton(String label) {
//		super(label);
//
//		setBackground(Color.GREEN);
//		setFocusable(false);
//
//		/*
//		 * These statements enlarge the button so that it becomes a circle
//		 * rather than an oval.
//		 */
//		Dimension size = getPreferredSize();
//		size.width = size.height = Math.max(size.width, size.height);
//		setPreferredSize(size);
//
//		/*
//		 * This call causes the JButton not to paint the background. This allows
//		 * us to paint a round background.
//		 */
//		setContentAreaFilled(false);
//	}
//
//	@Override
//	protected void paintComponent(Graphics g) {
//		
//		Graphics2D g2d = (Graphics2D)g;
//		
//		g2d.drawImage(Resource.playButton, 0, 0, getSize().width - 1, getSize().height - 1, null);
//		if (getModel().isArmed()) {
//			g.setColor(Color.WHITE);
//		} else {
//			g.setColor(getBackground());
//		}
//		//g.setColor(Resource.iBlack);
//		//g2d.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
//		super.paintComponent(g2d);// show label
//	}
//
//	@Override
//	protected void paintBorder(Graphics g) {
//		// g.setColor(Color.darkGray);
//		// g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
//	}
//
//	// Hit detection.------------------------------------
//	Shape shape;
//
//	@Override
//	public boolean contains(int x, int y) {
//		// If the button has changed size, make a new shape object.
//		if (shape == null || !shape.getBounds().equals(getBounds())) {
//			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
//		}
//		return shape.contains(x, y);
//	}
//
//	// ---------------------------------------------------
//	public static void main(String[] args) {
//
//		// JFrame.setDefaultLookAndFeelDecorated(true);
//		JFrame frame = new JFrame("Rounded Button Example");
//		frame.setLayout(new FlowLayout());
//
//		JButton b1 = new RoundButton("");
//		JButton b2 = new RoundButton("B2");
//
//		b1.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				JOptionPane.showMessageDialog(null, "testsstet");
//			}
//		});
//		
//		b1.setPreferredSize(new Dimension(200, 200));
//		frame.add(b1);
//		frame.add(b2);
//
//		frame.setSize(500, 500);
//		frame.setVisible(true);
//	}
//}
