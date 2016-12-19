package render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;

import input.InputUtility;

public class GameScreen extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameScreen() {
		super();
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(640,480));
		setVisible(true);
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				InputUtility.setKeyPressed(arg0.getKeyCode(), false);
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				InputUtility.setKeyPressed(arg0.getKeyCode(), true);
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 640, 480);
		
		List<IRenderable> entities = RenderableHolder.getInstance().getRenderableList();
		for(IRenderable entity : entities) {
			entity.draw(g2d);
		}
	}
}
