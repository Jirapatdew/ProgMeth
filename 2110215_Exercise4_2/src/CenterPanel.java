import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CenterPanel {
	public CenterPanel(JFrame frame, final NorthPanel north) {
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(400, 150));
		panel.setBackground(new Color(240,240,216));
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		String[] name = {"ID", "First Name", "Last Name"};
		JTextField[] tf = new JTextField[name.length];
		
		for(int i=0; i<name.length; i++) {
			JLabel label = new JLabel();
			label.setText(name[i]);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = i;
			c.weightx = 0.5;
			c.weighty = 1.0;
			c.insets = new Insets(2,7,5,7);
			panel.add(label, c);
			
			tf[i] = new JTextField();
			tf[i].setPreferredSize(new Dimension(200,30));
			c.gridx = 1;
			c.gridwidth = 5;
			c.weightx = 10.0;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			c.insets = new Insets(0,0,0,0);
			panel.add(tf[i], c);
		}
		
		c.gridy = 3;
		c.gridx = 3;
		c.weightx = 0.2;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		JButton btn = new JButton("Submit");
		btn.setPreferredSize(new Dimension(80,26));
		panel.add(btn, c);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = tf[0].getText();
				String name = tf[1].getText();
				String last = tf[2].getText();

				boolean accept = true;

				for (int i = 0; i < id.length(); i++) {
					if (!Character.isDigit(id.charAt(i)))
						accept = false;
				}

				for (int i = 0; i < name.length(); i++) {
					if (!Character.isLetter(name.charAt(i)))
						accept = false;
				}

				for (int i = 0; i < last.length(); i++) {
					if (!Character.isLetter(last.charAt(i)))
						accept = false;
				}

				if (id.length() != 10 || name.length() == 0 || last.length() == 0)
					accept = false;

				if (accept) {
					north.setName(id + " " + name + " " + last);
				} else {
					JOptionPane.showMessageDialog(
						frame,
						"ID should contain 10 digits.\n" +
						"First name should contain only letters. (At least 1)\n" +
						"Last name should contain only letters. (At least 1)"
					);
				}
			}
		});
				
		frame.add(panel, BorderLayout.CENTER);
	}
}
