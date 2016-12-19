package GUIPuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SoundButton extends RoundButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SoundButton(MuteSoundButton muteSoundButton) {
		super(Resource.soundButton);
		setSize(80, 80);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(muteSoundButton.isVisible()){
					//open sound
					//JOptionPane.showMessageDialog(null, "Open Sound");
					Main.openSound = true;
					muteSoundButton.setVisible(false);
				}
				else {
					//close sound
					//JOptionPane.showMessageDialog(null, "Close Sound");
					Main.openSound = false;
					muteSoundButton.setVisible(true);
				}
			}
		});
	}
}