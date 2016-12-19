package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import button.BackButton;
import utility.HighScoreUtility;
import render.Resource;

public class StatScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private HighScoreUtility.HighScoreRecord[] highScoreRecords;
	
	public StatScreen(HighScoreUtility.HighScoreRecord[] highScoreRecords) {
		// TODO Auto-generated constructor stub
		this.highScoreRecords = highScoreRecords;
		
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
		
		for(int i = 1; i <= 7; i++) {
			g2d.drawImage(Resource.rank[i], 120, 150 + (70*(i-1)), 45, 45, null);
		}
		
		g2d.setFont(new Font("Century Gothic", Font.PLAIN, 36));
		g2d.setColor(Color.WHITE);
		String title = "---- High Score ----";
		FontMetrics fm = g2d.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(title, g2d);
        int x = (this.getWidth() - (int) r.getWidth()) / 2;
        g2d.drawString(title, x, 100);
		
        
		g2d.setFont(Resource.standardFont);
		g2d.setColor(Color.WHITE);
		for(int i = 0; i < highScoreRecords.length; i++) {
			if(i==30) {
				g2d.setFont(Resource.smallFont);
				g2d.setColor(Color.WHITE);
			}
			g2d.drawString(highScoreRecords[i].getName(), 250, 180 + (70*i));
			g2d.drawString(Integer.toString(highScoreRecords[i].getScore()), 440, 180 + (70*i));
		}
	}
}


