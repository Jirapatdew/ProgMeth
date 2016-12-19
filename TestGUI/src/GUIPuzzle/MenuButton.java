package GUIPuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuButton extends RoundButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuButton() {
		super(Resource.menuButton);
		setSize(70, 70);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.gameWindow.switchScreen(new MainScreen());
			}
		});
	}
}
