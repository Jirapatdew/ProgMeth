package GUIPuzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ControlScreen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControlScreen() {
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
		g2d.setColor(Resource.iGreen);
		g2d.fillRect(80, 80, 480, 600);
		g2d.setColor(Resource.iBlack);
		g2d.fillRect(500, 670, 40, 40);
		
		g2d.drawImage(Resource.box2, 120, 160, 40, 40, null);
		g2d.drawImage(Resource.box, 120, 240, 40, 40, null);
		g2d.drawImage(Resource.player, 120, 320, 40, 40, null);
		g2d.drawImage(Resource.star, 120, 400, 40, 40, null);
	}
}
