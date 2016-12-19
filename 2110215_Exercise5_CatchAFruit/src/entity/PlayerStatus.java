package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import render.IRenderable;
import render.Resource;

public class PlayerStatus implements IRenderable {
	private int score;

	public PlayerStatus() {
		score = 0;
	}
	
	public void addScore(int a) {
		score += a;
	}
	public void subtractionScore(int a) {
		score -= a;
		if(score < 0) score = 0;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.BLACK);
		//fillRect(int x, int y, int width, int height)
		g2d.fillRect(0, 420, 640, 60);
			
		g2d.setFont(Resource.standardFont);
		g2d.setColor(Color.WHITE);
		g2d.drawString("SCORE: " + score, 10, 460);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
}
