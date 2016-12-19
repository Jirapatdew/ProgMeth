import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton exitButton, showButton;
	JTextField text;

	public MainWindow() {
		// 1. Optional: Specify who draws the window
		// decorations. (default: native window system)
		JFrame.setDefaultLookAndFeelDecorated(true);
		// 2. Optional but recommend: What happens when the
		// frame closes?
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 3. Optional: How the components are put in the frame?
		this.setLayout(new FlowLayout());
		// 4. Optional: Where the frame started?
		setLocationRelativeTo(null);
		// 5. Create GUI/Swing components
		JButton exitButton = new JButton(" Exit ");
		showButton = new JButton(" Show ");
		text = new JTextField("This is a text field.", 20);
		// 6. Put the components in the frame
		this.add(showButton, BorderLayout.WEST);
		this.add(text, BorderLayout.CENTER);
		this.add(exitButton, BorderLayout.EAST);
		this.setSize(300, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		MainWindow m = new MainWindow();
	}
}