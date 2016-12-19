package GUIPuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

public class MuteSoundButton extends RoundButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MuteSoundButton() {
		super(Resource.muteSoundButton);
		setSize(80, 80);
		if(Main.openSound) setVisible(false);
		else setVisible(true);
		
	}
}