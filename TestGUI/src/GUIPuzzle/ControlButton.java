package GUIPuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControlButton extends RoundButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControlButton() {
		super(Resource.controlButton);
		setSize(80, 80);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null, "test ControlButton");
				Main.gameWindow.switchScreen(new ControlScreen());
			}
		});
	}
}
