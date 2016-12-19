package GUIPuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RefreshButton extends RoundButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RefreshButton() {
		super(Resource.refreshButton);
		setSize(70, 70);
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Main.gameWindow.switchScreen(new GameScreen());
			}
		});
	}
}
