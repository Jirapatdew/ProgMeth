
import java.awt.BorderLayout;

import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		
		NorthPanel north = new NorthPanel(frame);
		new WestPanel(frame, north);
		new CenterPanel(frame, north);
		SouthPanel south = new SouthPanel(frame);
		new EastPanel(frame, south);
		
		
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}

}
