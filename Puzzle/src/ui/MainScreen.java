package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import button.ControlButton;
import button.LikeButton;
import button.PlayButton;
import button.SoundButton;
import button.StatButton;
import render.Resource;

public class MainScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	public MainScreen() {
		// TODO Auto-generated constructor stub

		setPreferredSize(new Dimension(640, 800));
		setLayout(null);
		
		PlayButton playButton = new PlayButton();
		add(playButton);
		playButton.setLocation(230,330);
		
		StatButton statButton = new StatButton();
		add(statButton);
		statButton.setLocation(115, 570);
		
		ControlButton controlButton = new ControlButton();
		add(controlButton);
		controlButton.setLocation(225, 570);
		
		SoundButton soundButton = new SoundButton();
		add(soundButton);
		soundButton.setLocation(335, 570);
		
		LikeButton likeButton = new LikeButton();
		add(likeButton);
		likeButton.setLocation(445, 570);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(Resource.mainScreen2,0,0,640,800,null);
		g2d.setColor(new Color(5, 5, 5, 230));
		g2d.fillRect(0, 0, 640, 800);
		
		g2d.setFont(Resource.largeFont);
		g2d.setColor(Color.WHITE);
        
        g2d.drawImage(Resource.logo, 70, 80, 450, 200, null);
	}
}
