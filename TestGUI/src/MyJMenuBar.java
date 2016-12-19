import javax.swing.*;

public class MyJMenuBar {
	public static void main(String[] args) {
		JFrame f = new JFrame("JFrame");
		JMenuBar mb = new JMenuBar();
		f.setJMenuBar(mb);
		JMenu fileMenu = new JMenu("File");
		mb.add(fileMenu);
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem closeItem = new JMenuItem("Close");
		fileMenu.add(openItem);
		fileMenu.addSeparator();
		fileMenu.add(closeItem);
		f.setSize(150, 150);
		f.setVisible(true);
	}
}