package button;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import config.PlayerStatus;
import main.Main;
import render.Resource;
import ui.GameScreen;
import utility.HighScoreUtility;

public class RefreshButton extends RoundButton {

	private static final long serialVersionUID = 1L;
	
	public RefreshButton() {
		super(Resource.refreshButton);
		
		setSize(70, 70);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Resource.s_button.play();
				
				if(PlayerStatus.heart > 1) {
					PlayerStatus.increaseheart(-1);
					PlayerStatus.increaseScore(-PlayerStatus.newScore, 2);
					Main.gameWindow.switchScreen(new GameScreen());
				}
				else {
					//GAME OVER
					HighScoreUtility.recordHighScore(PlayerStatus.score);
					HighScoreUtility.displayTopScore();
				}
				
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(PlayerStatus.heart == 1) bimg = Resource.flagButton;
		else bimg = Resource.refreshButton;
	}
}
