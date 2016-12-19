package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import button.MenuButton;
import button.RefreshButton;
import config.PlayerStatus;
import render.Resource;

public class StatusPanel extends JPanel{

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
		String text = "Score : " + PlayerStatus.score;
		FontMetrics fm = g2d.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(text, g2d);
        int x = (this.getWidth() - (int) r.getWidth()) / 2;
        g2d.drawString(text, x, 70);
		
		for(int i = 0; i < PlayerStatus.heart; i++) {
			g2d.drawImage(Resource.heart, 220 + (40 * i), 90, 30, 30, null);
		}
	}
}

