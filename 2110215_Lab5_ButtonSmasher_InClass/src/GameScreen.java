/**
 * @author Jirapat Atiwattanachai (5731015621) 
 * @version 13 Nov 2015
 * Lab5 part1 (2/2014) in 2110215 Prog Meth
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;


public class GameScreen extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameLogic logic;
	private final Font font = new Font("Tahoma",Font.BOLD,30);
	private final Font smallfont = new Font("Tahoma",Font.PLAIN,20);
	
	public GameScreen(GameLogic logic){
		super();
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(300,300));
		this.logic = logic;
		
		requestFocus();
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					InputUtility.setSpacePressed(false);
				}
					
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_SPACE){
					if(!InputUtility.isSpacePressed()) {
						InputUtility.setSpacePressed(true);
						InputUtility.setSpaceTriggered(true);
					}
				}
				
			}
		});
	}
	
	private int[] getDrawingParameter(Graphics context, Font font,String status){
		int[] params = new int[6];
		FontMetrics metrics = context.getFontMetrics(font);
		Rectangle2D rect = metrics.getStringBounds(status, context);
		int rectHeight = (int)rect.getHeight();
		params[0] = 0;
		params[1] = (300-rectHeight)/2;
		params[2] = 300;
		params[3] = rectHeight;
		params[4] = (300-(int)rect.getWidth())/2;
		params[5] = (300-rectHeight)/2+rectHeight-context.getFontMetrics(font).getDescent();
		return params;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, 300, 300);
		
		
		int[] params;
		String status;
		if(logic.isHittingTime()) {
			g2d.setColor(Color.BLUE);
			status = "PRESS";
		}
		else {
			g2d.setColor(Color.RED);
			status = "STOP";
		}
		
		params = getDrawingParameter(g, font,status);
		g2d.fillRect(params[0], params[1], params[2], params[3]);
		g2d.setFont(font);
		g2d.setColor(Color.WHITE);
		g2d.drawString(status, params[4], params[5]);
		g2d.setFont(smallfont);
		g2d.setColor(Color.WHITE);
		g2d.drawString("SCORE: " + logic.getScore(), 5, 295);
	}
}
