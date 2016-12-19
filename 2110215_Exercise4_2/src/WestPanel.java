import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class WestPanel {
	public WestPanel(JFrame frame, NorthPanel north) {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(2,2));
		panel.setPreferredSize(new Dimension(150, 150));
		
		Color[] list = {
			new Color(84,36,55),
			new Color(96,72,72),
			new Color(47,6,24),
			new Color(98,40,36)
		};
		
		for(int i=0; i<list.length; i++) {
			JButton btn = new JButton();
			btn.setBackground(list[i]);
			panel.add(btn);
			final int j = i;
			btn.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					north.setBackground(list[j]);
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {}
			});
		}
		
		frame.add(panel, BorderLayout.LINE_START);
	}
}
