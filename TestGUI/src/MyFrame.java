import java.awt.*;
import java.awt.event.*;

class MyWindowAapter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

public class MyFrame {
	public static void main(String[] args) {
		Frame f = new Frame("Frame");
		f.addWindowListener(new MyWindowAapter());
		Label l = new Label("Hello World");
		l.setForeground(Color.blue);
		f.add(l);
		f.setSize(600, 300);
		f.setVisible(true);
	}
}