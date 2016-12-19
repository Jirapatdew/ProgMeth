package GUIPuzzle;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class PlayButton extends RoundButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlayButton() {
		super(Resource.playButton);
		//setPreferredSize(new Dimension(180, 180));
		setSize(180, 180);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.gameWindow.switchScreen(new GameScreen());
			}
		});
	}
}
