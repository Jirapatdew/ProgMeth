import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class EastPanel {
	public EastPanel(JFrame frame, SouthPanel south) {
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(150,150));
		panel.setBackground(new Color(192,216,96));
		
		JButton btn = new JButton("Choose File");
		panel.add(btn);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(
					new File(System.getProperty("user.dir"))
				);
				int status = chooser.showOpenDialog(frame);
				
				if(status == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					try {
						String txt = readFileContent(file.getAbsolutePath());
						south.setText(txt);
					} catch(IOException e1) {
						south.setText("");
					}
				}
			}
		});
		
		File defaultFile = new File("./src/ExampleFile1.txt");
		try {
			String txt = readFileContent(defaultFile.getAbsolutePath());
			south.setText(txt);
		} catch(IOException e) {
			JOptionPane.showMessageDialog(
				frame, 
				"File is not found"
			);
			south.setText("File \"" + defaultFile.getName() + "\" at " + defaultFile.getPath() + " is not found.");
		}
		
		frame.add(panel, BorderLayout.EAST);
	}
	
	public String readFileContent(String path) throws IOException {
		String txt = "";
		for (String line : Files.readAllLines(Paths.get(path))) {
		    txt += line + "\n";
		}
		return txt;
	}
}
