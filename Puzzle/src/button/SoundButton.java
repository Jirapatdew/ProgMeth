package button;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import config.PlayerStatus;
import render.Resource;

public class SoundButton extends RoundButton {

	private static final long serialVersionUID = 1L;
	
	public SoundButton() {
		super(Resource.soundButton);
		if(!PlayerStatus.enableSound) bimg = Resource.muteSoundButton;
		
		setSize(80, 80);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Resource.s_button.play();
				
				PlayerStatus.enableSound = !PlayerStatus.enableSound;
				
				if(PlayerStatus.enableSound) Resource.s_back.loop();
				else Resource.s_back.stop();
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(PlayerStatus.enableSound) bimg = Resource.soundButton;
		else bimg = Resource.muteSoundButton;
	}
}