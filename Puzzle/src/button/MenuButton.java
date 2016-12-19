package button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Main;
import render.Resource;
import ui.MainScreen;

public class MenuButton extends RoundButton {

	private static final long serialVersionUID = 1L;

	public MenuButton() {
		super(Resource.menuButton);
		setSize(70, 70);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Resource.s_button.play();
				
				Main.gameWindow.switchScreen(new MainScreen());
			}
		});
	}
}
