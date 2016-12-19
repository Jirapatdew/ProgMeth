package app;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import twitterlib.Tweet;

public class TweetDisplay extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TweetDisplay(Tweet tweet) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel txt = new JLabel(" @" + tweet.getScreenName() + " : " + tweet.getText());
		JLabel img = new JLabel(new ImageIcon(tweet.getProfilePicture()));
		
		add(img);
		add(txt);
	}
}
