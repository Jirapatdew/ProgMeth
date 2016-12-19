import java.awt.event.*;
import javax.swing.*;

public class Login implements MouseListener {
	private JTextField t;

	public Login() {
		JFrame f = new JFrame("JFrame");
		JPanel p = new JPanel();
		JLabel l = new JLabel("Name");
		JButton b = new JButton("Login");
		t = new JTextField(15);
		b.addMouseListener(this);
		p.add(l);
		p.add(t);
		p.add(b);
		f.add(p);
		f.setSize(200, 150);
		f.setVisible(true);
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		String msg = "Hello " + t.getText();
		JDialog d = new JDialog();
		d.setSize(100, 100);
		d.add(new JLabel(msg));
		d.setVisible(true);
	}

	public static void main(String[] args) {
		new Login();
	}
}