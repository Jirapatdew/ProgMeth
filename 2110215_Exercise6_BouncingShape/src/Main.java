import java.awt.BorderLayout;
import javax.swing.JFrame;


public class Main {

	private static CenterPanel centerPanel;
	private static EastPanel eastPanel;
	
	
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("5731015621 Jirapat Atiwattanachai Exercise 6 2015/1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		centerPanel = new CenterPanel();
		eastPanel = new EastPanel();
		frame.add(centerPanel, BorderLayout.CENTER);
		frame.add(eastPanel, BorderLayout.EAST);
		
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static CenterPanel getCenterPanel() {
		return centerPanel;
	}

	public static EastPanel getEastPanel() {
		return eastPanel;
	}
	
}
