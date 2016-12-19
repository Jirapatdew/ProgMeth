import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyButton {
	public static void main(String[] args) {
		JFrame f = new JFrame("title"); // create & configure
		JPanel p = new JPanel();
		JButton b = new JButton("press me");
		p.add(b);// add button to panel
		f.add(p); // add panel to frame
		f.pack();
		f.setVisible(true);
	}
}