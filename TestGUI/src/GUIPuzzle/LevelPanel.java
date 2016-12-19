package GUIPuzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class LevelPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LevelPanel() {
		// TODO Auto-generated constructor stub
		setPreferredSize(new Dimension(640, 80));
		setLayout(null);
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Resource.iBlack);
		g2d.fillRect(0, 0, 640, 80);
		
		g2d.setFont(Resource.standardFont);
		g2d.setColor(Color.WHITE);
		g2d.drawString("Level 1", 280, 50);
	}
}
