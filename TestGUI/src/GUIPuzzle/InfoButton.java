package GUIPuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class InfoButton extends RoundButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InfoButton() {
		super(Resource.infoButton);
		setSize(80, 80);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.gameWindow.switchScreen(new InfoScreen());
			}
		});
	}
}
