package GUIPuzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class StatusPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StatusPanel() {
		// TODO Auto-generated constructor stub
		setPreferredSize(new Dimension(640, 160));
		setLayout(null);
		
		MenuButton menuButton = new MenuButton();
		add(menuButton);
		menuButton.setLocation(40, 40);
		
		RefreshButton refreshButton = new RefreshButton();
		add(refreshButton);
		refreshButton.setLocation(520, 40);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Resource.iBlack);
		g2d.fillRect(0, 0, 640, 160);
		
		g2d.setFont(Resource.mediumFont);
		g2d.setColor(Color.WHITE);
		g2d.drawString("Score : " + "220", 220, 70);
		
		for(int i = 0; i < 5; i++) {
			g2d.drawImage(Resource.heart, 220 + (40 * i), 90, 30, 30, null);
		}
	}
}
