
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class NorthPanel {
	
	private JPanel panel = new JPanel();
	private Color prevCol = new Color(84,36,55);
	private JLabel label;
	
	public NorthPanel(JFrame frame) {
		panel.setPreferredSize(new Dimension(700, 100));
		panel.setLayout(new GridBagLayout());
		panel.setBackground(new Color(84,36,55));
		
		label = new JLabel();
		label.setText("5731015621 Dew Test");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		label.setForeground(Color.WHITE);
		panel.add(label);
		
		panel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				panel.setBackground(prevCol);
				label.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel.setBackground(new Color(236,208,120));
				label.setForeground(Color.DARK_GRAY);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		frame.add(panel, BorderLayout.NORTH);
	}
	
	public void setBackground(Color col) {
		prevCol = col;
		panel.setBackground(col);
	}
	
	public void setName(String name) {
		label.setText(name);
	}
}
