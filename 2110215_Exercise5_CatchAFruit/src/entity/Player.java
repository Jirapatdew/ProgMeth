package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import input.InputUtility;
import render.IRenderable;

public class Player implements IRenderable{
	protected int x;
	protected int y;
	protected int radius;
	
	
	public Player() {
		x = 300;
		y = 380;
		radius = 20;
	}

	public void update(){
		if (InputUtility.getKeyPressed(KeyEvent.VK_LEFT)) {
				x -= 5;
				if(x < 0) x=0;
		} else if (InputUtility.getKeyPressed(KeyEvent.VK_RIGHT)) {
				x += 5;
				if(x > 600) x = 600;
		}
	}
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 5;
	}
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.BLUE);
		g2d.fillOval(x, y, radius * 2, radius * 2);
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
