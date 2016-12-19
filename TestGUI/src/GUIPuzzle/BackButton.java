package GUIPuzzle;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BackButton extends RoundButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BackButton() {
		super(Resource.backButton);
		setSize(115, 115);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JOptionPane.showMessageDialog(null, "test BackButton");
				Main.gameWindow.switchScreen(new MainScreen());
			}
		});
	}
}
