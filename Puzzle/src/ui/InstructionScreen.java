package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import button.BackButton;
import render.Resource;

public class InstructionScreen extends JPanel {

	private static final long serialVersionUID = 1L;

	public InstructionScreen() {
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
		g2d.drawImage(Resource.howToPlay, 80, 80, 480, 600, null);
		g2d.setColor(Resource.iBlack);
		g2d.fillRect(500, 670, 40, 40);

	}
}
