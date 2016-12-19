/**
 * @author Jirapat Atiwattanachai (5731015621) 
 * @version 28 OCT 2015
 * Lab4 (1/2015) in 2110215 ProgMeth
 */

package ui;

import lib.ConfigurableOption;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameTitle extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel optionPanel;
	JButton newGame,viewScore;
	public GameTitle() {
		
		this.setPreferredSize(new Dimension(ConfigurableOption.screenWidth, ConfigurableOption.screenHeight));
		this.setLayout(new BorderLayout());
		
		/*------------------ Part1 title ---------------------*/
		JLabel title = new JLabel("Shoot the bullet", JLabel.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD + Font.ITALIC, 30));
		title.setBackground(Color.BLUE);
		title.setOpaque(true);
		title.setForeground(Color.BLACK);
		this.add(title, BorderLayout.NORTH);
		
		/*------------------ Part2 buttonPanel ---------------------*/
		JPanel buttonPanel = new JPanel();
		JButton newGame = new JButton("New Game");
		JButton viewScore = new JButton("High Score");
		buttonPanel.setLayout(new FlowLayout (FlowLayout.CENTER, ConfigurableOption.screenWidth /8, 5));
		buttonPanel.setBackground(Color.GREEN);
		buttonPanel.add(newGame);
		buttonPanel.add(viewScore);
		
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//read the setting values from GUI and store them in the variables defined in ConfigurableOption
				// GameManager.newGame()
				String text = "New Game\n";
				text += "objectCreationMinDelay="+ ConfigurableOption.objectCreationMinDelay +"\n";
				text += "objectCreationMaxDelay="+ ConfigurableOption.objectCreationMaxDelay +"\n";
				text += "objectMinDuration="+ ConfigurableOption.objectMinDuration +"\n";
				text += "objectMaxDuration="+ ConfigurableOption.objectMaxDuration +"\n";
				text += "timelimit="+ ConfigurableOption.timelimit;
				JOptionPane.showMessageDialog(null, text);
			}
		});
		
		viewScore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//HighScoreUtility.displayTop10()
				String text = "High Score";
				JOptionPane.showMessageDialog(null, text);
			}
		});
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		/*------------------ Part3 optionPanel ---------------------*/
		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(new BorderLayout());
		
		JPanel resolutionSetting = new JPanel();
		resolutionSetting.setLayout(new FlowLayout (FlowLayout.CENTER, 20, 2));
		
		JLabel lWidth = new JLabel("WIDTH");
		JLabel lHeight = new JLabel("HEIGHT");
		JTextField fWidth = new JTextField(String.format("%s", ConfigurableOption.screenWidth));
		JTextField fHeight = new JTextField(String.format("%s", ConfigurableOption.screenHeight));
		fWidth.setPreferredSize(new Dimension(100,20));
		fHeight.setPreferredSize(new Dimension(100,20));
		JButton apply = new JButton("Apply");
		apply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//GameManager.resizeScreen();
				try {
					ConfigurableOption.screenWidth = Integer.parseInt(fWidth.getText());
					ConfigurableOption.screenHeight = Integer.parseInt(fHeight.getText());
					String text = "Apply\n";
					text += "screenWidth="+ fWidth.getText() +"\n";
					text += "screenHeight="+ fHeight.getText() +"\n";
					JOptionPane.showMessageDialog(null, text);
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JPanel pWidth = new JPanel();
		JPanel pHeight = new JPanel();
		pWidth.add(lWidth);
		pWidth.add(fWidth);
		pHeight.add(lHeight);
		pHeight.add(fHeight);
		
		resolutionSetting.add(pWidth);
		resolutionSetting.add(pHeight);
		resolutionSetting.add(apply);
		
		optionPanel.add(resolutionSetting, BorderLayout.NORTH);
		
		//------------------------------------------------------
		JPanel otherSetting = new JPanel();
		otherSetting.setLayout(new GridLayout(3,2));
		
		JLabel cmind = new JLabel("Creation min delay");
		JLabel cmaxd = new JLabel("Creation max delay");
		JLabel omind = new JLabel("Object min duration");
		JLabel omaxd = new JLabel("Object max duration");
		JLabel timelimit = new JLabel("Time limit (sec)");
		JSpinner scmind = new JSpinner(new SpinnerNumberModel(ConfigurableOption.objectCreationMinDelay,0,1000,10));
		JSpinner scmaxd = new JSpinner(new SpinnerNumberModel(ConfigurableOption.objectCreationMaxDelay,0,1000,10));
		JSpinner somind = new JSpinner(new SpinnerNumberModel(ConfigurableOption.objectMinDuration,0,1000,10));
		JSpinner somaxd = new JSpinner(new SpinnerNumberModel(ConfigurableOption.objectMaxDuration,0,1000,10));
		JSpinner stimelimit = new JSpinner(new SpinnerNumberModel(ConfigurableOption.timelimit,0,1000,1));
		
		JPanel a = new JPanel();
		JPanel b = new JPanel();
		JPanel c = new JPanel();
		JPanel d = new JPanel();
		JPanel e = new JPanel();
		
		a.add(cmind);
		a.add(scmind);
		b.add(cmaxd);
		b.add(scmaxd);
		c.add(omind);
		c.add(somind);
		d.add(omaxd);
		d.add(somaxd);
		e.add(timelimit);
		e.add(stimelimit);
		
		otherSetting.add(a);
		otherSetting.add(b);
		otherSetting.add(c);
		otherSetting.add(d);
		otherSetting.add(e);
		
		optionPanel.add(otherSetting, BorderLayout.CENTER);
		
		
		
		this.add(optionPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		GameTitle titleScene = new GameTitle();
		JFrame f = new JFrame();
		f.add(titleScene);
		f.pack();
		f.setVisible(true);
	}
	
}
