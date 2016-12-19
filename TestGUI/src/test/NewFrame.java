package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Blob;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NewFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("5555");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(640,720);
		
		frame.setLayout(new BorderLayout());
		
		Color iBlack = new Color(59, 64, 67);
		Color iPink = new Color(251, 97, 105);
		
		JPanel p1 = new JPanel();
		p1.setBackground(iBlack);
		p1.setPreferredSize(new Dimension(640, 160));
		JPanel p2 = new JPanel();
		p2.setBackground(iPink);
		p2.setPreferredSize(new Dimension(480, 560));
		JPanel p3 = new JPanel();
		p3.setBackground(iBlack);
		p3.setPreferredSize(new Dimension(640, 80));
		
		JPanel p4 = new JPanel();
		p4.setBackground(iBlack);
		p4.setPreferredSize(new Dimension(80, 560));
		JPanel p5 = new JPanel();
		p5.setBackground(iBlack);
		p5.setPreferredSize(new Dimension(80, 560));
		
//		JPanel p1 = new JPanel();
//		p1.setBackground(iBlack);
//		p1.setPreferredSize(new Dimension(640, 160));
//		JPanel p2 = new JPanel();
//		p2.setBackground(iPink);
//		p2.setPreferredSize(new Dimension(40, 40));
//		JPanel p3 = new JPanel();
//		p3.setBackground(iBlack);
//		p3.setPreferredSize(new Dimension(640, 80));
//		
//		JPanel p4 = new JPanel();
//		p4.setBackground(iBlack);
//		p4.setPreferredSize(new Dimension(300, 40));
//		JPanel p5 = new JPanel();
//		p5.setBackground(iBlack);
//		p5.setPreferredSize(new Dimension(300, 40));
		frame.add(p1,BorderLayout.NORTH);
		frame.add(p2,BorderLayout.CENTER);
		frame.add(p3,BorderLayout.SOUTH);
		frame.add(p4,BorderLayout.EAST);
		frame.add(p5,BorderLayout.WEST);
		
		
		
		frame.pack();
		
	}
}
