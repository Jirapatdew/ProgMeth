package GUIPuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import highscore.HighScoreUtility;

public class StatButton extends RoundButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatButton() {
		super(Resource.statButton);
		setSize(80, 80);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null, "test StatButton");
				HighScoreUtility.displayTopScore();
			}
		});
	}
}
