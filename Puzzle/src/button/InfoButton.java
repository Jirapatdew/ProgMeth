package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main;
import render.Resource;
import ui.InfoScreen;

public class InfoButton extends RoundButton {

	private static final long serialVersionUID = 1L;

	public InfoButton() {
		super(Resource.infoButton);
		setSize(80, 80);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Resource.s_button.play();
				
				Main.gameWindow.switchScreen(new InfoScreen());
			}
		});
	}
}
