package jPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class JPanelMain {
	public static void main(String[] args) {
		JFrame f = new JFrame("TestJPanel");
		//f.setSize(700, 800);
		f.setVisible(true);
		f.setLayout(new GridLayout());
		
		
		f.add(new JPanelTest(Color.BLUE));
		f.add(new JPanelTest(Color.GREEN));
		f.add(new JPanelTest(Color.YELLOW));
		f.pack();
	}
	
}
