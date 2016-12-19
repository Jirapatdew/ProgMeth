package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utility.HighScoreUtility;
import render.Resource;

public class StatButton extends RoundButton {

	private static final long serialVersionUID = 1L;

	public StatButton() {
		super(Resource.statButton);
		setSize(80, 80);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Resource.s_button.play();
				
				HighScoreUtility.displayTopScore();
			}
		});
	}
}
