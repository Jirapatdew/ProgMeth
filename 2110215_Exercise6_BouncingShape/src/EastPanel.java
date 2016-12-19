import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class EastPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EastPanel() {
		
		JButton button = new JButton("Start");
		
		setPreferredSize(new Dimension(150, 360));
		setBackground(Color.LIGHT_GRAY);
		setBorder(new EmptyBorder(20, 0, 0, 0));
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(button.getText().equals("Start")) {
					Main.getCenterPanel().startAllThread();
					button.setText("Pause");
				}
				else if(button.getText().equals("Pause")) {
					Main.getCenterPanel().square2.isMoving = false;
					button.setText("Continue");
				}
				else {
					synchronized (Main.getCenterPanel().square2) {
						Main.getCenterPanel().square2.isMoving = true;
						Main.getCenterPanel().square2.notifyAll();
					}
					button.setText("Pause");
				}
			}
		});
		
		add(button);
	}
}
