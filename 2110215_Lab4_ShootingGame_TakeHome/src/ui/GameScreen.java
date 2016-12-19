/**
 * @author Jirapat Atiwattanachai (5731015621) 
 * @version 28 OCT 2015
 * Lab4 (1/2015) in 2110215 ProgMeth
 */
package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import lib.ConfigurableOption;
import lib.IRenderableHolder;
import lib.IRenderableObject;
import lib.InputUtility;

public class GameScreen extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IRenderableHolder renderableHolder;
	
	protected GameScreen(IRenderableHolder holder){
		renderableHolder = holder;
		//this.setPreferredSize(new Dimension(ConfigurableOption.screenWidth, ConfigurableOption.screenHeight));
		applyResize();
		addListener();
		setDoubleBuffered(true);
	}
	
	private void addListener(){
		/*---------- MouseListener - listener1 ----------- */
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getButton() == 1) {
					InputUtility.setMouseLeftDown(true);
					InputUtility.setMouseLeftLastDown(true);
				}
				else {
					InputUtility.setMouseLeftDown(false);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setMouseOnScreen(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setMouseOnScreen(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		/*---------- MouseMotionListener - listener2 ----------- */
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				if(InputUtility.isMouseOnScreen()) {
					InputUtility.setMouseX(e.getX());
					InputUtility.setMouseY(e.getY());
				}
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if(InputUtility.isMouseOnScreen()) {
					InputUtility.setMouseX(e.getX());
					InputUtility.setMouseY(e.getY());
				}
			}
		});
		
		/*---------- KeyListener - listener3 ----------- */
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setKeyPressed(e.getKeyCode(), false);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setKeyPressed(e.getKeyCode(), true);
				InputUtility.setKeyTriggered(e.getKeyCode(), true);
			}
		});
		
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;		
		
		// assign the background color to be "black"
		g2.setBackground(Color.BLACK);
		
		// clear all the objects
		Dimension dim = getSize();
		g2.clearRect(0, 0, (int)dim.getWidth(), (int)dim.getHeight());
		
		// render all the objects
		for(IRenderableObject renderable : renderableHolder.getSortedRenderableObject()){
			renderable.render(g2);
		}
	}
	
	protected void applyResize(){
		this.setPreferredSize(new Dimension(ConfigurableOption.screenWidth, ConfigurableOption.screenHeight));
		this.validate();
	}
}
