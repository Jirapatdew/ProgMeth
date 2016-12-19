package button;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import config.PlayerStatus;
import render.Resource;


public class LikeButton extends RoundButton {

	private static final long serialVersionUID = 1L;
	
	public LikeButton() {
		super(Resource.likeButton);
		if(PlayerStatus.CheatMode) bimg = Resource.likeButton2;
		setSize(80, 80);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Resource.s_button.play();
				
				PlayerStatus.CheatMode = !PlayerStatus.CheatMode;
				
				if(PlayerStatus.CheatMode) System.out.println("Cheat Mode is Active");
				else System.out.println("Cheat Mode is Close");
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(PlayerStatus.CheatMode) bimg = Resource.likeButton2;
		else bimg = Resource.likeButton;
	}
}

