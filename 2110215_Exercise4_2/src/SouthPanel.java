import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SouthPanel {
	
	private JTextArea ta;
	
	public SouthPanel(JFrame frame) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(700,100));
		panel.setLayout(new CardLayout());
		
		ta = new JTextArea();
		ta.setPreferredSize(new Dimension(700,100));
		panel.add(ta);
		
		JScrollPane scrollPane = new JScrollPane(ta);
		panel.add(scrollPane);
		
		frame.add(panel, BorderLayout.SOUTH);
	}
	
	public void setText(String text) {
		ta.setText("Text :\n"+text);
	}
}
