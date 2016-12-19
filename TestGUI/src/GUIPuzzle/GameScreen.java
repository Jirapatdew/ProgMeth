package GUIPuzzle;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GameScreen extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameScreen() {
		// TODO Auto-generated constructor stub
		setPreferredSize(new Dimension(640, 800));
		setLayout(new BorderLayout());
		
		add(new StatusPanel(),BorderLayout.NORTH);
		add(new LevelPanel(),BorderLayout.SOUTH);
	}
}
