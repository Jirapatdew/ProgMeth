package GUIPuzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class InfoScreen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InfoScreen() {
		// TODO Auto-generated constructor stub
		setPreferredSize(new Dimension(640, 800));
		setLayout(null);
		
		BackButton backButton = new BackButton();
		add(backButton);
		backButton.setLocation(475, 640);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Resource.iBlack);
		g2d.fillRect(0, 0, 640, 800);
		g2d.setColor(Resource.iYellow);
		g2d.fillRect(80, 80, 480, 600);
		g2d.setColor(Resource.iBlack);
		g2d.fillRect(500, 670, 40, 40);
		
	}
}
