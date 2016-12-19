package GUIPuzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import highscore.HighScoreUtility;

public class StatScreen extends JPanel {
	
	/**
	 * 
	 */
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
		
		for(int i = 0; i < 7; i++) {
			g2d.drawImage(Resource.rank[i+1], 120, 150 + (70*i), 45, 45, null);
		}
		
//		g2d.drawImage(Resource.gold, 120, 160, 45, 45, null);
//		g2d.drawImage(Resource.silver, 120, 230, 45, 45, null);
//		g2d.drawImage(Resource.bronze, 120, 300, 45, 45, null);
		
		g2d.setFont(new Font("Century Gothic", Font.BOLD, 36));
		g2d.setColor(Color.WHITE);
		String title = "---- High Score ----";
		FontMetrics fm = g2d.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(title, g2d);
        int x = (this.getWidth() - (int) r.getWidth()) / 2;
        //int y = (this.getHeight() - (int) r.getHeight()) / 2 + fm.getAscent();
        g.drawString(title, x, 100);
        
//		g2d.drawString("--- High Score ---", 170, 100);
		
		g2d.setFont(Resource.standardFont);
		g2d.setColor(Color.WHITE);
		for(int i = 0; i < highScoreRecords.length; i++) {
			if(i==30) {
				g2d.setFont(Resource.smallFont);
				g2d.setColor(Color.WHITE);
			}
			g2d.drawString(highScoreRecords[i].getName(), 250, 180 + (70*i));
			g2d.drawString(highScoreRecords[i].getScore(), 440, 180 + (70*i));
		}
		
//		g2d.drawString("Oliver", 250, 180);
//		g2d.drawString("500", 440, 180);
//		g2d.drawString("Jack", 250, 250);
//		g2d.drawString("400", 440, 250);
//		g2d.drawString("Noah", 250, 320);
//		g2d.drawString("300", 440, 320);
//		
//		g2d.setFont(Resource.smallFont);
//		g2d.setColor(Color.WHITE);
//		g2d.drawString("Jacob", 250, 390);
//		g2d.drawString("200", 440, 390);
//		g2d.drawString("Charlie", 250, 460);
//		g2d.drawString("100", 440, 460);
//		g2d.drawString("Harry", 250, 530);
//		g2d.drawString("50", 440, 530);
//		g2d.drawString("Oscar", 250, 600);
//		g2d.drawString("10", 440, 600);
	}
}

