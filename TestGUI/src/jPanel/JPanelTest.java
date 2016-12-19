package jPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class JPanelTest extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanelTest() {
		// TODO Auto-generated constructor stub
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(200, 300));
	}
	public JPanelTest(Color aa) {
		// TODO Auto-generated constructor stub
		setBackground(aa);
		setPreferredSize(new Dimension(200, 300));
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(28, 32, 20, 40);
		
	}
}
